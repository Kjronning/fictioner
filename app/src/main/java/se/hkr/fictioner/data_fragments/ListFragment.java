package se.hkr.fictioner.data_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmList;
import se.hkr.fictioner.model.data_classes.Book;

public class ListFragment extends Fragment implements ListFragmentContract.ContractView {
    private MyAdapter adapter;
    private int fragmentResource;
    private int recyclerViewResource;
    private ListFragmentContract.Presenter presenter;
    RecyclerView recyclerView;

    public ListFragment(int fragmentResource, int recyclerViewResource){
        this.fragmentResource = fragmentResource;
        this.recyclerViewResource = recyclerViewResource;
        adapter = new MyAdapter(null, true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        View view = inflater.inflate(fragmentResource,
                container, false);
        recyclerView = view.findViewById(recyclerViewResource);
        recyclerView.setAdapter(adapter);
        System.out.println(recyclerView.getAdapter());
        //recyclerView.setLayoutManager(new MyLayoutManager());
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }
    @Override
    public void setListItems(RealmList items) {
        System.out.println("is adapter created?" + (adapter!=null));
        adapter.updateData(items);
    }

    @Override
    public void setPresenter(ListFragmentContract.Presenter presenter) {
        this.presenter = presenter;
    }
}

