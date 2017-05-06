# VS2

# DB構成
## MySQLのユーザーとデータベースの作成

```
mysql
create database sv2;
create user 'sv2'@'localhost' identified by 'sv2';
grant all privileges on sv2.* to 'sv2'@'localhost';
flush privileges;
```
```
mysql(テスト)
create database sv2_test;
create user 'sv2'@'localhost' identified by 'sv2';
grant all privileges on sv2_test.* to 'sv2'@'localhost';
flush privileges;
```

- マイグレーションの実行
```
sbt flywayMigrate -Dflyway.url=jdbc:mysql://localhost:3306/sv2 -Dflyway.user=sv2 -Dflyway.password=sv2
```
- DBの初期化
```
sbt flywayClean -Dflyway.url=jdbc:mysql://localhost:3306/sv2 -Dflyway.user=sv2 -Dflyway.password=sv2
```


- マイグレーションの実行(テスト)
```
sbt flywayMigrate -Dflyway.url=jdbc:mysql://localhost:3306/sv2_test -Dflyway.user=sv2 -Dflyway.password=sv2
```
- DBの初期化
```
sbt flywayClean -Dflyway.url=jdbc:mysql://localhost:3306/sv2_test -Dflyway.user=sv2 -Dflyway.password=sv2
```

- アプリケーションの実行
```
$ activator "sv2/run"
```

- アプリケーションのテスト
```
$ activator "sv2/test"
```

- 特定のテストの実行

例えば ```CharacterAffiliationRepositorySpecs``` のみ実行する場合は以下の通りです。

```
$ activator "siliconValley/testOnly siliconValley.domain.character.repository.CharacterAffiliationRepositorySpecs"
```




