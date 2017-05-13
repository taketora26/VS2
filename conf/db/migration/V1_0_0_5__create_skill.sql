CREATE TABLE `skill` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `skill` VARCHAR(4096) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

INSERT INTO `skill` (`id`,`skill`)
VALUES
(1,'アルゴリズム'),
(2,'プレゼン'),
(3,'セキュリティ'),
(4,'Java'),
(5,'scala');