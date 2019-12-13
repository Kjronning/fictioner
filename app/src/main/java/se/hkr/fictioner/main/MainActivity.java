package se.hkr.fictioner.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import android.os.Bundle;
import se.hkr.fictioner.R;
import se.hkr.fictioner.databinding.MainActivityBinding;

public class MainActivity extends AppCompatActivity implements MainContract.ContractView {

    MainPresenter presenter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        presenter = new MainPresenter(this);
        MainActivityBinding binding = DataBindingUtil.setContentView(this,R.layout.main_activity);
        binding.setPresenter(presenter);
    }
}
