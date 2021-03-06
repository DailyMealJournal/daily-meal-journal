package project.model;

import java.io.Serializable;

import com.google.appengine.api.datastore.Key;

import org.slim3.datastore.Attribute;
import org.slim3.datastore.Model;

@Model(schemaVersion = 1)
public class Meal implements Serializable {
    
    private static final long serialVersionUID = 1L;
    public static final String KIND_NAME= "MEAL";
    public static final String[] KIND_ATTRIBUTES = {"Key", "Name", "Def_Quantity", "Unit", "Calories", "Description", "Picture"};
    
    private long id;
    private String name;
    private String category;
    private int def_quantity;
    private String unit;
    private int calories;
    private String description;
    private String picture;
    

    @Attribute(primaryKey = true)
    private Key key;

    @Attribute(version = true)
    private Long version;

    /**
     * Returns the key.
     *
     * @return the key
     */
    public Key getKey() {
        return key;
    }

    /**
     * Sets the key.
     *
     * @param key
     *            the key
     */
    public void setKey(Key key) {
        this.key = key;
    }

    /**
     * Returns the version.
     *
     * @return the version
     */
    public Long getVersion() {
        return version;
    }

    /**
     * Sets the version.
     *
     * @param version
     *            the version
     */
    public void setVersion(Long version) {
        this.version = version;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        Meal other = (Meal) obj;
        if (key == null) {
            if (other.key != null) {
                return false;
            }
        } else if (!key.equals(other.key)) {
            return false;
        }
        return true;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public int getDef_quantity() {
        return def_quantity;
    }

    public void setDef_quantity(int def_quantity) {
        this.def_quantity = def_quantity;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPicture() {
        return picture;
    }

    public void setPicture(String picture) {
        this.picture = picture;
    }
    
    public String toString(){
        String result = null;
    
        result = "Id: " + this.id + "\nName: " + this.name + "\nCategory: " + this.category + 
                "\nDefault Quantity: " + this.def_quantity + "\nUnit: " + this.unit + 
                "\nCalories: " + this.calories + "\nDescription: " + this.description + 
                "\nPicture: " + this.picture;
        
        return result;
    }

}
