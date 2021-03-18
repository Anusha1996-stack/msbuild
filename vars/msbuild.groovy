def call (String buildParams, String projectname, String buildDir, String Platform)
{
sh '''
dir(buildDir)
{
def W = ["WES_UTILS"];

      println(W.contains(projectname));

	version(projectname)

if( projectname.take(W) == "WES_UTILS")
{
	bat '''
        msbuild /t:clean/property:configuration=Release
'''
}

bat '''
msbuild /t:build/property:configuration=Release "${buildParams}"
'''
'''
}

}
