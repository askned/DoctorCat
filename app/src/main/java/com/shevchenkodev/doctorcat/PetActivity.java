package com.shevchenkodev.doctorcat;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.shevchenkodev.doctorcat.dialog.AddingPetDialog;

public class PetActivity extends AppCompatActivity {

    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        fragmentManager = getFragmentManager();


        FloatingActionButton fabpet = (FloatingActionButton) findViewById(R.id.fabpet);
        fabpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment addingPetDialog = new AddingPetDialog();
                addingPetDialog.show(fragmentManager, "AddingPetDialog");
            }
        });
    }
}


