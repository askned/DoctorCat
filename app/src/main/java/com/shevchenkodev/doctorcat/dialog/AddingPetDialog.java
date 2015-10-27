package com.shevchenkodev.doctorcat.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.support.design.widget.TextInputLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

import com.shevchenkodev.doctorcat.R;


public class AddingPetDialog extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View conteiner = inflater.inflate(R.layout.dialog_pet, null);

        final TextInputLayout tilTitle = (TextInputLayout) conteiner.findViewById(R.id.tilDialogTaskTitle1);
        final EditText etTitle = tilTitle.getEditText();

        TextInputLayout tilDate = (TextInputLayout) conteiner.findViewById(R.id.tilDialogTaskDate1);
        final EditText etDate = tilDate.getEditText();


        builder.setTitle(R.string.dialog_title);
        builder.setView(conteiner);
        return super.onCreateDialog(savedInstanceState);
    }
}

