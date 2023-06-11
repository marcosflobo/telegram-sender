package com.marcosflobo.telegram;

import io.micronaut.context.annotation.Property;
import lombok.extern.slf4j.Slf4j;

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

  public void sendAudio(String urlAudio) {

    log.info("Building InputFile..");
    System.out.println("Building InputFile with URL " + urlAudio + "..");
    InputFile audio = new InputFile(urlAudio);
    log.info("InputFile built");
    System.out.println("InputFile built");

    SendAudio message = SendAudio.builder()
      .chatId(userId)
      .audio(audio)
      .caption("Four seaons")
      .duration(198)
      .title("Vivaldi_-_Four_Seasons_4_Winter_Air_Force_Strings")
      .performer("Vivaldi")
      .build();
    System.out.println("SendAudio built");
    

    sendToTelegram(message);
  }

  private void sendToTelegram(SendAudio message) {
    try {
      log.info("Sending to Telegram...");
      System.out.println("Sending to Telegram...");
      execute(message);                        //Actually sending the message
      log.info("Message sent!");
      System.out.println("Message sent!");
    } catch (TelegramApiException e) {
      System.out.println("Something happend and the message was not sent to Telegram");
      System.out.println(e);
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
