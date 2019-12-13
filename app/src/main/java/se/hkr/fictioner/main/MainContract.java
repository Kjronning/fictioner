package se.hkr.fictioner.main;

import android.content.Context;
import android.view.View;

import se.hkr.fictioner.model.data_management.DataRepository;

public interface MainContract {
    interface ContractView{
        void loginSuccessful();
        void changeScreen();

    }
    interface Presenter{
        void handleLoginButtonPress(View view);
    }
}
