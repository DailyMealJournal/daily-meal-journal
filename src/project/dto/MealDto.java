package project.dto;

import java.util.List;

public class MealDto {
    private List<String> errorList;
    private int id;
    private String name;
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
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
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
}
