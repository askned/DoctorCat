package com.shevchenkodev.doctorcat.dialog;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Switch;

import com.shevchenkodev.doctorcat.R;
import com.shevchenkodev.doctorcat.Utils;
import com.shevchenkodev.doctorcat.model.ModelPet;
import com.shevchenkodev.doctorcat.pet.PetActivity;

import java.util.Calendar;


public class AddingPetDialog extends DialogFragment {

    PetActivity activity;

    public interface AddingPetListener {
        public void onPetAdded(ModelPet newPet, boolean saveToDB);

        void onPetAddingCancel();
    }

    AddingPetListener addingPetListener;
    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            addingPetListener = (AddingPetListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString() + " must implement AddingPetListener");
        }
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(R.string.pet_dialogtit);

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View conteiner = inflater.inflate(R.layout.dialog_pet, null);
        final ModelPet pet = new ModelPet();

        final TextInputLayout tilTitle = (TextInputLayout) conteiner.findViewById(R.id.tilDialogTaskTitle1);
        final EditText etTitle = tilTitle.getEditText();

        TextInputLayout tilDate = (TextInputLayout) conteiner.findViewById(R.id.tilDialogTaskDate1);
        final EditText etDate = tilDate.getEditText();
        tilTitle.setHint(getResources().getString(R.string.pet_name));
        tilDate.setHint(getResources().getString(R.string.task_date));
        final Switch swPetType = (Switch) conteiner.findViewById(R.id.swPetType);

        final Calendar calendar = Calendar.getInstance();
        calendar.set(Calendar.HOUR_OF_DAY, calendar.get(Calendar.HOUR_OF_DAY) + 1);

        builder.setView(conteiner);


        builder.setPositiveButton(R.string.dialog_ok, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
//kot tyt
                pet.setPetName(etTitle.getText().toString());
                pet.setbDate(calendar.getTimeInMillis());
                if (swPetType.isChecked()) {
                    pet.setPetType(1);
                } else {
                    pet.setPetType(0);
                }


                dialog.dismiss();
                addingPetListener.onPetAdded(pet, true);
            }
        }).setNegativeButton(R.string.dialog_cancel, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

                dialog.cancel();
            }
        });


        AlertDialog alertDialog = builder.create();


        etDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (etDate.length() == 0) {
                    etDate.setText(" ");
                }

                DialogFragment datePickerFragment = new DatePickerFragment() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);
                        etDate.setText(Utils.getDate(calendar.getTimeInMillis()));
                    }

                    @Override
                    public void onCancel(DialogInterface dialog) {
                        etDate.setText(null);
                    }
                };
                datePickerFragment.show(getFragmentManager(), "DatePickerFragment");
            }
        });


        alertDialog.setOnShowListener(new DialogInterface.OnShowListener() {
            @Override
            public void onShow(DialogInterface dialog) {
                final Button positiveButton = ((AlertDialog) dialog).getButton(DialogInterface.BUTTON_POSITIVE);
                if (etTitle.length() == 0) {
                    positiveButton.setEnabled(false);
                    tilTitle.setError(getResources().getString(R.string.dialog_error_empty_title));
                }

                etTitle.addTextChangedListener(new TextWatcher() {
                    @Override
                    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

                    }

                    @Override
                    public void onTextChanged(CharSequence s, int start, int before, int count) {
                        if (s.length() == 0) {
                            positiveButton.setEnabled(false);
                            tilTitle.setError(getResources().getString(R.string.dialog_error_empty_title));
                        } else {
                            positiveButton.setEnabled(true);
                            tilTitle.setErrorEnabled(false);
                        }
                    }

                    @Override
                    public void afterTextChanged(Editable s) {

                    }
                });
            }
        });


        return alertDialog;
    }
}

