package domfarr.ws;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/message")
public class SomeEndpoint {

    public static final String CURRENT_USER_KEY = "currentUser";

    @GET
    public Response getCurrentUser() {
        Subject subject = SecurityUtils.getSubject();
        Session session = subject.getSession(false);
        String message;
        if(session != null) {
            message = "Current user: " + session.getAttribute(CURRENT_USER_KEY);
        } else {
            message = "No current user, no session created";
        }
        return Response.ok(message).build();
    }

    @GET
    @Path("/set")
    // yes yes. this should be post but for simplicity it's a get
    public Response setCurrentUser() {
        Subject currentUser = SecurityUtils.getSubject();
        Session session = currentUser.getSession(true);
        session.setAttribute(CURRENT_USER_KEY, "It's ME!");

//        return Response.noContent().build();
        return Response.ok(String.format("I've set a value {%s} in the session with key {%s} ", session.getAttribute(CURRENT_USER_KEY), CURRENT_USER_KEY)).build();
    }
}
