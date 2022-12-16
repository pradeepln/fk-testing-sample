package com.training.service;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Profile({"nosms","default"})
@Service
public class SilentMessageSender implements SMSSender{
	@Override
	public void sendMessage(String message) {
		System.out.println("-------- staying silent -------");
		
	}
}
