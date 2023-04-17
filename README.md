# Проект базе данных "Корабли"

Рассматривается БД кораблей, участвовавших во второй мировой войне.

## Запуск

1. Для запуска вам понадобиться **[Java 11](https://www.java.com/ru/)** и выше.
2. СУБД использован **[PostgreSQL 15.0](https://www.postgresql.org/)**.

## Технологии

1. **[Spring Boot](https://spring.io/projects/spring-boot)** проект использует систему сборки на основе **[Maven](https://maven.apache.org/)**.
2. Для работы с базами данных и для сохраниение Java-обьектов используется **[Spring Data Jpa](https://docs.spring.io/spring-data/jpa/docs/current/reference/html/)**, для реализации **[Hibernate](https://hibernate.org/)**.
3. **[Spring Security](https://spring.io/projects/spring-security)** для аутентификации и контрола доступа.
4. Для описание **API** и создание документации, в проекте использован **[Swagger](https://swagger.io/).**
````
 http://localhost:8077/swagger-ui.html#
````
6. Для тестирование **API** - **[Postman](https://www.postman.com/)**.


## Настройки и описания проекта

1. Настройки соединение к БД прописаны в файле `src/main/resources/application.proporties` (надо будет создать новую database и прописать username и password
2. Все зависимости и библиотеки прописаны в файле `pom.xml` (при запуска автоматические будут загружены).
3. Сервер порт по умолчанию **'8077'**, при желание можно поменять в файле `src/main/resources/application.proporties`.
4. При запуске проекта, автоматический добавиться нужные таблицы в **PostgreSQL** и необходимы SQL запросы из файла `src/main/resources/data.sql`.

## Важное

1. При добавление данных в таблицы могут возникнуть ошибки, эти ошибки возникают из-за того что при запуске проекта автоматические добавляются записи в БД и 
автоматический этим записяям присваеваются ID, пэотому при добавления генерация уникальных значений выдает ошибку "повторяющееся значение ключа нарушает 
ограничение уникальности", при возникновении этих ошибок, надо пропустить автоматический добавленных данных с нажатаем `send`.
2. Удаления записей в таблицах можно сделать только с доступом "ROLE_ADMIN".

## Описание API запросов для контроля доступа 

1. POST запрос "Аутентификация" `http://localhost:8077/api/v1/auth/login`

- Пользователь с доступом admin **(ROLE_ADMIN)**: 
- username: **mirbek**
- password: **AdIl1!2@** (есть валидация пароля)

## Описание API запроcов для добавления контента

### **Таблица: Battle**


1. Get запрос **"/Battle/result"** - [sql-ex.ru/exercises/48](https://sql-ex.ru/exercises/index.php?act=learn&LN=48#resPlace) 
- **Поиск классы кораблей, в которых хотя бы один корабль был потоплен в сражении**

````
http://localhost:8077/swagger-ui.html#/1.%20%D0%91%D0%B8%D1%82%D0%B2%D1%8B/findByBattleResultUsingGET
````
- поиск по названию битвы:
- значение name: **North Atlantic**


2. Post запрос **"Save"** `http://localhost:8077/swagger-ui.html#/1.%20%D0%91%D0%B8%D1%82%D0%B2%D1%8B/saveUsingPOST` - сохранение новых битв.
````
{
  "name": "string",
  "date": "1945.04.17"
}
````
- name - названия битвы,
- date - дата битвы.

 
3. Get запрос **"findByName"**  - поиск битвы по названию.
````
http://localhost:8077/swagger-ui.html#/1.%20%D0%91%D0%B8%D1%82%D0%B2%D1%8B/findByNameUsingGET
````
- name: North Atlantic


4. Get запрос **"findAll"**  - поиск всех битв.
````
http://localhost:8077/swagger-ui.html#/1.%20%D0%91%D0%B8%D1%82%D0%B2%D1%8B/findAllUsingGET
````


5. Delete запрос **"delete"** - удаления записи в базе данных
````
http://localhost:8077/swagger-ui.html#/1.%20%D0%91%D0%B8%D1%82%D0%B2%D1%8B/deleteUsingDELETE
````
- name: North Atlantic

**Важное! Удаления записи из БД только с доступом "ROLE_ADMIN"**
