package com.marcosflobo;

import java.util.List;

import javax.inject.Inject;

import org.telegram.telegrambots.meta.TelegramBotsApi;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
import org.telegram.telegrambots.meta.exceptions.TelegramApiRequestException;
import org.telegram.telegrambots.meta.generics.LongPollingBot;
import org.telegram.telegrambots.meta.generics.WebhookBot;
import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;

import com.marcosflobo.telegram.Bot;

import io.micronaut.context.event.ApplicationEventListener;
import io.micronaut.context.event.StartupEvent;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class TelegramRegistryService implements ApplicationEventListener<StartupEvent> {

    @Inject
    List<LongPollingBot> longPollingBots;


    @Override
    public void onApplicationEvent(StartupEvent event) {
        TelegramBotsApi botsApi;
		try {
			botsApi = new TelegramBotsApi(DefaultBotSession.class);
            //botsApi.registerBot(new Bot());

            log.info("Registering Longpolling Bots");
            for (LongPollingBot bot : longPollingBots) {
                try {
                    botsApi.registerBot(bot);
                    log.info("Registered {}", bot.getBotUsername());
                } catch (TelegramApiRequestException e) {
                    log.error(e.getMessage(), e);
                }
            }
            log.info("Finished registering bots");
		} catch (TelegramApiException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
    
}
