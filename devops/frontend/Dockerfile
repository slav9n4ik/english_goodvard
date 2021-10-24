FROM node:latest
USER root

WORKDIR /opt
RUN git clone https://github.com/slav9n4ik/english_goodvard &&\
    mv /opt/english_goodvard/frontend /home && rm -R /opt/english_goodvard

WORKDIR /home/frontend
RUN npm install

EXPOSE 5000
CMD npm run-script start