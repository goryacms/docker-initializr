-- Mongo
insert into port (id , app , docker, services_id)
values ( 1, 27017, 27017, 2 );
-- Mongo express
insert into port (id , app , docker, services_id)
values ( 2, 8081, 8081, 3 );
-- H2
insert into port (id , app , docker, services_id)
values ( 3, 7071, 8181, 10 );
insert into port (id , app , docker, services_id)
values ( 4, 1521, 1521, 10 );
-- Apache
insert into port (id , app , docker, services_id)
values ( 5, 7084, 80, 4 );
-- Nginx
insert into port (id , app , docker, services_id)
values ( 6, 8084, 80, 5 );
-- Oracle
insert into port (id , app , docker, services_id)
values ( 7, 1527, 1521, 6 );
insert into port (id , app , docker, services_id)
values ( 8, 7080, 8080, 6 );
-- Postgres
insert into port (id , app , docker, services_id)
values ( 9, 5432, 5432, 1 );
-- RabbiMQ
insert into port (id , app , docker, services_id)
values ( 10, 5672, 5672, 7 );
insert into port (id , app , docker, services_id)
values ( 11, 15672, 15672, 7 );
-- Elasticsearch
insert into port (id , app , docker, services_id)
values ( 12, 9200, 9200, 8 );
insert into port (id , app , docker, services_id)
values ( 13, 9300, 9300, 8 );
-- Kibana
insert into port (id , app , docker, services_id)
values ( 14, 5601, 5601, 9 );
-- Zookeeper
insert into port (id , app , docker, services_id)
values ( 15, 2181, 2181, 11 );
-- Kafka
insert into port (id , app , docker, services_id)
values ( 16, 9092, 9092, 12 );
-- Cassandra
insert into port (id , app , docker, services_id)
values ( 17, 7000, 7000, 13 );
insert into port (id , app , docker, services_id)
values ( 18, 7001, 7001, 13 );
insert into port (id , app , docker, services_id)
values ( 19, 7199, 7199, 13 );
insert into port (id , app , docker, services_id)
values ( 20, 9042, 9042, 13 );
insert into port (id , app , docker, services_id)
values ( 21, 9160, 9160, 13 );