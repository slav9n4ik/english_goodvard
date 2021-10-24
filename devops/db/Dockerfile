FROM node:latest
USER root

WORKDIR /opt
RUN git clone https://github.com/slav9n4ik/GoodVard

WORKDIR /opt/GoodVard
RUN rm -R .git

WORKDIR /opt/GoodVard/goodvard
RUN npm install && npm install nodemon
COPY goodvard/mail-config.js /opt/GoodVard/goodvard/mail-config.js

WORKDIR /opt/GoodVard/goodvard/client
RUN npm install &&\
    npm run-script build &&\
    rm -R node_modules &&\
    rm -R src &&\
    rm -R public

EXPOSE 5000
CMD npm run-script server --prefix /opt/GoodVard/goodvard