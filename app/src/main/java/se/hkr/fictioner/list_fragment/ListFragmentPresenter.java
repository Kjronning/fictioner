package se.hkr.fictioner.list_fragment;

public class ListFragmentPresenter implements ListFragmentContract.Presenter {

    private ListFragmentContract.ContractView contractView;

    public ListFragmentPresenter(ListFragmentContract.ContractView contractView){
        this.contractView = contractView;
    }
}
