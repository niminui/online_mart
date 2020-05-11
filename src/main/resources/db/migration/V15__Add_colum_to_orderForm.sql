ALTER TABLE `online_mart`.`order_form`
  ADD COLUMN `STATUS` VARCHAR(50) DEFAULT '0'  NULL   COMMENT '0为未送达，1为已送达' AFTER `total_price`,
  ADD COLUMN `destination` VARCHAR(255) NULL AFTER `STATUS`;