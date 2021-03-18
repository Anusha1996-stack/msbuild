@Library('msbuild@master')_

node {
	stage('compile')
	{
		compile(msbuild, mode=dev build_number=${BUILD_NUMBER} ,WES_UTILS, bremen)
	}

	/*stage('msbuild running')
	{
		println("msbuild file calling")
		msbuild()
		println("msbuild file executed")
	}*/
}