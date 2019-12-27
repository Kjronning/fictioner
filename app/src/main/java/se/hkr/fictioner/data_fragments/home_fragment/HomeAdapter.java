package se.hkr.fictioner.data_fragments.home_fragment;

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
import se.hkr.fictioner.data_fragments.RecyclerViewClickListener;
import se.hkr.fictioner.data_fragments.RepositoryListContract;
import se.hkr.fictioner.model.data_classes.Note;

public class HomeAdapter extends RealmRecyclerViewAdapter<Note, NoteViewHolder> {
    NoteListPresenter presenter;
    private RecyclerViewClickListener clickListener;

    public HomeAdapter(@Nullable OrderedRealmCollection data, boolean autoUpdate) {
        super(data, autoUpdate);
    }


    public HomeAdapter(@Nullable OrderedRealmCollection data, boolean autoUpdate, RecyclerViewClickListener clickListener) {
        super(data, autoUpdate);
        this.clickListener = clickListener;
    }

    public HomeAdapter(@Nullable OrderedRealmCollection data, boolean autoUpdate, boolean updateOnModification) {
        super(data, autoUpdate, updateOnModification);
    }

    @NonNull
    @Override
    public NoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_list_item, parent, false);
        presenter = new NoteListPresenter();
        return new NoteViewHolder(itemView, clickListener);

    }

    @Override
    public void onBindViewHolder(@NonNull NoteViewHolder holder, int position) {
        presenter.onBindRepositoryViewAtPosition(position,holder);

    }
}

class NoteViewHolder extends RecyclerView.ViewHolder implements RepositoryListContract.ContractView,View.OnClickListener {
    private TextView bodyTextView;
    private TextView titleTextView;
    private RecyclerViewClickListener clickListener;

    NoteViewHolder(@NonNull View itemView, RecyclerViewClickListener clickListener) {
        super(itemView);
        bodyTextView = itemView.findViewById(R.id.body_text_view);
        titleTextView = itemView.findViewById(R.id.title_text_view);
        this.clickListener = clickListener;
        itemView.setOnClickListener(this);
    }

    @Override
    public void setTitle(String title) {
        titleTextView.setText(title);
    }

    @Override
    public void setBody(String body) {
        bodyTextView.setText(body);
    }

    @Override
    public void onClick(View v) {
        clickListener.onClick(v, getAdapterPosition(), "note");
    }
}
