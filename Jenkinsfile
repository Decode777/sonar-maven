pipeline {
    agent any

    tools {
        maven 'sonarmaven' // Ensure Maven is configured in Jenkins
    }

    environment {
        SONAR_TOKEN = credentials('Sonarqube-token') // Replace with the correct credentials ID
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17' // Ensure this path is correct
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                checkout scm
            }
        }
        stage('Build') {
            steps {
                bat "mvn clean compile"
            }
        }
        stage('Test') {
            steps {
                bat "mvn test"
            }
        }
        stage('SonarQube Analysis') {
            steps {
                bat """
                mvn sonar:sonar ^
                  -Dsonar.projectKey=maven-pro1 ^
                  -Dsonar.host.url=http://localhost:9000 ^
                  -Dsonar.login=${SONAR_TOKEN}
                """
            }
        }
        stage('Package') {
            steps {
                bat "mvn package"
            }
        }
    }

    post {
        always {
            cleanWs() // Ensure workspace cleanup after each run
        }
        success {
            echo 'Pipeline executed successfully!'
        }
        failure {
            echo 'Pipeline failed. Please check the logs for details.'
        }
    }
}
