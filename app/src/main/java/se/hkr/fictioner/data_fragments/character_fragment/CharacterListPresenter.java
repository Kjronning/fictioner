package se.hkr.fictioner.data_fragments.character_fragment;

import se.hkr.fictioner.data_fragments.RepositoryListContract;
import se.hkr.fictioner.model.data_classes.Character;
import se.hkr.fictioner.model.data_management.DataRepository;

public class CharacterListPresenter implements RepositoryListContract.Presenter {
    @Override
    public void onBindRepositoryViewAtPosition(int position, RepositoryListContract.ContractView holder) {
        Character character = (Character)DataRepository.GetItemsFromCurrentBook("character").get(position);
        String name = character != null ? character.getName() : "";
        String summary = character != null ? character.getSummary() : "";
        holder.setTitle(name);
        holder.setBody(summary);
    }
}
