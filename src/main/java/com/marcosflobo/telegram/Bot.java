package com.marcosflobo.telegram;

import io.micronaut.context.annotation.Property;
import lombok.extern.slf4j.Slf4j;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
public class Bot extends TelegramLongPollingBot {

  @Property(name = "telegram.username")
  private String username;

  @Property(name = "telegram.token")
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

    System.out.println(user.getFirstName() + " wrote " + msg.getText());

    var id = user.getId();

    sendText(id, "Copy that, " + user.getFirstName() + "!");
  }

  public void sendText(Long who, String what){
    SendMessage sm = SendMessage.builder()
            .chatId(who.toString()) //Who are we sending a message to
            .text(what).build();    //Message content
    try {
        execute(sm);                        //Actually sending the message
    } catch (TelegramApiException e) {
        throw new RuntimeException(e);      //Any error will be printed here
    }
}

}
