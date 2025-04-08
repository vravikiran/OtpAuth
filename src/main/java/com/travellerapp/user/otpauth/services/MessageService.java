package com.travellerapp.user.otpauth.services;

import java.io.UnsupportedEncodingException;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.travellerapp.user.otpauth.entities.EmailAuthRequest;
import com.travellerapp.user.otpauth.entities.MobileAuthRequest;
import com.travellerapp.user.otpauth.security.TwilioConfig;
import com.twilio.exception.ApiException;
import com.twilio.rest.api.v2010.account.Message;
import com.twilio.type.PhoneNumber;

import jakarta.mail.MessagingException;

@Service
public class MessageService {
	private static final Integer EXPIRE_MIN = 5;
	private LoadingCache<String, String> otpCache;
	@Autowired
	EmailService emailService;
	@Autowired
	TwilioConfig twilioConfig;

	private String getRandomEmailOtp(String email) {
		String otp = String.valueOf(new Random().nextInt(1000, 10000));
		otpCache.put(email, otp);
		return otp;
	}

	private String getRandomOtp(String mobileno) {
		String otp = String.valueOf(new Random().nextInt(1000, 10000));
		otpCache.put(mobileno, otp);
		return otp;
	}

	public MessageService() {
		otpCache = CacheBuilder.newBuilder().expireAfterWrite(EXPIRE_MIN, TimeUnit.MINUTES).build(new CacheLoader<>() {
			@Override
			public String load(String s) {
				return "";
			}
		});
	}

	public void generateOtpToEmail(String email) throws UnsupportedEncodingException, MessagingException {
		String otp = getRandomEmailOtp(email);
		String content = "Please find the OTP to login into App: " + otp;
		emailService.sendEmail(email, "OTP to login application", content);
	}

	public boolean validateEmailOtp(EmailAuthRequest emailAuthRequest) throws ExecutionException {
		if (otpCache.get(emailAuthRequest.getEmail()) != null
				&& otpCache.get(emailAuthRequest.getEmail()).equals(emailAuthRequest.getOtp())) {
			return true;
		}
		return false;
	}

	public void generateOtpToMobile(String mobileNo) throws ApiException {
		if (mobileNo != null) {
			PhoneNumber to = new PhoneNumber("+91" + mobileNo);
			String otpMessage = "Please find the OTP to login into App: " + getRandomOtp(mobileNo);
			Message.creator(to, twilioConfig.getServiceId(), otpMessage).create();
		}
	}
	
	public boolean validateMobileOtp(MobileAuthRequest mobileAuthRequest) throws Exception {
		if (otpCache.get(mobileAuthRequest.getMobileNo()) != null
				&& otpCache.get(mobileAuthRequest.getMobileNo()).equals(mobileAuthRequest.getOtp())) {
			return true;
		}
		return false;
	}
}
