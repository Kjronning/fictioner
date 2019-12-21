package se.hkr.fictioner.data_fragments.character_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmList;
import se.hkr.fictioner.R;
import se.hkr.fictioner.data_fragments.ListFragmentContract;

public class CharacterListFragment extends Fragment implements ListFragmentContract.ContractView {
    private CharacterAdapter adapter;
    private ListFragmentContract.Presenter presenter;
    private RecyclerView recyclerView;
    private LinearLayoutManager linearLayoutManager;
    private DividerItemDecoration dividerItemDecoration;

    public CharacterListFragment(){
        adapter = new CharacterAdapter(null, true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(R.layout.character_fragment,
                container, false);
        recyclerView = view.findViewById(R.id.character_recycler_view);
        recyclerView.setAdapter(adapter);
        linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(),
                linearLayoutManager.getOrientation());
        dividerItemDecoration.setDrawable(getResources().getDrawable(R.drawable.recyclerview_divider));
        recyclerView.addItemDecoration(dividerItemDecoration);
        return view;
    }
    @Override
    public void setListItems(RealmList items) {
        adapter.updateData(items);
    }

    @Override
    public void setPresenter(ListFragmentContract.Presenter presenter) {
        this.presenter = presenter;
    }
}

