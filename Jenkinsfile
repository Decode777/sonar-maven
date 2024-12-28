pipeline {
    agent any

    environment {
        // Define global environment variables if needed
        MAVEN_HOME = tool(name: 'Maven', type: 'maven')
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
                    sh "${MAVEN_HOME}/bin/mvn clean compile"
                }
            }
        }
        stage('Test') {
            steps {
                // Run unit tests using Maven
                script {
                    sh "${MAVEN_HOME}/bin/mvn test"
                }
            }
        }
        stage('Package') {
            steps {
                // Package the application
                script {
                    sh "${MAVEN_HOME}/bin/mvn package"
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
            echo 'Build and test stages completed successfully!'
        }
        failure {
            echo 'Build or test failed. Please check the logs.'
        }
    }
}
