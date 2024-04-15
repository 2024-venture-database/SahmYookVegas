CREATE USER 'syvegas'@'%' IDENTIFIED BY 'syvegas';
CREATE DATABASE IF NOT EXISTS vegas;
GRANT ALL PRIVILEGES ON vegas.* TO 'syvegas'@'%';
FLUSH PRIVILEGES;
--  워크벤치로 커넥션 만드세욥 root 계정에서 바로 사용할것이면 use vegas; 입력

DROP TABLE IF EXISTS customer, game, log, product, vegasrank;

CREATE TABLE vegas_rank
(
    vegas_rank_id INT NOT NULL AUTO_INCREMENT,
    vegas_rank_name VARCHAR(255),
    vegas_credit_rate FLOAT,
    PRIMARY KEY (vegas_rank_id)
);

CREATE TABLE product
(
    product_code INT NOT NULL AUTO_INCREMENT,
    product_type VARCHAR(255),
    product_name VARCHAR(255),
    product_price INT,
    product_quantity INT,
    product_summary VARCHAR(255),
    PRIMARY KEY (product_code)
);

CREATE TABLE game
(
    game_code INT NOT NULL AUTO_INCREMENT,
    game_name VARCHAR(255) NOT NULL,
    game_rate FLOAT,
    PRIMARY KEY (game_code)
);

CREATE TABLE customer
(
    customer_code INT NOT NULL AUTO_INCREMENT,
    customer_name VARCHAR(255) NOT NULL,
    customer_id VARCHAR(255) NOT NULL,
    customer_password VARCHAR(255) NOT NULL,
    customer_phone VARCHAR(255),
    customer_birth VARCHAR(255),
    customer_address VARCHAR(255),
    customer_balance INT,
    customer_credit INT,
    customer_rank INT NOT NULL,
    PRIMARY KEY (customer_code),
    FOREIGN KEY (customer_rank) REFERENCES vegas_rank(vegas_rank_id)
);


CREATE TABLE log
(
    log_code INT NOT NULL AUTO_INCREMENT,
    log_date VARCHAR(255),
    log_amount INT,
    log_balance INT,
    product_code INT NOT NULL,
    customer_code INT NOT NULL,
    PRIMARY KEY (log_code),
    FOREIGN KEY (product_code) REFERENCES product(product_code),
    FOREIGN KEY (customer_code) REFERENCES customer(customer_code)
);