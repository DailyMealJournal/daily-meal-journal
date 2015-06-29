package project.controller.admin;

import api.controller.*;
import org.slim3.controller.Navigation;

public class InsertController extends APIController {

    @Override
    public Navigation run() throws Exception {
        return forward("insert.jsp");
    }
}
