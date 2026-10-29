<?xml version="1.0" encoding="UTF-8"?>
<Configuration>
<Appenders>
<Console name="Console">
<PatternLayout pattern="%d %-5level - %msg%n"/>
</Console>
<File name="File" fileName="logs/test.log">
<PatternLayout pattern="%d %-5level - %msg%n"/>
</File>
</Appenders>
<Root level="info">
<AppenderRef ref="Console"/>
<AppenderRef ref="File"/>
</Root>
</Configuration>