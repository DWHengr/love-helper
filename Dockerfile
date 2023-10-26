FROM openjdk:8-alpine
WORKDIR /opt/lovehelper
COPY *.jar ./app.jar
EXPOSE 11520
ENV LANG en US.UTF-8
ENV LANGUAGE en uS:en
ENV LC ALL en_US.UTF-8
RUN rm -f /etc/localtime \
    && ln -sv /usr/share/zoneinfo/Asia/Shanghai /etc/localtime  \
    && echo "Asia/Shanghai" > /etc/timezone
ENTRYPOINT ["java","-jar","./app.jar"]
