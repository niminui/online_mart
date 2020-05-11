CREATE TABLE `online_mart`.`comment`(
  `id` BIGINT(5) NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT(5) NOT NULL,
  `order_id` BIGINT(5) NOT NULL,
  `gmt_create` BIGINT(20) NOT NULL,
  PRIMARY KEY (`id`)
);
