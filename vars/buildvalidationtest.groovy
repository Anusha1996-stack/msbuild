def call(String projectname)
{
if (projectname == "DHC1.5")
{
	build job: 'Trigger_BVT_DHC', parameters: [[$class: 'StringParameterValue', name: 'BundleNumber', value: 'LATEST']]
}
else
{
	println ("No other project to be tested")
}
}
