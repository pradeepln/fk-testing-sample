package com.training.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"withsms"})
@Service
public class RealMessageSender implements SMSSender {

	@Override
	public void sendMessage(String message) {
		System.out.println("[[[[[[[[[[[[[ REAL MESSAGE SENT ]]]]]]]]]]]]");
		
	}

}
