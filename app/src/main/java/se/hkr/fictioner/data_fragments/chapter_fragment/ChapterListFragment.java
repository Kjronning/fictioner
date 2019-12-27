package se.hkr.fictioner.data_fragments.chapter_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import io.realm.RealmList;
import se.hkr.fictioner.R;
import se.hkr.fictioner.data_fragments.ListFragmentContract;
import se.hkr.fictioner.data_fragments.RecyclerViewClickListener;
import se.hkr.fictioner.databinding.ChapterFragmentBinding;

public class ChapterListFragment extends Fragment implements ListFragmentContract.ContractView {
    private ChapterAdapter adapter;
    private ListFragmentContract.Presenter presenter;

    public ChapterListFragment(RecyclerViewClickListener clickListener){
        adapter = new ChapterAdapter(null, true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState){
        ChapterFragmentBinding binding = DataBindingUtil.inflate(inflater, R.layout.chapter_fragment,container,false);
        View view = binding.getRoot();
        binding.setPresenter(presenter);
        RecyclerView recyclerView = view.findViewById(R.id.chapter_recycler_view);
        recyclerView.setAdapter(adapter);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(linearLayoutManager);
        return view;
    }
    @Override
    public void setListItems(RealmList items) {
        adapter.updateData(items);
    }

    @Override
    public void openEditDialog() {

    }

    @Override
    public void setPresenter(ListFragmentContract.Presenter presenter) {
        this.presenter = presenter;
    }
}

