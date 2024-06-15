create table author
(
    id    bigint DEFAULT nextval('author_sequence') not null,
    firstName varchar(255)                              not null,
    lastName  varchar(255)                              not null,
    primary key (id)
);