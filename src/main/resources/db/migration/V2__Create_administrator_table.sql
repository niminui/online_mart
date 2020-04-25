CREATE TABLE `administrator`(
  `id` BIGINT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(50),
  `password` VARCHAR(20),
  `avatar_url` VARCHAR(255),
  `gmt_create` BIGINT(20),
  `gmt` BIGINT(20),
  PRIMARY KEY (`id`)
) CHARSET=utf8 COLLATE=utf8_unicode_ci;