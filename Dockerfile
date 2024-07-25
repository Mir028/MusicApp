FROM maven AS build

WORKDIR /app

COPY src ./src

COPY pom.xml .

RUN mvn clean package -DskipTests


FROM openjdk:21-jdk

WORKDIR /app

COPY --from=build /app/target/Music_App-0.0.1-SNAPSHOT.jar app.jar

EXPOSE 8080

CMD ["java", "-jar", "app.jar"]
