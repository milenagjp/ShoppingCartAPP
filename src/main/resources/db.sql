insert into PRODUCTS values (1, 'TestProduct1', 15.2);
insert into PRODUCTS values (2, 'TestProduct2', 12.3);
insert into PRODUCTS values (3, 'TestProduct3', 1.0);
insert into PRODUCTS values (4, 'TestProduct4', 6.4);
insert into PRODUCTS values (5, 'TestProduct5', 12.7);

insert into SHOPPING_CART values (1);
insert into SHOPPING_CART values (2);
insert into SHOPPING_CART values (3);
insert into SHOPPING_CART values (4);
insert into SHOPPING_CART values (5);

insert into SHOPPING_CART_PRODUCTS values (1 ,1);
insert into SHOPPING_CART_PRODUCTS values (1 ,2);
insert into SHOPPING_CART_PRODUCTS values (1 ,3);
insert into SHOPPING_CART_PRODUCTS values (2 ,2);
insert into SHOPPING_CART_PRODUCTS values (2 ,3);
insert into SHOPPING_CART_PRODUCTS values (3 ,1);
insert into SHOPPING_CART_PRODUCTS values (3 ,4);
insert into SHOPPING_CART_PRODUCTS values (3 ,5);
insert into SHOPPING_CART_PRODUCTS values (4 ,1);
insert into SHOPPING_CART_PRODUCTS values (4 ,2);


select * from PRODUCTS;
select * from SHOPPING_CART ;
select * from SHOPPING_CART_PRODUCTS ;

