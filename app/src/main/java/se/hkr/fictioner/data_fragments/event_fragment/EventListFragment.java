package se.hkr.fictioner.data_fragments.event_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmList;
import se.hkr.fictioner.R;
import se.hkr.fictioner.data_fragments.ListFragmentContract;
import se.hkr.fictioner.data_fragments.RecyclerViewClickListener;
import se.hkr.fictioner.databinding.EventFragmentBinding;

public class EventListFragment extends Fragment implements ListFragmentContract.ContractView {
    private EventAdapter adapter;
    private ListFragmentContract.Presenter  presenter;
    RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;

    public EventListFragment(RecyclerViewClickListener clickListener){
        adapter = new EventAdapter(null, true, clickListener);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        EventFragmentBinding binding = DataBindingUtil.inflate(inflater,R.layout.event_fragment,
                container, false);
        View view = binding.getRoot();
        binding.setPresenter(presenter);
        recyclerView = view.findViewById(R.id.event_recycler_view);
        recyclerView.setAdapter(adapter);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }
    @Override
    public void setListItems(RealmList items) {
        adapter.updateData(items);
    }

    @Override
    public void openEditDialog() {

    }

    @Override
    public void setPresenter(ListFragmentContract.Presenter presenter) {
        this.presenter = presenter;
    }
}

