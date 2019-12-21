package se.hkr.fictioner.data_fragments.home_fragment;

public class HomeFragmentPresenter implements HomeFragmentContract.Presenter {
    private HomeFragmentContract.ContractView contractView;

    public HomeFragmentPresenter(HomeFragmentContract.ContractView contractView){
        this.contractView = contractView;
    }

}
