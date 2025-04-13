## PROJECT: aspect-bpp-proxying-beans

---

##  Основные аннотации

| Аннотация         | Описание                                   |
|------------------|---------------------------------------------|
| `@Aspect`        | Помечает класс как аспект                   |
| `@Before`        | Выполняется **до** вызова метода            |
| `@After`         | Выполняется **после** вызова метода         |
| `@AfterReturning`| Выполняется после **успешного** завершения  |
| `@AfterThrowing` | Выполняется при **исключении**              |
| `@Around`        | Полный контроль: до, после, изменение вызова|

---

##  Pointcut Designators (ключевые слова)

| Выражение        | Описание                                                          |
|------------------|-------------------------------------------------------------------|
| `execution(...)` | По сигнатуре метода                                               |
| `within(...)`    | Все методы **внутри** класса/пакета                               |
| `@within(...)`   | Методы в классах, помеченных аннотацией                           |
| `@annotation(...)` | Методы, **помеченные аннотацией**                             |
| `args(...)`      | Методы с аргументами определённого типа                           |
| `@args(...)`     | Аргументы с определённой аннотацией                               |
| `target(...)`    | Методы в классе, соответствующем типу (реальный класс)            |
| `this(...)`      | Методы в прокси-объекте, реализующем интерфейс                    |
| `bean(...)`      | По имени Spring-бина                                              |

---

##  Примеры аспектов

### `@Before` — до вызова метода
```java
@Before("execution(* com.example.service..*(..))")
public void logBefore(JoinPoint joinPoint) {
    log.info("Метод {} вызывается", joinPoint.getSignature().getName());
}
```

### `@After` — после вызова метода (в любом случае)
```java
@After("execution(* com.example.service..*(..))")
public void logAfter(JoinPoint joinPoint) {
    log.info("Метод {} завершил выполнение", joinPoint.getSignature().getName());
}
```

### `@AfterReturning` — если метод завершился успешно
```java
@AfterReturning(
        pointcut = "execution(* com.example.service.UserService.getUser(..))",
        returning = "result"
)
public void logReturn(Object result) {
    log.info("Метод вернул значение: {}", result);
}
```

### `@AfterThrowing` — если выброшено исключение
```java
@AfterThrowing(
        pointcut = "execution(* com.example.service..*(..))",
        throwing = "ex"
)
public void logException(Throwable ex) {
    log.error("Метод выбросил исключение: {}", ex.getMessage());
}

```

### `@Around` — полный контроль
```java
@Around("execution(* com.example.service..*(..))")
public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
    log.info("Перед вызовом {}", pjp.getSignature());
    Object result = pjp.proceed(); // вызов целевого метода
    log.info("После вызова {} — вернул {}", pjp.getSignature(), result);
    return result;
}
```

### `@annotation(...)` — аннотация на методе
```java
@Before("@annotation(com.example.aspect.TrackExecution)")
public void beforeTrackedMethod(JoinPoint jp) {
    log.info("Вызван аннотированный метод: {}", jp.getSignature().getName());
}
```

### `@within(...)` — методы в классе с аннотацией
```java
@Before("@within(com.example.aspect.TrackedClass)")
public void beforeInTrackedClass(JoinPoint jp) {
    log.info("Метод в аннотированном классе: {}", jp.getSignature().getName());
}
```

### `@args(...)` — параметры с аннотацией
```java
@Before("@args(com.example.aspect.AspectBeforeExecutionParam)")
public void paramWithAnnotation(JoinPoint joinPoint) {
    log.info("Метод вызван с аннотированными параметрами");
}
```

###  Примеры execution(...) выражений
```text
// Любой метод любого класса
execution(* *(..))

// Метод любого класса в пакете
execution(* com.example.service.*.*(..))

// Метод с конкретным именем
execution(* com.example.service.UserService.findUser(..))

// Метод с конкретным типом параметра
execution(* com.example.service.UserService.findUserById(Long))

// Метод, возвращающий List
execution(java.util.List com.example..*.*(..))
```
