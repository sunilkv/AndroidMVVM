// Generated by view binder compiler. Do not edit!
package com.gw.callingcard.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.viewbinding.ViewBinding;
import com.gw.callingcard.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class FragmentLoginBinding implements ViewBinding {
  @NonNull
  private final ConstraintLayout rootView;

  @NonNull
  public final Button buttonLogin;

  @NonNull
  public final EditText editTextTextEmailAddress;

  @NonNull
  public final EditText editTextTextPassword;

  @NonNull
  public final ImageView imageView2;

  @NonNull
  public final ProgressBar progressbar;

  @NonNull
  public final TextView textViewForgotPassword;

  @NonNull
  public final TextView textViewRegisterNow;

  private FragmentLoginBinding(@NonNull ConstraintLayout rootView, @NonNull Button buttonLogin,
      @NonNull EditText editTextTextEmailAddress, @NonNull EditText editTextTextPassword,
      @NonNull ImageView imageView2, @NonNull ProgressBar progressbar,
      @NonNull TextView textViewForgotPassword, @NonNull TextView textViewRegisterNow) {
    this.rootView = rootView;
    this.buttonLogin = buttonLogin;
    this.editTextTextEmailAddress = editTextTextEmailAddress;
    this.editTextTextPassword = editTextTextPassword;
    this.imageView2 = imageView2;
    this.progressbar = progressbar;
    this.textViewForgotPassword = textViewForgotPassword;
    this.textViewRegisterNow = textViewRegisterNow;
  }

  @Override
  @NonNull
  public ConstraintLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static FragmentLoginBinding inflate(@NonNull LayoutInflater inflater,
      @Nullable ViewGroup parent, boolean attachToParent) {
    View root = inflater.inflate(R.layout.fragment_login, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static FragmentLoginBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.buttonLogin;
      Button buttonLogin = rootView.findViewById(id);
      if (buttonLogin == null) {
        break missingId;
      }

      id = R.id.editTextTextEmailAddress;
      EditText editTextTextEmailAddress = rootView.findViewById(id);
      if (editTextTextEmailAddress == null) {
        break missingId;
      }

      id = R.id.editTextTextPassword;
      EditText editTextTextPassword = rootView.findViewById(id);
      if (editTextTextPassword == null) {
        break missingId;
      }

      id = R.id.imageView2;
      ImageView imageView2 = rootView.findViewById(id);
      if (imageView2 == null) {
        break missingId;
      }

      id = R.id.progressbar;
      ProgressBar progressbar = rootView.findViewById(id);
      if (progressbar == null) {
        break missingId;
      }

      id = R.id.textViewForgotPassword;
      TextView textViewForgotPassword = rootView.findViewById(id);
      if (textViewForgotPassword == null) {
        break missingId;
      }

      id = R.id.textViewRegisterNow;
      TextView textViewRegisterNow = rootView.findViewById(id);
      if (textViewRegisterNow == null) {
        break missingId;
      }

      return new FragmentLoginBinding((ConstraintLayout) rootView, buttonLogin,
          editTextTextEmailAddress, editTextTextPassword, imageView2, progressbar,
          textViewForgotPassword, textViewRegisterNow);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
