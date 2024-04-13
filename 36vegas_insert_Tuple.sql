select * from product;

INSERT INTO product (product_type, product_name, product_price, product_quantity)
VALUES ('음료', '코카콜라', 4000, 20);

INSERT INTO product (product_type, product_name, product_price, product_quantity)
VALUES ('음료', '펩시', 4000, 20);

INSERT INTO product (product_type, product_name, product_price, product_quantity)
VALUES ('음료', '아이스티', 4000, 20);

INSERT INTO product (product_type, product_name, product_price, product_quantity)
VALUES ('과자', '자유시간', 2000, 40);

INSERT INTO product (product_type, product_name, product_price, product_quantity)
VALUES ('과자', '포카칩', 3000, 30);

INSERT INTO product (product_type, product_name, product_price, product_quantity)
VALUES ('담배', '담배', 6000, 100);

INSERT INTO vegas_rank (vegas_rank_name, vegas_credit_rate) VALUES ('normal', 0.03);
INSERT INTO vegas_rank (vegas_rank_name, vegas_credit_rate) VALUES ('vip', 0.05);
INSERT INTO vegas_rank (vegas_rank_name, vegas_credit_rate) VALUES ('vvip', 0.1);

INSERT INTO customer 
(customer_name, customer_id, customer_password, customer_phone, customer_balance, customer_credit, customer_rank)
VALUES 
('정재현', 'jungjh97', 'wjdwogus0214', '010-1234-5678', 0, 0, 1);

