sudo docker stop zuulkeeper-gateway
sudo docker rm zuulkeeper-gateway
sudo docker rmi sourcecode/zuulkeeper-gateway
sudo mvn clean install -DskipTests
sudo docker run  -p 443:443 -d --name zuulkeeper-gateway sourcecode/zuulkeeper-gateway

