package io.github.duke605.bindingdemo;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;

import io.github.duke605.bindingdemo.databinding.ObservableBinding;
import io.github.duke605.bindingdemo.item.PersonObservable;

public class ObservableActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        final PersonObservable person = new PersonObservable("Cole", 0);
        super.onCreate(savedInstanceState);

        // Inflating the content view
        ObservableBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_observable);

        // Setting the person to bind the view to
        binding.setPerson(person);

        // Asynchronously incrementing the person age to show observable variables
        new Thread(new Runnable() {

            // Keeping track of the persons age without having to get it every loop
            private int age = person.getAge();

            public void run() {

                // Counting up to 22 or till the activity is finished
                while (age < 22 && !ObservableActivity.this.isDestroyed()) {
                    System.out.println(age);
                    person.setAge(++age);
                    try { Thread.sleep(1000); } catch (Exception e) {}
                }
            }

        }).start();
    }
}
