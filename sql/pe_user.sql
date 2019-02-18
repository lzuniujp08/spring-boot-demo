
DROP TABLE IF EXISTS `pe_user`;
CREATE TABLE `pe_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `user_name` varchar(64) NOT NULL,
  `password` varchar(64) NOT NULL,
  `real_name` varchar(64) DEFAULT NULL,
  `mobile` varchar(64) DEFAULT NULL,
  `email` varchar(64) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Records of pe_user
-- ----------------------------
INSERT INTO `pe_user` VALUES ('1', 'zhangsan', '123456', null, null, null);
INSERT INTO `pe_user` VALUES ('2', 'lisi', '123456', null, null, null);
