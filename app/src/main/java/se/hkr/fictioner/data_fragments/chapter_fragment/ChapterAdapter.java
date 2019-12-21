package se.hkr.fictioner.data_fragments.chapter_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import se.hkr.fictioner.R;
import se.hkr.fictioner.model.data_classes.Chapter;

public class ChapterAdapter extends RealmRecyclerViewAdapter {
    public ChapterAdapter(@Nullable OrderedRealmCollection data, boolean autoUpdate) {
        super(data, autoUpdate);
    }

    public ChapterAdapter(@Nullable OrderedRealmCollection data, boolean autoUpdate, boolean updateOnModification) {
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
        Chapter currentItem = (Chapter) getItem(position);
        TextView textView = holder.itemView.findViewById(R.id.viewholder_textview);
        textView.setText(currentItem != null ? currentItem.getName() : null);

    }
}

class ViewHolder extends RecyclerView.ViewHolder{


    ViewHolder(@NonNull View itemView) {
        super(itemView);
    }
}
