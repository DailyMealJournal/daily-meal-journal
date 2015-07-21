/* ------------------------------------------------------------------------------
 * Unauthorized copying of this file, via any medium is strictly prohibited
 * Proprietary and confidential
 * Copyright (C) Rococo Global Technologies, Inc - All Rights Reserved 2015
 * --------------------------------------------------------------------------- */
package project.service;

import java.util.ArrayList;
import java.util.List;

import project.dao.ProjectDao;
import project.dto.UserDto;
import project.model.User;

public class ProjectService {
    ProjectDao dao = new ProjectDao();
    
    public UserDto user(UserDto input, String action){
        User user = new User();
        if(action.equals("create")){
            user.setUsername(input.getUsername());
            user.setPassword(input.getPassword());
            user.setFirstName(input.getFirstname());
            user.setLastName(input.getLastname());
            
            if(!this.dao.createUser(user)){
                input.setErrorList(new ArrayList<String>());
                input.getErrorList().add("error!");
            }
        } else if(action.equals("login")) {
            user.setUsername(input.getUsername());
            user.setPassword(input.getPassword());
            if(!this.dao.checkUser(input)){
                input.setErrorList(new ArrayList<String>());
                input.getErrorList().add("error!");
            }
        }
        
        return input;
    }
    
    public List<User> getUserList() {
        return this.dao.getAllUsers();
    }
}
