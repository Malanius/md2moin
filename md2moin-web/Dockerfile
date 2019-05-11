FROM openjdk:8-jdk-alpine

MAINTAINER Malanius Privierre <malaniusprivierre@gmail.com>

ARG DEPENDENCY=target/dependency
COPY ${DEPENDENCY}/BOOT-INF/lib /app/lib
COPY ${DEPENDENCY}/META-INF /app/META-INF
COPY ${DEPENDENCY}/BOOT-INF/classes /app
ENTRYPOINT ["java","-cp","app:app/lib/*","net.malanius.md2moin.web.WebMain"]

EXPOSE 8080
