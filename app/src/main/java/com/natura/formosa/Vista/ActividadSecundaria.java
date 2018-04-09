package com.natura.formosa.Vista;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import android.widget.TextView;

import com.github.clans.fab.FloatingActionButton;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;
import com.google.firebase.auth.FirebaseAuth;
import com.natura.formosa.R;
import com.richpath.RichPath;
import com.richpath.RichPathView;
import com.richpathanimator.RichPathAnimator;

/**
 * Created by Marceloi7 on 06/04/2018.
 */

public class ActividadSecundaria extends AppCompatActivity implements GoogleApiClient.OnConnectionFailedListener{

    private FirebaseAuth firebaseAuth;
    private GoogleApiClient mGoogleApiClient;
    TextView nombre, bienvenida;
    FloatingActionButton logout, share;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.actividad_secundaria);
        share = findViewById(R.id.compartir);
        share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
        logout = findViewById(R.id.logout);
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cerrarSesion();
            }
        });
        bienvenida = findViewById(R.id.bienvenida);
        Typeface chocolatines= Typeface.createFromAsset(getAssets(), "fonts/Chocolatines.ttf");
        Typeface roboto= Typeface.createFromAsset(getAssets(), "fonts/Roboto-Thin.ttf");
        bienvenida.setTypeface(chocolatines);
        nombre = findViewById(R.id.nombre);
        nombre.setTypeface(roboto);
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            nombre.setText(extras.getString("username"));
        }

        GoogleSignInOptions googleSignInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();
        mGoogleApiClient = new GoogleApiClient.Builder(this)
                .enableAutoManage(this, this)
                .addApi(Auth.GOOGLE_SIGN_IN_API,googleSignInOptions)
                .build();

    }



    @Override
    public void onBackPressed() {
        super.onBackPressed();
        return;
    }

    private void cerrarSesion(){
        firebaseAuth = FirebaseAuth.getInstance();
        firebaseAuth.signOut();

        Auth.GoogleSignInApi.signOut(mGoogleApiClient).setResultCallback(new ResultCallback<Status>() {
            @Override
            public void onResult(@NonNull Status status) {
                iniciarActividad();
            }
        });
    }

    public void iniciarActividad(){
        Intent intent = new Intent(this, ActividadPrincipal.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onConnectionFailed(@NonNull ConnectionResult connectionResult) {

    }
}
