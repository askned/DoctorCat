package com.shevchenkodev.doctorcat.pet;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.shevchenkodev.doctorcat.R;
import com.shevchenkodev.doctorcat.dialog.AddingPetDialog;
import com.shevchenkodev.doctorcat.model.ModelPet;

import java.util.ArrayList;

public class PetActivity extends AppCompatActivity implements AddingPetDialog.AddingPetListener {

    FragmentManager fragmentManager;
    ListView listView;

    // public ArrayAdapter<String> adapter;
    final ArrayList<String> names = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        ListView listView = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        names.add("Red");

        // присваиваем адаптер списку
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();




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



    public void onPetAdded(ModelPet newPet) {

        ListView listView = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        adapter.add(newPet.getPetName());
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }


    @Override
    public void onPetAddingCancel() {

    }
}


