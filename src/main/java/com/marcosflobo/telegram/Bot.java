package com.marcosflobo.telegram;

import io.micronaut.context.annotation.Property;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

@Slf4j
public class Bot extends TelegramLongPollingBot {

  @Property(name = "{telegram.username}")
  private String username;

  @Property(name = "{telegram.token}")
  private String token;

  @Override
  public String getBotUsername() {
    log.info("username: {}", username);
    return username;
  }

  @Override
  public String getBotToken() {

    log.info("token: {}", token);
    return token;
  }

  @Override
  public void onUpdateReceived(Update update) {
    var msg = update.getMessage();
    var user = msg.getFrom();

    log.info(user.getFirstName() + " wrote " + msg.getText());
  }

}
