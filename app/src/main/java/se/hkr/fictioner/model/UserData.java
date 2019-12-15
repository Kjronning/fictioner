package se.hkr.fictioner.model;

import io.realm.RealmObject;
import se.hkr.fictioner.model.data_management.DataRepository;

public class UserData extends RealmObject {
    private static UserData ourInstance;
    private String currentBookId;
    private String userId;

    public static UserData getInstance() {
        if (ourInstance==null){
            ourInstance = DataRepository.GetUserData();
        }
        if (ourInstance==null){
            ourInstance = new UserData();
        }
        return ourInstance;
    }

    private UserData() {
    }

    public void setCurrentBook(String bookId){
        currentBookId = bookId;
    }

    public String getCurrentBookId() {
        return currentBookId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public void logout(){
        currentBookId = "";
        userId = "";
    }
}
