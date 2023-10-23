CREATE TABLE `employee` (
   `id` bigint NOT NULL AUTO_INCREMENT,
   `name` varchar(255) DEFAULT NULL,
   `dateofbirth` varchar(255) DEFAULT NULL,
   `gender` varchar(255) DEFAULT NULL,
   `address` varchar(255) DEFAULT NULL,
   `city` varchar(255) DEFAULT NULL,
   `state` varchar(255) DEFAULT NULL,
   `loginid` varchar(255) DEFAULT NULL,
   `password` varchar(255) DEFAULT NULL,
   PRIMARY KEY (`id`)
 ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci