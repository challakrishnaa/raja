pipeline{
    agent {label: "slavename"}
    tools{
        tool 'maven version'
    }
    stages{
        stage('git checkout'){
            have to provide the url here
        }
        stage('build'){
            steps{
            sh 'mvn clean package'
        }
        }
        stage('sonar code quality'){
            steps{
                sh 'mvn sonar:sonar'
            }
        }
        stage('publish artifact to nexus'){
            steps{
                sh 'mvn deploy'
            }
        }
    }
}