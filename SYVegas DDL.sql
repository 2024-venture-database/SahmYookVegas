CREATE USER 'syvegas'@'%' IDENTIFIED BY 'syvegas';
CREATE DATABASE IF NOT EXISTS vegas;
GRANT ALL PRIVILEGES ON vegas.* TO 'syvegas'@'%';
FLUSH PRIVILEGES;
--  워크벤치로 커넥션 만드세욥 root 계정에서 바로 사용할것이면 use vegas; 입력

use vegas;

DROP TABLE IF EXISTS customer, game, log, product, vegas_rank;
DROP TABLE IF EXISTS customer, log;
CREATE TABLE product
(
    product_code INT NOT NULL AUTO_INCREMENT, -- 상품 코드
    product_type VARCHAR(255) NOT NULL, -- 상품 종류
    product_name VARCHAR(255) NOT NULL, -- 상품 이름
    product_price INT NOT NULL, -- 상품 금액
    product_quantity INT default 0, -- 상품 수량
    PRIMARY KEY (product_code)
);

CREATE TABLE game
(
    game_code VARCHAR(255) NOT NULL , -- 게임 코드
    game_name VARCHAR(255) NOT NULL, -- 게임 이름
    game_rate FLOAT NOT NULL, -- 게임 배당률
    PRIMARY KEY (game_code)
);

CREATE TABLE vegas_rank
(
    vegas_rank_id varchar(255) NOT NULL, -- 유저 등급 코드
    vegas_rank_name VARCHAR(255) NOT NULL, -- 유저 등급 이름
    vegas_credit_rate FLOAT NOT NULL, -- 등급에 따른 크레딧 교환률 (지갑에 돈 insert시 돈*vegas_credit_rate로 잔액에 추가)
    PRIMARY KEY (vegas_rank_id)
);

CREATE TABLE customer
(
    customer_id VARCHAR(255) NOT NULL, -- 이용자 ID ,중복 허용 X, 기본키
    customer_password VARCHAR(255) NOT NULL, -- 이용자 비밀번호
    customer_name VARCHAR(255) NOT NULL, -- 이용자 이름
    customer_phone VARCHAR(255) default 'none', -- 이용자 전화번호 null 가능

    customer_balance INT default 0, -- 이용자 지갑 잔액
    customer_credit INT default 0, -- 이용자 크레딧 잔액
    customer_rank varchar(255) default 'n1', -- 이용자 등급 코드(외래키)
    PRIMARY KEY (customer_id),
    FOREIGN KEY (customer_rank) REFERENCES vegas_rank(vegas_rank_id)
);

CREATE TABLE log
(
    log_code INT NOT NULL AUTO_INCREMENT, -- 로그 코드, 값 입력시 증가
    log_date DATE NOT NULL, -- 현재 날짜 추가
    log_money INT NOT NULL, -- 변동된 금액 
    log_kind_money VARCHAR(255), -- 사용 돈의 종류
    log_activiy VARCHAR(255) NOT NULL, -- 금액 변동의 활동 종류 ex)충전, 상품 구매, 칩교환, 반환
    log_customer_id VARCHAR(255), -- 이용자 ID (fk)
    PRIMARY KEY (log_code),
    FOREIGN KEY ( log_customer_id) REFERENCES customer(customer_id)
);



