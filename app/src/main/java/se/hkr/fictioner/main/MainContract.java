package se.hkr.fictioner.main;

import android.view.View;


public interface MainContract {
    interface ContractView{
        void changeScreen();
        void makeToast(String text);
    }
    interface Presenter{
        void handleLoginButtonPress(View view);

        void handleLoggedIn();
    }
}
