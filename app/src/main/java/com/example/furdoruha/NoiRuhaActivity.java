package com.example.furdoruha;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class NoiRuhaActivity extends AppCompatActivity {
    private static final String LOG_TAG = NoiRuhaActivity.class.getName();
    private static final String PREF_KEY = MainActivity.class.getPackage().toString();
    private FirebaseUser user;

    private FirebaseFirestore mFirestore;
    private CollectionReference mFurdoruhak;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_noi_ruha);

        user = FirebaseAuth.getInstance().getCurrentUser();
        if(user != null) {
            Log.d(LOG_TAG, "Authenticated user!");
        } else {
            Log.d(LOG_TAG, "Unauthenticated user!");
            finish();
        }

        mFirestore = FirebaseFirestore.getInstance();
        mFurdoruhak= mFirestore.collection("furdoruhashop");
        initializeData();
    }


    private void initializeData(){


        String[] furdoruhaNevek = getResources().getStringArray(R.array.furdoruha_nevek);
        String[] furdoruhaLeiras = getResources().getStringArray(R.array.furdoruha_leiras);
        String[] furdoruhaArak = getResources().getStringArray(R.array.furdoruha_arak);

        for(int i = 0; i < furdoruhaNevek.length;i++){
            mFurdoruhak.add(new FurdoRuha(furdoruhaNevek[i], furdoruhaLeiras[i],furdoruhaArak[i]));
        }
    }

}