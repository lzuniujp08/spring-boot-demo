# spring-boot-demo

一个简单的Spring Boot工程，主要实现：

1、工程的初始化；

2、数据库的连接与操作（增、删、改、查）；

3、接口的跨域设置与接口结构的包装；

4、swagger接口文档的引入。

##### 1、初始化
```mvn install```

##### 2、启动
```mvn spring-boot:run```

##### 3、编译与启动
###### 3.1 编译
```mvn package```
###### 3.2 启动
```java -jar ./spring-boot-demo-0.0.1-SNAPSHOT.jar```

启动后访问[swagger接口文档](访问 http://127.0.0.1:18081/swagger-ui.html#/)