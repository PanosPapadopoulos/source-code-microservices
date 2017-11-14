sudo docker stop authentication
sudo docker rm authentication
sudo docker rmi flexbridge/authentication
sudo mvn clean install -DskipTests
sudo docker run  -p 9000:9000 -d --name authentication-ms sourcecode/authentication


