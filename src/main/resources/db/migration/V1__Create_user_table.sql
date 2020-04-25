CREATE TABLE `user`(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `password` VARCHAR(25),
  `gender` CHAR(1) DEFAULT '男',
  `birthday` DATE,
  `email` VARCHAR(50),
  `telephone` VARCHAR(50),
  `address` VARCHAR(255),
  `avatar_url` VARCHAR(255),
  `token` VARCHAR(36),
  `gmt_create` BIGINT(20),
  `gmt_modified` BIGINT(20),
  PRIMARY KEY (`id`)
) CHARSET=utf8 COLLATE=utf8_unicode_ci;