create table product (
    id          BIGSERIAL primary key,
    code        uuid not null,
    name        varchar(250) not null,
    price       numeric(15,4) not null,
    constraint uk_code unique (code)
)