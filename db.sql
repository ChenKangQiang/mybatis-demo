
CREATE DATABASE mybatis;

USE DATABASE mybatis;


CREATE  TABLE users (
       id INT AUTO_INCREMENT NOT NULL ,
       username VARCHAR(40) ,
       password VARCHAR(32) ,
       email VARCHAR(40) ,
       regdata DATETIME ,
       PRIMARY KEY (id)
);


INSERT INTO mybatis.users (username, password, email, regdata)
    VALUES ('Tom', md5('111111'), 'tom@meituan.com', now()) ,
           ('Mary', md5('222222'), 'mary@meituan.com', now()) ,
           ('Jack', md5('333333'), 'jack@meituan.com', now()) ,
           ('Tommy', md5('444444'), 'tommy@meituan.com', now()) ,
           ('Smith', md5('555555'), 'smith@meituan.com', now()) ,
           ('July', md5('666666'), 'july@meituan.com', now()) ,
           ('Lilei', md5('777777'), 'lilei@meituan.com', now()) ;