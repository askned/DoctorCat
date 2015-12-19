package com.shevchenkodev.doctorcat;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shevchenkodev.doctorcat.weight.Weight1Fragment;


public class WaightActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_waight);
        Weight1Fragment weight1Fragment = new Weight1Fragment();
        fragmentManager = getFragmentManager();

        fragmentManager.beginTransaction()
                .replace(R.id.weightconteiner, weight1Fragment)
                .addToBackStack(null)
                .commit();

    }

    void onClickArrow() {
        //  switch (num) {
        //  case 0:
        AddingWFragment addingWFragment = new AddingWFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.weightconteiner, addingWFragment)
                .addToBackStack(null)
                .commit();


    }

    public void clickNext(View view) {
        AddingWFragment addingWFragment = new AddingWFragment();
        fragmentManager.beginTransaction()
                .replace(R.id.weightconteiner, addingWFragment)
                .addToBackStack(null)
                .commit();
    }
}
