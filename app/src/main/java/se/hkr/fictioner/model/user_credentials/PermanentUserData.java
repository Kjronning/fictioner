package se.hkr.fictioner.model.user_credentials;

import io.realm.RealmObject;
import se.hkr.fictioner.model.data_classes.User;

public class PermanentUserData extends RealmObject {
    User user;

    public PermanentUserData(){}

    public PermanentUserData(User user){
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
