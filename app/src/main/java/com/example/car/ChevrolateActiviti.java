package com.example.car;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class ChevrolateActiviti extends AppCompatActivity
{

    private Button Meeting_Button;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chevrolate_activiti);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Meeting_Button = findViewById(R.id.M_B);
        Meeting_Button.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                Intent intent = new Intent(ChevrolateActiviti.this, MeetingActivity.class);
                startActivity(intent);
            }
        });
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem I)
    {
        if (I.getItemId() == android.R.id.home)
        {
            // Handle the back button press
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(I);
    }
}