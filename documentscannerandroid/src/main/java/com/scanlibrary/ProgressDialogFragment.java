package com.scanlibrary;

import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.KeyEvent;

import androidx.annotation.NonNull;
import androidx.fragment.app.DialogFragment;

public class ProgressDialogFragment extends DialogFragment {

    public String message;

    public ProgressDialogFragment(String message) {
        this.message = message;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        return new ProgressDialog.Builder(requireContext())
                .setMessage(message)
                .setOnKeyListener((dialog, keyCode, keyEvent) -> keyCode == KeyEvent.KEYCODE_BACK)
                .setCancelable(false)
                .create();
    }
}