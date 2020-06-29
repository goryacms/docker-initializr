-- Mongo
insert into volume
(id, app, docker, services_id)
values ( 1, './mongo-init.js', '/docker-entrypoint-initdb.d/mongo-init.js:ro', 2 );
-- Aapche
insert into volume
(id, app, docker, services_id)
values ( 2, './htdocs/', '/usr/local/apache2/htdocs/', 4 );
insert into volume
(id, app, docker, services_id)
values ( 3, './.htaccess', '/usr/local/apache2/htdocs/.htaccess', 4 );
insert into volume
(id, app, docker, services_id)
values ( 4, './httpd.conf', '/usr/local/apache2/conf/httpd.conf', 4 );
-- Postgres
insert into volume
(id, app, docker, services_id)
values ( 5, './docker-data/postgres/init-00.sql', '/docker-entrypoint-initdb.d/init-00.sql', 1 );
-- Elasticsearch
insert into volume
(id, app, docker, services_id)
values ( 6, './docker-data/elasticsearch/config/elasticsearch.yml', '/usr/share/elasticsearch/config/elasticsearch.yml:ro', 8 );
-- Kibana
insert into volume
(id, app, docker, services_id)
values ( 7, './docker-data/kibana/config/kibana.yml', '/usr/share/kibana/config/kibana.yml:ro', 9 );
-- Kafka
insert into volume
(id, app, docker, services_id)
values ( 8, '/var/run/docker.sock', '/var/run/docker.sock', 12 );
