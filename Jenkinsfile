
def gv

pipeline {

    agent any

    environment {
        BUILD_VERSION = '1.2.0'
    }

    parameters {
        choice(name: 'Version', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'runTests', defaultValue: true, description: '')
    }

    tools {
        maven 'Maven'
    }
    
    stages {

        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("build") {
            when {
                expression {
                    env.BRANCH_NAME == 'dev' || env.BRANCH_NAME == 'main'
                }
            }
            steps {
                script {
                    gv.buildApp()
                }
            }
        }
    
        stage("test") {
            when {
                expression {
                    params.runTests == true
                }
            }
            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage("deploy") {
            steps {
                script{
                    gv.deployApp()
                }
            }
        }
    
    }
}
