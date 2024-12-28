pipeline {
    agent any

    tools {
        maven 'sonarmaven' // Configure Maven in Jenkins (Manage Jenkins > Global Tool Configuration)
    }

    environment {
        // Environment variables
        SONAR_TOKEN = credentials('sonar-token') // Replace with your SonarQube token credentials ID
        JAVA_HOME = 'C:\\Program Files\\Java\\jdk-17' // Update with the path to your Java installation
        PATH = "${JAVA_HOME}\\bin;${env.PATH}"
    }

    stages {
        stage('Checkout') {
            steps {
                // Check out code from the source repository
                checkout scm
            }
        }
        stage('Build') {
            steps {
                // Build the project using Maven
                script {
                    sh "mvn clean compile"
                }
            }
        }
        stage('Test') {
            steps {
                // Run unit tests using Maven
                script {
                    sh "mvn test"
                }
            }
        }
        stage('Package') {
            steps {
                // Package the application
                script {
                    sh "mvn package"
                }
            }
        }
        stage('SonarQube Analysis') {
            steps {
                // Execute SonarQube analysis
                script {
                    sh """
                        mvn clean verify sonar:sonar \
                          -Dsonar.projectKey=sonarmaven \
                          -Dsonar.projectName='sonarmaven' \
                          -Dsonar.host.url=http://localhost:9000 \
                          -Dsonar.login=${SONAR_TOKEN}
                    """
                }
            }
        }
        stage('Archive Artifacts') {
            steps {
                // Archive the packaged artifact
                archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
            }
        }
    }

    post {
        always {
            // Clean up workspace
            cleanWs()
        }
        success {
            echo 'Pipeline executed successfully, including SonarQube analysis!'
        }
        failure {
            echo 'Pipeline failed. Please check the logs for details.'
        }
    }
}
