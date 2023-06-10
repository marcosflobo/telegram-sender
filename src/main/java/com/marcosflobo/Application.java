package com.marcosflobo;

import io.micronaut.runtime.Micronaut;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

public class Application {

    public static void main(String[] args) throws TelegramApiException {
        Micronaut.run(Application.class, args);
    }
}
