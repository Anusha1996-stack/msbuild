//import groovy.yaml.YamlSlurper
def call()

{

def yamlFile = new File("jenkins.yaml")
//yamlFile.withReader { reader ->
def yaml = new YamlSlurper().parse(reader)


if (yaml.buildEnvironment.agentype == "VM")
{
mcsgcipipelinenew()

}
else 
{
mcsgdockercipipeline()

}
}

