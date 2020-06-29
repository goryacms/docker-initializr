-- Nginx
insert into depends_on (id , valueName, services_id)
values ( 1, 'apache', 5 );
-- Kibana
insert into depends_on (id , valueName, services_id)
values ( 2, 'elasticsearch', 9 );
-- Kafka
insert into depends_on (id , valueName, services_id)
values ( 3, 'zookeeper', 12 );

