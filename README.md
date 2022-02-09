`Глава 5`
> 1. Преимущество хорошего еррор-месседжа? Для чего javax.validation.Valid?

* Регистрировать баги, что может помочь в устранении.

> 2. "Какие знаете аннотации Bean Validation 2.0 / Hibernate Validator?"

* NotNull, Null, Max, Min, Past, Future, Size, Pattern

> 3. Как в Spring Boot создать хандлер эксепшинов во всем приложении с кастомным телом ответа? (принцип и анотации)

* Создаём класс наследуемый от требуемого исключения, в нём создаём методы которые принимают сообщения ошибки от
  разработчика и java, эти сообщения записываем в логи и нужное показываем пользователю. В классе где нужно создать
  исключение вызываем метод написанного нами класса исключений, передаём ему информацию об ошибках.

> 4. Над полем какого типа мы ставим @Pattern? А @Size?

* @Pattern - ищет соответствие с заданным регулярным выражением строки.
* @Size - для задания размера коллекции мин — макс, и для цифровых значений.

> 5. Привести пример использования @ModelAttribute("mouse").


```@RequestMapping(value = "/mice")
public ResponseEntity<?> createMouse(@ModelAttribute("mouse") Mouse mouse) {
mouse = mouseRepository.save(mouse);
HttpHeaders responseHeaders = new HttpHeaders();
URI newPollURI = ServletUriComponentsBuilder
.fromCurrentRequest()
.path("/{id}")
.buildAndExpand(mouse.getId())
.toUri();
responseHeaders.setLocation(newPollURI);
return new ResponseEntity<>(null, responseHeaders, HttpStatus.CREATED);
}
```

> 6. Ради какого бенефита мы создали messages.properties?

* Для возможности изменения сообщения ошибки без исправления кода, плюс упрощается мультиязычная поддержка.

> 7. *Формат ключа (идентификатора) и сообщения. Что означает {1} в тексте сообщения? Как происходит поиск сообщения в файле (то, что нужно для того чтобы знать, как называть ключи)? Что если сообщения нет в файле?

* Первое имя ограничения, затем имя класса, название поля, через точку. {1} - параметр ограничения минимального
  количества вопросов.

> 8. Как связаны @ModelAttribute и ключ (идентификатор) сообщения в properties файле? Как будет определн идентификатор если мы не указали @ModelAttribute (привести пример на конкретном классе сущности, например Mouse)?

* Аннотация @ModelAttribute задаёт имея модели - (идентификатор) сообщения. Если @ModelAttribute не указан то
  идентификатор будет определён автоматически по имени класса(нельзя задавать имя метода):
  NotEmpty.mouse.name=Name is a required field

> 9. Почему мы пронаследовались от ResponseEntityExceptionHandler (спринг 3.2), а не от DefaultHandlerExceptionResolver (спринг 3.0), в чем бенефит?

* ResponseEntityExceptionHandler возвращает ResponseEntity для записи в ответ с помощью конвертера сообщений, в отличие
  от DefaultHandlerExceptionResolver, который возвращает ModelAndView.

> 10. (optional) Как без ResponseEntityExceptionHandler?



> 11. Какие конкретно эксепшины хандлит ResponseEntityExceptionHandler? (можно скопировать код)

* HttpRequestMethodNotSupportedException.class, HttpMediaTypeNotSupportedException.class,
  HttpMediaTypeNotAcceptableException.class, MissingPathVariableException.class, MissingServletRequestParameterException.class,
  ServletRequestBindingException.class, ConversionNotSupportedException.class, TypeMismatchException.class,
  HttpMessageNotReadableException.class, HttpMessageNotWritableException.class, MethodArgumentNotValidException.class,
  issingServletRequestPartException.class, BindException.class, NoHandlerFoundException.class, AsyncRequestTimeoutException.class

> 12. Конкретный тип MessageSource в QuickPoll в рантайм.

*  String getMessage(org.springframework.context.MessageSourceResolvable messageSourceResolvable,
   java.util.Locale locale)

`Глава 6.`

> 1. Что такое Swagger, из каких модулей состоит, какие проблемы решают.

* Swagger - фреймворк для интерактивного создания REST API документации. swagger-ui - для отображения документации
  WEB API слоя и swagger-ui-dist для отображения Domain слоя

> 2. Какие swagger core аннотации можете назвать и для чего они?

* EnableSwagger2 - добавляем swagger в проект.
* @ApiModelProperty - описывает свойства модели класса.
* @ApiResponse - изменяет сообщение кодов.
* @ApiOperation - описывает endpoint и ответ.
 
> 3. Как создать (подключить) в проект RESTful web services документацию на основе swagger yaml?

* Добавляем зависимости: springfox-swagger2, springfox-swagger-ui. Создаём конфигурационный класс который анотируем
  @Configuration, @EnableSwagger2, в классе создаём бин Docket, в котором настраиваем путь к контроллер пакеджу и 
  указываем методы, которые документируются с использованием строковых предикатов.

> 4. Как мы можем обойтись без написания yaml? Какие знаете способы чтобы динамически сгенерировать документиацию?

* Да.

> 5. SpringFox. Кратко, суть @EnableSwagger2 и чем отличается от @EnableSwagger.

* EnableSwagger более ранний плагин, который прекратили поддерживать.

> 6. Что репрезентует Docket.

* начальный конфигуратор, механизм инициализирует настройку swagger. 

> 7. Отличия .apis() от .paths(). Что устанавливают эти настройки:
     .apis(RequestHandlerSelectors.any())
     .paths(PathSelectors.regex("(?!/error).+"))

* apis() - указываем путь к пакеджу с контролёрами. any() - Просматривает все пакеджи.
* paths() - указываем предикат конечной точки. regex - предикат указанный с помощью регулярного выражения.

> 8. Что выключает swaggerSpringMvcPlugin.useDefaultResponseMessages(false) ?

* Отключаются дефолтные сообщения swagger.

> 9. Как бы вы использовали @ApiModel?

*  Аннотация позволяет показать пример заполненной модели.