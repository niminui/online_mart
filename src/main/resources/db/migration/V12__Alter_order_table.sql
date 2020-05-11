ALTER TABLE `order` CHANGE `product_id` `product_id_array` VARCHAR(255) NOT NULL,
  ADD COLUMN `total_price` FLOAT(50) DEFAULT 0  NULL AFTER `gmt_create`;
