insert into game(game_code, game_name, game_rate)
values('r1','미니룰렛',1.6),
	('r2','익스트림룰렛',16.0);

select * from game;

insert into product(product_type, product_name, product_price, product_quantity)
values('술','잭다니엘',15000,5),
		('술','조니워커블랙',50000,4),
		('음료','사이다',5000,6),
		('음료','환타',5000,2),
		('음식','핫바',4500,6);
select * from product;

insert into vegas_rank(vegas_rank_id, vegas_rank_name, vegas_credit_rate)
values('n1','일반', 0.03),
		('v1','vip', 0.08),
		('v2','vvip', 0.15),
		('ma','관리자',0);
select * from vegas_rank;

insert into customer(customer_id, customer_password, customer_name,  customer_phone, customer_rank, customer_balance)
values('aaa','aaa','호랑이', '1111111', 'n1',200000), 
		('bbb','bbb','사자', '2222222','n1',350000),
		('ccc','ccc','토끼', '33333333', 'n1',260000),
		('ddd','ddd','악어', '4444444','v1',1000000),
        ('ggg','ggg','독수리', '5555555','v1',1500000),
        ('hhh','hhh', '코끼리','66666666', 'v2',15000000),
	('admin','admin','카지노대통령',123456789,'ma',0);
select * from customer;        
        
insert into log(log_date, log_money, log_kind_money, log_activiy,  log_customer_id)
values(curdate(),5000000,'지갑','충전','hhh'),
		(curdate(),200000,'지갑','칩 교환','aaa'),
        (curdate(),-200000,'지갑','칩 교환','hhh'),
        (curdate(),300000,'지갑','칩 반환','hhh'),
        (curdate(),-2000,'크레딧','상품구매','bbb');
select * from log;