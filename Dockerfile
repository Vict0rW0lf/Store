FROM openjdk:11
COPY target/store-*.jar store.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "store.jar"]