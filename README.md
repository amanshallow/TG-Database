# TG-Database
Get started with MongoDB CRUD operations with IBM's OpenLiberty and Maven.

---------------------------------

**Use the following commands in a Terminal in order to fix the "SSL Handshake Error":**

---------------------------------

***Location of key.p12 file:*** 

```\TG-Database\target\liberty\wlp\usr\servers\defaultServer\resources\security```

`openssl s_client -showcerts -servername tg-database-shard-00-02.1q9gs.mongodb.net:27017 -connect tg-database-shard-00-02.1q9gs.mongodb.net:27017 > fix.txt`

`openssl s_client -showcerts -servername tg-database-shard-00-00.1q9gs.mongodb.net:27017 -connect tg-database-shard-00-00.1q9gs.mongodb.net:27017 >> key.p12`

`openssl s_client -showcerts -servername tg-database-shard-00-01.1q9gs.mongodb.net:27017 -connect tg-database-shard-00-01.1q9gs.mongodb.net:27017 >> key.p12`
