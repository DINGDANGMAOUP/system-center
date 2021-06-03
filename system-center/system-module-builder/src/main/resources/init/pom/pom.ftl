<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
  <parent>
    <artifactId>system-center</artifactId>
    <groupId>com.yinlu</groupId>
    <version>1.0.0-SNAPSHOT</version>
  </parent>
  <modelVersion>4.0.0</modelVersion>

  <artifactId>${projectName}</artifactId>

  <properties>
    <project.build.sourceEncoding>UTF-8</project.build.sourceEncoding>
    <maven.compiler.source>11</maven.compiler.source>
    <maven.compiler.target>11</maven.compiler.target>
  </properties>
  <dependencies>
    <dependency>
      <groupId>com.microsoft.sqlserver</groupId>
      <artifactId>mssql-jdbc</artifactId>
      <scope>runtime</scope>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-validation</artifactId>
    </dependency>
    <dependency>
      <groupId>com.yinlu</groupId>
      <artifactId>system-common-swagger</artifactId>
    </dependency>
    <dependency>
      <groupId>com.yinlu</groupId>
      <artifactId>system-common-mybatis-plus</artifactId>
    </dependency>
    <dependency>
      <groupId>com.yinlu</groupId>
      <artifactId>system-core</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter-web</artifactId>
    </dependency>
    <dependency>
      <groupId>org.springframework.boot</groupId>
      <artifactId>spring-boot-starter</artifactId>
    </dependency>
  </dependencies>
  <profiles>
    <!-- 开发环境 -->
    <profile>
      <activation>
        <activeByDefault>true</activeByDefault>
      </activation>
      <id>dev</id>
      <properties>
        <environment>dev</environment>
        <failOnMissingWebXml>false</failOnMissingWebXml>
      </properties>
    </profile>
    <!-- 测试环境 -->
    <profile>
      <activation>
        <activeByDefault>false</activeByDefault>
      </activation>
      <id>test</id>
      <properties>
        <environment>test</environment>
        <failOnMissingWebXml>false</failOnMissingWebXml>
      </properties>
    </profile>
    <!-- 生产环境 -->
    <profile>
      <activation>
        <activeByDefault>false</activeByDefault>
      </activation>
      <id>prod</id>
      <properties>
        <environment>prod</environment>
        <failOnMissingWebXml>false</failOnMissingWebXml>
      </properties>
    </profile>
  </profiles>
</project>