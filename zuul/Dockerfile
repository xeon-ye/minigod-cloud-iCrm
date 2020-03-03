FROM java:8

MAINTAINER kouyandong

RUN mkdir /app

WORKDIR /app

COPY ./target/zuul.jar /app

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/zuul.jar"]

EXPOSE 8602