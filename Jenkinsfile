@Library('msbuild@master')_

node {
	stage('compile')
	{
		compile(msbuild, mode=dev build_number=${BUILD_NUMBER} cert=WES_UTILS_selfsign ,WES_UTILS, bremen)
	}

	/*stage('msbuild running')
	{
		println("msbuild file calling")
		msbuild()
		println("msbuild file executed")
	}*/
}