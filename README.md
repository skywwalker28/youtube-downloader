# Youtube-downloader

Сервис-посредник, который проксирует запросы к `ytdlp-service`. Предоставляет единый API для клиентов.

## Возможности

- Проксирование запросов на получение информации о видео
- Проксирование запросов на скачивание видео
- Проксирование запросов на извлечение 39-го кадра от конца видео

## Требования

- Java 21
- Maven
- **Запущенный контейнер `ytdlp-service`** (на порту 8081)

## Быстрый старт

1. Убедитесь, что `ytdlp-service` запущен:

```bash
    curl http://localhost:8081/actuator/health
    # Должен вернуть: {"status":"UP"}
```

2. Запустите сервис:

```bash
    # Через Maven
    ./mvnw spring-boot:run
    
    # Или соберите JAR и запустите
    ./mvnw clean package
    java -jar target/youtube-downloader-*.jar
```


# API Эндпоинты

### Базовый URL: http://localhost:8080/youtube

- ### Получить информацию о видео:

```text
POST /youtube/info
Content-Type: application/json

{
    "url": "https://www.youtube.com/watch?v=VIDEO_ID"
}
```

- ### Скачать видео:

```text
POST /youtube/download
Content-Type: application/json

{
    "url": "https://www.youtube.com/watch?v=VIDEO_ID",
    "formatId": "18"  // опционально, по умолчанию лучшее качество
}
```

#### Форматы:
1. ```"18"```	360p с аудио (MP4)
2. ```"298"```	720p 60fps без аудио
3. ```"298+251"```	720p 60fps + лучшее аудио
4. ```null```	автоматический выбор лучшего качества

- ### Извлечь 39-й кадр от конца

```text
POST /youtube/frame39
Content-Type: application/json

{
    "videoId": "VIDEO_ID",
    "formatId": "18"  // опционально
}
```

## Примеры запросов

1. Получить информацию о видео

```bash
    curl -X POST http://localhost:8080/youtube/info \
      -H "Content-Type: application/json" \
      -d '{"url":"https://www.youtube.com/watch?v=dQw4w9WgXcQ"}'
```
2. Скачать видео в лучшем качестве

```bash
    curl -X POST http://localhost:8080/youtube/download \
      -H "Content-Type: application/json" \
      -d '{"url":"https://www.youtube.com/watch?v=dQw4w9WgXcQ"}'
```
3. Скачать видео в формате 360p

```bash
    curl -X POST http://localhost:8080/youtube/download \
      -H "Content-Type: application/json" \
      -d '{"url":"https://www.youtube.com/watch?v=dQw4w9WgXcQ","formatId":"18"}'
```

4. Получить 39-й кадр от конца

```bash
    curl -X POST http://localhost:8080/youtube/frame39 \
      -H "Content-Type: application/json" \
      -d '{"videoId":"dQw4w9WgXcQ"}'
```
## Структура ответов

- ### ```/youtube/info```

```json
{
    "id": "VIDEO_ID",
    "title": "Video Title",
    "duration": 221,
    "uploader": "Channel Name",
    "thumbnail": "https://...",
    "formats": ["..."]
}
```

- ### ```/youtube/download```

```json
{
    "downloadPath": "/downloads/VIDEO_ID.mp4"
}
```

- ### ```/youtube/frame39```

```json
{
    "framePath": "http://localhost:8081/downloads/VIDEO_ID_frame39_from_end.jpg"
}
```


### ⚠️ Перед запуском youtube-downloader обязательно запустите ytdlp-service!


# Правильный порядок запуска:
```bash
    1. cd ytdlp-service && docker-compose up -d   # запуск основного сервиса
    2. cd youtube-downloader && ./mvnw spring-boot:run  # запуск сервиса-посредника
```