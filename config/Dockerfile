FROM java:8

MAINTAINER kouyandong

RUN mkdir /app

WORKDIR /app

COPY ./target/config.jar /app

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/config.jar"]

EXPOSE 8600