package com.rohasoft.www.gcash.Controler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import com.rohasoft.www.gcash.Modal.GetUserCallBack;
import com.rohasoft.www.gcash.Modal.ServerRequest;
import com.rohasoft.www.gcash.Modal.User;
import com.rohasoft.www.gcash.R;


public class LoginActivity extends AppCompatActivity {

    private EditText mEditTextEmail, mEditTextPassword;
    private Button mButtonLogin;



    String email, pass;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_login);

        mEditTextEmail = (EditText) findViewById(R.id.login_email_edit_text);
        mEditTextPassword = (EditText) findViewById(R.id.login_password_edit_text);
        mButtonLogin = (Button) findViewById(R.id.login_login_button);
        
        logIn();




    }

    private void logIn() {

        mButtonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username=mEditTextEmail.getText().toString().trim();
                String pass=mEditTextPassword.getText().toString();
                User user=new User(username,pass);
                authenticate(user);
            }
        });
    }

    private void authenticate(User user) {

        ServerRequest serverRequest=new ServerRequest(this);
        serverRequest.fetchUserDataInBackground(user, new GetUserCallBack() {
            @Override
            public void Done(User returedUser) {
                if (returedUser == null){
                    showErrorMessage();
                }else {
                    logUserIn(returedUser );
                }
            }
        });
    }

    private void logUserIn(User returedUser) {
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }


    private void showErrorMessage() {

        android.support.v7.app.AlertDialog.Builder builder = new android.support.v7.app.AlertDialog.Builder(LoginActivity.this);
        builder.setMessage("Incorrect user details :(");
        builder.setPositiveButton("ok", null);
        builder.show();

    }
}
