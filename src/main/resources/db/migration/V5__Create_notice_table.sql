CREATE TABLE `notice`(
  `id` BIGINT NOT NULL,
  `administrator_id` BIGINT NOT NULL,
  `details` TEXT,
  `gmt_create` BIGINT(20),
  `gmt_modified` BIGINT(20),
  PRIMARY KEY (`id`)
) CHARSET=utf8 COLLATE=utf8_unicode_ci;
