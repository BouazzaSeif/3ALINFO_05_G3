FROM openjdk:8-jdk-alpine
EXPOSE 8087
ADD target/timesheet_devops-1.0.jar timesheet_devops-1.0.jar
ENTRYPOINT ["java","-jar","/timesheet_devops-1.0.jar"]
