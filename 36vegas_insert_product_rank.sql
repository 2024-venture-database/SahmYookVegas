select * from product;

INSERT INTO product (product_type, product_name, product_price, product_quantity, product_summary) 
VALUES ('음료', '코카콜라', 4000, 20, '코카콜라 355ml');

INSERT INTO product (product_type, product_name, product_price, product_quantity, product_summary) 
VALUES ('음료', '펩시', 4000, 20, '펩시 355ml');

INSERT INTO product (product_type, product_name, product_price, product_quantity, product_summary) 
VALUES ('음료', '아이스티', 4000, 20, '아이스티');

INSERT INTO product (product_type, product_name, product_price, product_quantity, product_summary) 
VALUES ('과자', '자유시간', 2000, 40, '에너지바');

INSERT INTO product (product_type, product_name, product_price, product_quantity, product_summary) 
VALUES ('과자', '포카칩', 3000, 30, '포카칩오리지널맛');

INSERT INTO product (product_type, product_name, product_price, product_quantity, product_summary) 
VALUES ('담배', '담배', 6000, 100, '담배');

INSERT INTO vegas_rank (vegas_rank_name, vegas_credit_rate) VALUES ('normal', 0.03);
INSERT INTO vegas_rank (vegas_rank_name, vegas_credit_rate) VALUES ('vip', 0.05);
INSERT INTO vegas_rank (vegas_rank_name, vegas_credit_rate) VALUES ('vvip', 0.1);
