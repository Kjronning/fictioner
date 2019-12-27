package se.hkr.fictioner.data_fragments;

public class RepositoryListContract {
    public interface ContractView{
        void setTitle(String title);
        void setBody(String body);
    }
    public interface Presenter{
        void onBindRepositoryViewAtPosition(int position, ContractView holder);
    }
}
