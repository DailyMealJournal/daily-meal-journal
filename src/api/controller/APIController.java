package api.controller;


import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;

public abstract class APIController extends Controller{
    
    @Override
    protected Navigation run() throws Exception {
        return null;
    }

    public String getBaseUrl() 
    {
      String url = request.getRequestURL().toString();
      String base_url = url.substring(0, url.length() - request.getRequestURI().length()) + request.getContextPath() + "/";
      
      return base_url;
    }
    
    protected Navigation proceedTo(String requestURL) throws NullPointerException {
        if(sessionScope("user") == null && !request.getRequestURL().toString().equals(getBaseUrl())) {
            return redirect(getBaseUrl());
        } else {
            return forward(requestURL);
        }
    }
}
