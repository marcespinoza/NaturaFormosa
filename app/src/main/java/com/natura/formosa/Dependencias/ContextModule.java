package com.natura.formosa.Dependencias;

import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Marceloi7 on 05/04/2018.
 */

@Module
public class ContextModule {
    private final Context context;

    public ContextModule (Context context) {
        this.context = context;
    }

    @Provides
    @Singleton
    public Context context() {
        return context;
    }
}
