pipeline {
    environment {
        maven = tool 'maven350'
        EMAIL_RECIPIENTS = "seifeddine.bouazza@esprit.tn"
        registry = 'seifbouazza/devopsimage'
        registryCredential = 'dockerHub'
        dockerImage = ''
    }
    
    agent any
    tools {
         maven 'maven350'
        jdk 'jdk'
    }
     stages {
        stage('cloning project') {
            steps {
                git 'https://github.com/BouazzaSeif/3ALINFO_05_G3.git'
            }
        }
        stage('build') {
            steps {
                bat 'mvn clean install -DskipTests -X '
            }
        }
     
        stage('Run test') {
           steps {
                 bat 'mvn test '
           }
       } 
         stage('Sonar') {
            steps {
                // bat 'mvn org.codehaus.mojo:sonar-maven-plugin:sonar -Dsonar.host.url=http://localhost:9000/'
                bat 'mvn sonar:sonar'
            }
        }
       stage('Deploy on nexus') {
           steps {
bat 'mvn clean package -Dmaven.test.skip=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar  -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet_devops-1.0.jar'
           }
       }
        stage('Build Docker image') {
            steps { script { dockerImage = docker.build registry + ":$BUILD_NUMBER" } }
        }
        stage('Deploy Docker image') {
            steps
            {
                script
                 {
                    docker.withRegistry('', registryCredential)
                     {
                        dockerImage.push()
                     }
                 }
            }
        }
        stage('Cleaning up') {
            steps { bat "docker rmi $registry:$BUILD_NUMBER" }
        }
     }
    post {
            always {
                 mail(
                        to: "${EMAIL_RECIPIENTS}",
                        replyTo: "${EMAIL_RECIPIENTS}",
                        subject:
                         "[BuildResult][${currentBuild.currentResult}] - Job '${env.JOB_NAME}' (${env.BUILD_NUMBER})",
                        mimeType: 'text/html',
                        body:
                        /* groovylint-disable-next-line GStringExpressionWithinString */
                        "Hello ,our runner finish the build with Status ${currentBuild.currentResult} on ${env.JOB_NAME} project"
                        )
                deleteDir()
            }        
    }
    
     options {
            buildDiscarder(logRotator(numToKeepStr: '4'))
            timeout(time: 60, unit: 'MINUTES')
        }
}


