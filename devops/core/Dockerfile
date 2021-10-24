FROM openjdk:11-slim
USER root

RUN apt-get update &&\
    apt-get install git-core -y &&\
    mkdir -p /root/Projects/goodvard-config

COPY ./application.properties /root/Projects/goodvard-config

WORKDIR /opt
RUN git clone https://github.com/slav9n4ik/english_goodvard
WORKDIR /opt/english_goodvard
RUN ./gradlew build && mv /opt/english_goodvard/core/build/libs /home && rm -R /opt/english_goodvard

WORKDIR /home/libs
EXPOSE 8080
CMD java -jar core-1.0-SNAPSHOT.jar