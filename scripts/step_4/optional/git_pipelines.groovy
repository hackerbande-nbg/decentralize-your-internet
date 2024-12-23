pipeline {    // this is a demo pipeline for tests for git pipelines
    agent any  // always keep control of repos you call jenkins pipelines from!

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World from a git repo'
            }
        }
    }
}
