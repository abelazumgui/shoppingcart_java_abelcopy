FROM mysql:latest AS mysql_tienda
ENV MYSQL_DATABASE tienda
COPY ./sql-script/ /docker-entrypoint-initdb.d/

FROM openjdk:latest AS rest_service_tienda
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} app.jar
ENTRYPOINT ["java","-jar","/app.jar"]