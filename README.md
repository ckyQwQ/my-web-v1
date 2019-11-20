1/启动zookeeper
bin/zkServer.sh start

2/启动kafka

3.kafka使用例子
https://www.orchome.com/6


q1.
启动zk

q2.启动kafka
bin/kafka-server-start.sh config/server.properties

q3.创建topic
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test

bin/kafka-topics.sh --list --zookeeper localhost:2181
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic test1
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic test
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic test --from-beginning