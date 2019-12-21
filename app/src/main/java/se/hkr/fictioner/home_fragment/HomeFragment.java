package se.hkr.fictioner.home_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import se.hkr.fictioner.R;

public class HomeFragment extends Fragment implements HomeFragmentContract.ContractView {

    HomeFragmentPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.home_fragment,
                container, false);
        return view;
    }

    public void setPresenter(HomeFragmentPresenter presenter){
        this.presenter = presenter;
    }
}
