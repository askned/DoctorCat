package com.shevchenkodev.doctorcat.dialog;

import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;

/**
 * Created by Администратор on 21.11.2015.
 */
public class PetMenuDialog extends DialogFragment {

    protected Dialog onCreateDialog() {


        final String[] mCatsName = {"Васька", "Рыжик", "Мурзик"};

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Выбираем кота"); // заголовок для диалога

        builder.setItems(mCatsName, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int item) {
                // TODO Auto-generated method stub
//                Toast.makeText(getActivity()),
//                        "Выбранный кот: " + mCatsName[item],
//                        Toast.LENGTH_SHORT).show();
            }
        });
        builder.setCancelable(false);
        return builder.create();

    }
}
