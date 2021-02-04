DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `inventory` (
`item_id`(11) NOT NULL AUTO_INCREMENT,
`item_name` VARCHAR(40) DEFAULT NULL,
`price` VARCHAR(40),
`quantity` VARCAR (40),
PRIMARY KEY `item_id`,

);






);
