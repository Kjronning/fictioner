package se.hkr.fictioner.model.user_credentials;

import se.hkr.fictioner.model.data_classes.User;
import se.hkr.fictioner.model.data_management.DataRepository;

public class UserData {
    private static UserData ourInstance;
    private User user;

    public static UserData getInstance() {
        if (ourInstance==null){
            if(DataRepository.loggedIn())
                ourInstance = new UserData(DataRepository.GetSavedUserData());
        }
        if (ourInstance==null){
            ourInstance = new UserData();
        }
        return ourInstance;
    }

    private UserData(){

    }

    private UserData(PermanentUserData savedUserData){
        user = savedUserData.getUser();
    }


    public void logout(){
        user = null;
    }

    public User getUser(){
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
