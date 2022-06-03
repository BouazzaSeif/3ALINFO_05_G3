pipeline {
    environment {
        registry = 'seifbouazza/devopsimage'
        registryCredential = 'dockerHub'
        dockerImage = ''
    }
    agent any
    tools {
        maven 'maven'
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
      /*  stage('Deploy on nexus') {
           steps {
                 bat 'mvn deploy -Dmaven.test.skip=true'
           }
           stage ('Publish')
           {
           nexusPublisher nexusInstanceId: 'localnexus',
           nexusRepositoryId: 'maven-releases',
           packages: [[$class: 'MavenPackage',
           mavenAssetList: [],
           mavenCoordinate: [artifactId: 'timesheet_devops', groupId: 'tn.esprit.spring', packaging: 'jar', version: '1.0']]]
           steps {
                 bat 'mvn deploy -Dmaven.test.skip=true'
           }
           }
        }*/

        stage('Building our image') {
            steps { script { dockerImage = docker.build registry + ":$BUILD_NUMBER" } }
        }
        stage('Deploy our image') {
            steps
            {
                script
                 {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push()
                    }
                 }
            }
        }
        stage('Cleaning up') {
            steps { bat "docker rmi $registry:$BUILD_NUMBER" }
        }
      /*  post {
            always {
                deleteDir()
            }
        }*/
    }
}

