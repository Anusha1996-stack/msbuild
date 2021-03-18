@Library('msbuild@master')_

node {
	stage('compile')
	{
		compile(msbuild,WES_UTILS, bremen)
	}

	/*stage('msbuild running')
	{
		println("msbuild file calling")
		msbuild()
		println("msbuild file executed")
	}*/
}