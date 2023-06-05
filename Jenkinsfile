pipeline {
    agent any

    stages {
        stage('checkout') {
            steps {
                git credentialsId: 'github-ssh-key', url: 'git@github.com:dsh-dsh/iex-plug.git'
                sh "ls -la"
            }
        }
    }
}