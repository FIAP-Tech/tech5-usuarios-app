FROM azul/zulu-openjdk-alpine:21
ENV DATASOURCE_URL DATASOURCE_URL
ENV DATASOURCE_USERNAME DATASOURCE_USERNAME
ENV DATASOURCE_PASSWORD DATASOURCE_PASSWORD
EXPOSE 8080
COPY target/*.jar usuarios-0.0.1-SNAPSHOT.jar
ENTRYPOINT ["java","-jar","/usuarios-0.0.1-SNAPSHOT.jar"]
