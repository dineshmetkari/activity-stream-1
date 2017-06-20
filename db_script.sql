use `circle_test`;

DROP TABLE IF EXISTS `circle`;

CREATE TABLE `circle` (
  `id` varchar(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `admin_id` varchar(20) DEFAULT NULL,
  `status` char(1) DEFAULT 'A',
  `created_date` datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  UNIQUE KEY `name` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `circle` WRITE;

INSERT INTO `circle` VALUES ('angular','angular','Som',NULL,NULL),('cucumber','cucumber','sam',NULL,NULL),('hobes','hobes','Swamy',NULL,NULL),('java','java','Dinesh',NULL,NULL),('Mockito','Mockito','sam',NULL,NULL),('MockMvc','MockMvc','sam',NULL,NULL),('mongo','mongo','Som',NULL,NULL),('SampleCircle','SampleCircle','john',NULL,NULL),('selenium','selenium','sam',NULL,NULL),('SemanticUI','SemanticUI','JP',NULL,NULL);

UNLOCK TABLES;


DROP TABLE IF EXISTS `stream`;

CREATE TABLE `stream` (
  `id` int(11) NOT NULL,
  `parent_id` varchar(20) DEFAULT NULL,
  `sender_id` varchar(20) DEFAULT NULL,
  `posted_date` datetime DEFAULT CURRENT_TIMESTAMP,
  `stream_type` varchar(20) NOT NULL,
  `tag` varchar(20) NOT NULL,
  `message` varchar(200) DEFAULT NULL,
  `receiver_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `stream` WRITE;

INSERT INTO `stream` VALUES (0,'','JP','2017-05-20 13:16:43','String','controller','This is posted to Angular Circle',NULL),(128,NULL,'simanta','2017-06-06 15:39:09','String','No Tags','hello','Anuradha'),(885,NULL,'simanta','2017-06-06 15:38:30','String','No Tags','hi','Abbas'),(1102,NULL,'Abbas','2017-06-02 09:16:22','String','No Tags','not yet confirmed','Somsubhra'),(1197,NULL,'somsubhra','2017-06-02 09:15:36','String','No Tags','Hi Abbas','Abbas'),(1374,NULL,'sam','2017-06-05 07:44:52','String','No Tags','hi','Abbas'),(1816,NULL,'simanta','2017-06-06 15:40:28','String','java,angular','This project is developed in #java and #angular','Abbas'),(2153,NULL,'sam','2017-06-05 07:34:55','String','java','Hi I am learning #Java','Abbas'),(2269,NULL,'somsubhra','2017-06-02 12:58:25','String','No Tags','hello','Anuradha'),(2330,NULL,'sachin','2017-06-07 11:04:18','String','No Tags','hi','Abbas'),(2816,NULL,'somsubhra','2017-06-09 15:45:59','String','No Tags','hi','Debjit'),(2891,NULL,'sachin','2017-06-07 11:06:10','String','No Tags','hello','Anuradha'),(3274,NULL,'JP','2017-05-30 02:54:30','String','angular','hello',NULL),(3512,'','Som','2017-05-20 13:47:01','String','service','This is a private message about Angular service','JP'),(4039,NULL,'sachin','2017-06-07 11:04:34','String','java','I am working on #java','Abbas'),(4099,NULL,'somsubhra','2017-06-02 15:54:35','String','angular','#angular is coming with a new version','Anuradha'),(4118,NULL,'JP','2017-06-01 15:49:34','String','DigiNxt','This is a test message','Abbas'),(4149,NULL,'somsubhra','2017-06-09 16:06:26','String','No Tags','hello','Abbas'),(4384,NULL,'sam','2017-06-05 08:04:13','String','No Tags','hi','Anuradha'),(4413,NULL,'sachin','2017-06-07 11:05:02','String','semantic,angular','this app is created with #semantic and #angular','Abbas'),(4415,NULL,'somsubhra','2017-06-09 15:46:11','String','No Tags','hey','Dinesh'),(4853,NULL,'somsubhra','2017-06-05 07:49:57','String','No Tags','we should reach office by 9am today','Abbas'),(5051,NULL,'JP',NULL,'String','DigiNxt','Hey Abbas!! When is the next batch starting?','Abbas'),(5897,NULL,'JP','2017-05-30 14:44:37','String','angular','hi Francis',NULL),(5921,NULL,'will','2017-06-07 10:04:54','String','No Tags','hi','Abbas'),(5946,NULL,'somsubhra','2017-06-02 09:15:49','String','No Tags','When are you reaching Bangalore?','Abbas'),(6388,NULL,'somsubhra','2017-06-02 12:34:41','String','No Tags','hi','Anuradha'),(6506,NULL,'will','2017-06-07 10:05:04','String','No Tags','hello','Anuradha'),(7413,NULL,'Abbas','2017-06-02 07:24:57','String','No Tags','hi','Shaubhik'),(7771,NULL,'somsubhra','2017-06-09 16:01:06','String','No Tags','hi','Abbas'),(8465,NULL,'somsubhra','2017-06-09 16:06:22','String','No Tags','hello','Abbas'),(9062,NULL,'somsubhra','2017-06-09 15:58:38','String','No Tags','hello','Abbas'),(9511,NULL,'simanta','2017-06-06 15:38:52','String','semantic','I am explaining #semantic','Abbas'),(9613,NULL,'somsubhra','2017-06-05 07:45:22','String','No Tags','hi Abbas','Abbas'),(61925,NULL,'somsubhra','2017-06-20 10:29:20','String','test','this is a #test tool',NULL),(67760,NULL,'somsubhra','2017-06-10 12:48:15','String','angular','#angular',NULL),(72216,NULL,'somsubhra','2017-06-02 21:28:59','String','mongodb,nosql','#mongodb is a #nosql',NULL),(129259,NULL,'somsubhra','2017-06-02 16:14:23','String','java','#java is an OOPS',NULL),(141312,NULL,'Som','2017-05-26 15:33:29','String','Abstract class','Abstract class is another feature of Java',NULL),(149958,NULL,'somsubhra','2017-06-09 12:34:46','String','angular','sample message #angular',NULL),(203619,NULL,'somsubhra','2017-06-02 17:30:25','String','j2ee,java','#J2EE is the enterprise edition of #Java',NULL),(215150,NULL,'JP','2017-05-30 14:42:18','String','angular','This is done now',NULL),(237940,NULL,'will','2017-06-07 10:04:41','String','No Tags','this is my first post',NULL),(251057,NULL,'JP','2017-05-30 02:52:31','String','java',NULL,NULL),(265720,NULL,'JP','2017-05-30 12:03:40','String','java','hello',NULL),(269659,NULL,'somsubhra','2017-06-08 12:53:08','String','java,j2ee','I am working in #java and #j2ee',NULL),(272854,NULL,'JP','2017-05-30 02:51:24','String','java',NULL,NULL),(312949,NULL,'somsubhra','2017-06-10 12:48:26','String','angular,spring','#angular #spring',NULL),(437953,NULL,'JP','2017-05-30 02:50:20','String','angular','This is another message',NULL),(509768,NULL,'Som','2017-05-26 00:00:00','String','Inheritance','Inheritance is a feature of Java',NULL),(547687,NULL,'JP','2017-05-30 02:53:59','String','angular',NULL,NULL),(579253,NULL,'JP','2017-05-30 02:57:23','String','angular','this is a test message in Angular Circle',NULL),(596363,NULL,'JP','2017-05-30 02:56:34','String','java','This is a test message',NULL),(623309,NULL,'somsubhra','2017-06-02 21:25:34','String','mongo','I am working with #mongo',NULL),(653365,NULL,'somsubhra','2017-06-05 07:49:31','String','No Tags','great',NULL),(659619,NULL,'JP','2017-05-30 14:43:06','String','angular','wow!!',NULL),(815683,NULL,'somsubhra','2017-06-20 10:29:06','String','No Tags','hi',NULL),(858106,'','Som','2017-05-20 13:25:56','String','service','This post is about Angular service',NULL),(859735,NULL,'somsubhra','2017-06-09 16:06:10','String','No Tags','hi',NULL),(861504,NULL,'somsubhra','2017-06-02 15:53:31','String','angular','test message2 #angular',NULL),(884975,NULL,'sam','2017-06-05 07:44:18','String','No Tags','I am learning mongo',NULL),(896350,NULL,'sam','2017-06-05 07:39:03','String','mongo','test message in #mongo circle',NULL),(973153,NULL,'JP','2017-05-30 02:54:47','String','java','hey',NULL),(984136,NULL,'Som','2017-05-30 02:40:25','String','Angular Event','this post is about Angular Event',NULL);

UNLOCK TABLES;

DROP TABLE IF EXISTS `stream_circle`;

CREATE TABLE `stream_circle` (
  `id` int(11) NOT NULL,
  `stream_id` varchar(20) DEFAULT NULL,
  `circle_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `stream_circle` WRITE;

INSERT INTO `stream_circle` VALUES (0,'92688','hobes'),(21507,'633408','java'),(28143,'623309','mongo'),(34223,'14079','hobes'),(57120,'587884','angular'),(60736,'11564','hobes'),(95692,'61925','hobes'),(104194,'206511','angular'),(108224,'973153','java'),(159887,'437953','angular'),(171561,'884975','mongo'),(186045,'203619','java'),(228217,'659619','angular'),(232886,'312949','angular'),(250420,'896350','mongo'),(286766,'444357','angular'),(299399,'149958','angular'),(324296,'984136','angular'),(325123,'72216','mongo'),(361234,'67760','angular'),(373533,'596363','java'),(378261,'815683','hobes'),(459319,'141312','java'),(492682,'858106','angular'),(546293,'3274','angular'),(564936,'136752','angular'),(565530,'579253','angular'),(579950,'265720','java'),(592179,'237940','cucumber'),(592844,'215150','angular'),(617771,'129259','java'),(647898,'5897','angular'),(679898,'859735','mongo'),(697924,'0','angular'),(710412,'272854','java'),(729751,'509768','java'),(731539,'269659','java'),(837016,'861504','angular'),(894827,'653365','mongo'),(916676,'251057','java'),(927626,'981612','java'),(974060,'35670','hobes'),(977523,'84977','java'),(989078,'547687','angular');

UNLOCK TABLES;

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `id` varchar(20) NOT NULL,
  `name` varchar(30) DEFAULT NULL,
  `password` varchar(20) DEFAULT NULL,
  `role` varchar(20) DEFAULT NULL,
  `enabled` tinyint(1) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


LOCK TABLES `user` WRITE;

INSERT INTO `user` VALUES ('Abbas','Abbas','password2','ROLE_USER',1),('Anuradha','Anuradha','password','ROLE_USER',1),('atul','atul verma','password',NULL,0),('Debjit','Debjit','password','ROLE_USER',1),('Dinesh','Dinesh','Dinesh','ROLE_USER',1),('Dinesh2','Dinesh2','password','ROLE_USER',1),('Farooq','Farooq','Farooq','ROLE_USER',1),('Hushnoon','Hushnoon','password','ROLE_USER',1),('john','John Doe','password@123','ROLE_USER',1),('JP','JP','password','ROLE_USER',1),('Koel','Koel','password','ROLE_USER',1),('Partha','partha','password','ROLE_USER',1),('sachin','saching','password','ROLE_USER',1),('sam','sam jones','password','ROLE_USER',1),('Shaubhik','Shaubhik','password','ROLE_USER',1),('ShaubhikSen','shaubhiksen','password','ROLE_USER',1),('simanta','simanta','password','ROLE_USER',1),('Som','Som','Som','ROLE_USER',1),('Somsubhra','somsubhra','password','ROLE_ADMIN',1),('Soumya','Soumya','password','ROLE_USER',1),('will','william jones','password','ROLE_USER',1);

UNLOCK TABLES;

DROP TABLE IF EXISTS `user_circle`;

CREATE TABLE `user_circle` (
  `id` int(11) NOT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `circle_id` varchar(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_circle` WRITE;

INSERT INTO `user_circle` VALUES (58,'john','SampleCircle'),(997,'somsubhra','java'),(3913,'Dinesh','Coder_Platofm'),(5043,'sam','angular'),(11085,'somsubhra','hobes'),(18856,'JP','hobes'),(18881,'will','angular'),(21380,'somsubhra','mongo'),(22428,'sam','MockMvc'),(24901,'simanta','angular'),(25650,'Abbas','angular'),(32740,'will','java'),(33987,'JP','angular'),(34654,'will','cucumber'),(35111,'john','SampleCircle'),(44423,'sam','mongo'),(45520,'john','SampleCircle'),(49551,'Dinesh','Coder_Platofm'),(50196,NULL,NULL),(53461,'JP','java'),(55699,'Dinesh','mongo'),(64346,'Dinesh','mongo'),(66209,'sachin','java'),(82317,'somsubhra','angular'),(84010,'somsubhra','cucumber'),(84943,'sam','java'),(93613,'sachin','angular'),(94528,'Dinesh','Coder_Platofm'),(97787,'john','SampleCircle');

UNLOCK TABLES;


DROP TABLE IF EXISTS `user_home`;

CREATE TABLE `user_home` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_id` varchar(20) DEFAULT NULL,
  `sender_id` varchar(20) DEFAULT NULL,
  `circle_id` varchar(20) DEFAULT NULL,
  `posted_date` datetime DEFAULT NULL,
  `stream_type` varchar(20) DEFAULT NULL,
  `tag` varchar(20) DEFAULT NULL,
  `message` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=85 DEFAULT CHARSET=utf8;

LOCK TABLES `user_home` WRITE;

INSERT INTO `user_home` VALUES (1,'Dinesh','swamy',NULL,'2017-05-22 15:26:44','String','Message','Copying to user home from all circles?-1'),(4,NULL,'Som',NULL,'2017-05-26 15:33:29','String','Abstract class','Abstract class is another feature of Java'),(5,NULL,'Som',NULL,'2017-05-30 02:40:25','String','Angular Event','this post is about Angular Event'),(6,NULL,'JP',NULL,'2017-05-30 02:50:20','String','angular','This is another message'),(7,NULL,'JP',NULL,'2017-05-30 02:51:24','String','java',NULL),(8,NULL,'JP',NULL,'2017-05-30 02:52:31','String','java',NULL),(9,NULL,'JP',NULL,'2017-05-30 02:53:59','String','angular',NULL),(10,NULL,'JP',NULL,'2017-05-30 02:54:30','String','angular','hello'),(11,NULL,'JP',NULL,'2017-05-30 02:54:47','String','java','hey'),(12,NULL,'JP',NULL,'2017-05-30 02:56:34','String','java','This is a test message'),(13,NULL,'JP',NULL,'2017-05-30 02:57:23','String','angular','this is a test message in Angular Circle'),(14,NULL,'JP',NULL,'2017-05-30 12:03:40','String','java','hello'),(15,NULL,'JP',NULL,'2017-05-30 14:42:18','String','angular','This is done now'),(16,NULL,'JP',NULL,'2017-05-30 14:43:06','String','angular','wow!!'),(17,NULL,'JP',NULL,'2017-05-30 14:44:37','String','angular','hi Francis'),(18,'Abbas','JP',NULL,NULL,'String','DigiNxt','Hey Abbas!! When is the next batch starting?'),(19,'Abbas','JP',NULL,'2017-06-01 15:49:34','String','DigiNxt','This is a test message'),(20,'Abbas','JP',NULL,'2017-06-01 16:50:56','String','private','hi'),(21,'Abbas','JP',NULL,'2017-06-01 16:51:07','String','private','hello'),(22,'Anuradha','JP',NULL,'2017-06-01 16:52:03','String','private','hello'),(23,'JP','Abbas',NULL,'2017-06-01 16:58:27','String','private','Hi JP'),(24,'Anuradha','Abbas',NULL,'2017-06-01 17:27:09','String','private','hello'),(25,'Anuradha','Abbas',NULL,'2017-06-02 07:09:30','String','private','good morning'),(26,'Anuradha','Abbas',NULL,'2017-06-02 07:09:59','String','private','This is a lovely day #koramangala'),(27,'Anuradha','Abbas',NULL,'2017-06-02 07:10:44','String','private','I am currently working on #niit #diginxt project'),(28,'Shaubhik','Abbas',NULL,'2017-06-02 07:24:57','String','No Tags','hi'),(29,'Shaubhik','Abbas',NULL,'2017-06-02 07:28:40','String','#Stackroute,#Bglr','I am currently working from #Stackroute #Bglr'),(30,NULL,'Abbas',NULL,'2017-06-02 07:54:28','String','#AngularJS,#ngRepeat','#AngularJS has many directives. #ngRepeat is one of them'),(31,'Abbas','somsubhra',NULL,'2017-06-02 09:15:36','String','No Tags','Hi Abbas'),(32,'Abbas','somsubhra',NULL,'2017-06-02 09:15:49','String','No Tags','When are you reaching Bangalore?'),(33,'Somsubhra','Abbas',NULL,'2017-06-02 09:16:22','String','No Tags','not yet confirmed'),(34,'Abbas','somsubhra',NULL,'2017-06-02 10:58:34','String','#coffee','loving the #coffee here .'),(35,NULL,'somsubhra',NULL,'2017-06-02 11:21:20','String','#streams','#streams is a feature of Java'),(36,'Anuradha','somsubhra',NULL,'2017-06-02 12:34:41','String','No Tags','hi'),(37,'Abbas','somsubhra',NULL,'2017-06-02 12:36:09','String','#SemanticUI','I am currently discussing about #SemanticUI with Swamy.'),(38,'Abbas','somsubhra',NULL,'2017-06-02 12:36:35','String','#spring,#angularJS','we are working on #spring and #angularJS'),(39,'Anuradha','somsubhra',NULL,'2017-06-02 12:53:35','String','#diginxt','status of #DigiNxt registrations?'),(40,'Anuradha','somsubhra',NULL,'2017-06-02 12:58:25','String','No Tags','hello'),(41,'Anuradha','somsubhra',NULL,'2017-06-02 15:23:57','String','#diginxt','java is included in #DigiNxt'),(42,NULL,'somsubhra',NULL,'2017-06-02 15:28:20','String','#diginxt','J2EE is also included in #DigiNxt'),(43,'Anuradha','somsubhra',NULL,'2017-06-02 15:40:24','String','#angular','do you know #angular?'),(44,'Anuradha','somsubhra',NULL,'2017-06-02 15:41:03','String','#angular','I love coding with #angular'),(45,NULL,'somsubhra',NULL,'2017-06-02 15:43:05','String','#angular','test message in #angular circle'),(46,NULL,'somsubhra',NULL,'2017-06-02 15:50:04','String','','test message #angular'),(47,NULL,'somsubhra',NULL,'2017-06-02 15:53:31','String','angular','test message2 #angular'),(48,'Anuradha','somsubhra',NULL,'2017-06-02 15:54:35','String','angular','#angular is coming with a new version'),(49,NULL,'somsubhra',NULL,'2017-06-02 16:14:23','String','java','#java is an OOPS'),(50,NULL,'somsubhra',NULL,'2017-06-02 17:30:25','String','j2ee,java','#J2EE is the enterprise edition of #Java'),(51,NULL,'somsubhra',NULL,'2017-06-02 21:25:34','String','mongo','I am working with #mongo'),(52,NULL,'somsubhra',NULL,'2017-06-02 21:28:59','String','mongodb,nosql','#mongodb is a #nosql'),(53,'Abbas','sam',NULL,'2017-06-05 07:34:55','String','java','Hi I am learning #Java'),(54,NULL,'sam',NULL,'2017-06-05 07:39:03','String','mongo','test message in #mongo circle'),(55,NULL,'sam',NULL,'2017-06-05 07:44:18','String','No Tags','I am learning mongo'),(56,'Abbas','sam',NULL,'2017-06-05 07:44:52','String','No Tags','hi'),(57,'Abbas','somsubhra',NULL,'2017-06-05 07:45:22','String','No Tags','hi Abbas'),(58,NULL,'somsubhra',NULL,'2017-06-05 07:49:31','String','No Tags','great'),(59,'Abbas','somsubhra',NULL,'2017-06-05 07:49:57','String','No Tags','we should reach office by 9am today'),(60,'Anuradha','sam',NULL,'2017-06-05 08:04:13','String','No Tags','hi'),(61,'Abbas','simanta',NULL,'2017-06-06 15:38:30','String','No Tags','hi'),(62,'Abbas','simanta',NULL,'2017-06-06 15:38:52','String','semantic','I am explaining #semantic'),(63,'Anuradha','simanta',NULL,'2017-06-06 15:39:09','String','No Tags','hello'),(64,'Abbas','simanta',NULL,'2017-06-06 15:40:28','String','java,angular','This project is developed in #java and #angular'),(65,NULL,'will',NULL,'2017-06-07 10:04:41','String','No Tags','this is my first post'),(66,'Abbas','will',NULL,'2017-06-07 10:04:54','String','No Tags','hi'),(67,'Anuradha','will',NULL,'2017-06-07 10:05:04','String','No Tags','hello'),(68,'Abbas','sachin',NULL,'2017-06-07 11:04:18','String','No Tags','hi'),(69,'Abbas','sachin',NULL,'2017-06-07 11:04:34','String','java','I am working on #java'),(70,'Abbas','sachin',NULL,'2017-06-07 11:05:02','String','semantic,angular','this app is created with #semantic and #angular'),(71,'Anuradha','sachin',NULL,'2017-06-07 11:06:10','String','No Tags','hello'),(72,NULL,'somsubhra',NULL,'2017-06-08 12:53:08','String','java,j2ee','I am working in #java and #j2ee'),(73,NULL,'somsubhra',NULL,'2017-06-09 12:34:46','String','angular','sample message #angular'),(74,'Debjit','somsubhra',NULL,'2017-06-09 15:45:59','String','No Tags','hi'),(75,'Dinesh','somsubhra',NULL,'2017-06-09 15:46:11','String','No Tags','hey'),(76,'Abbas','somsubhra',NULL,'2017-06-09 15:58:38','String','No Tags','hello'),(77,'Abbas','somsubhra',NULL,'2017-06-09 16:01:06','String','No Tags','hi'),(78,NULL,'somsubhra',NULL,'2017-06-09 16:06:10','String','No Tags','hi'),(79,'Abbas','somsubhra',NULL,'2017-06-09 16:06:22','String','No Tags','hello'),(80,'Abbas','somsubhra',NULL,'2017-06-09 16:06:26','String','No Tags','hello'),(81,NULL,'somsubhra',NULL,'2017-06-10 12:48:15','String','angular','#angular'),(82,NULL,'somsubhra',NULL,'2017-06-10 12:48:26','String','angular,spring','#angular #spring'),(83,NULL,'somsubhra',NULL,'2017-06-20 10:29:06','String','No Tags','hi'),(84,NULL,'somsubhra',NULL,'2017-06-20 10:29:20','String','test','this is a #test tool');

UNLOCK TABLES;


DROP TABLE IF EXISTS `user_tag`;

CREATE TABLE `user_tag` (
  `id` int(11) NOT NULL,
  `user_id` varchar(20) DEFAULT NULL,
  `tag` varchar(30) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

LOCK TABLES `user_tag` WRITE;

INSERT INTO `user_tag` VALUES (7137,'sachin','angular'),(36804,'somsubhra','angular'),(43071,'simanta','java'),(45942,'will','java'),(73105,'somsubhra','mongo'),(73449,'sam','angular'),(80669,'atul verma','controller'),(93408,'somsubhra','nosql'),(94380,'somsubhra','java'),(98227,'somsubhra','j2ee');

UNLOCK TABLES;
