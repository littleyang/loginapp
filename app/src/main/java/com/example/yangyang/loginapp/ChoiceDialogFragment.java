package com.example.yangyang.loginapp;

import android.app.AlertDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by yangyang on 14-9-23.
 */
public class ChoiceDialogFragment extends DialogFragment {

    private List mSelectedItems = new ArrayList();

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        builder.setTitle(R.string.multi_choice).setMultiChoiceItems(R.array.toppings,null,new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which, boolean checked) {

                if(checked){
                    mSelectedItems.add(which);
                }else if(mSelectedItems.contains(which)){
                    mSelectedItems.remove(Integer.valueOf(which));
                }
            }
        });

        // set ok and cancel button
        builder.setPositiveButton(R.string.ok_button,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setNegativeButton(R.string.cancle,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        });
        return builder.create();
    }
}
