
DROP TABLE IF EXISTS sys_code;
CREATE TABLE sys_code (
  id serial,
  pid numeric,
  name varchar(64) NOT NULL,
  code text,
  PRIMARY KEY (id)
);

-- ----------------------------
-- Records of sys_user
-- ----------------------------
INSERT INTO sys_user VALUES (1, 'zhangsan', '123456', null, null, null);
INSERT INTO sys_user VALUES (2, 'lisi', '123456', null, null, null);
INSERT INTO sys_user VALUES (3, 'zhangwu', '123456', null, null, null);
insert into sys_user(user_name, password) values('lzugis', '123456');

select * from sys_user;
