package se.hkr.fictioner.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import se.hkr.fictioner.R;
import se.hkr.fictioner.bottom_navigation.BottomNavigationActivity;
import se.hkr.fictioner.databinding.MainActivityBinding;
import se.hkr.fictioner.model.user_credentials.UserData;

public class MainActivity extends AppCompatActivity implements MainContract.ContractView {

    MainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        presenter = new MainPresenter(this);
        MainActivityBinding binding = DataBindingUtil.setContentView(this,R.layout.main_activity);
        binding.setPresenter(presenter);
        TextView textView = findViewById(R.id.login_title_textview);
        Typeface typeface = getResources().getFont(R.font.grand_hotel);
        textView.setTypeface(typeface);
        //TODO: make this method call a new method in presenter
        if (UserData.getInstance().getUser() != null) presenter.handleLoggedIn();
    }

    @Override
    public void makeToast(String message){
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void changeScreen() {
        makeToast("logged in!");
        Intent intent = new Intent(this, BottomNavigationActivity.class);
        startActivity(intent);
        //Change the screen to BottomNavigationActivity
    }
}
