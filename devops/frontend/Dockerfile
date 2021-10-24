FROM openjdk:16-slim
USER root

RUN apt-get update &&\
    apt-get install curl -y &&\
    curl -sL https://deb.nodesource.com/setup_10.x | bash - &&\
    apt-get install nodejs -y

WORKDIR /opt
RUN git clone https://github.com/slav9n4ik/english_goodvard

WORKDIR /opt/english_goodvard
RUN rm -R .git

WORKDIR /opt/english_goodvard/frontend
RUN npm install && npm run-script start

WORKDIR /opt/english_goodvard
RUN ./gradlew build

WORKDIR /opt/english_goodvard/core/build/libs
EXPOSE 5000
CMD java -jar core-1.0-SNAPSHOT.jar