package com.myappcompany.voidsway.passwordusername;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity
{

    protected void ButtonClick(View view)
    {
        EditText usernameEditText = findViewById(R.id.editText);
        EditText passwordEditText3 = findViewById(R.id.editText3);

        Log.i("userNameValue", usernameEditText.getText().toString());
        Log.i("PasswordValue", passwordEditText3.getText().toString());
        Log.i("jfd", "string");
        Toast.makeText(this, "You've logged in.", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
