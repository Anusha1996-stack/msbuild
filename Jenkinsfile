@Library('msbuild@master')_

node {

	stage('checkout')
	{
		datas = readYaml(file: 'jenkins.yaml')
	}
	stage('compile')
	{
		compile(datas.compile.builtool, datas.projectname,datas.compile.buildDir)
	}

	/*stage('msbuild running')
	{
		println("msbuild file calling")
		msbuild()
		println("msbuild file executed")
	}*/
}