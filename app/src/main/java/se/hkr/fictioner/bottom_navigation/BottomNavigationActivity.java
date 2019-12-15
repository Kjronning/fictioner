package se.hkr.fictioner.bottom_navigation;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.annotation.NonNull;

import android.view.MenuItem;
import android.widget.TextView;

import se.hkr.fictioner.R;

public class BottomNavigationActivity extends AppCompatActivity implements BottomNavigationContract.ContractView {
    private TextView mTextMessage;
    private BottomNavigationContract.Presenter presenter;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                //Load fragment?
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_event:
                    mTextMessage.setText(R.string.title_event);
                    return true;
                case R.id.navigation_book:
                    mTextMessage.setText(R.string.title_book);
                    return true;
                case R.id.navigation_character:
                    mTextMessage.setText(R.string.title_character);
                case R.id.navigation_location:
                    mTextMessage.setText(R.string.title_location);
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bottom_navigation);
        BottomNavigationView navView = findViewById(R.id.nav_view);
        mTextMessage = findViewById(R.id.message);
        navView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        presenter = new BottomNavigationPresenter(this);
    }

}
