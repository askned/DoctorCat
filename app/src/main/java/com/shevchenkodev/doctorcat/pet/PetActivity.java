package com.shevchenkodev.doctorcat.pet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.FragmentManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import com.shevchenkodev.doctorcat.R;
import com.shevchenkodev.doctorcat.WaightActivity;
import com.shevchenkodev.doctorcat.activity.TestActivity;
import com.shevchenkodev.doctorcat.datebase.DBHelper;
import com.shevchenkodev.doctorcat.dialog.AddingPetDialog;
import com.shevchenkodev.doctorcat.model.ModelPet;

import java.util.ArrayList;
import java.util.List;

public class PetActivity extends AppCompatActivity implements AddingPetDialog.AddingPetListener {

    FragmentManager fragmentManager;

    public DBHelper dbHelper;
    String name;
    ArrayAdapter adapter;

    final ArrayList<String> names = new ArrayList<String>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_pet);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        dbHelper = new DBHelper(getApplicationContext());
        addPetFromDB();
        final ListView listView = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);


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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                name = listView.getItemAtPosition(position).toString();
                showDialog(position);
            }
        });
        if (adapter.isEmpty()) {
            DialogFragment addingPetDialog = new AddingPetDialog();
            addingPetDialog.show(fragmentManager, "AddingPetDialog");
            // Snackbar snackbar = Snackbar.make(findViewById(R.id.coordinator2), R.string.pressplus, Snackbar.LENGTH_LONG);
//snackbar.show();

        }

    }


    public void onPetAdded(ModelPet newPet, boolean saveToDB) {

        ListView listView = (ListView) findViewById(R.id.listView1);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        if (newPet != null) {
            adapter.add(newPet.getPetName());
        }
        listView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
        dbHelper = new DBHelper(getApplicationContext());

        if (saveToDB) {
            dbHelper.savePet(newPet);
        }

    }


    @Override
    public void onPetAddingCancel() {

    }


    public void addPetFromDB() {

        List<ModelPet> pets = new ArrayList<>();
        pets.addAll(dbHelper.query().getPets());

        for (int i = 0; i < pets.size(); i++) {
            onPetAdded(pets.get(i), false);
        }

    }

    @Override
    protected Dialog onCreateDialog(int id) {


        //  final String[] mCatsName = {"Edit", "Deleta", "Cancel"};
        final String[] mCatsName = {getString(R.string.showtask), getString(R.string.pet_weight), getString(R.string.pet_test), getString(R.string.del), getString(R.string.censel)};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.petlist); // заголовок для диалога

        builder.setItems(mCatsName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {

//                Toast.makeText(getApplicationContext(),
//                        "Pet " + mCatsName[item],
//                        Toast.LENGTH_SHORT).show();

                switch (item) {
                    case 0:
                        onBackPressed();
                        return;
                    case 1:

                        Intent intent = new Intent(PetActivity.this, WaightActivity.class);
                        startActivity(intent);
                        return;
                    case 2:

                        Intent intent2 = new Intent(PetActivity.this, TestActivity.class);
                        startActivity(intent2);
                        return;
                    case 3:
                        dbHelper.removePet(name);
                        if (names.size() == 1) {
                            onPetAdded(null, false);
                        }
                        names.clear();

                        Toast.makeText(getApplicationContext(),
                                R.string.delpet,
                                Toast.LENGTH_SHORT).show();
                        //   if (names.size() == 0) {
                        //       DialogFragment addingPetDialog = new AddingPetDialog();
                        //      addingPetDialog.show(fragmentManager, "AddingPetDialog");
                        //  }
                        addPetFromDB();
                        return;
                    case 4:
                        return;
                }


            }
        });
        builder.setCancelable(false);

        return builder.create();
    }


}




