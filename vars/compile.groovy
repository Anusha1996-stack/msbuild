def call(String buildtool, String projectname, String buildDir)
{
//script{ datas = readYaml (file: 'jenkins.yaml') }
if ( buildtool == "make" ) {   //previously ( ${datas.compile.makeParams}, ${datas.projectname}, ${datas.compile.buildDir}), projectname doesnt exist in yaml, its serviceName
make( makeParams, projectname, buildDir)
}
else if ( buildtool == "msbuild" ) {
msbuild(projectname, buildDir)
}
else if ( buildtool == "cmake" ) {
cmake()
}
else if ( buildtool == "maven" ) {
maven()
}
else if ( buildtool == "devenv" ) {
devenv()
}
}
