alter table temploye add column version int4;
update temploye set version=1;
alter table temploye alter column version set not null;
