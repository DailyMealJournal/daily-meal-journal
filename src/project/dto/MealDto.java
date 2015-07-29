package project.dto;

import java.util.List;

public class MealDto {
    private List<String> errorList;
    private String MealName;
    private int Calories;
    private int UserKey;
    private String Description;
    private String Tags;
    private String Picture;
    
    public List<String> getErrorList() {
        return errorList;
    }
    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }
    
    public String getMealName() {
        return MealName;
    }
    public void setMealName(String MealName) {
        this.MealName = MealName;
    }

    public int getCalories() {
        return Calories;
    }
    public void setCalories(int Calories) {
        this.Calories = Calories;
    }
    
    public int getUserKey() {
        return UserKey;
    }  
    public void setUserKey(int UserKey) {
        this.UserKey = UserKey;
    }
    
    public String getDescription() {
        return Description;
    }
    public void setDescription(String Description) {
        this.Description = Description;
    }

    public String getTags() {
        return Tags;
    }
    public void setTags(String Tags) {
        this.Tags = Tags;
    }

    public String getPicture() {
        return Picture;
    }
    public void setPicture(String Picture) {
        this.Picture = Picture;
    }
}
