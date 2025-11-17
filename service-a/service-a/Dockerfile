FROM eclipse-temurin:17-jdk

# Create folder for agent
RUN mkdir /otel

# Copy OTel Java agent into image
COPY otel/opentelemetry-javaagent.jar /otel/opentelemetry-javaagent.jar

# Copy app JAR
COPY target/service-a-0.0.1-SNAPSHOT.jar /app.jar

ENTRYPOINT ["java", "-javaagent:/otel/opentelemetry-javaagent.jar", "-jar", "/app.jar"]

