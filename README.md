# TG-Database
Use MongoDB with OpenLiberty via Maven.

-----------------------------------

**Please DON'T edit ".gitignore", target and .idea are IDE unique for everyone! Thus, they cannot be included in this shared repo!**

---------------------------------

**Use either the SSLErrorFix.txt file from Discord in order to fix the "SSL Handshake Error" or the following commands in a Terminal:**

-------------------------------------------

***Location: These commands must be run from: \TG-Database\target\liberty\wlp\usr\servers\defaultServer\resources\security***

`openssl s_client -showcerts -servername tg-database-shard-00-02.1q9gs.mongodb.net:27017 -connect tg-database-shard-00-02.1q9gs.mongodb.net:27017 >> fix.txt`

`openssl s_client -showcerts -servername tg-database-shard-00-00.1q9gs.mongodb.net:27017 -connect tg-database-shard-00-00.1q9gs.mongodb.net:27017 >> key.p12`

`openssl s_client -showcerts -servername tg-database-shard-00-01.1q9gs.mongodb.net:27017 -connect tg-database-shard-00-01.1q9gs.mongodb.net:27017 >> key.p12`
