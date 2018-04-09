package com.natura.formosa.Dependencias;

import android.content.Context;

import com.natura.formosa.Modelo.LoginModelo;
import com.natura.formosa.Vista.ActividadPrincipal;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by Marceloi7 on 06/04/2018.
 */

@Component(modules={ContextModule.class})
@Singleton
public interface ContextComponent {

    void inject(LoginModelo loginModelo);
}