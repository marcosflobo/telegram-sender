package com.marcosflobo.service;

import javax.inject.Singleton;

import com.marcosflobo.telegram.Bot;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Singleton
public class TelegramBotService {

    private final Bot bot;

	public TelegramBotService(Bot bot) {
		this.bot = bot;
	}

    public void sendAudio(String urlAudio) {

        log.info("Sending audio to Telegram Bot");
        bot.sendAudio(urlAudio);
    }

    public void send(String what) {
        bot.send(what);
    }
}
