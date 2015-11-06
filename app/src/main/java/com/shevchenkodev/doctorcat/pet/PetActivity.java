package com.shevchenkodev.doctorcat.pet;

import android.app.DialogFragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.shevchenkodev.doctorcat.R;
import com.shevchenkodev.doctorcat.dialog.AddingPetDialog;
import com.shevchenkodev.doctorcat.fragment.PetFragment;
import com.shevchenkodev.doctorcat.model.ModelPet;

public class PetActivity extends AppCompatActivity implements AddingPetDialog.AddingPetListener {

    FragmentManager fragmentManager;
    PetFragment frag2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

//        frag2 = new PetFragment();
//        FragmentTransaction ft = getFragmentManager().beginTransaction();
//        ft.add(R.id.petfragm, frag2);
//        ft.commit();
        frag2 = new PetFragment();


        fragmentManager = getFragmentManager();
        getFragmentManager().beginTransaction().replace(R.id.petfragm, new PetFragment()).commit();

        FloatingActionButton fabpet = (FloatingActionButton) findViewById(R.id.fabpet);
        fabpet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment addingPetDialog = new AddingPetDialog();
                addingPetDialog.show(fragmentManager, "AddingPetDialog");
            }
        });
        //    petFragment = new PetFragment();
    }


    @Override
    public void onPetAdded(ModelPet newPet) {
        frag2.addPet(newPet);
    }

    @Override
    public void onPetAddingCancel() {

    }
}


