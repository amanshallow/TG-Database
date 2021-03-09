# TG-Database
Get started with MongoDB CRUD operations using IBM's OpenLiberty microservice framework and Maven.

---------------------------------

**Use the following commands in a Terminal in order to fix the "SSL Handshake Error":**

---------------------------------

***Location of key.p12 file:*** 

```\TG-Database\target\liberty\wlp\usr\servers\defaultServer\resources\security```

```
openssl s_client -showcerts -servername [endpoint-name].mongodb.net:27017 -connect [endpoint-name].mongodb.net:27017 > key.p12
openssl s_client -showcerts -servername [endpoint-2-name].mongodb.net:27017 -connect [endpoint-2-name].mongodb.net:27017 >> key.p12
openssl s_client -showcerts -servername [endpoint-3-name].mongodb.net:27017 -connect [endpoint-3-name].mongodb.net:27017 >> key.p12
```
