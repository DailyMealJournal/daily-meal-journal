package project.dto;

import java.util.ArrayList;
import java.util.List;

import com.google.appengine.api.datastore.Key;

public class JournalDto {
	private List<String> errorList = new ArrayList<String>();
	
    private long id;
    private String journal_date;
    private long journal_meal_id;
    private String UserKey;
    
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
	public String getJournal_date() {
		return journal_date;
	}
	public void setJournal_date(String journal_date) {
		this.journal_date = journal_date;
	}
	public long getJournal_meal_id() {
		return journal_meal_id;
	}
	public void setJournal_meal_id(long journal_meal_id) {
		this.journal_meal_id = journal_meal_id;
	}
	public String getUserKey() {
		return UserKey;
	}
	public void setUserKey(String userKey) {
		UserKey = userKey;
	}
    
}
