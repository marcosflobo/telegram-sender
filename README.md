# telegram-sender
REST API that accepts messages and are sent to a Telegram group

## Run
### Via gradle
```shell
TELEGRAM_TOKEN=foo TELEGRAM_BOTUSERNAME=@bar ./gradlew run
```

### Send a file
```shell
curl -X POST -d @Vivaldi_-_Four_Seasons_4_Winter_Air_Force_Strings_-_United_States_Air_Force_Band.mp3 -H "Content-Type: application/octet-stream" 'https://marcosflobo-congenial-space-journey-6ww47gwp74fx7-8080.preview.app.github.dev/v1/hello/audio' \
  -H 'authority: marcosflobo-congenial-space-journey-6ww47gwp74fx7-8080.preview.app.github.dev'