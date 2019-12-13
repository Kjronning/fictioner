package se.hkr.fictioner.main;

import android.view.View;

public class MainPresenter implements MainContract.Presenter{
    private MainContract.ContractView contractView;

    MainPresenter(MainContract.ContractView contractView){
        this.contractView = contractView;
    }

    @Override
    public void handleLoginButtonPress(View view) {
        contractView.changeScreen();
    }
}
