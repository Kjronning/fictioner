package se.hkr.fictioner.bottom_navigation;

import android.graphics.Typeface;
import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import io.realm.RealmObject;
import se.hkr.fictioner.R;
import se.hkr.fictioner.data_fragments.RecyclerViewClickListener;
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
import se.hkr.fictioner.model.data_management.DataRepository;

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationContract.ContractView {


    FloatingActionButton fab;
    TextView bookTitleTextView;

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

    private void setFragments(RecyclerViewClickListener listener){
        homeFragment = new HomeFragment();
        chapterListFragment = new ChapterListFragment(listener);
        characterListFragment = new CharacterListFragment(listener);
        locationListFragment = new LocationListFragment(listener);
        eventListFragment = new EventListFragment(listener);
        currentFragment = homeFragment;
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, chapterListFragment, "chapter").hide(chapterListFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, characterListFragment, "character").hide(characterListFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, locationListFragment, "location").hide(locationListFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, eventListFragment, "event").hide(eventListFragment).commit();
        getSupportFragmentManager().beginTransaction().add(R.id.main_container, homeFragment, "note").commit();
    }

    @Override
    public void onBackPressed(){

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        RecyclerViewClickListener listener = new RecyclerViewClickListener() {
            @Override
            public void onClick(View view, int position, String type) {
                presenter.handleRecyclerViewClick(type, position);
            }
        };
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        fab = findViewById(R.id.add_button);
        setFragments(listener);
        setPresenters();
        attachPresentersToFragments();
        setDataToFragments();
        setupActionBar();
        presenter = new BottomNavigationPresenter(this);
        presenter.changeBookTitle();
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                presenter.handleAddButtonPress(v);
            }
        });
    }

    private void setupActionBar() {
        ActionBar actionBar = getSupportActionBar();
        if(actionBar != null){
            actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
            actionBar.setDisplayShowCustomEnabled(true);
            actionBar.setCustomView(R.layout.action_bar);
            bookTitleTextView =  actionBar.getCustomView().findViewById(R.id.book_title);
            bookTitleTextView.setText(DataRepository.getCurrentBookTitle());
            Typeface typeface = getResources().getFont(R.font.grand_hotel);
            ((TextView)actionBar.getCustomView().findViewById(R.id.actionbar_title)).setTypeface(typeface);
        }
    }

    private void setDataToFragments() {
        locationListFragmentPresenter.sendListDataToAdapter();
        eventListFragmentPresenter.sendListDataToAdapter();
        chapterListFragmentPresenter.sendListDataToAdapter();
        characterListFragmentPresenter.sendListDataToAdapter();
        homeFragmentPresenter.sendListDataToAdapter();
        homeFragmentPresenter.sendListDataToSpinnerAdapter();
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

    @Override
    public void changeBookTitleText(String currentBookTitle) {
        if(bookTitleTextView!=null)
        bookTitleTextView.setText(currentBookTitle);
    }

    @Override
    public void openEditDialogue(RealmObject object, String type) {
        new EditDialog(object,type).show(getSupportFragmentManager(),"dialog");
    }

    private void switchToFragment(Fragment fragment){
        getSupportFragmentManager().beginTransaction().hide(currentFragment).show(fragment).commit();
        currentFragment = fragment;
        presenter.setTag(fragment.getTag());
    }
}
