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

        stage("Test"){
            steps{
                sh "mvn test cobertura:cobertura"
            }
            steps{
                sh /Applications/SoapUI-5.7.0.app/Contents/java/app/bin/testrunner.sh -r -a -j -flogs /Users/camila/Desktop/DevOps_Tareas/REST-Project-2-soapui-project.xml
            }

            steps{
                sh cd /Users/camila/Desktop/DevOps_Tareas/apache-jmeter-5.5/bin
                sh ./jmeter.sh -Jjmeter.save.saveservice.output_format=xml -n -t "/Users/camila/Desktop/DevOps_Tareas/apache-jmeter-5.5/PruebaM4.jmx" -l ./log/csvBlaze.jtl
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