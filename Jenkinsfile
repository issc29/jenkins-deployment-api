pipeline {
    agent any

    stages {
        stage('Build') {
        environment {
               SONAR_PASS = credentials('issc29-sonar')
               GH_ACCESS_TOKEN = credentials('issc29-gh-sonar')
           }
           steps {
            script {
              if(isUnix()) {
                sh 'mvn clean verify sonar:sonar'
                }
              else {
                bat 'mvn clean verify sonar:sonar'
              }
            }
          }
        }
        stage('Sonar - PR') {
         when { expression { return env.CHANGE_ID != "" } }
        environment {
               SONAR_PASS = credentials('issc29-sonar')
               GH_ACCESS_TOKEN = credentials('issc29-gh-sonar')
           }
           steps {
            script {
              if(isUnix()) {
                sh 'mvn clean verify sonar:sonar -Dsonar.analysis.mode=preview -Dsonar.github.pullRequest=${CHANGE_ID} -Dsonar.github.repository=birds-of-a-feather/dc-summit-integration-workshop-ci-java -Dsonar.github.oauth=${GH_ACCESS_TOKEN}'
                }
              else {
                bat 'mvn clean verify sonar:sonar -Dsonar.analysis.mode=preview -Dsonar.github.pullRequest=%CHANGE_ID% -Dsonar.github.repository=birds-of-a-feather/dc-summit-integration-workshop-ci-java -Dsonar.github.oauth=%GH_ACCESS_TOKEN%'
              }
            }
          }
        }
    }
}
