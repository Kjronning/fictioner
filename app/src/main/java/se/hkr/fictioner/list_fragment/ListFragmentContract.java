package se.hkr.fictioner.list_fragment;

import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmObject;

public interface ListFragmentContract {
    interface ContractView<T extends RealmObject>{
        void setListItems(RealmList<T> items);
    }
    interface Presenter<T extends RealmObject> {
        void fetchRealmObjectList();
    }
}
