package se.hkr.fictioner.home_fragment;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment implements HomeFragmentContract.ContractView {

    HomeFragmentPresenter presenter;

    public void setPresenter(HomeFragmentPresenter presenter){
        this.presenter = presenter;
    }
}
