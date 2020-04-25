CREATE TABLE `online_mart`.`sales_idrecord`(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `user_id` BIGINT NOT NULL,
  `product_id` BIGINT NOT NULL,
  `sales_times` BIGINT(20) NOT NULL,
  `sales_count` BIGINT DEFAULT 1,
  `price` FLOAT,
  PRIMARY KEY (`id`)
) CHARSET=utf8 COLLATE=utf8_unicode_ci;
