package se.hkr.fictioner.bottom_navigation;

public class BottomNavigationPresenter implements BottomNavigationContract.Presenter{

    BottomNavigationContract.ContractView contractView;

    public BottomNavigationPresenter(BottomNavigationContract.ContractView contractView){
        this.contractView = contractView;
    }

    @Override
    public void handleCharacterButtonPress() {
        contractView.switchToCharacterFragment();
    }

    @Override
    public void handleChapterButtonPress() {
        contractView.switchToChapterFragment();
    }

    @Override
    public void handleEventButtonPress() {
        contractView.switchToEventFragment();
    }

    @Override
    public void handleLocationButtonPress() {
        contractView.switchToLocationFragment();
    }

    @Override
    public void handleHomeButtonPress() {
        contractView.switchToHomeFragment();
    }
}
