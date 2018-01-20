package kamilmilik.przewodnikpogaleriihandlowej.MainView.login;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import kamilmilik.przewodnikpogaleriihandlowej.MainView.parking.SharedPreferencesOperation;
import kamilmilik.przewodnikpogaleriihandlowej.MainView.shops.Identifiers;
import kamilmilik.przewodnikpogaleriihandlowej.R;

public class LoginActivity extends AppCompatActivity {
    private static final String TAG = "LoginActivity";
    private EditText emailEditText, passwordEditText;
    private SharedPreferencesOperation sharedPreferencesOperation;
    private Button loginButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        loginButton = findViewById(R.id.loginButton);
        emailEditText = findViewById(R.id.emailEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        sharedPreferencesOperation = new SharedPreferencesOperation(LoginActivity.this, Identifiers.SHARED_PREFERENCES_LOGIN_KEY);
        loginButtonAction();


        setUpToolbar();
    }
    public void setUpToolbar(){
        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
    }
    public void loginButtonAction(){
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = emailEditText.getText().toString();
                String password = passwordEditText.getText().toString();
                if(!email.equals("") || !password.equals("") || !email.equals("") && !password.equals("")) {
                    UserDataObject userDataObject = new UserDataObject(email, password);
                    sharedPreferencesOperation.saveToSharedPreferences(email, userDataObject);
                    if (!sharedPreferencesOperation.getAllItemsLogin().isEmpty()) {
                        ArrayList<UserDataObject> userDataObjectsList = sharedPreferencesOperation.getAllItemsLogin();
                        for (UserDataObject userDataObject1 : userDataObjectsList) {
                            Log.i(TAG, userDataObject1.getEmail() + " " + userDataObject1.getPassword());
                        }
                        if(userDataObject.getEmail().equals(email) && userDataObject.getPassword().equals(password)){
                            Intent intent = new Intent(getApplicationContext(),LoggedInUserActivity.class);
                            startActivity(intent);
                        }
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Prosze wpisac dane",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
