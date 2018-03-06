sudo docker stop discovery-server
sudo docker rm discovery-server
sudo docker rmi sourcecode/discovery-server
sudo mvn clean install -DskipTests
sudo docker run  -p 9004:9004 -d --name discovery-server sourcecode/discovery-server

