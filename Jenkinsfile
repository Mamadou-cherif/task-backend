pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: 'https://github.com/Mamadou-cherif/task-backend.git'
            }
        }
        stage('Build') {
            steps {
                echo "Building the project"
            }
        }
        stage('Dockerize') {
            steps {
                echo "Creating Docker image"
            }

        }
        stage('Docker Publish') {
            steps {
                echo "Publishing Docker image"
            }
        }
    }
}
