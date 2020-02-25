package com.example.sharedpreferenceex;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText edtUsername, edtPassword;
    private Button login;
    private static final String username = "android", password = "12345";
    private static final String SHARED_PRE = "login";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        login = findViewById(R.id.btnLogin);


        loadData();

        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = edtUsername.getText().toString();
                String pass = edtPassword.getText().toString();


                if(checkValidation(user, pass)==true){
                    saveData();
                    startActivity(new Intent(LoginActivity.this,MainActivity.class));
                    finish();
                }
                Toast.makeText(LoginActivity.this, "" + checkValidation(user, pass), Toast.LENGTH_SHORT).show();
            }
        });

    }

    private void loadData() {


        try {
            SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PRE,MODE_PRIVATE);
            String namee=sharedPreferences.getString("user_name",null).toString();
            Toast.makeText(LoginActivity.this, "" + namee, Toast.LENGTH_SHORT).show();
            if(!namee.equals(null)){
                Intent intent=new Intent(LoginActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }catch (Exception e){

        }




    }

    private void saveData() {
        SharedPreferences sharedPreferences=getSharedPreferences(SHARED_PRE,MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.putString("user_name",username);
        editor.putString("password",password);
        editor.commit();
        Toast.makeText(LoginActivity.this, "" + "Save Data", Toast.LENGTH_SHORT).show();

    }

    private boolean checkValidation(String user, String pass) {
        if(TextUtils.isEmpty(user)){
            edtUsername.setError("Enter username first");
        }
        if(TextUtils.isEmpty(pass)){
            edtPassword.setError("Enter password first");
        }
            return (user.equals(username) && pass.equals(password));

    }
}
