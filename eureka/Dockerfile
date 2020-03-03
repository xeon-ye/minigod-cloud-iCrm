#FROM java:8
#VOLUME /tmp
#ADD ./target/eureka.jar /eureka.jar
#RUN bash -c 'touch /eureka.jar'
#EXPOSE 8761
#ENTRYPOINT ["java","-jar","/eureka.jar"]



# Name:     eureka
# Time:     2017-05-07

FROM java:8

MAINTAINER kouyandong

RUN mkdir /app

WORKDIR /app

COPY ./target/eureka.jar /app

ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-jar", "/app/eureka.jar"]

EXPOSE 8601