pipeline {

    agent any

    environment {
        BUILD_VERSION = 1.2
        SERVER_CREDENTIALS = credentials('')
    }

    tools {
        maven 'Maven'
    }

    parameters {
        choice(name: 'Version', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'runTests', defaultValue: true, description: '')
    }

    stages {

        stage("build") {
            when {
                expression {
                    env.BRANCH_NAME == 'dev' || env.BRANCH_NAME == 'main'
                }
            }
            steps {
                echo "Building Stage ..."
                echo "Build for version ${BUILD_VERSION}"
            }
        }
    
        stage("test") {
            when {
                expression {
                    params.runTests == true
                }
            }
            steps {
                echo "Testing Stage ..."
            }
        }

        stage("deploy") {
            steps {
                echo "Deploying Stage ..."
                echo "Deploying version ${params.Version}"
            }
        }
    
    }

    post {

        always {

        }
        success {

        }
        failure {

        }
    }

}
