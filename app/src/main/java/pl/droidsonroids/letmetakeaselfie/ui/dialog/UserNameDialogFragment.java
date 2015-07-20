package pl.droidsonroids.letmetakeaselfie.ui.dialog;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.Bind;
import butterknife.ButterKnife;
import pl.droidsonroids.letmetakeaselfie.R;

public class UserNameDialogFragment extends DialogFragment {

    @Bind(R.id.edit_user_name) EditText userNameEdit;

    private OnUserNameTypedListener onUserNameTypedListener;

    @Override
    public void onAttach(final Activity activity) {
        super.onAttach(activity);
        try {
            onUserNameTypedListener = (OnUserNameTypedListener) activity;
        } catch (ClassCastException e) {
            String message = String.format("%s must implement OnUserNameTypedListener!", activity.getClass().getSimpleName());
            throw new IllegalStateException(message);
        }
    }

    @NonNull
    @Override
    @SuppressLint("InflateParams")
    public Dialog onCreateDialog(final Bundle savedInstanceState) {
        View view = LayoutInflater.from(getActivity()).inflate(R.layout.dialog_user_name, null);
        ButterKnife.bind(this, view);
        return new AlertDialog.Builder(getActivity())
                .setMessage(R.string.type_your_name)
                .setView(view)
                .setPositiveButton(R.string.send_selfie, null)
                .setNegativeButton(R.string.cancel_selfie, null)
                .create();
    }

    @Override
    public void onStart() {
        super.onStart();
        AlertDialog alertDialog = (AlertDialog) getDialog();
        alertDialog.getButton(AlertDialog.BUTTON_POSITIVE).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                String userName = userNameEdit.getText().toString().trim();

                if (!TextUtils.isEmpty(userName)) {
                    onUserNameTypedListener.onUserNameTyped(userName);
                    dismiss();
                } else {
                    Toast.makeText(getActivity(), R.string.invalid_username, Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    public void onDetach() {
        super.onDetach();
        onUserNameTypedListener = null;
    }

    public interface OnUserNameTypedListener {
        void onUserNameTyped(@NonNull final String userName);
    }
}
