package com.example.furdoruha;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class KezdolapActivity extends AppCompatActivity {


    private static final String LOG_TAG = MainActivity.class.getName();
    private static final String PREF_KEY = MainActivity.class.getPackage().toString();
    private static final int SECRET_KEY = 99;

    private FirebaseUser user;

    private NotificationAndAlarm notificationAndAlarm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kezdolap);

        notificationAndAlarm = new NotificationAndAlarm(this);
        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null){
            Log.d(LOG_TAG,  "Authenticated user!");
        }
        else {
            Log.d(LOG_TAG,  "Unauthenticated user!");
            finish();
        }
    }
    private void startNoiRuhak(){
        Intent intent = new Intent(this, NoiRuhaActivity.class);
        intent.putExtra("SECRET_KEY",SECRET_KEY);
        notificationAndAlarm.send("Karbantartás alatt,térjen vissza később!");
        startActivity(intent);
    }

    public void noiRuhak(View view){
        startNoiRuhak();
    }

    private void startFerfiRuhak(){
        Intent intent = new Intent(this, FerfiRuhaActivity.class);
        intent.putExtra("SECRET_KEY",SECRET_KEY);
        notificationAndAlarm.send("Karbantartás alatt,térjen vissza később!");
        startActivity(intent);
    }

    public void ferfiRuha(View view){
        startFerfiRuhak();
    }



}