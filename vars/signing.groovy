def call(String signtype, String certificate, String filestobesigned, String dirforsignedfiles)
{
if( ${signtype} == "openSSL")
{

sh '''
#!bin/sh
#chmod +x /opt/signtool1/sign_tool.py
sudo python2 /opt/Signing.py $dirforsignedfiles $filestobesigned $certificate
'''

}
/*else
{
	//windows
}
fi*/
}

