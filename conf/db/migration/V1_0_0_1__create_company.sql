CREATE TABLE `company` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `name` varchar(256) DEFAULT NULL,
  `company_product_id` bigint(20) unsigned NOT NULL,
  `image_url` varchar(4096) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

INSERT INTO `company` (`id`, `name`, `company_product_id`,`image_url`)
VALUES
(1,'PiedPiper',1,'http://store.hbo.com/imgcache/product/resized/000/800/957/catl/silicon-valley-pied-piper-mouse-pad-858_1000.jpg?k=d0ab6436&pid=800957&s=catl&sn=hbo'),
(2,'Holli',2,'http://store.hbo.com/imgcache/product/resized/000/558/189/catl/silicon-valley-hooli-t-shirt-140_1000.jpg?k=e2adbbab&pid=558189&s=catl&sn=hbo');
