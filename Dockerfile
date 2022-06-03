FROM openjdk:8-jdk-alpine
EXPOSE 8087
ADD target/Timesheet-1.0.jar Timesheet-1.0.jar
ENTRYPOINT ["java","-jar","/Timesheet-1.0.jar"]
