package com.natura.formosa.Modelo;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;

import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.natura.formosa.Interface.Login;
import com.natura.formosa.R;

import javax.inject.Inject;

/**
 * Created by Marceloi7 on 05/04/2018.
 */

public class LoginModelo implements Login.Modelo {

    @Inject
    Context context;
    private Login.Presentador pLogin;
    private GoogleApiClient mGoogleApiClient;
    public FirebaseAuth firebaseAuth;

    public LoginModelo(Login.Presentador pLogin) {
        this.pLogin=pLogin;
    }

    @Override
    public void login(FirebaseUser user) {
            addUserToDatabase(user);
    }

    public void addUserToDatabase(FirebaseUser firebaseUser) {
        DatabaseReference database = FirebaseDatabase.getInstance().getReference();
        Log.i("token","token"+FirebaseInstanceId.getInstance().getToken());
        Cliente cliente = new Cliente(firebaseUser.getDisplayName(), FirebaseInstanceId.getInstance().getToken());
        database.child("Clientes")
                .child(firebaseUser.getUid())
                .setValue(cliente)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {

                        } else {

                        }
                    }
                });
    }


}
