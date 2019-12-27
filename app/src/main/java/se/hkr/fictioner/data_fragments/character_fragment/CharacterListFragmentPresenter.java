package se.hkr.fictioner.data_fragments.character_fragment;

import io.realm.RealmList;
import se.hkr.fictioner.data_fragments.ListFragmentContract;
import se.hkr.fictioner.model.data_management.DataRepository;

public class CharacterListFragmentPresenter implements ListFragmentContract.Presenter {

    private ListFragmentContract.ContractView contractView;
    private RealmList<Character> listData;

    public RealmList<Character> getListData() {
        return listData;
    }

    public void setListData(RealmList<Character> listData) {
        this.listData = listData;
    }

    public CharacterListFragmentPresenter(ListFragmentContract.ContractView contractView) {
        this.contractView = contractView;
        fetchObjectListFromCurrentBook();
    }

    @Override
    public void fetchObjectListFromCurrentBook() {
        listData = DataRepository.GetItemsFromCurrentBook("character");
    }

    @Override
    public void sendListDataToAdapter() {
        contractView.setListItems(listData);
    }

    @Override
    public void handleEditButtonPress() {

    }
}
