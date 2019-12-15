package se.hkr.fictioner.main;

import android.view.View;


public interface MainContract {
    interface ContractView{
        void changeScreen();

    }
    interface Presenter{
        void handleLoginButtonPress(View view);

        void handleLoggedIn();
    }
}
