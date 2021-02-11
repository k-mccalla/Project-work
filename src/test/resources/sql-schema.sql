DROP TABLE IF EXISTS `customers`;

CREATE TABLE IF NOT EXISTS `customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);


CREATE TABLE IF NOT EXISTS `items` (
`item_id` int(11) NOT NULL AUTO_INCREMENT,
`item_name` VARCHAR(40) DEFAULT NULL,
`price` double,
PRIMARY KEY (`item_id`)

);


CREATE TABLE IF NOT EXISTS `orders` (
  `id` INT(11) NOT NULL,
`order_id` int(11) NOT NULL AUTO_INCREMENT,
`price` double,
PRIMARY KEY (`order_id`),
FOREIGN KEY (`id`) REFERENCES customers(id) on delete cascade


);

CREATE TABLE IF NOT EXISTS `order_items`(
`sale_id` int(11) NOT NULL AUTO_INCREMENT,
`order_id` int(11) NOT NULL,
`item_id` int(11) NOT NULL,
PRIMARY KEY (`sale_id`),
FOREIGN KEY (`order_id`) REFERENCES orders(order_id) on delete cascade,
FOREIGN KEY (`item_id`) REFERENCES items(item_id) on delete cascade

);






