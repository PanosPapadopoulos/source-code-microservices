sudo docker stop filestream-ms
sudo docker rm filestream-ms
sudo docker rmi sourcecode/filestream-ms
sudo mvn clean install -DskipTests
sudo docker run  -p 9004:9004 -d --name filestream-ms sourcecode/filestream-ms

