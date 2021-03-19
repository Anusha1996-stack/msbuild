
#!/usr/bin/env groovy

def call(String tolist)
{
	post {
        always {
            emailext body: '''${SCRIPT, template="groovy-html.template"}''',
            mimeType: 'text/html',
            subject: "Jenkins: ${env.JOB_NAME} | build# ${env.BUILD_NUMBER} - ${currentBuild.result}",
            to: "CPG_BUILD-INFRA@Dell.com", tolist //to
            replyTo: "CPG_BUILD-INFRA@Dell.com" //replyTo
        }
}
}

}
