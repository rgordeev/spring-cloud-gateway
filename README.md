### Spring cloud gateway example

Проект состоит из трех компонент:
+ Books microservice: port 8889
+ API Gateway (Srpring Cloud gateway): port 8887
+ Service Discovery (Eureka): 8888

### Собрать и запустить

Собираем
```
./gradlew
```

Запускаем дискавери сервис
```
./gradlew :discovery:bootRun
```

Запускаем шлюз
```
./gradlew :gateway:bootRun
```

Запускаем микросервис
```
./gradlew :bookstore:bootRun
```

Проверяем запросы доступные по адресу микросервиса
```
GET http://localhost:8889/books
GET http://localhost:8889/books/9781524763138
```

Получаем аналогичные результаты через шлюз
```
GET http://localhost:8887/api/books
GET http://localhost:8887/api/books/9781524763138
```
