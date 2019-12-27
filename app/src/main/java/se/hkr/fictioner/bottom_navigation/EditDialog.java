package se.hkr.fictioner.bottom_navigation;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import androidx.fragment.app.DialogFragment;

import io.realm.RealmObject;
import se.hkr.fictioner.R;
import se.hkr.fictioner.model.data_classes.Chapter;
import se.hkr.fictioner.model.data_classes.Character;
import se.hkr.fictioner.model.data_classes.Event;
import se.hkr.fictioner.model.data_classes.Location;
import se.hkr.fictioner.model.data_classes.Note;

public class EditDialog extends DialogFragment {
    String type;
    RealmObject object;
    EditText nameText;
    EditText bodyText;

    public EditDialog(RealmObject object, String type){
        this.object = object;
        this.type = type;
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = requireActivity().getLayoutInflater();
        final EditDialogPresenter presenter = new EditDialogPresenter();
        View view = inflater.inflate(R.layout.edit_object_dialog, null);
        nameText = view.findViewById(R.id.edit_name);
        bodyText = view.findViewById(R.id.edit_body);

        switch (type){
            case "character":
                nameText.setText(((Character)object).getName());
                nameText.setText(((Character)object).getSummary());
                break;
            case "chapter":
                nameText.setText(((Chapter)object).getName());
                nameText.setText(((Chapter)object).getBody());
                break;
            case "location":
                nameText.setText(((Location)object).getName());
                nameText.setText(((Location)object).getSummary());
                break;
            case "event":
                nameText.setText(((Event)object).getName());
                nameText.setText(((Event)object).getSummary());
                break;
            case "note":
                nameText.setText(((Note)object).getName());
                nameText.setText(((Note)object).getBody());
                break;
        }

        builder.setView(view)

                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        presenter.createObject(object, type, nameText.getText().toString(),bodyText.getText().toString());
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        presenter.deleteObject(object);
                        EditDialog.this.getDialog().cancel();
                    }
                });

        return builder.create();
    }
}
