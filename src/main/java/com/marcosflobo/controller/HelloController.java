package com.marcosflobo.controller;

import com.marcosflobo.service.TelegramBotService;

import io.micronaut.http.HttpResponse;
import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Body;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import io.micronaut.http.annotation.Post;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller("/v1/hello")
public class HelloController {

    private final TelegramBotService telegramBotService;
    
    public HelloController(TelegramBotService telegramBotService) {
        this.telegramBotService = telegramBotService;
    }

    @Post(value = "/audio", consumes = MediaType.APPLICATION_OCTET_STREAM)
    public HttpResponse<String> helloAudio(@Body byte[] data) {

        log.info("Request to send audio received");
        telegramBotService.sendAudio(data);

        return HttpResponse.ok();
    }

    @Get
    public HttpResponse<String> hello() {

        telegramBotService.send("\u1F44B Hi!");

        return HttpResponse.ok();
    }
}
