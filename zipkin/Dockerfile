FROM java:8

MAINTAINER kouyandong

RUN mkdir /app

WORKDIR /app

COPY ./target/zipkin.jar /app

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/zipkin.jar"]

EXPOSE 8603