package project.controller.admin;

import api.controller.*;
import org.slim3.controller.Navigation;

/**
 * Admin/CRUD Screen Home controller.
 * @author <name here>
 *
 */
public class IndexController extends APIController {

    @Override
    protected Navigation run() throws Exception {
        return forward("crud.jsp");
    }
}
