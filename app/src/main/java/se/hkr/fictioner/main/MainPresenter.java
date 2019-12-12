package se.hkr.fictioner.main;

public class MainPresenter implements MainContract.Presenter{
    private MainContract.ContractView contractView;

    MainPresenter(MainContract.ContractView contractView){
        this.contractView = contractView;
    }
}
