package se.hkr.fictioner.model;

public class UserData {
    private static UserData ourInstance;

    public static UserData getInstance() {
        if (ourInstance==null){
            ourInstance = new UserData();
        }
        return ourInstance;
    }

    private UserData() {
    }


}
