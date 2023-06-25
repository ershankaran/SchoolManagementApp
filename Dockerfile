FROM ubuntu:latest

MAINTAINER name shankar-sma

RUN apt-get update && apt install -y openjdk-17-jdk 

WORKDIR /usr/local/bin

ENV sma-version=docker-0.1
ENV jdbcurl
ENV dbusername
ENV dbpassword


ADD schoolmanagementapp-0.0.1-SNAPSHOT.jar .

ENTRYPOINT ["java","-jar","schoolmanagementapp-0.0.1-SNAPSHOT.jar"]
