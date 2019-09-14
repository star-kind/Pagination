+---------+--------------------------------------------------------------------+
| Table   | Create Table                                                       |
+---------+--------------------------------------------------------------------+
| soldier | CREATE TABLE `soldier` (                                           |
|         |   `soldier_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '士兵编号',  |
|         |   `soldier_name` varchar(30) NOT NULL COMMENT '士兵名字',           |
|         |   `join_army_time` timestamp NOT NULL COMMENT '参军时间',           |
|         |   PRIMARY KEY (`soldier_id`),                                      |
|         |   KEY `sid` (`soldier_id`)                                         |
|         | ) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8              |
+---------+--------------------------------------------------------------------+

-- insert
insert into soldier (soldier_id,soldier_name,join_army_time) values (5,'oouu','2018-09-07 18:55:11');
insert into soldier (soldier_id,soldier_name,join_army_time) values (6,'duuu','2018-11-07 18:55:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (7,'uuus','2018-09-07 11:55:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (8,'uudu','2013-09-07 18:55:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (9,'uuee','2008-09-07 18:55:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (10,'guuu','2008-12-07 18:45:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (11,'fuuu','2023-12-07 18:45:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (12,'fruu','2001-12-07 18:45:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (13,'dfuu','2008-10-07 18:55:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (14,'uuuty','2018-04-07 18:55:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (1,'gguty','2014-04-07 18:55:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (15,'oouu','2018-01-07 18:55:11');
insert into soldier (soldier_id,soldier_name,join_army_time) values (16,'duruu','2018-01-07 18:55:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (17,'uuugs','2018-02-07 11:55:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (18,'uuddu','2013-03-07 18:55:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (19,'uudee','2008-04-07 18:55:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (20,'guduu','2008-11-07 18:45:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (21,'fuduu','2023-10-07 18:45:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (22,'frduu','2001-11-07 18:45:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (23,'dfduu','2008-11-07 18:55:10');
insert into soldier (soldier_id,soldier_name,join_army_time) values (24,'ufuuty','2018-05-07 18:55:10');

-- limit
select * from soldier where soldier_id limit 0,3;