DROP TABLE IF EXISTS `book`;
CREATE TABLE `book` (
                        `id` int(11) NOT NULL AUTO_INCREMENT,
                        `author` varchar(255) DEFAULT NULL,
                        `isbn` varchar(255) DEFAULT NULL,
                        `name` varchar(255) DEFAULT NULL,
                        `pages` int(11) DEFAULT NULL,
                        `price` double DEFAULT NULL,
                        `publish_house` varchar(255) DEFAULT NULL,
                        `publish_time` datetime(6) DEFAULT NULL,
                        `number` int(11) DEFAULT NULL,
                        `type` varchar(255) DEFAULT NULL,
                        PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8;