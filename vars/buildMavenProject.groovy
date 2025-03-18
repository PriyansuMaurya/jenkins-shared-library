def call(String projectPath = '.') {
    pipeline {
        agent any
        stages {
            stage('Build Maven Project') {
                steps {
                    script {
                        try {
                            echo "Building Maven Project in: ${projectPath}"
                            def buildResult = sh(script: "cd ${projectPath} && mvn clean package", returnStatus: true)

                            if (buildResult == 0) {
                                echo "✅ Build was successful!"
                            } else {
                                error "❌ Build failed. Check logs for details."
                            }
                        } catch (Exception e) {
                            error "Build process encountered an error: ${e.message}"
                        }
                    }
                }
            }
        }
    }
}
