def call()

stages {
        stage('Checkout and Version') {
            steps {
            checkout([
            $class: 'GitSCM',
            branches: [[name: branchID]],
            doGenerateSubmoduleConfigurations: false,
            extensions: [[$class: 'CloneOption', timeout: 120, depth: 5, noTags: false, reference: '', shallow: true], [$class: 'SubmoduleOption', recursiveSubmodules: true], [$class: 'CleanBeforeCheckout'], [$class: 'CleanCheckout']],
            submoduleCfg: [],
            userRemoteConfigs: [[credentialsId: gitUserID, url: gitURLString]]
            ])
        }
        }

