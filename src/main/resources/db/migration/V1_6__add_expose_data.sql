-- Apache
insert into expose (id , port, services_id)
values ( 1, 7084, 4 );
-- Nginx
insert into expose (id , port, services_id)
values ( 2, 8084, 5 );
-- Postgres
insert into expose (id , port, services_id)
values ( 3, 5432, 1 );
-- Elasticsearch
insert into expose (id , port, services_id)
values ( 4, 9200, 8 );
insert into expose (id , port, services_id)
values ( 5, 9300, 8 );
