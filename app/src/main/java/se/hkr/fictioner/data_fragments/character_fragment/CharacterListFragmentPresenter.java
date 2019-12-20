package se.hkr.fictioner.data_fragments.character_fragment;


import android.provider.ContactsContract;

import io.realm.RealmList;
import se.hkr.fictioner.data_fragments.ListFragmentContract;
import se.hkr.fictioner.model.data_management.DataRepository;
import se.hkr.fictioner.model.user_credentials.UserData;

public class CharacterListFragmentPresenter implements ListFragmentContract.Presenter {

    private ListFragmentContract.ContractView contractView;
    private RealmList<Character> listData;

    public CharacterListFragmentPresenter(ListFragmentContract.ContractView contractView) {
        this.contractView = contractView;
    }

    @Override
    public void fetchObjectListFromCurrentBook() {
        listData = DataRepository.GetItemsFromCurrentBook("character");
    }
}
