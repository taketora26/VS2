CREATE TABLE `character_skill` (
  `character_id` bigint(20)  NOT NULL ,
  `skill_id` bigint(20)  NOT NULL ,
  PRIMARY KEY (`character_id`,`skill_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 ROW_FORMAT=DYNAMIC;

INSERT INTO `character_skill` (`character_id`,`skill_id`)
    VALUE
  (1,1),
  (2,2),
  (4,3),
  (5,4),
  (5,5);