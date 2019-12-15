package se.hkr.fictioner.list_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.OrderedRealmCollection;
import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.RealmRecyclerViewAdapter;
import io.realm.RealmResults;
import se.hkr.fictioner.R;

public class ListFragment <T extends RealmObject> implements ListFragmentContract.ContractView {
    private ListFragmentPresenter<T> presenter;
    private MyAdapter<T> adapter;

    public ListFragment(Class<T> tClass){
        //create that shit?
        presenter = new ListFragmentPresenter<>(this);
        adapter = new MyAdapter<>(null, true);
        presenter.fetchRealmObjectList(tClass);
    }


    @Override
    public void setListItems(RealmResults items) {
        adapter.updateData(items);
    }
}

class MyAdapter<T extends RealmObject> extends RealmRecyclerViewAdapter {
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
