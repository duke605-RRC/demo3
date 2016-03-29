package io.github.duke605.bindingdemo.item;

import android.databinding.BaseObservable;
import android.databinding.Bindable;
import android.view.View;
import io.github.duke605.bindingdemo.BR;

public class PersonObservable extends BaseObservable {

    private String name;
    private int age;

    public PersonObservable(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Bindable generates the name variable in the BR class
     */
    @Bindable
    public String getName() {
        return this.name;
    }

    /**
     * Bindable generates the name variable in the BR class
     */
    @Bindable
    public int getAge() {
        return this.age;
    }

    public void setName(String name) {
        this.name = name;

        // This will notify any listeners that the name has been changed (Must be used with getters)
        notifyPropertyChanged(BR.name);
    }

    public void setAge(int age) {
        this.age = age;

        // This will notify any listeners that the name has been changed (Must be used with getters)
        notifyPropertyChanged(BR.age);
    }

    public void onClick(View view) {
        System.out.println("Deleting... (Not really)");
        System.out.println(this.toString());
    }

    public String toString() {
        return "Name: " + this.getName() + "\nAge: " + this.getAge();
    }
}
