package com.marcosflobo.telegram;

import io.micronaut.context.annotation.Property;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

public class Bot extends TelegramLongPollingBot {

  @Property(name = "{telegram.token}")
  private String token;

  @Override
  public String getBotUsername() {
    return null;
  }

  @Override
  public String getBotToken() {
    return token;
  }

  @Override
  public void onUpdateReceived(Update update) {}

}
