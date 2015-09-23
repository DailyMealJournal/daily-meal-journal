package project.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Key;

public class JournalMealDto {
    private List<String> errorList = new ArrayList<String>();
    
    private Long id;
    
    private Long journal_id;
    private Long meal_id;
    private int quantity;
    private int total_calories;
    
    public List<String> getErrorList() {
        return errorList;
    }
    
    public void setErrorList(List<String> errorList) {
        this.errorList = errorList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getJournal_id() {
        return journal_id;
    }

    public void setJournal_id(Long journal_id) {
        this.journal_id = journal_id;
    }

    public Long getMeal_id() {
        return meal_id;
    }

    public void setMeal_id(Long meal_id) {
        this.meal_id = meal_id;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getTotal_calories() {
        return total_calories;
    }

    public void setTotal_calories(int total_calories) {
        this.total_calories = total_calories;
    }

    
}
