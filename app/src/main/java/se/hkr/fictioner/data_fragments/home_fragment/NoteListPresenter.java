package se.hkr.fictioner.data_fragments.home_fragment;

import se.hkr.fictioner.data_fragments.RepositoryListContract;
import se.hkr.fictioner.model.data_classes.Note;
import se.hkr.fictioner.model.data_management.DataRepository;

public class NoteListPresenter implements RepositoryListContract.Presenter {
    @Override
    public void onBindRepositoryViewAtPosition(int position, RepositoryListContract.ContractView holder) {
        Note note = (Note)DataRepository.GetItemsFromCurrentBook("note").get(position);
        holder.setTitle(note.getName());
        holder.setBody(note.getBody());
    }
}
