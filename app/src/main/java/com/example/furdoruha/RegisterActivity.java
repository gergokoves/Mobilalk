package com.example.furdoruha;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private static final String LOG_TAG = MainActivity.class.getName();
    private static final String PREF_KEY = MainActivity.class.getPackage().toString();
    private static final int SECRET_KEY = 99;


    EditText userNameEditText;
    EditText userEmailEditText;
    EditText passwordEditText;
    EditText passwordConfirmedEditText;
    EditText phoneEditText;
    EditText addressEditText;

    private SharedPreferences preferences;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        int secret_key = getIntent().getIntExtra("SECRET_KEY", 0);

        if(secret_key != 99){
            finish();
        }
        userNameEditText = findViewById(R.id.usernameEditText);
        userEmailEditText = findViewById(R.id.userEmailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);
        passwordConfirmedEditText = findViewById(R.id.passwordAgainEditText);
        phoneEditText = findViewById(R.id.phoneEditText);
        addressEditText = findViewById(R.id.addressEditText);

        preferences = getSharedPreferences(PREF_KEY, MODE_PRIVATE);
        String username = preferences.getString("username", "");
        String password = preferences.getString("password", "");

        userNameEditText.setText(username);
        passwordEditText.setText(password);
        passwordConfirmedEditText.setText(password);


        mAuth = FirebaseAuth.getInstance();

        Log.i(LOG_TAG, "onCreate");
    }

    public void register(View view) {
        String userName = userNameEditText.getText().toString();
        String password = passwordEditText.getText().toString();
        String email = userEmailEditText.getText().toString();
        String passwordConfirm = passwordConfirmedEditText.getText().toString();
        String phoneNumber = phoneEditText.getText().toString();
        String address = addressEditText.getText().toString();

        if(!password.equals(passwordConfirm)){
            Log.e(LOG_TAG,"Nem egyenlő a két jelszó!");
            return;
        }

        Log.i(LOG_TAG,"Regisztrált: " + userName + "Email: " + email);
        startKezdolap();



        mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    Log.d(LOG_TAG, "User created successfully");
                    startKezdolap();
                }
                else {
                    Log.d(LOG_TAG, "User was not created successfully");
                    Toast.makeText(RegisterActivity.this, "User was not created successfully: " + task.getException().getMessage(), Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public void cancel(View view) {
        finish();
    }

    private void startKezdolap(/*registered user data*/){
        Intent intent = new Intent(this, KezdolapActivity.class);
        intent.putExtra("SECRET_KEY",SECRET_KEY);
        startActivity(intent);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(LOG_TAG, "onStop");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(LOG_TAG, "onStop");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(LOG_TAG, "onDestroy");

    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(LOG_TAG, "onPause");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(LOG_TAG, "onResume");

    }
    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(LOG_TAG, "onRestart");

    }
}