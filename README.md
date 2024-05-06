# WeatherApp

# Deployment to Docker and Kubernetes 
<hr>

## Step 1: Creating a Dockerfile in the root directory of your project
1. **Dockerfile**
FROM openjdk:17
COPY target/demo.jar .
EXPOSE 8080
ADD target/demo.jar demo.jar
ENTRYPOINT ["java","-jar","demo.jar"]

2.Run Maven clean and install and build the application.
Two Jar files will be created under target folder.

3.Open the terminal at your project directory
  Check with ```ls``` command if the dockerfile is present or not.
  
## Step 2: Login to DockerHub
1. Create a DockerHub Account
2. Create a public repository on dockerHub by the name: ```repo-name```

## Step 3: Build Docker Image
1. Login docker with (in terminal)
  ``` docker login```

2. Build local image of Docker with
  ``` docker build -t <proj-name>``` .

3. Tag the new image
// new image will be demo with the latest tag
 ```docker tag proj-name username/proj-name```

4. Push the tagged image to Docker Hub Registery
  ``` docker push username/image-name```

## Step 4: Installing Docker Compose
1. Download docker compose by:  
```sudo curl -L https://github.com/docker/compose/releases/latest/download/docker-compose-$(uname -s)-$(uname -m) -o /usr/local/bin/docker-compose```
2. ```sudo chmod +x /usr/local/bin/docker-compose```
3. ```docker-compose version```. (version during creation: ```v2.12.2```)

## Step 5:  Creating Docker Image Configuration
1. Pull postgres image: ```docker pull postgres:14-alpine``` (alpine is lightweight and apt for our app).
2. Create a yaml file: ```vim docker-compose.yml```.
3. Paste following inside the yaml file:
```
version: '3.5'
services:
  flights:
    image: skieer/flightapp
    ports:
      - 8080:8080
    environment:
      SPRING_DATASOURCE_URL: 'jdbc:postgresql://postgres:5432/<db-name>'      
      SPRING_DATASOURCE_USERNAME: <db-username>
      SPRING_DATASOURCE_PASSWORD: <db-password>

  postgres:
    image: postgres:14-alpine
    ports:
      - 5432:5432
    environment:
      - POSTGRES_DB=<db-name>
      - POSTGES_USER=<db-username>
      - POSTGRES_PASSWORD=<db-password>
```
4. Run the config file using: ```docker-compose up -d```  
-d : run in detached state
5. Access application using ```<public_dns>:8080/api/login``` and test on Postman.

## Step 6: Install Kubectl 
### Kubectl
1. ```curl -o kubectl https://s3.us-west-2.amazonaws.com/amazon-eks/1.22.6/2022-03-09/bin/linux/amd64/kubectl```
2. ```chmod +x ./kubectl```
3. ```mkdir -p $HOME/bin && cp ./kubectl $HOME/bin/kubectl && export PATH=$PATH:$HOME/bin```
4. ```kubectl version --short --client``` (Version during Creation: ```Client Version: v1.22.6-eks-7d68063```)
 
## Step 7: Install minikube
### Minikube
1.curl -LO https://storage.googleapis.com/minikube/releases/latest/minikube-darwin-amd64
2.sudo install minikube-darwin-amd64 /usr/local/bin/minikube
3.minikube start
4.minikube status

###  Step 8: Deployment Config File
1. Create app-deployment file  and db-deployment file in the root directory of project.

## Step 9: Apply the Deployment and Service Config to Kubernetes
1. ```kubectl apply -f deploy.yml```.
2. ```kubectl apply -f service.yml```.
3. Check for the deployments
  ``` kubectl get deployments ```
4. To view Pods: ```kubectl get pods -o wide```

## Step 10: Check the logs for respective pods
1.``` kubectl logs <pod-name>
   

