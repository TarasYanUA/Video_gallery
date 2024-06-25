Модуль "Видео галерея" v3.6.0 + тема Юни2(Ult+MV+Ru) v4.18.1b. Лучше установить весь пакет темы Юни2.

Запустить тесты можно:
1) Через файл CucumberTestNG.xml
2) Через файл CucumberTestRunner (путь к файлу: src -- test -- java)
3) Через Surefire отчёт: перейти в "Терминал" и ввести "mvn clean test". После этого в папке "target -> surefire reports"
   открыть файл "index.html" с помощью браузера (правая кнопка мыши -> Open in -> Browser).


**Cucumber JSON Report отчёт**:
- найти файл "target -- cucumber_target.html",
- на файле нажать правую кнопку мыши,
- выбрать "Open in -- Browser -- Chrome".


**Условия для работоспособности авто-тестов:**
1) Следить за актуальностью библиотек (файл pom.xml);
2) В класс hooks.DriverHooks добавить актуальную ссылку, на которой будут запускаться авто-тесты.
3) Используя команду "mvn clean verify" в Терминале. "clean" очищает проект, удаляя директорию target и всё её содержимое. "verify" выполняет тесты, используя maven-failsafe-plugin, и проверяет, что проект корректно построен.


Здесь используются следующие **библиотеки**:
* Selenide;
* TestNG;
* Cucumber;
* Cucumber JSON Report;
* Файл логирования для SLF4J (библиотека logback-classic и его сопутствующий файл test -- resources -- logback.xml), чтобы отключить лишние логи.