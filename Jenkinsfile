pipeline {
agent any
stages {
stage ('GIT') {
steps {
echo "Getting Project from Git";
git "https://github.com/BouazzaSeif/3ALINFO_05_G3";
}
}
stage ('MVN CLEAN') {
steps {
echo "Maven Clean";
bat 'mvn clean';
}
}
stage ('MVN TEST') {
steps {
echo "Maven Test JUnit";
bat 'mvn test';
}
}
}
}