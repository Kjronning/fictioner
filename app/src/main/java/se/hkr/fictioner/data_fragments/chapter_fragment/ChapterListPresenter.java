package se.hkr.fictioner.data_fragments.chapter_fragment;

import se.hkr.fictioner.data_fragments.RepositoryListContract;
import se.hkr.fictioner.model.data_classes.Chapter;
import se.hkr.fictioner.model.data_management.DataRepository;

public class ChapterListPresenter implements RepositoryListContract.Presenter {
    @Override
    public void onBindRepositoryViewAtPosition(int position, RepositoryListContract.ContractView holder) {
        Chapter chapter = (Chapter)DataRepository.GetItemsFromCurrentBook("chapter").get(position);
        holder.setBody(chapter.getBody());
        holder.setTitle(chapter.getName());
    }
}
