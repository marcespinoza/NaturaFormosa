package com.natura.formosa.Fcm;

import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Marceloi7 on 07/04/2018.
 */

public class MyFirebaseInstanceIDService extends FirebaseInstanceIdService {

    @Override
    public void onTokenRefresh() {
        super.onTokenRefresh();
        String refreshedToken = FirebaseInstanceId.getInstance().getToken();
        sendRegistrationToServer(refreshedToken);
    }

    private void sendRegistrationToServer(final String token) {
        if (FirebaseAuth.getInstance().getCurrentUser() != null) {
            Log.i("token","toke");
            FirebaseDatabase.getInstance()
                    .getReference()
                    .child("Clientes")
                    .child(FirebaseAuth.getInstance().getCurrentUser().getUid())
                    .child("Token")
                    .setValue(token);
        }
    }

}
