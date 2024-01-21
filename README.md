# Character Frequency API

API для вычисления частоты встречи символов в заданной строке.

Вы можете получить доступ к Swagger и просмотреть доступный эндпоинт, посетив http://localhost:8080/swagger-ui/index.html.

## Запуск приложения

Перед запуском приложения убедитесь, что у вас установлены следующие компоненты и платформы:

- JDK (Java Development Kit) версии 8 или выше

- Apache Maven версии 3.6.0 или выше

- Git (необходимо для клонирования репозитория)

### Установка и настройка

1. Склонируйте репозиторий проекта с GitHub:
git clone https://github.com/nkashlev/frequency-calculator.git
2. Скачайте и распакуйте проект.
3. В командной строке перейдите в папку проекта.
4. Соберите проект с помощью Apache Maven: `mvn clean install`
5. Запустите приложение с помощью команды: `./mvnw spring-boot:run`

## Запросы API

### Вычисление частоты встречи символов

**URL:** /api/v1/frequency

**Метод:** GET

**Описание:** Получить частоту символов в строке

**Параметры:**
- `string` (обязательный) - заданная строка

**Пример запроса:**
GET /api/v1/frequency?string=aaaaabcccc


**Пример ответа:**
{
"a": 5,
"c": 4,
"b": 1
}

