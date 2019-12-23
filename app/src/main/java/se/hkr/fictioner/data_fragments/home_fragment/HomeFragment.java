package se.hkr.fictioner.data_fragments.home_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmList;
import se.hkr.fictioner.R;
import se.hkr.fictioner.databinding.HomeFragmentBinding;
import se.hkr.fictioner.model.data_classes.Book;

public class HomeFragment extends Fragment implements HomeFragmentContract.ContractView {
    HomeAdapter adapter;
    SpinnerAdapter spinnerAdapter;
    HomeFragmentPresenter presenter;
    RecyclerView recyclerView;

    public HomeFragment(){
        adapter = new HomeAdapter(null, true);
        spinnerAdapter = new SpinnerAdapter(null);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        HomeFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.home_fragment, container, false);
        binding.setPresenter(presenter);
        View view = binding.getRoot();
        recyclerView = view.findViewById(R.id.note_recycler_view);
        recyclerView.setAdapter(adapter);
        Spinner spinner = view.findViewById(R.id.current_book_spinner);
        spinner.setAdapter(spinnerAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        return view;
    }

    @Override
    public void setListItems(RealmList items) {
        adapter.updateData(items);
    }

    @Override
    public void setPresenter(HomeFragmentPresenter presenter) {
        this.presenter = presenter;
    }

    @Override
    public void openChangeBookDialogue() {
        openDialogue(new ChangeBookDialogue());
    }



    @Override
    public void changeToLoginScreen() {

    }

    @Override
    public void openEditBookDialogue() {
        openDialogue(new EditBookDialogue());
    }

    @Override
    public void openDialogue(DialogFragment dialog){
        dialog.show(getFragmentManager(), "dialogue");
    }

    @Override
    public void setListItemsToSpinner(RealmList<Book> bookListData) {
        spinnerAdapter.updateData(bookListData);
    }
}
