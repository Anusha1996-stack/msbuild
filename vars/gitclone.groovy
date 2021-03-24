/*def call(String gitURLString, String branchID, String gitUserID, Boolean submodule)
{
            checkout([
            $class: 'GitSCM',
            branches: [[name: branchID]],
            doGenerateSubmoduleConfigurations: false,
            extensions: [[$class: 'CloneOption', timeout: 120, depth: 1, noTags: false, reference: '', shallow: true], [$class: 'SubmoduleOption', recursiveSubmodules: submodule]], [$class: 'CleanCheckout']],
            submoduleCfg: [],
            userRemoteConfigs: [[credentialsId: gitUserID, url: gitURLString]]
            ])
 	
}*/

def call(String gitURLString, String branchID, String gitUserID, String submodule)
{
            checkout([
            $class: 'GitSCM',
            branches: [[name: branchID]],
            doGenerateSubmoduleConfigurations: false,
            extensions: [[$class: 'CloneOption', timeout: 120, depth: 1, noTags: false, reference: '', shallow: true], [$class: 'SubmoduleOption', recursiveSubmodules: submodule], [$class: 'CleanBeforeCheckout'], [$class: 'CleanCheckout']],
            submoduleCfg: [],
            userRemoteConfigs: [[credentialsId: gitUserID, url: gitURLString]]
            ])

}

