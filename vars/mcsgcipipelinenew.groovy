
//def mcsg-cicd-pipelines() {
//    def jenkinsSettingsMap = [:]
//    scmCheckout 'BitBucketSCM'
//    println("reading jenkins.yaml")
 //   if(fileExists('jenkins.yaml')) {
  //      jenkinsSettingsMap = readYaml file: 'jenkins.yaml'
  //  }

   // return jenkinsSettingsMap
//}
def call(String emaillist)
{
def datas
/*node
{
	script{ datas = readYaml (file: 'jenkins.yaml') }

}*/
pipeline 
{
	agent any {
	    
	} 

stages
{
	stage('Checkout')
	{
		steps
		{
			script{ datas = readYaml (file: 'jenkins.yaml') }
			gitclone( datas.sourcecode.gitrepo, datas.sourcecode.gitbranch, "fa4889703f43518ca02f1c8db37662218c848116" ,datas.sourcecode.submodule)

		}
	}

	stage('Compile')
        {
                steps
                {
			compile(datas.compile.buildtool, datas.compile.makeParams, datas.serviceName, datas.compile.buildDir)
			script{
			if(datas.codesigning.signing == 'YES') {
				signing(datas.codesigning.signtype, datas.codesigning.signingcert, datas.codesigning.filetobesigned, datas.codesigning.dirforsignedfiles)

			}
			}
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
		      script{
		      if(datas.postbuildactivity.archiveartifact != null && datas.postbuildactivity.archiveartifact != "") {
            			archive(datas.postbuildactivity.archiveartifact)
            	      		return
        		}
			}

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
