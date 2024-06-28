# Project Setup using below tools

1) Maven
2) Git Hub
3) Jenkins
4) Docker

# Step-1 : Jenkins Server Setup in Linux VM #

1) Ubuntu VM <br/>
2) Enable 8080 Port Number
3) Connect to VM using MobaXterm
4) Install Java

```
sudo apt update
sudo apt install fontconfig openjdk-17-jre
java -version
```

3) Install Jenkins
```
sudo wget -O /usr/share/keyrings/jenkins-keyring.asc \
  https://pkg.jenkins.io/debian-stable/jenkins.io-2023.key
echo deb [signed-by=/usr/share/keyrings/jenkins-keyring.asc] \
  https://pkg.jenkins.io/debian-stable binary/ | sudo tee \
  /etc/apt/sources.list.d/jenkins.list > /dev/null
sudo apt-get update
sudo apt-get install jenkins
```
4) Start Jenkins

```
sudo systemctl enable jenkins
sudo systemctl start jenkins
```

5) Verify Jenkins

```
sudo systemctl status jenkins
```
	
6) Access jenkins server in browser using VM public ip

```
http://public-ip:8080/

```

7) Copy jenkins admin pwd

```
sudo cat /var/lib/jenkins/secrets/initialAdminPassword
```
	   
8) Create Admin Account & Install Required Plugins in Jenkins

## Step-2 : Configure Maven as Global Tool in Jenkins ##

1) Manage Jenkins -> Tools -> Maven Installation -> Add maven <br/>

## Step-3 : Setup Docker in Jenkins ##
```
curl -fsSL get.docker.com | /bin/bash
sudo usermod -aG docker jenkins
sudo usermod -aG docker {SYSTEM USER ON UBUNTU}
sudo systemctl restart jenkins
sudo docker version
```
for docker compose if need
```
# Installe Docker Compose si ce n'est pas déjà fait
if ! [ -x "$(command -v docker-compose)" ]; then
curl -L "https://github.com/docker/compose/releases/download/1.29.2/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
chmod +x /usr/local/bin/docker-compose
fi
```

# Step - 4 : Create Jenkins Job #

- **Stage-1 : Clone Git Repo** <br/> 
- **Stage-2 : Maven Build** <br/>
- **Stage-3 : Create Docker Image** <br/>
- **Stage-4 : Create Docker Container** <br/>

```
pipeline {

    agent any

    tools{
        maven 'm3'
    }

    stages {

        stage('git clone'){
            steps{
                git 'https://github.com/{USER}/{REPO}.git'
            }
        }

        stage('mvn build'){
            steps{
                sh 'mvn clean package'
            }
        }

        stage('docker image'){
            steps{
                sh 'docker build -t img .'
            }
        }

        stage('deployment'){
            steps{
                sh 'docker stop img'
                sh 'docker rm img'
                sh 'docker run -d -p 9090:8080 --name img img'
            }
        }

    }

}
```
with docker compose
```
pipeline {

    agent any

    stages {

        stage('git clone'){
            steps{
                git 'https://github.com/{USER}/{REPO}.git'
            }
        }

        stage('Stop old instances') {
            steps {
                sh 'docker-compose down'
            }
        }

        stage('Build and Deploy') {
            steps {
                sh 'docker-compose up --build -d'
            }
        }

    }

}
```
	
# Step - 5 : Trigger Jenkins Job #


# Step - 6 : Access Application in Browser #

- **We should be able to access our application** <br/>

URL : http://public-ip:port/
	
# We are done with our Setup #

