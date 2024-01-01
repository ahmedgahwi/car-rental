package com.example.car;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

public class MeetingActivity extends AppCompatActivity
{

    private EditText N;
    private EditText C;
    private Button UB;
    private Button CB;
    private Button VB;
    private EditText D;

    private String SHI;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meeting);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        N = findViewById(R.id.Name);
        C = findViewById(R.id.company_name);
        UB = findViewById(R.id.update_Button);
        CB = findViewById(R.id.Clear_Button);
        VB = findViewById(R.id.view_Button);
        D = findViewById(R.id.day);
        UB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                ub();
            }
        });

        CB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                cd();
            }
        });

        VB.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {

                vh();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem I)
    {
        if (I.getItemId() == android.R.id.home)
        {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(I);
    }

    private void ub()
    {
        String myname = N.getText().toString();
        String cartype = C.getText().toString();

        Toast.makeText(MeetingActivity.this, "myname: " + myname + ", cartype: " + cartype, Toast.LENGTH_SHORT).show();
    }

    private void cd()
    {
        N.setText("");
        C.setText("");
        SHI = null;
        Toast.makeText(MeetingActivity.this, " the Data cleared succssefuly", Toast.LENGTH_SHORT).show();
    }

    private void vh()
    {
        String myname = N.getText().toString();
        String cartype = C.getText().toString();
        String wichDay = D.getText().toString();

        if (myname.isEmpty() || cartype.isEmpty() || wichDay.isEmpty())
        {
            Toast.makeText(MeetingActivity.this, "Please fill the fields", Toast.LENGTH_SHORT).show();
        } else {
            String message = "Name: " + myname + "\ncartype: " + cartype + "\nwich Day: " + wichDay;
            Toast.makeText(MeetingActivity.this, message, Toast.LENGTH_LONG).show();
        }
    }

    private void selectSchedule(String scheduleItem)
    {
        SHI = scheduleItem;
        Toast.makeText(MeetingActivity.this, "Selected Schedule: " + SHI, Toast.LENGTH_SHORT).show();
    }
}