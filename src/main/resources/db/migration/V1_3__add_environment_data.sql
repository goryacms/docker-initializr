-- Mongo
insert into environment (id , valueName, services_id )
values (1, 'MONGO_INITDB_ROOT_USERNAME: manhattan', 2);
insert into environment (id , valueName, services_id )
values (2, 'MONGO_INITDB_ROOT_PASSWORD: manhattan123', 2);
insert into environment (id , valueName, services_id )
values (3, 'MONGO_INITDB_DATABASE: manhattan', 2);
-- Mongo express
insert into environment (id , valueName, services_id )
values (4, 'ME_CONFIG_MONGODB_ADMINUSERNAME: manhattan', 3);
insert into environment (id , valueName, services_id )
values (5, 'ME_CONFIG_MONGODB_ADMINPASSWORD: manhattan123', 3);
-- Elasticsearch
insert into environment (id , valueName, services_id )
values (6, '- discovery.type=single-node', 8);
-- Kafka
insert into environment (id , valueName, services_id )
values (7, 'KAFKA_CREATE_TOPICS: "UploadFile:1:1,GetFile:1:1,TrackUpload:1:1,GetEmailContent:1:1"', 12);
insert into environment (id , valueName, services_id )
values (8, 'KAFKA_ADVERTISED_HOST_NAME: kafka', 12);
insert into environment (id , valueName, services_id )
values (9, 'KAFKA_ZOOKEEPER_CONNECT: zookeeper:2181', 12);
insert into environment (id , valueName, services_id )
values (10, 'KAFKA_ADVERTISED_PORT: 9092', 12);
