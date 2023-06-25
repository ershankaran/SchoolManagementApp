FROM ubuntu:latest

MAINTAINER name shankar-sma

RUN apt-get update && apt install -y openjdk-17-jdk 

WORKDIR /usr/local/bin

ENV sma-version=docker-aws-db-0.2
ENV jdbcurl=jdbc:postgresql://sma-aws-db-2.clum3jufsr9p.us-east-1.rds.amazonaws.com:5432/postgres
ENV dbusername=postgres
ENV dbpassword=postgres


ADD target/schoolmanagementapp.jar .

ENTRYPOINT ["java","-jar","schoolmanagementapp.jar"]
