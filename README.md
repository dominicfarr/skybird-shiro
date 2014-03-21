Shiro Security Basic Examples
=============================

This project is to help users of the shiro user forum is simple questions.

Each url helps a specific question asked on the forum.

By no means is this code to be taken literally, it is just for demonstration purposes. There are many bad practices in this project that should not be used in real code.


Web Server
----------

This is a maven project, with an embedded jetty plugin.

To start jetty and the web application use maven command

`mvn jetty:run`

Web application locations
-------------------------

Use a browser to see anonymous and authenticated web pages.

**Welcome page** [http://localhost:8888/](http://localhost:8888/) No authentication required.

**Secured page** [http://localhost:8888/web/secure-web.html](http://localhost:8888/web/secure-web.html) 

Secured page requres an Authenticated subject. If the current subject isn't authenticated then the browser is required to  the Login page. 

- Username = dom
- Password = password

After successful authentication, the browser is required back to the Secure page.

**Show principle page** [http://localhost:8888/web/showPrincipal.jsp](http://localhost:8888/web/showPrincipal.jsp) Requires an authenticated subject. It shows the principle stored in the session. This jsp page uses JSP expression, which I would recommend against use normally. 

**Preserve Hash id** [http://localhost:8888/web/workspace.html#documents](http://localhost:8888/web/workspace.html#documents) Requires an authenticated subject. It will preserve the hash id #document in the url after redirect to log in page.

Webservice locations
--------------------

A com.sun.jersey.spi.container.servlet.ServletContainer is set up to provide two GET endpoints. Using curl or other tools these endpoints can be used. These endpoints don't require authentication. 

Set a message ("It's ME!") into the session. (Again, this is very poor code, don't use GET for changing things. POST or PUT are much better)

`curl http://localhost:8888/jersey/message/set`

Get the message from the session, if it is set.

`curl http://localhost:8888/jersey/message`


Extensions
----------
[PreserveFormOnFailureFormAuthenticationFilter](src/main/java/domfarr/filter/PreserveFormOnFailureFormAuthenticationFilter.java) extends the standard FormAuthenticationFilter. It now puts the username back into the request on login failure.

```
@Override
protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
    super.setFailureAttribute(request, ae);
    request.setAttribute(getUsernameParam(), request.getParameter(getUsernameParam()));
}
```

```
[main]
authc = domfarr.filter.PreserveFormOnFailureFormAuthenticationFilter
```
