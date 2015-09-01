package project.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

public class Session implements Serializable{
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String id;
    private String Username;
    private String FirstName;
    private String LastName;
    private String ImageUrl;
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public String getUsername() {
        return Username;
    }
    public void setUsername(String username) {
        Username = username;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
  
    public String getImageUrl() {
        return ImageUrl;
    }
    public void setImageUrl(String imageUrl) {
        ImageUrl = imageUrl;
    }
    
    public Map<String, String> getMap() {
        Map<String,String> list = new HashMap<String,String>(); 
        list.put("id", this.id);
        list.put("username", this.Username);
        list.put("first_name", this.FirstName);
        list.put("last_name", this.LastName);
        list.put("image_url", this.ImageUrl);

        return list;
        
    }
    
}
