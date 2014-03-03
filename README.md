skybird-shiro
=============

example web secured by shiro that uses two types of authentication one being basic auth

to run.

`mvn jetty:run`

open browser to http://localhost:8888/

http://localhost:8888/index.html (unsecure)

http://localhost:8888/web/secure-web.html (secure via log in form, username/password = dom/password)

http://localhost:8888/api/api.html secure (secure via basic auth, username/password = dom/password)



