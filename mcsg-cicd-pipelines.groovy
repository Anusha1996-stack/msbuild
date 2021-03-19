#!/usr/bin/groovy
import java.util.ArrayList
import java.util.UUID


def readPipelineYaml() {
    def jenkinsSettingsMap = [:]
    scmCheckout 'BitBucketSCM'
    println("reading jenkins.yaml")
    if(fileExists('jenkins.yaml')) {
        jenkinsSettingsMap = readYaml file: 'jenkins.yaml'
    }

    return jenkinsSettingsMap
}
def runstages() {

gitclone(gitrepo,570d9806-0dc7-4d24-a611-5dc7227f2842,gitbranch,submodule)
}		
