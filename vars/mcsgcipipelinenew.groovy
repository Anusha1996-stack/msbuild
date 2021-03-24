
//def mcsg-cicd-pipelines() {
//    def jenkinsSettingsMap = [:]
//    scmCheckout 'BitBucketSCM'
//    println("reading jenkins.yaml")
 //   if(fileExists('jenkins.yaml')) {
  //      jenkinsSettingsMap = readYaml file: 'jenkins.yaml'
  //  }

   // return jenkinsSettingsMap
//}
def call()
{
def datas
pipeline 
{
	agent any

stages
{
	stage('Checkout')
	{
		steps
		{
		script{ datas = readYaml (file: 'jenkins.yaml')
		gitclone( datas.sourcecode.gitrepo, datas.sourcecode.gitbranch, 'fa4889703f43518ca02f1c8db37662218c848116',datas.sourcecode.submodule)

		}
	}

	}

	stage('Compile')
        {
                steps
                {
			compile(datas.compile.buildMode,datas.compile.Signcert,datas.compile.ISO,datas.serviceName)

		}
	}
	stage('UnitTest')
	{
		steps
		{
			unittest(datas.serviceName)

		}
	}
	stage('Build Validation Test')
	{
		when{
		  expression{
			datas.buildvalidationtest.BVT == 'YES'
	          }
		}
		steps
		{

		   	buildvalidationtest(datas.serviceName)
		}
		
	}
         stage('Artifact Upload')
	 {
	 	steps
		{
		      artifact_upload()
		 }
	}
	
}
	post {
        always {
            emailext body: '''${SCRIPT, template="groovy-html.template"}''',
            mimeType: 'text/html',
            subject: "Jenkins: ${env.JOB_NAME} | build# ${env.BUILD_NUMBER} - ${currentBuild.result}",
            to: datas.emailID, //to
            replyTo: "CPG_BUILD-INFRA@Dell.com" //replyTo
        }
	}

}

}
