package se.hkr.fictioner.data_fragments;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.OrderedRealmCollection;
import io.realm.RealmModel;
import io.realm.RealmRecyclerViewAdapter;
import se.hkr.fictioner.R;
import se.hkr.fictioner.model.data_classes.Character;

public class MyAdapter extends RealmRecyclerViewAdapter {
    public MyAdapter(@Nullable OrderedRealmCollection data, boolean autoUpdate) {
        super(data, autoUpdate);
    }

    public MyAdapter(@Nullable OrderedRealmCollection data, boolean autoUpdate, boolean updateOnModification) {
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
        Character currentItem = (Character)getItem(position);
        TextView textView = holder.itemView.findViewById(R.id.viewholder_textview);
        if(currentItem==null){
            System.out.println("current item is null");
        }else {
            textView.setText(currentItem.getName());
        }
    }
}

class ViewHolder extends RecyclerView.ViewHolder{


    ViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
