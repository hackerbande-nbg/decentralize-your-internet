pipeline {
    agent { node { label 'master' } }  // this is how you can reference agents with a specific label

    stages {
        stage('Hello') {
            steps {
                echo 'Hello World on specific machine'
            }
        }
    }
}
