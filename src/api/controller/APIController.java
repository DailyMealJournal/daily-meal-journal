package api.controller;


import java.io.IOException;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;


import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONException;
import org.slim3.repackaged.org.json.JSONObject;

import project.model.Session;

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
    
    public void responseSuccess(HttpServletResponse response, JSONObject success) throws IOException {
        response.getWriter().print(success);
    }  

    public void responseFail(HttpServletResponse response, JSONObject error) throws IOException {
        response.getWriter().print(error);
    }
    
    public Map<String,String> setSession(JSONObject json) {
        Session sess = new Session();
        
        try {
            sess.setId(json.getJSONObject("key").get("id").toString());
            sess.setUsername(json.getJSONObject("properties").get("username").toString());
            sess.setFirstName(json.getJSONObject("properties").get("firstName").toString());
            sess.setLastName(json.getJSONObject("properties").get("lastName").toString());
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            sess = null;
        }
        return sess.getMap();
    }
}
