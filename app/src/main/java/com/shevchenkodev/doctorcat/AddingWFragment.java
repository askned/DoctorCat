package com.shevchenkodev.doctorcat;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


public class AddingWFragment extends Fragment {
    ArrayAdapter<String> petBreedAdapter;
    Integer petType;
    double breedConst = 0;
    EditText etTitle;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_adding_w, container, false);
        ImageView imageView4 = (ImageView) rootView.findViewById(R.id.imageView4);
        final TextInputLayout tilTitle = (TextInputLayout) rootView.findViewById(R.id.tilWeightEnter);
        final EditText etTitle = tilTitle.getEditText();
        tilTitle.setHint(getResources().getString(R.string.enterweight));
        Spinner spType = (Spinner) rootView.findViewById(R.id.spinnertype);
        final Spinner spBreed = (Spinner) rootView.findViewById(R.id.spinnerbreed);

        ArrayAdapter<String> petTypeAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.pet_type));
        spType.setAdapter(petTypeAdapter);
        spType.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    petBreedAdapter = new ArrayAdapter<String>(getActivity(),
                            android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.cat_breed));
                    petType = 100;
                    spBreed.setAdapter(petBreedAdapter);

                }
                if (position == 1) {
                    petType = 200;
                    petBreedAdapter = new ArrayAdapter<String>(getActivity(),
                            android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.dog_breed));
                    spBreed.setAdapter(petBreedAdapter);


                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                petBreedAdapter = new ArrayAdapter<String>(getActivity(),
                        android.R.layout.simple_spinner_dropdown_item, getResources().getStringArray(R.array.cat_breed));
                petType = 100;
                spBreed.setAdapter(petBreedAdapter);
            }
        });
        imageView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double trying = Double.valueOf(etTitle.getText().toString());
                Double norma = (((breedConst - trying) / breedConst)) * 100;
                if (breedConst != 0) {
                    if (norma > -10) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle(R.string.resulttit)
                                .setMessage(R.string.weightmess)


                                .setCancelable(false)
                                .setNegativeButton(R.string.returning,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {

                                                dialog.cancel();
                                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                                startActivity(intent);
                                            }
                                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    } else if (norma <= -10) {

                        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
                        builder.setTitle(R.string.resulttit)
                                .setMessage(getString(R.string.petweigres1) + Math.round(-norma) + getString(R.string.petweughtres2))

                                .setCancelable(false)
                                .setNegativeButton(R.string.returning,
                                        new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int id) {
                                                dialog.cancel();
                                                Intent intent = new Intent(getActivity(), MainActivity.class);
                                                startActivity(intent);
                                            }
                                        });
                        AlertDialog alert = builder.create();
                        alert.show();
                    }
                } else {
                    Toast.makeText(getActivity(), R.string.didnchois, Toast.LENGTH_LONG).show();
                }
            }
        });
        spBreed.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                                              @Override
                                              public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                                                  Integer petBreed = petType + position;
                                                  switch (petBreed) {


                                                      case 100:
                                                          breedConst = 4.3;
                                                          break;
                                                      case 101:
                                                          breedConst = 5;
                                                          break;
                                                      case 102:
                                                          breedConst = 3.9;
                                                          break;
                                                      case 103:
                                                          breedConst = 4.8;
                                                          break;
                                                      case 104:
                                                          breedConst = 4.5;
                                                          break;
                                                      case 105:
                                                          breedConst = 4;
                                                          break;
                                                      case 106:
                                                          breedConst = 3.9;
                                                          break;
                                                      case 107:
                                                          breedConst = 5;
                                                          break;
                                                      case 108:
                                                          breedConst = 4.5;
                                                          break;
                                                      case 109:
                                                          breedConst = 4.5;
                                                          break;
                                                      case 110:
                                                          breedConst = 4.8;
                                                          break;
                                                      case 111:
                                                          breedConst = 3.9;
                                                          break;
                                                      case 112:
                                                          breedConst = 4.3;
                                                          break;
                                                      case 113:
                                                          breedConst = 4;
                                                          break;
                                                      case 114:
                                                          breedConst = 4.8;
                                                          break;
                                                      case 115:
                                                          breedConst = 3.6;
                                                          break;
                                                      case 116:
                                                          breedConst = 3.8;
                                                          break;
                                                      case 117:
                                                          breedConst = 4.4;
                                                          break;
                                                      case 118:
                                                          breedConst = 3.4;
                                                          break;
                                                      case 119:
                                                          breedConst = 4;
                                                          break;
                                                      case 120:
                                                          breedConst = 4.4;
                                                          break;
                                                      case 121:
                                                          breedConst = 4.1;
                                                          break;
                                                      case 122:
                                                          breedConst = 7.3;
                                                          break;
                                                      case 123:
                                                          breedConst = 3.2;
                                                          break;
                                                      case 124:
                                                          breedConst = 4.1;
                                                          break;
                                                      case 125:
                                                          breedConst = 3.7;
                                                          break;
                                                      case 126:
                                                          breedConst = 5.5;
                                                          break;
                                                      case 127:
                                                          breedConst = 4.8;
                                                          break;
                                                      case 128:
                                                          breedConst = 3.2;
                                                          break;
                                                      case 129:
                                                          breedConst = 6.3;
                                                          break;
                                                      case 130:
                                                          breedConst = 4.6;
                                                          break;
                                                      case 131:
                                                          breedConst = 3.9;
                                                          break;
                                                      case 132:
                                                          breedConst = 5;
                                                          break;
                                                      case 133:
                                                          breedConst = 3.1;
                                                          break;
                                                      case 134:
                                                          breedConst = 4.3;
                                                          break;
                                                      case 135:
                                                          breedConst = 4.1;
                                                          break;
                                                      case 136:
                                                          breedConst = 4.3;
                                                          break;
                                                      case 137:
                                                          breedConst = 5;
                                                          break;
                                                      case 138:
                                                          breedConst = 4.4;
                                                          break;
                                                      case 139:
                                                          breedConst = 4.1;
                                                          break;
                                                      case 140:
                                                          breedConst = 5;
                                                          break;
                                                      case 141:
                                                          breedConst = 4.8;
                                                          break;
                                                      case 142:
                                                          breedConst = 5;
                                                          break;
                                                      case 143:
                                                          breedConst = 4.8;
                                                          break;
                                                      case 144:
                                                          breedConst = 3.6;
                                                          break;
                                                      case 145:
                                                          breedConst = 3.6;
                                                          break;
                                                      case 200:
                                                          breedConst = 28;
                                                          break;
                                                      case 201:
                                                          breedConst = 32;
                                                          break;
                                                      case 202:
                                                          breedConst = 2.7;
                                                          break;
                                                      case 203:
                                                          breedConst = 5.4;
                                                          break;
                                                      case 204:
                                                          breedConst = 27;
                                                          break;
                                                      case 205:
                                                          breedConst = 25;
                                                          break;
                                                      case 206:
                                                          breedConst = 55;
                                                          break;
                                                      case 207:
                                                          breedConst = 8.2;
                                                          break;
                                                      case 208:
                                                          breedConst = 5;
                                                          break;
                                                      case 209:
                                                          breedConst = 23;
                                                          break;
                                                      case 210:
                                                          breedConst = 3.6;
                                                          break;
                                                      case 211:
                                                          breedConst = 3.2;
                                                          break;

                                                  }

                                              }

                                              @Override
                                              public void onNothingSelected(AdapterView<?> parent) {
                                                  Toast.makeText(getActivity(), R.string.didnchois, Toast.LENGTH_LONG).show();
                                              }
                                          }
        );
        return rootView;
    }


    }
