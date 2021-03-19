
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
/*node
{
	script{ datas = readYaml (file: 'jenkins.yaml') }

}*/
pipeline 
{
	agent none

stages
{

	stage('Compile')
        {
                steps
                {
			 script{ datas = readYaml (file: 'jenkins.yaml') }
			println("Hello docker")

		}
	}
	
}
}
}
