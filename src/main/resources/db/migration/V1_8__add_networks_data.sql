-- Elasticsearch
insert into networks (id , valueName, services_id)
values ( 1, 'elastic', 8 );
-- Kibana
insert into networks (id , valueName, services_id)
values ( 2, 'elastic', 9 );
-- Cassandra
insert into networks (id , valueName, services_id)
values ( 3, '\ncufer-network:\n        aliases:\n          - cassandra-node-01', 13 );