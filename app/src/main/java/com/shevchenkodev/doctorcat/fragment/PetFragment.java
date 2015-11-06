package com.shevchenkodev.doctorcat.fragment;

import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.shevchenkodev.doctorcat.R;
import com.shevchenkodev.doctorcat.adapter.PetAdapter;
import com.shevchenkodev.doctorcat.model.ModelPet;

/**
 * Created by Администратор on 31.10.2015.
 */
public class PetFragment extends Fragment {
    RecyclerView recyclerView;
    RecyclerView.LayoutManager layoutManager;
    PetAdapter adapter;

    public PetFragment() {
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_pet_view, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.rvCurrentTasks1);

        layoutManager = new LinearLayoutManager(getActivity());

        recyclerView.setLayoutManager(layoutManager);

        adapter = new PetAdapter();
        recyclerView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return rootView;
    }

    public void addPet(ModelPet newPet) {
        adapter = new PetAdapter();
        adapter.addPet(newPet);


    }
}
