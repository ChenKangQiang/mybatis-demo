# mybatis-demo


## mybatis配置log4j2

1. 在 ``mybatis-config.xml``中开启日志功能
```
<configuration>
    <settings>
        <setting name="logImpl" value="LOG4J2" />
    </settings>
</configuration>
```
2. 在``src/main/resources``目录下添加``log4j2.xml``
```
<?xml version="1.0" encoding="UTF-8"?>
<Configuration status="INFO">
    <Appenders>
        <Console name="Console" target="SYSTEM_OUT">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} [%t] %-5level %logger{36} - %msg%n" />
            <!--可以配置过滤器，进一步控制输出的消息级别-->
            <ThresholdFilter level="debug" onMatch="ACCEPT" onMismatch="DENY"/>
        </Console>

        <!--文件会打印出所有信息，这个log每次运行程序会自动清空，由append属性决定，这个也挺有用的，适合临时测试用-->
        <File name="FileLog" fileName="/data/demologs/mybatis-demo/test.log" append="false">
            <PatternLayout pattern="%d{HH:mm:ss.SSS} %-5level %class{36} %L %M - %msg%xEx%n"/>
        </File>

        <!--这个会打印出所有的信息，每次大小超过size，则这size大小的日志会自动存入按年份-月份建立的文件夹下面并进行压缩，作为存档-->
        <RollingFile name="RollingFile" fileName="/data/demologs/mybatis-demo/app.log"
                     filePattern="log/$${date:yyyy-MM}/app-%d{MM-dd-yyyy}-%i.log.gz">
            <PatternLayout pattern="%d{yyyy-MM-dd 'at' HH:mm:ss z} %-5level %class{36} %L %M - %msg%xEx%n"/>
            <SizeBasedTriggeringPolicy size="50MB"/>
        </RollingFile>

    </Appenders>

    <Loggers>
        <!--将业务dao接口填写进去,并用控制台输出即可-->
        <Logger name="edu.tongji.comm.spring.demo.mappers.UserMapper" level="debug" additivity="false">
            <AppenderRef ref="Console" />
        </Logger>
        <!--未在log4j2.xml中配置的logger都会继承root logger-->
        <Root level="error">
            <AppenderRef ref="Console" />
        </Root>
    </Loggers>

</Configuration>
```