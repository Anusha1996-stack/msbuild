/*def call(String projectname)
{
if (projectname == "DCA_Enabler")
{
def RESET_REL_VERSION = datas.compile.RESET_REL_VERSION
	sh'''
	#!/bin/sh
	if [ ! -z "$RESET_REL_VERSION" ]
                    then
                        echo "In the IF Section"
                        sed -i "s/\\(^PACKAGE_RELEASE=\\).*/\\1\$RESET_REL_VERSION/" /root/version_enabler.txt ;
                        sed -i "s/\\(^PKG_RELEASE=\\).*/\\1\$RESET_REL_VERSION/" ${WORKSPACE}/DCA_ENABLER/INFO  ;
                        sed -i "s/\\(^PKG_RELEASE=\\).*/\\1\$RESET_REL_VERSION/" ${WORKSPACE}/DCA_ENABLER_PACKAGES/INFO  ;
                    else
                        . /root/version_enabler.txt
                        echo "Now Sourcing PACKAGE_RELEASE number"
                        echo "Package release version before increnting is PACKAGE_RELEASE"
                        varInc=`expr \$PACKAGE_RELEASE + 01`
                        echo "Package release version is \$varInc"
                        sed -i "s/\\(^PACKAGE_RELEASE=\\).*/\\1\$varInc/" /root/version_enabler.txt ;
                        sed -i "s/\\(^PKG_RELEASE=\\).*/\\1\$varInc/" ${WORKSPACE}/DCA_ENABLER/INFO ;
                        sed -i "s/\\(^PKG_RELEASE=\\).*/\\1\$varInc/" ${WORKSPACE}/DCA_ENABLER_PACKAGES/INFO ;
                        echo "\$varInc" > /root/env_version.txt
        fi
	'''
}
if (projectname == "Lassan_WDA")
{

        sh'''
        #!/bin/sh
if [ ! -z "$RESET_REL_VERSION" ]
then
      
      sed -i "s/\\(^PACKAGE_RELEASE=\\).*/\\1$RESET_REL_VERSION/" /root/version.txt
      sed -i "s/\\(^PKG_RELEASE=\\).*/\\1$RESET_REL_VERSION/" $WORKSPACE/Deployment/ubuntu/INFO
else
      #echo $RESET_REL_VERSION > /root/version.txt
      #cd $WORKSPACE/Deployment/ubuntu
      source /root/version.txt
      echo "Package release version before increnting is $PACKAGE_RELEASE"
	  i=`expr $PACKAGE_RELEASE + 01`
      echo "Package release version is $i"
      sed -i "s/\\(^PACKAGE_RELEASE=\\).*/\\1$i/" /root/version.txt
      sed -i "s/\\(^PKG_RELEASE=\\).*/\\1$i/" $WORKSPACE/Deployment/ubuntu/INFO
fi
'''
}

}*/
