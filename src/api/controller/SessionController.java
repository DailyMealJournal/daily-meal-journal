package api.controller;


import org.slim3.controller.Controller;
import org.slim3.controller.Navigation;
import org.slim3.repackaged.org.json.JSONObject;

public abstract class SessionController extends Controller{
    
    @Override
    protected Navigation run() throws Exception {
        if(sessionScope("user") != null) {  
           response.getWriter().print("ss");
        } else {
            JSONObject noSession = new JSONObject();
            noSession.put("2001", "Session Does Not Exist");
            response.getWriter().print(noSession);
        }
        return null;
    }

}
