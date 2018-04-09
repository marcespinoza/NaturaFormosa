package com.natura.formosa.Presentador;

import com.google.firebase.auth.FirebaseUser;
import com.natura.formosa.Interface.Login;
import com.natura.formosa.Modelo.LoginModelo;

/**
 * Created by Marceloi7 on 05/04/2018.
 */

public class LoginPresentador implements Login.Presentador {

    private Login.Vista vLogin;
    private Login.Modelo mLogin;

    public LoginPresentador(Login.Vista vLogin) {
        this.vLogin=vLogin;
        mLogin = new LoginModelo(this);
    }

    @Override
    public void login(FirebaseUser user) {
        mLogin.login(user);
    }
}
