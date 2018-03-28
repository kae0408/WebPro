set names utf8;
set foreign_key_checks = 0;
drop database if exists logindb;
/*もし「logindb」というデータベースがあったら削除します*/
create database logindb;
/*もし「logindb」データベースを作成します*/

use logindb;
/*作成した「lodindb」を使います！*/

create table user(
/*「user」 がテーブル名になる*/
id int;
user_name varchar(255),
password varchar(255)
);

insert into user values
/*「user」 テーブルに情報を保存*/
(1,"taro","123"),
(2,"joro","123"),
(3,"hanako","123"),
(4,"saburo","123");
