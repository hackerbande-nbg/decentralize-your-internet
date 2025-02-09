# Step 4 - Install jenkins

- install jenkins (add keyring, add repository, install jenkins)
```bash
sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
    https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key
echo "deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc]" \
    https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
    /etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt update
sudo apt install -y fontconfig openjdk-17-jre
sudo apt install -y jenkins
```
- find out your current ip
```bash
ip -4 addr show | grep -oP '(?<=inet\s)\d+(\.\d+){3}'
```
- you will get 3 ip addresses, 127.0.0.1=localhost, 172.17.x.x=Docker host, you private network ip e. g. 192.168.x.x=your-ip 
- on your admin machine, open your browser and go to http://`<`your-ip`>`:8080
- this will open the jenkins web interface
- copy the password from the console
```bash
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```
- type the password into the web interface
- you can now install plugins in jenkins
  - the default installation aims for developer setups
  - we don't need that, but it doesn't hurt
  - if you select yourself, the following are not needed:
    - ant, gradle, PAM authentication, LDAP authentication, matrix authorization
- click Install
- wait for the installation to finish
- add your admin user
  - username: clenkins
  - password: clenkins
  - full name: Cloudy McCloudface
  - email: none@cloudy.com (jenkins can send mails if things go south)
- Jenkins URL: Keep Default
- Instance Configuration: Save and Finish
- Start using Jenkins 🌈

# Post Installation

- For details on the Jenkins setup, check: [4.1-jenkins_nodes.md](4.1-jenkins_nodes.md)
 - For details on the setup of pipelines, check [4.2-add_jenkins_pipelines.md](4.2-add_jenkins_pipelines.md)
  