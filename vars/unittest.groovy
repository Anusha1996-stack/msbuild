/*def call (String projectname)
{
if( projectname == "DHC1.5" )
{
sh '''
#!/bin/sh   
	cd bremen_build
	make run-unittest
        rm -rf squashfs-root
'''
}
else
{
println ("No other project to unittest")
}
}*/
def call (String projectname)
{
if( projectname == "WES_UTILS" )
{
bat '''
        msbuild /t:clean/property:configuration=Release
        msbuild /t:build/property:configuration=Release "${buildParams}"
        rm -rf CSE_DIR
        rm -rf DCEditor_DIR
        '''
}
else
{
println ("No other project to unittest")
}
}
