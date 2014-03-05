skybird-shiro
=============

example web secured by shiro that uses two types of authentication one being basic auth

to run.

`mvn jetty:run`

open browser to http://localhost:8888/

http://localhost:8888/index.html (unsecure)

http://localhost:8888/web/secure-web.html (secure via log in form, username/password = dom/password)

http://localhost:8888/api/api.html secure (secure via basic auth, username/password = dom/password)


Curling API without Authorization header 401 will be returned.

    curl -v http://localhost:8888/api/api.html

    Adding handle: conn: 0x7fbc99803a00
    Adding handle: send: 0
    Adding handle: recv: 0
    Curl_addHandleToPipeline: length: 1
    - Conn 0 (0x7fbc99803a00) send_pipe: 1, recv_pipe: 0
    About to connect() to localhost port 8888 (#0)
      Trying ::1...
    Connected to localhost (::1) port 8888 (#0)
    GET /api/api.html HTTP/1.1
    User-Agent: curl/7.30.0
    Host: localhost:8888
    Accept: */*

    HTTP/1.1 401 Unauthorized
    WWW-Authenticate: BASIC realm="application"
    Content-Length: 0
    Server Jetty(8.1.12.v20130726) is not blacklisted
    Server: Jetty(8.1.12.v20130726)

    Connection #0 to host localhost left intact


Curling API with Authorization header


    curl -v -H "Authorization: basic ZG9tOnBhc3N3b3Jk" http://localhost:8888/api/api.html

    Adding handle: conn: 0x7fbe6a003a00
    Adding handle: send: 0
    Adding handle: recv: 0
    Curl_addHandleToPipeline: length: 1
    - Conn 0 (0x7fbe6a003a00) send_pipe: 1, recv_pipe: 0
    About to connect() to localhost port 8888 (#0)
      Trying ::1...
    Connected to localhost (::1) port 8888 (#0)
    GET /api/api.html HTTP/1.1
    User-Agent: curl/7.30.0
    Host: localhost:8888
    Accept: */*
    Authorization: basic ZG9tOnBhc3N3b3Jk

    HTTP/1.1 200 OK
    Set-Cookie: JSESSIONID=45f08f8b-9823-44a3-9418-d638fe6484e7; Path=/; HttpOnly
    Set-Cookie: rememberMe=deleteMe; Path=/; Max-Age=0; Expires=Sun, 02-Mar-2014 09:21:25 GMT
    Content-Type: text/html
    Last-Modified: Mon, 03 Mar 2014 08:37:48 GMT
    Content-Length: 136
    Accept-Ranges: bytes
    Server Jetty(8.1.12.v20130726) is not blacklisted
    Server: Jetty(8.1.12.v20130726)

    Connection #0 to host localhost left intact

    <!DOCTYPE html>
    <html>
    <head>
        <title>api</title>
    </head>
    <body>
         <h1>this page represents the api endpoints</h1>
    </body>



shows where shiro stores the principal object in the session
----

http://localhost:8888/web/showPrincipal.jsp secure (secure via basic auth, username/password = dom/password)
