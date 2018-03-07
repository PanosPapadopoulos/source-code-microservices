sudo docker stop discovery-server
sudo docker rm discovery-server
sudo docker rmi sourcecode/discovery-server
sudo mvn clean install -DskipTests
sudo docker run  -p 1112:1112 -d --name discovery-server -m 150M sourcecode/discovery-server

