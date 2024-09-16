CREATE TABLE `product` (
  `product_id` int(11) NOT NULL auto_increment,
  `product_name` varchar(50) default NULL,
  `product_price` decimal(10,0) default NULL,
  `product_qoh` int(11) default NULL,
  PRIMARY KEY  (`product_id`)
) ENGINE=InnoDB;
