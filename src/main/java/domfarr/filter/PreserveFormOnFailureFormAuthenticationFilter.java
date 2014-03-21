package domfarr.filter;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;

import javax.servlet.ServletRequest;

public class PreserveFormOnFailureFormAuthenticationFilter extends FormAuthenticationFilter {
    @Override
    protected void setFailureAttribute(ServletRequest request, AuthenticationException ae) {
        super.setFailureAttribute(request, ae);
        request.setAttribute("username", request.getParameter(getUsernameParam()));
    }
}
