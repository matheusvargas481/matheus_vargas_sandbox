FROM openjdk:8-alpine

RUN apk update && apk add bash && apk add wget

RUN wget http://mirror.nbtelecom.com.br/apache/kafka/2.4.0/kafka_2.12-2.4.0.tgz && tar -xzf kafka_2.12-2.4.0.tgz

RUN export JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64

WORKDIR /kafka_2.12-2.4.0

EXPOSE 9092

ENTRYPOINT [ "/bin/bash", "-c", "bin/zookeeper-server-start.sh config/zookeeper.properties && bin/kafka-server-start.sh config/server.properties && bin/kafka-topics.sh --create --bootstrap-server localhost:9092 --replication-factor 1 --partitions 1 --topic myTopic"]