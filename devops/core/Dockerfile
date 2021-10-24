FROM openjdk:16-slim
USER root

FROM openjdk:16-slim
USER root

RUN apt-get update &&\
    apt-get install git-core -y &&\
    mkdir -R /home/root/Projects/goodvard-config

COPY /home/root/Projects/goodvard-config/application.yaml /home/root/Projects/goodvard-config/application.yaml

WORKDIR /opt
RUN git clone https://github.com/slav9n4ik/english_goodvard

WORKDIR /opt/english_goodvard
RUN ./gradlew build

WORKDIR /opt/english_goodvard/core/build/libs
EXPOSE 8080
CMD java -jar core-1.0-SNAPSHOT.jar