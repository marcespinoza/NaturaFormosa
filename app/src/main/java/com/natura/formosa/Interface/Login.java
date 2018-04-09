package com.natura.formosa.Interface;

import com.google.firebase.auth.FirebaseUser;

/**
 * Created by Marceloi7 on 05/04/2018.
 */

public interface Login {

    interface Modelo {
        void login(FirebaseUser user);
    }

    interface Vista {
        void login();
    }

    interface Presentador{
        void login(FirebaseUser user);
    }

}
