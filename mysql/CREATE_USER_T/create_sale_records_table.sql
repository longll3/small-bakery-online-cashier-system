CREATE TABLE t_sales_records
(RECORD_ID INT NOT NULL AUTO_INCREMENT,
_DATE DATE NOT NULL,
COUNT INT NOT NULL,
PRODUCT_ID INT(11),
primary key (RECORD_ID),
foreign key (PRODUCT_ID) references t_products(product_id)
)ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

INSERT INTO `t_sales_records` VALUES ('1', '2017-04-01', '10', '1');
INSERT INTO `t_sales_records` VALUES ('2', '2017-04-01', '12', '3');