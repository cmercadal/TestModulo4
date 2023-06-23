def COLOR_MAP = [
    'SUCCESS': 'good',
    'FAILURE':'danger',
    ]


pipeline {
    agent any

    tools {
        maven "mvn386"
        jdk "java16"
    }


    stages {


        stage("Build con Maven"){
            steps{
                sh "mvn -Dmaven.test.failure.ignore=true clean package"
            }

            post{
                success{
                echo 'archivando artefactos'
                archiveArtifacts "target/*.jar"
                }
            }
        }

        stage("Test maven"){
            steps{
                sh "mvn test"
            }
        }


    }

    post {
        always{
            echo "Slack Notifications"
            slackSend channel: '#pipelines',
            color: COLOR_MAP[currentBuild.currentResult],
            message:"*${currentBuild.currentResult}: Job ${env.JOB_NAME} build ${env.BUILD_NUMBER}\n More Info at: ${env.BUILD_URL}"
        }
    }




}