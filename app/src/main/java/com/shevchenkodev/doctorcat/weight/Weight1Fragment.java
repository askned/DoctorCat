package com.shevchenkodev.doctorcat.weight;


import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.shevchenkodev.doctorcat.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Weight1Fragment extends Fragment {

    FragmentManager fragmentManager;

    public Weight1Fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_weight1, container, false);

        ImageView imageView4 = (ImageView) container.findViewById(R.id.imageView4);

//        imageView4.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                fragmentManager = getFragmentManager();
//                AddingWFragment addingWFragment = new AddingWFragment();
//                fragmentManager.beginTransaction()
//                        .replace(R.id.weightconteiner, addingWFragment)
//                        .addToBackStack(null)
//                        .commit();
//            }
//        });

        return rootView;

    }


}
