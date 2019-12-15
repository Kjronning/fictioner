package se.hkr.fictioner.list_fragment;

import io.realm.RealmObject;
import io.realm.RealmResults;

public interface ListFragmentContract {
    interface ContractView<T extends RealmObject>{
        void setListItems(RealmResults<T> items);
    }
    interface Presenter<T extends RealmObject> {
        void fetchRealmObjectList(Class<T> itemClass);
    }
}
