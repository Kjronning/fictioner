package se.hkr.fictioner.main;

import android.view.View;

import se.hkr.fictioner.model.data_classes.User;
import se.hkr.fictioner.model.data_management.DataRepository;

public class MainPresenter implements MainContract.Presenter{
    private MainContract.ContractView contractView;
    private String username;
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    MainPresenter(MainContract.ContractView contractView){
        this.contractView = contractView;
    }

    @Override
    public void handleLoginButtonPress(View view) {
        //Set UserData to login user, fetch current book from database.
        User user = DataRepository.GetUserFromDataSource(username);
        if(user != null){
            if(user.isPasswordCorrect(password)){
                DataRepository.SetUserForSession(user);
                contractView.changeScreen();
            }else{
                contractView.makeToast("Password Incorrect");
            }
        }else{
            contractView.makeToast("User not found");
        }
        }

    @Override
    public void handleLoggedIn() {
        contractView.changeScreen();
    }

    @Override
    public void handleRegisterButtonPress(View view){
        if (DataRepository.UserAlreadyExists(username)){
            contractView.makeToast("User already exists");
        }else{
            DataRepository.CreateNewUser(new User(username,password));
            contractView.makeToast("Register successful");
        }
    }
}
