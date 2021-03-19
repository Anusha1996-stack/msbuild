#!/usr/bin/env groovy

def call() //parameters
{
                rtPublishBuildInfo (
                    serverId: "Artifactory Version 6.8.12",
                    buildName: "${JOB_NAME}",
                    buildNumber: "${BUILD_NUMBER}"
                )

                rtUpload (
                    serverId: "Artifactory Version 6.8.12",
                    spec:
                        """{
                            "files": [
                                {
                                "pattern": "*.deb, *.signature",
                                "target": "CPG-Builds/LASSEN_WDA/${JOB_NAME}/${BUILD_NUMBER}/"
                                }
                            ]
                        }"""
                )
}
  
