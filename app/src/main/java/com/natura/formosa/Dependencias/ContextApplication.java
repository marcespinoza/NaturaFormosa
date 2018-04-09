package com.natura.formosa.Dependencias;

import android.app.Application;

import dagger.Provides;

/**
 * Created by Marceloi7 on 06/04/2018.
 */

public class ContextApplication extends Application {

    protected static ContextComponent contextComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        contextComponent = DaggerContextComponent.builder().contextModule(new ContextModule(getApplicationContext())).build();
    }

    public ContextComponent getContextComponent(){
        return contextComponent;
    }

}
