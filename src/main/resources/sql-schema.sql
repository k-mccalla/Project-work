drop schema ims;

CREATE SCHEMA IF NOT EXISTS `ims`;

USE `ims` ;

CREATE TABLE IF NOT EXISTS `ims`.`customers` (
    `id` INT(11) NOT NULL AUTO_INCREMENT,
    `first_name` VARCHAR(40) DEFAULT NULL,
    `surname` VARCHAR(40) DEFAULT NULL,
    PRIMARY KEY (`id`)
);

CREATE TABLE IF NOT EXISTS `items` (
`item_id` int(11) NOT NULL AUTO_INCREMENT,
`item_name` VARCHAR(40) DEFAULT NULL,
`price` VARCHAR(40),
`quantity` VARCHAR(40),
PRIMARY KEY (`item_id`)

);


CREATE TABLE IF NOT EXISTS `orders` (
`order_id` int(11) NOT NULL AUTO_INCREMENT,
`price` int(11) NOT NULL,
`quantity` int(11) NOT NULL,
`date` DATE NOT NULL,
PRIMARY KEY (`order_id`),
FOREIGN KEY (`id`) REFERENCES customers(id),
FOREIGN KEY (`item_id`) REFERENCES items(item_id)


);

CREATE TABLE IF NOT EXISTS `total_sales`(
PRIMARY KEY (`sales_id`), 
FOREIGN KEY (`id`) REFERENCES customers(id),
FOREIGN KEY (`item_id`) REFERENCES items(item_id),
FOREIGN KEY (`price`) REFERENCES items(price),
FOREIGN KEY (`order_id`) REFERENCES orders(order_id),
FOREIGN KEY (`quantity`) REFERENCES orders(quantity),

);
