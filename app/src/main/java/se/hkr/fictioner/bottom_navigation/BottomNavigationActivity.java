package se.hkr.fictioner.bottom_navigation;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.view.View;

import se.hkr.fictioner.R;
import se.hkr.fictioner.data_fragments.chapter_fragment.ChapterListFragment;
import se.hkr.fictioner.data_fragments.chapter_fragment.ChapterListFragmentPresenter;
import se.hkr.fictioner.data_fragments.character_fragment.CharacterListFragment;
import se.hkr.fictioner.data_fragments.character_fragment.CharacterListFragmentPresenter;
import se.hkr.fictioner.data_fragments.event_fragment.EventListFragment;
import se.hkr.fictioner.data_fragments.event_fragment.EventListFragmentPresenter;
import se.hkr.fictioner.data_fragments.location_fragment.LocationListFragment;
import se.hkr.fictioner.data_fragments.location_fragment.LocationListFragmentPresenter;
import se.hkr.fictioner.data_fragments.home_fragment.HomeFragment;
import se.hkr.fictioner.data_fragments.home_fragment.HomeFragmentPresenter;

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationContract.ContractView {


    FloatingActionButton fab;

    private BottomNavigationContract.Presenter presenter;
    private LocationListFragmentPresenter locationListFragmentPresenter;
    private CharacterListFragmentPresenter characterListFragmentPresenter;
    private ChapterListFragmentPresenter chapterListFragmentPresenter;
    private EventListFragmentPresenter eventListFragmentPresenter;
    private HomeFragmentPresenter homeFragmentPresenter;

    private LocationListFragment locationListFragment;
    private CharacterListFragment characterListFragment;
    private ChapterListFragment chapterListFragment;
    private EventListFragment eventListFragment;
    private HomeFragment homeFragment;
    private Fragment currentFragment;


    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    presenter.handleHomeButtonPress();
                    presenter.setButtonIconResource(R.drawable.ic_home_black_24dp);
                    return true;
                case R.id.navigation_event:
                    presenter.handleEventButtonPress();
                    presenter.setButtonIconResource(R.drawable.ic_event_black_24dp);
                    return true;
                case R.id.navigation_book:
                    presenter.handleChapterButtonPress();
                    presenter.setButtonIconResource(R.drawable.ic_book_black_24dp);
                    return true;
                case R.id.navigation_character:
                    presenter.handleCharacterButtonPress();
                    presenter.setButtonIconResource(R.drawable.ic_character_black_24dp);
                    return true;
                case R.id.navigation_location:
                    presenter.handleLocationButtonPress();
                    presenter.setButtonIconResource(R.drawable.ic_location_on_black_24dp);
                    return true;
            }
            return false;
        }
    };

    private void setPresenters(){
        characterListFragmentPresenter = new CharacterListFragmentPresenter(characterListFragment);
        chapterListFragmentPresenter = new ChapterListFragmentPresenter(chapterListFragment);
        eventListFragmentPresenter = new EventListFragmentPresenter(eventListFragment);
        locationListFragmentPresenter = new LocationListFragmentPresenter(locationListFragment);
        homeFragmentPresenter = new HomeFragmentPresenter(homeFragment);

    }

    private void attachPresentersToFragments(){
        chapterListFragment.setPresenter(chapterListFragmentPresenter);
        characterListFragment.setPresenter(characterListFragmentPresenter);
        locationListFragment.setPresenter(locationListFragmentPresenter);
        eventListFragment.setPresenter(eventListFragmentPresenter);
        homeFragment.setPresenter(homeFragmentPresenter);
    }

    private void setFragments(){
        homeFragment = new HomeFragment();
        chapterListFragment = new ChapterListFragment();
        characterListFragment = new CharacterListFragment();
        locationListFragment = new LocationListFragment();
        eventListFragment = new EventListFragment();
        currentFragment = homeFragment;
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, chapterListFragment, "chapters").hide(chapterListFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, characterListFragment, "characters").hide(characterListFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, locationListFragment, "locations").hide(locationListFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, eventListFragment, "events").hide(eventListFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, homeFragment, "home").commit();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fab = findViewById(R.id.add_button);
        setFragments();
        setPresenters();
        attachPresentersToFragments();
        setDataToFragments();
        presenter = new BottomNavigationPresenter(this);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.handleAddButtonPress(v);
            }
        });
    }

    private void setDataToFragments() {
        locationListFragmentPresenter.sendListDataToAdapter();
        eventListFragmentPresenter.sendListDataToAdapter();
        chapterListFragmentPresenter.sendListDataToAdapter();
        characterListFragmentPresenter.sendListDataToAdapter();
    }

    @Override
    public void switchToCharacterFragment() {
        switchToFragment(characterListFragment);
    }

    @Override
    public void switchToChapterFragment() {
        switchToFragment(chapterListFragment);
    }

    @Override
    public void switchToEventFragment() {
        switchToFragment(eventListFragment);
    }

    @Override
    public void switchToLocationFragment() {
        switchToFragment(locationListFragment);

    }

    @Override
    public void switchToHomeFragment() {
        switchToFragment(homeFragment);

    }

    @Override
    public void setFabIcon(int resource){
        fab.setImageResource(resource);
    }

    private void switchToFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().hide(currentFragment).show(fragment).commit();
        currentFragment = fragment;
        presenter.setTag(fragment.getTag());
    }
}
