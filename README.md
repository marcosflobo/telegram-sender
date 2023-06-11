# telegram-sender
REST API that accepts messages and are sent to a Telegram group

## Run
### Via gradle
```shell
TELEGRAM_TOKEN=foo TELEGRAM_BOTUSERNAME=@bar ./gradlew run
```

### Send a file
```shell
curl -i -X POST -d '{"url":"https://upload.wikimedia.org/wikipedia/commons/0/0e/Vivaldi_-_Four_Seasons_4_Winter_Air_Force_Strings_-_United_States_Air_Force_Band.mp3"}' 'https://marcosflobo-congenial-space-journey-6ww47gwp74fx7-8080.preview.app.github.dev/v1/hello/audio' -H 'Content-Type: application/json' \
  -H 'authority: marcosflobo-congenial-space-journey-6ww47gwp74fx7-8080.preview.app.github.dev'
```

## Micronaut
- https://docs.micronaut.io/latest/guide/configurationreference.html