CREATE TABLE `online_mart`.`product_information`(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(20),
  `type` INT,
  `avatar_url` VARCHAR(255),
  `price` FLOAT NOT NULL DEFAULT 0,
  `discount` FLOAT DEFAULT 0,
  `sell_count` BIGINT DEFAULT 0,
  `view_count` BIGINT DEFAULT 0,
  `stock` BIGINT DEFAULT 0,
  `description` TEXT,
  `administrator_id` BIGINT NOT NULL COMMENT '商品添加人',
  `gmt_create` BIGINT(20),
  `gmt_modified` BIGINT(20),
  PRIMARY KEY (`id`)
);