pipeline {
    environment {
registry = "seifbouazza/devopsimage"
registryCredential= 'dockerHub'
dockerImage = ''
}
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
                // bat 'mvn org.codehaus.mojo:sonar-maven-plugin:sonar -Dsonar.host.url=http://localhost:9000/'
               bat 'mvn sonar:sonar'
           }
       }
      /*  stage('Run test') {
           steps {
                 bat 'mvn test '
           }
       } */
        stage('Deploy on nexus') {
           steps {
                 bat 'mvn clean package -Dmaven.test.skip=true deploy:deploy-file -DgroupId=tn.esprit.spring -DartifactId=timesheet_devops -Dversion=1.0 -DgeneratePom=true -Dpackaging=jar -DrepositoryId=deploymentRepo -Durl=http://localhost:8081/repository/maven-releases/ -Dfile=target/timesheet_devops-1.0.jar '
           }
        }
       
     stage('Building our image') {
    steps { script { dockerImage= docker.build registry + ":$BUILD_NUMBER" } }
    }
stage('Deploy our image') {
steps { script { docker.withRegistry( '', registryCredential) { dockerImage.push() } } }
}
stage('Cleaning up') {
steps { bat "docker rmi $registry:$BUILD_NUMBER" }
}
    
      
    
}
