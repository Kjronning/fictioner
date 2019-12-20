package se.hkr.fictioner.data_fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.OrderedRealmCollection;
import io.realm.RealmList;
import io.realm.RealmRecyclerViewAdapter;
import se.hkr.fictioner.R;

public abstract class ListFragment extends Fragment implements ListFragmentContract.ContractView {
    private MyAdapter adapter;

    @Override
    public void setListItems(RealmList items) {
        adapter.updateData(items);
    }

    @Override
    public void setPresenter(ListFragmentContract.Presenter presenter) {

    }
}

class MyAdapter extends RealmRecyclerViewAdapter {
    MyAdapter(@Nullable OrderedRealmCollection data, boolean autoUpdate) {
        super(data, autoUpdate);
    }

    MyAdapter(@Nullable OrderedRealmCollection data, boolean autoUpdate, boolean updateOnModification) {
        super(data, autoUpdate, updateOnModification);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent, false);
        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

    }
}

class ViewHolder extends RecyclerView.ViewHolder{

    ViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
