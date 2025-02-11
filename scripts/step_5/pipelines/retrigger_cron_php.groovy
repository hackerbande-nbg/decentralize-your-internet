// this pipeline executes the cron.php script in the Nextcloud container
// to trigger the nextcloud event system
// 
// Recommendation: Run every 30 minutes

pipeline {
    agent any
    
    
    stages {

        stage('Docker Compose Operations') {
            steps {
                    // Perform docker-compose commands
                    sh '''
                        docker exec -u www-data cloudy_app_nextcloud php cron.php
                    '''
            }
        }
    }

    post {
        always {
            echo 'Pipeline execution complete.'
        }
        failure {
            echo 'Pipeline failed.'
        }
    }
}
