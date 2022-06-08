create schema shop;
create table shop.product
(
    id serial not null,
    title text not null,
    price bigint not null
);

create unique index product_id_uindex
	on shop.product (id);

alter table shop.product
    add constraint product_pk
        primary key (id);

INSERT INTO shop.product(title, price) VALUES ('Картошка', '100');
INSERT INTO shop.product(title, price) VALUES ('Огурцы', '200');
INSERT INTO shop.product(title, price) VALUES ('Бананы', '300');
INSERT INTO shop.product(title, price) VALUES ('Помидоры', '400');
INSERT INTO shop.product(title, price) VALUES ('Киви', '500');
INSERT INTO shop.product(title, price) VALUES ('Орехи', '600');
INSERT INTO shop.product(title, price) VALUES ('Яблоки', '700');
INSERT INTO shop.product(title, price) VALUES ('Груши', '800');
INSERT INTO shop.product(title, price) VALUES ('Виноград', '900');
INSERT INTO shop.product(title, price) VALUES ('Морковь', '1000');
INSERT INTO shop.product(title, price) VALUES ('Салат', '150');
INSERT INTO shop.product(title, price) VALUES ('Свекла', '250');
INSERT INTO shop.product(title, price) VALUES ('Абрикосы', '350');
INSERT INTO shop.product(title, price) VALUES ('Персики', '450');
INSERT INTO shop.product(title, price) VALUES ('Арбузы', '550');
INSERT INTO shop.product(title, price) VALUES ('Перец', '650');
INSERT INTO shop.product(title, price) VALUES ('Редиска', '750');
INSERT INTO shop.product(title, price) VALUES ('Ананасы', '850');
INSERT INTO shop.product(title, price) VALUES ('Апельсины', '950');
INSERT INTO shop.product(title, price) VALUES ('Мандарины', '1050');

create table shop.users (
                             username varchar(255) not null primary key,
                             password varchar(255) not null,
                             enabled boolean not null
);

create table shop.authorities (
                                   username varchar(255) not null,
                                   authority varchar(255) not null,
                                   foreign key (username) references users (username),
                                   unique (username, authority)
);

INSERT INTO shop.users (username, password, enabled) VALUES ('user1', '{noop}123', true);
INSERT INTO shop.users (username, password, enabled) VALUES ('user2', '{noop}123', true);
INSERT INTO shop.authorities (username, authority) VALUES ('user1', 'ROLE_ADMIN');
INSERT INTO shop.authorities (username, authority) VALUES ('user1', 'ROLE_USER');
INSERT INTO shop.authorities (username, authority) VALUES ('user2', 'ROLE_USER');