package io.github.duke605.bindingdemo;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import io.github.duke605.bindingdemo.databinding.POJOBinding;
import io.github.duke605.bindingdemo.item.Person;

public class POJOActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Inflating the layout
        POJOBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_pojo);

        // Setting the person variable
        binding.setPerson(new Person("Cole", 22));
    }

    public void nextActivity(View view) {
        Intent i = new Intent(this, ObservableActivity.class);
        startActivity(i);
    }
}
