package se.hkr.fictioner.data_fragments.chapter_fragment;

import io.realm.RealmList;
import se.hkr.fictioner.data_fragments.ListFragmentContract;
import se.hkr.fictioner.model.data_classes.Chapter;
import se.hkr.fictioner.model.data_management.DataRepository;

public class ChapterListFragmentPresenter implements ListFragmentContract.Presenter{

    private ListFragmentContract.ContractView contractView;
    private RealmList<Chapter> listData;

    public ChapterListFragmentPresenter(ListFragmentContract.ContractView contractView) {
        this.contractView = contractView;
    }
    @Override
    public void fetchObjectListFromCurrentBook() {
        listData = DataRepository.GetItemsFromCurrentBook("chapter");
    }
}
