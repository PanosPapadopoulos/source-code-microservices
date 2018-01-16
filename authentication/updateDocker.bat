sudo docker stop authentication-ms
sudo docker rm authentication-ms
sudo docker rmi sourcecode/authentication
sudo mvn clean install -DskipTests
sudo docker run  -p 9000:9000 -d --name authentication-ms sourcecode/authentication


