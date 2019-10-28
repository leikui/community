# oyyo 社区

## 资料
[spring文档](https://spring.io/guides)

[es社区](https://elasticsearch.cn/)

[GitHub Oauth](https://developer.github.com/apps/building-oauth-apps/)

[bootstrap文档](https://v3.bootcss.com/components/#glyphicons)

## sql
```sql
create table tb_user
(
    id           int auto_increment comment '主键'
        primary key,
    account_id   varchar(100) null comment '账户id
',
    name         varchar(50)  null comment '姓名',
    token        char(36)     null comment 'uuid token',
    gmt_create   bigint       null comment '创建时间',
    gmt_modified bigint       null comment '修改时间'
);

```
