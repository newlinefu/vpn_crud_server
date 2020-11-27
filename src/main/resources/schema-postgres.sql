DROP TABLE IF EXISTS vpns;
CREATE TABLE vpns (
    vpn_id serial primary key,
    vpn_title varchar(100) not null,
    vpn_server varchar(100) not null,
    vpn_password varchar(50),
    vnp_expiration_date date not null
 );