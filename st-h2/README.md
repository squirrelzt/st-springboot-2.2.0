H2数据库和JPA组合
spring:
  jackson:
    time-zone: GMT+8
    date-format: yyyy-MM-dd HH:mm:ss
此功能在返回Date、LocalDate、LocalTime、LocalDateTime时可以起到格式化作用；但是当接收时报错。因为SpringBoot2.0以后，Date等时间类型被转换成了时间戳。
在实体类中使用@JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")可以正常接收数据并转换成指定格式。

controller中@RequestMapping中/可以省略

JsonConfig类中JavaTimeModule设置LocalDate、LocalTime、LocalDateTime序列化和反序列化时的格式，将其注册到ObjectMapper中，实现自定义格式化json数据类型  