

# Currency Information Application 
> Demo application that communicates to binance endpoints

Elements in beautiful READMEs include, but are not limited to: images, screenshots, GIFs, text formatting, etc.

## Technologies used

- Kotlin
- Spring framework
- Gradle


## Running application

click run icon in editor or use:
- ``` ./gradlew bootRun ```

## Running with docker
build image:
- ``` docker build -t currency-information .```

run image in docker container:
- ``` docker run -dp 8080:8080 -e "DB_PASSWORD=${password}" currency-information```