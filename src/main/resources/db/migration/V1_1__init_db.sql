create sequence hibernate_sequence start with 1 increment by 1;

create table depends_on (id bigint generated by default as identity, valueName varchar(255), services_id bigint not null, primary key (id));
create table environment (id bigint generated by default as identity, valueName varchar(255), services_id bigint not null, primary key (id));
create table expose (id bigint generated by default as identity, port integer, services_id bigint not null, primary key (id));
create table networks (id bigint generated by default as identity, valueName varchar(255), services_id bigint not null, primary key (id));
create table port (id bigint generated by default as identity, app integer, docker integer, services_id bigint not null, primary key (id));
create table services (id bigint not null, command varchar(255), container_name varchar(255), image varchar(255), name varchar(255), restart varchar(255), useCommand boolean, useContainerName boolean, useDependsOn boolean, useEnvironments boolean, useExpose boolean, useNetworks boolean, usePorts boolean, useRestart boolean, useVolumes boolean, build varchar(255), hostname varchar(255), mem_limit varchar(255), memswap_limit varchar(255), useBuild boolean, useMemLimit boolean, useMemswapLimit boolean , useHostname boolean, useImage boolean, primary key (id));
create table volume (id bigint generated by default as identity, app varchar(255), docker varchar(255), services_id bigint not null, primary key (id));

alter table depends_on add constraint FKa7w7jmiw4lexwtd5ic8npkhp6 foreign key (services_id) references services;
alter table environment add constraint FKoi90fqtbgqjty7tocplfui9x1 foreign key (services_id) references services;
alter table expose add constraint FKepyu9su8e4838jqbmnh6gt3vf foreign key (services_id) references services;
alter table networks add constraint FK7qb2dnxrtiwllbchvfxcq8cuc foreign key (services_id) references services;
alter table port add constraint FKq60wvjge5sluaq0m5nua2omy9 foreign key (services_id) references services;
alter table volume add constraint FKif57s28sv2o418msfcgw6ve3f foreign key (services_id) references services;

-- DROPS
-- drop table if exists depends_on CASCADE
-- drop table if exists environment CASCADE
-- drop table if exists expose CASCADE
-- drop table if exists networks CASCADE
-- drop table if exists port CASCADE
-- drop table if exists services CASCADE
-- drop table if exists volume CASCADE
-- drop sequence if exists hibernate_sequence