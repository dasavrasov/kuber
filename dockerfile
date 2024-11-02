# Start with a base image containing Java runtime
FROM openjdk:17-jdk-alpine

 #Add a label to the image
LABEL author=dasavrasov

EXPOSE 9000

 # Add metadata to the image
ARG JAR_FILE=target/*.jar

 # Copy the jar file to the container image
COPY ${JAR_FILE} app.jar

COPY src/main/resources /app/resources

# Run the jar file
ENTRYPOINT ["java","-jar","/app.jar"]


