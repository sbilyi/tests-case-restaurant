CREATE TABLE IF NOT EXISTS `menu_item` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `description` varchar(255) NOT NULL,
  `image` varchar(255) NOT NULL,
  `price` DECIMAL(10, 2) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `menu_item_additional_info` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `title` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;

CREATE TABLE IF NOT EXISTS `menu_item_additional_info_relations` (
  `menu_item_additional_info_id` int(11) NOT NULL,
  `menu_item_id` int(11) NOT NULL,
  CONSTRAINT UC_menu_item_additional_info_relations UNIQUE(`menu_item_additional_info_id`, `menu_item_id`),
  FOREIGN KEY (`menu_item_id`)  REFERENCES `menu_item` (`id`),
  FOREIGN KEY (`menu_item_additional_info_id`)  REFERENCES `menu_item_additional_info` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8;
