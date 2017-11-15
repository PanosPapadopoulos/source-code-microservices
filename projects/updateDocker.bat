sudo docker stop projects-ms
sudo docker rm projects-ms
sudo docker rmi flexbridge/projects-ms
sudo mvn clean install -DskipTests
sudo docker run  -p 9002:9002 -d --name projects-ms sourcecode/projects-ms


