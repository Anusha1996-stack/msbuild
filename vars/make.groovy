def call (String makeParams, String projectname, String buildDir)
{
dir(buildDir)
{
def lst = ["DCA_Enaber", "Lassan_WDA"];

      println(lst.contains(projectname));

	version(projectname)

if( projectname.take(3) == "DHC" || projectname == "Lassan_WDA")
{
	sh '''
	#!/bin/sh
	#cd bremen_build
	make clean
'''
}

sh '''
#!/bin/sh
sudo make ${makeParams}
'''

}

}
