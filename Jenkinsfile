pipeline {
    agent any
    tools {
        maven "maven"
        jdk "jdk"
    }
    stages {
        stage('cloning project') {
            steps {
                git 'https://github.com/BouazzaSeif/3ALINFO_05_G3.git'
            }
        }
        stage('build'){
            steps {
                bat 'mvn clean install -DskipTests -X '
            }
        }
        stage('Sonar') {
           steps {
                 bat 'mvn org.codehaus.mojo:sonar-maven-plugin:sonar -Dsonar.host.url=http://localhost:9000/'
           }
       }
      /*  stage('Run test') {
           steps {
                 bat 'mvn test '
           }
       } */
        stage('Deploy on nexus') {
           steps {
                 bat 'mvn deploy -DskipTests  '
           }
        }
        stage('Build docker file'){
            steps {
                bat 'mvn clean package docker:build -DskipTests -X '
                }
            }
        stage('Build docker image') {
           steps {
               script{
                   bat "docker build -t ramezrm212/master:timesheet-$BUILD_NUMBER /var/jenkins_home/workspace/TestDocker/Timesheet/target/docker/timesheet/build"

               }
           }
        }        
        stage('run docker image'){
            steps {
               
                bat 'mvn exec:exec@run-on-docker -Ddocker-image-name=ramezrm212/master:timesheet-$BUILD_NUMBER -X -f 3ALINFO_05_G3'
                }
            }

         stage('push to docker-HUB') {
           steps {
        withCredentials([usernamePassword(credentialsId: 'testcrd', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
           bat "echo $PASS | docker login -u $USER --password-stdin"
           bat 'docker push ramezrm212/master:timesheet-$BUILD_NUMBER'
       
               }  
           }
        }
         stage('clean') {
            steps {
                bat 'docker rmi -f ramezrm212/master:timesheet-$BUILD_NUMBER'
                bat 'docker rmi -f timesheet'
            }
         }
    }
}
