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
  -H 'authority: marcosflobo-congenial-space-journey-6ww47gwp74fx7-8080.preview.app.github.dev' \
  -H 'accept: text/html,application/xhtml+xml,application/xml;q=0.9,image/avif,image/webp,image/apng,*/*;q=0.8,application/signed-exchange;v=b3;q=0.7' \
  -H 'accept-language: es-ES,es;q=0.9,en-US;q=0.8,en;q=0.7,fr-FR;q=0.6,fr;q=0.5,de;q=0.4,pl;q=0.3' \
  -H 'cache-control: max-age=0' \
  -H 'cookie: __Host-vso-pf=C4E2C9A7F92DC9E06E90C3715D6D8D26%3AXe9ZtR6%2FwK9IxsxgAG%2BSPb19GmvKWnvLt9KVsY6cX5sV9lFOdY81uqoBI53QKIMTKZiqHX4QgoDM9ndfbujQ6CcvpyzxAL%2BK9PfRXIqIPn8NkvdSqE3CnYZcxCk1i4ED7R2NU6uZQRbkKCA8hefb0aAdyzRYkeEhvtTLDq3BVkyMTPX67pfDy1%2F%2BSKMOoZwe7f1IDDI0n0MvCtb5sgmxdOGNxuV5ggXwkfB20n3evYnXYHq7Z2kX0Pz7%2Bo20jNk1isiNmKU9bQzNtSsZgfu%2BdV4FZcyzf7XN%2B5QOpa%2BwrGPx%2FuVp9ETjGFtu7d3E5i1Z9gXPKub1HRGoG40lWGt1f6isn3pV0ZwP8XeIw4KlhZz8jXCcR45clMKk6F5giigAYC27gb754aUiJAukInuIRBCzImQdVW1w2Y6qyhBVqSonL40MoysCx0hNughIHg0OAPYJ7gc677PJ%2FTJ3RRT%2FrKCsp4LfSM5JpmgiRtm1E%2FAsa9cVyK%2FESHgvIV1f%2FFVZPiLShh8l9UeZ0TawhL2ih3vdalcM70s0w6fBO%2BbByeNbUK8uX5KIhmnbPYSro4K5GLEyXPiipjQUWnfnN148tokAeAfSxFCp30i7U%2Brzoh4JW0BCLX99gtlyMrq0KnwK7o73DutVTYeWEorJdbvC7aCxiV9h2PMouJfBpcN6DhA95ihX8NzGIEbgQHSrq%2BjdkuH3mGBeRhGZgYj93bVu5m2e5RTb9UeQAQNti7Tc1VSYhnieTBUuLXjFtBnTJPFRTUYrJMXmV5H2%2Bu739Z8OZiponx9T8Ru15645xyRqIjNfW4d9%2FvPkP6i2oAIUlGUfvqCnzr32vmLdzOaKz4NN95GS9Nkpemrv2L8q3baZwb5EV94DT0ooTCGThi%2BrM6y1afFu%2FuPQx81YqchkUnVIaoY5BAx1A0CUlPHJrOkpTE2b5aQBxgPHjEY99j2F3IhdmazyoIndWFj2WUmBlNm4hl3qi6PWDtwinLuWBdjKS5DwDK1c1mq83LKtOJ3KiVMyA5qpu7Y5iZqhjlnDiwbG8k4Y5%2FRSYEP0VWPhT879hfDrUauav5YGgvvPtyLGRsN0dhVPjPzUOb8hkp3sf3E8Qy4LMIwVix0COcMXAh61Lh7xt0AkUrf9orABmOc%2F8zyU3fP4mfxuGEP70zG97GJ4tmbIaW%2FdagHb%2Blx9dQnY47AU8kN4V6ZrGEGNSysKVk1KSwOzQf2Ay8b%2BXN4mAtuQ4GzViGdnmMQ41RwHrAkBNuLGpN5HK2ZqmttN3WTKkkyyx9a3t2eq79qBcO35bPcVDfK8A%2BLKiKCQztdBtYgJEzWKiwBHh6BB9hPg7lCsVXwKDABhm2yuYLafObk9sXqo3gGNhQduk9lxuqLjHKRd69bPPXRsEwu%2BKu47noZZmqCn7qjyUkKoPusFuBfldDhtiVAFLUY8rATRCy%2BhVg12COf62p5wuWiYi9VH7Zi2vnWmjWiBia8F09upuBGqDLDn1L0tXN6wzxVT22pD10ZcRgo%2BafNgUx075Xroc3d%2B1n3b0BdsNIOY4beivUMVNZJ04aieJhpnsXGELEs5bpesrOaCN%2F5sxLW%2BvmomJihQEv0dSSNBUgbegsO4HLCamhrOJeEdGgW4ZrBzc%2FtouuKU2RfysQoj9TljzWD9zYl6Ieac7mmxrlGr96%2FfHsN%2BHQ02cO%2BuGi%2FT6AdsXYJpiSD8rTh8xWEV5A5d%2B7fdGcUgMEw2%2FZxCCy1M6D%2FK0whIBrJDdnzmCOjbgFRotIeDPTOPaNGo5qBheYWtBcbnczj3yVWZ8O2YerayXwB4WfvS8aHfNTFgXA9Pe7%2Fd2ljXDh0Wdmj2ybS6oeGzpDDmkM%2BqipEmXVRANbek%2FwBfqI9GJz7gYmK%2BHWdPaAEInA258fX8AoqMl6tZwBWhfxkTrq5Qeh7jXf4jPE0%2FKXd7bFHJxpO8md5qhKqLh4etcZdi4PSvoOhBVItxPzW5daca68cEM%2FgbcN7d1Ev%2BHm%2BqIKpqE7ZmyLOLVUaKoh8H2YkWjvMTnLEoD8j3L7E5ATmH23aeVVCbrZUQPu6AXl5PjdTlvQSoDqV54xoMCvMPpOaEZUAxCLKpQvbx1G4cOKqpTSGeWrDl9YBT4eFv3TT2apET3I9666exRTUQlovEG6uLu7ijB%2F629YyP7Qn9O1k8Q%2Bxt0GBh10xU4YG31PCUeKmEO7ZyZ4Y6NqiVA9R2Y6AFatcOyyAy61sJtbKLCVik8B%2B2VoregSLYZVZRxrGxO%2FniAsgTabWz9MmpL8AuTE9%2Fp%2FH%2F8oPYjpcJa68kAOm5U%2FVOG56mu55i86ejbYN9O4acrQn4DmBgBm31a2TPasZQ9clUJwbd9u9hb1pqu%2BdpJnwXjmpazSuEwBVr0u1MbvEyKQkc5zNEPOrGP0Olswqn9a53K7E%3D' \
  -H 'sec-ch-ua: "Not.A/Brand";v="8", "Chromium";v="114", "Google Chrome";v="114"' \
  -H 'sec-ch-ua-mobile: ?0' \
  -H 'sec-ch-ua-platform: "macOS"' \
  -H 'sec-fetch-dest: document' \
  -H 'sec-fetch-mode: navigate' \
  -H 'sec-fetch-site: none' \
  -H 'sec-fetch-user: ?1' \
  -H 'upgrade-insecure-requests: 1' \
  -H 'user-agent: Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_7) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36' \
  --compressed
```

## Links
- https://core.telegram.org/bots/tutorial
