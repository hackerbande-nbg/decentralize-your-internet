# Step 3 - Install docker

- update your package manager and add docker repo [see script](../scripts/step_3/add_docker_apt_repo.sh)
```bash
# Add Docker's official GPG key:
sudo apt-get update
sudo apt-get install ca-certificates curl
sudo install -m 0755 -d /etc/apt/keyrings
sudo curl -fsSL https://download.docker.com/linux/ubuntu/gpg -o /etc/apt/keyrings/docker.asc
sudo chmod a+r /etc/apt/keyrings/docker.asc

# Add the repository to Apt sources:
echo \
  "deb [arch=$(dpkg --print-architecture) signed-by=/etc/apt/keyrings/docker.asc] https://download.docker.com/linux/ubuntu \
  $(. /etc/os-release && echo "$VERSION_CODENAME") stable" | \
  sudo tee /etc/apt/sources.list.d/docker.list > /dev/null
sudo apt update
```
- install docker and put your user into the docker group [see script](../scripts/step_3/install_docker.sh)
```bash
sudo apt install -y docker-ce docker-ce-cli containerd.io docker-buildx-plugin docker-compose-plugin
sudo usermod -aG docker $(whoami)
```
- logout with 
```bash 
exit
```
- logon again and test your installation
```bash
docker run hello-world
```
Should pull the hello-world image from Docker Hub and show a lengthy "Hello from Docker! ..." message.
