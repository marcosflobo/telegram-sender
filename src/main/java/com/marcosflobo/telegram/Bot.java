package com.marcosflobo.telegram;

import io.micronaut.context.annotation.Property;
import lombok.extern.java.Log;
import lombok.extern.slf4j.Slf4j;

import java.net.MalformedURLException;
import java.net.URL;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.net.URLConnection;

import javax.inject.Singleton;

import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.InputFile;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.api.objects.User;
import org.telegram.telegrambots.meta.api.methods.send.SendAudio;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Slf4j
@Singleton
public class Bot extends TelegramLongPollingBot {

  @Property(name = "telegram.token")
  private String token;

  @Property(name = "telegram.botusername")
  private String botUserName;

  private Long userId;

  private String userFirstName;

  @Override
  public String getBotUsername() {
    return botUserName;
  }

  @Override
  public String getBotToken() {
    return token;
  }

  @Override
  public void onUpdateReceived(Update update) {
    if (update.hasMessage() && update.getMessage().hasText()) {
      User user = update.getMessage().getFrom();
      userFirstName = user.getFirstName();
      userId = user.getId();
      long chatId = update.getMessage().getChatId();
      String messageText = update.getMessage().getText();

      SendMessage message = new SendMessage();
      message.setChatId(chatId);
      message.setText("¡Hola! "+userFirstName+" Has enviado el siguiente mensaje: " + messageText);

      try {
        execute(message);
      } catch (TelegramApiException e) {
        e.printStackTrace();
      }
    }
  }

  public void sendAudio(byte[] audioBytes) {

    log.info("Building InputFile..");
    InputStream is = new ByteArrayInputStream(audioBytes);
    InputFile audio = new InputFile(is, "Vivaldi_-_Four_Seasons_4_Winter_Air_Force_Strings_-_United_States_Air_Force_Band.mp3");
    log.info("InputFile built");

    SendAudio message = SendAudio.builder()
      .chatId(userId)
      .audio(audio)
      .caption("Four seaons")
      .duration(198)
      .title("Vivaldi_-_Four_Seasons_4_Winter_Air_Force_Strings")
      .performer("Vivaldi")
      .build();
    

    sendToTelegram(message);
  }

  private void sendToTelegram(SendAudio message) {
    try {
      log.info("Sending to Telegram...");
      execute(message);                        //Actually sending the message
      log.info("Message sent!");
    } catch (TelegramApiException e) {
      log.error("Something happend and the message was not sent to Telegram", e);
      throw new RuntimeException(e);      //Any error will be printed here
    }
  }

  public void send(String what) {

        SendMessage message = SendMessage.builder()
                    .chatId(userId) //Who are we sending a message to
                    .text(what).build();    //Message content
        try {
                execute(message);                        //Actually sending the message
        } catch (TelegramApiException e) {
                throw new RuntimeException(e);      //Any error will be printed here
        }
  }

}
