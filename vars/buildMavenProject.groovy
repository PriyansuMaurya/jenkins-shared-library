def call(String projectPath = '.') {
    pipeline {
        agent any
        stages {
            stage('Build Maven Project') {
                steps {
                    script {
                        echo "Building Maven Project in: ${projectPath}"
                        sh "cd ${projectPath} && mvn clean package"
                    }
                }
            }
        }
    }
}
