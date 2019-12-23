package se.hkr.fictioner.data_fragments.home_fragment;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.Objects;

import io.realm.OrderedRealmCollection;
import io.realm.RealmBaseAdapter;
import se.hkr.fictioner.model.data_classes.Book;

public class SpinnerAdapter extends RealmBaseAdapter {

    public SpinnerAdapter(@Nullable OrderedRealmCollection data) {
        super(data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Book book = (Book) getItem(position);
        TextView textView = new TextView(parent.getContext());
        textView.setText(Objects.requireNonNull(book).getName());
        return textView;
}
    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent){
        return getView(position, convertView, parent);
    }
}
