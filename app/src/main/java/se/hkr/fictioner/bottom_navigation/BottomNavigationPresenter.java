package se.hkr.fictioner.bottom_navigation;

public class BottomNavigationPresenter implements BottomNavigationContract.Presenter{

    BottomNavigationContract.ContractView contractView;

    public BottomNavigationPresenter(BottomNavigationContract.ContractView contractView){
        this.contractView = contractView;
    }
}
