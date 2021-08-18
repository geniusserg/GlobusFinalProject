# GlobusFinalProject
Web appilcation - Controller of Sensors for Trucks
Запуск приложения - docker-compose up, далее просто собрать приложение и запустить его из jar. Для запуска эмулятора датчиков передайте POST запрос на адрес localhost:8080/sensors/setup с файлом конфига. подробнее смотрите ниже: 

Маппинг:
GET localhost:8080/sensors/value - узнать все измерения за время наблюдения

GET localhost:8080/sensors/value/filtered - узнать все измерения за определнный промежуток постранично. 
    Json  с параметрами включает в себя начало и конец промежутка, а также количество записей в странице. 
    Время везде в миллисекундах. Пример в resources/filteredRequest.json

POST localhost:8080/sensors/setup - запустить эмулятор. Передается конфиг с параметрами, параметры считываются и запускаются эмуляторы, сборщик данных. Пример - resources/startConfig.json Эмулятор можно при желании запустить отдельно в классе EmulatorService

POST localhost:8080/sensors/report - служебный адрес, используется сборщиком данных с эмуляторов для передачи отчета на сервер.
