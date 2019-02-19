
DROP TABLE IF EXISTS sys_user;
CREATE TABLE sys_user (
  id serial,
  user_name varchar(64) NOT NULL,
  password varchar(64) NOT NULL,
  real_name varchar(64) DEFAULT NULL,
  mobile varchar(64) DEFAULT NULL,
  email varchar(64) DEFAULT NULL,
  PRIMARY KEY (id)
);

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO sys_user VALUES (1, 'zhangsan', '123456', null, null, null);
INSERT INTO sys_user VALUES (2, 'lisi', '123456', null, null, null);
INSERT INTO sys_user VALUES (3, 'zhangwu', '123456', null, null, null);

select * from sys_user;