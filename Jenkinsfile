pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                echo "_________________________________________Checkout_______________________"
                echo "checkout ${env.BRANCH_NAME}"
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
