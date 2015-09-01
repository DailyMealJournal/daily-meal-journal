package project.dto;

import java.util.List;

import com.google.appengine.api.datastore.Key;

public class MealDto {
    private List<String> errorList;
    
    private long id;
    private Key key;
    private String name;
    private String category;
    private int def_quantity;
    private String unit;
    private int calories;
    private String description;
    private String picture;
    
    public List<String> getErrorList() {
        return errorList;
    }
    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
    
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    public Key getKey() {
        return key;
    }
    public void setKey(Key key) {
        this.key = key;
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
