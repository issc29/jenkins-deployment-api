pipeline {
    agent any

    stages {
        stage('Build') {
        environment {
               SONAR_PASS = credentials('issc29-sonar')
               GH_ACCESS_TOKEN = credentials('issc29-gh-sonar')
           }
            steps {
                bat 'mvn clean verify sonar:sonar'
                bat 'mvn clean verify sonar:sonar -Dsonar.analysis.mode=preview -Dsonar.github.pullRequest=1 -Dsonar.github.repository=birds-of-a-feather/dc-summit-integration-workshop-ci-java -Dsonar.github.oauth=${GH_ACCESS_TOKEN}'
            }
        }
    }
}
