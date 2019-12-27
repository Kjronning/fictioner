package se.hkr.fictioner.data_fragments.character_fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.OrderedRealmCollection;
import io.realm.RealmRecyclerViewAdapter;
import se.hkr.fictioner.R;
import se.hkr.fictioner.data_fragments.RecyclerViewClickListener;
import se.hkr.fictioner.data_fragments.RepositoryListContract;
import se.hkr.fictioner.model.data_classes.Character;

public class CharacterAdapter extends RealmRecyclerViewAdapter<Character, CharacterViewHolder> {
    private CharacterListPresenter presenter;
    private RecyclerViewClickListener clickListener;

    public CharacterAdapter(@Nullable OrderedRealmCollection data, boolean autoUpdate) {
        super(data, autoUpdate);
    }

    public CharacterAdapter(@Nullable OrderedRealmCollection data, boolean autoUpdate, boolean updateOnModification) {
        super(data, autoUpdate, updateOnModification);
    }

    public CharacterAdapter(@Nullable OrderedRealmCollection data, boolean autoUpdate, RecyclerViewClickListener clickListener){
        super(data, autoUpdate);
        this.clickListener = clickListener;
    }

    @NonNull
    @Override
    public CharacterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.character_list_item, parent, false);
        presenter = new CharacterListPresenter();
        return new CharacterViewHolder(itemView, clickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull CharacterViewHolder holder, int position) {
        presenter.onBindRepositoryViewAtPosition(position,holder);
    }
}

class CharacterViewHolder extends RecyclerView.ViewHolder implements RepositoryListContract.ContractView, View.OnClickListener {
    private TextView bodyTextView;
    private TextView titleTextView;
    private RecyclerViewClickListener clickListener;

    CharacterViewHolder(@NonNull View itemView, RecyclerViewClickListener clickListener){
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
        clickListener.onClick(v, getAdapterPosition(), "character");
    }
}
