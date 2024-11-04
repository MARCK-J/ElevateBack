pipeline {
    agent any

    tools {
        // Usa la instalación de Maven configurada en Jenkins
        maven 'maven 3.8.6' // Nombre exacto de la instalación de Maven
    }

    stages {
        stage('Checkout') {
            steps {
                // Realiza el checkout del repositorio Git
                git url: 'https://github.com/MARCK-J/ElevateBack.git', branch: 'main'
            }
        }

        stage('Build') {
            steps {
                // Construye el proyecto con Maven
                bat 'mvn clean compile'
            }
        }

        stage('Test') {
            steps {
                // Ejecuta las pruebas con Maven
                bat 'mvn test'
            }
        }

        stage('Package') {
            steps {
                // Empaqueta la aplicación en un archivo JAR
                bat 'mvn package'
            }
        }
    }

    post {
        success {
            echo 'Build, test, and package stages completed successfully!'
        }
        failure {
            echo 'Something went wrong with the build process.'
        }
    }
}
