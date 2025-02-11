// Description: This pipeline will update the server and reboot it
//
// Recommendation: Run once a night

pipeline {
    agent any

    stages {
        stage('update') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'unimatrix_herdenadmin_pw', usernameVariable: 'SUDO_USER', passwordVariable: 'SUDO_PW')]) {
                sh 'echo $SUDO_PW | sudo -S apt update'
                }
            }
        }
        stage('upgrade') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'unimatrix_herdenadmin_pw', usernameVariable: 'SUDO_USER', passwordVariable: 'SUDO_PW')]) {
                sh 'echo $SUDO_PW | sudo -S apt-get upgrade -y'
                }
            }
        }
        stage('reboot') {
            steps {
                withCredentials([usernamePassword(credentialsId: 'unimatrix_herdenadmin_pw', usernameVariable: 'SUDO_USER', passwordVariable: 'SUDO_PW')]) {
                sh 'echo $SUDO_PW | sudo -S shutdown -r 1'
                }
            }
        }
    }
}
