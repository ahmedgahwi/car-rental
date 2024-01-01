package com.example.car;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity
{
    private EditText UN;
    private EditText PW;
    private Button LB;
    private DatabaseHelper databaseHelper;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        databaseHelper = new DatabaseHelper(this);

        UN = findViewById(R.id.user_name);
        PW = findViewById(R.id.password);
        LB = findViewById(R.id.login_Button);

        LB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                String user_name = UN.getText().toString().trim();
                String pass = PW.getText().toString().trim();

                if (user_name.equals("Suhaib") && pass.equals("Suhaib12345"))
                {
                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else
                {
                    Toast.makeText(LoginActivity.this, "user name OR password not correct", Toast.LENGTH_SHORT).show();
                }
            }
        });
        i_d("Suhaib", "Suhaib12345");
        u_D("admin", "new_Password");
        d_D("admin");
        Cursor dataCursor = v_D();

        c_D();
    }
    private void i_d(String user_name, String pass)
    {
        boolean isDataAdded = databaseHelper.ad(user_name, pass);
        if (isDataAdded) {
            Toast.makeText(this, "Data added successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to add data", Toast.LENGTH_SHORT).show();
        }
    }
    private void u_D(String user_name, String N_Password)
    {
        boolean isDataUpdated = databaseHelper.up(user_name, N_Password);
        if (isDataUpdated)
        {
            Toast.makeText(this, "successful updating", Toast.LENGTH_SHORT).show();
        } else
        {
            Toast.makeText(this, "The data don't updated", Toast.LENGTH_SHORT).show();
        }
    }

    private void d_D(String user_name)
    {
        boolean isDataDeleted = databaseHelper.dD(user_name);
        if (isDataDeleted)
        {
            Toast.makeText(this, "successful deleting", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "The data don't deleted", Toast.LENGTH_SHORT).show();
        }
    }

    private Cursor v_D()
    {
        Cursor dataCursor = databaseHelper.vd();
        return dataCursor;
    }
    private void c_D()
    {
        boolean isDataCleared = databaseHelper.cd();
        if (isDataCleared) {
            Toast.makeText(this, "Data cleared successfully", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Failed to clear data", Toast.LENGTH_SHORT).show();
        }
    }
}