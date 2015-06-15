/******************************************************************
 * Name           : Palaniappan Ramiah, Sridhar Gerendla
 * ZID            : Z1726972, Z1728314
 * Class          : Android
 * Assignment No. : 2
 * Program Name   : HeartRate.java
 * Description    : Used to calculate the Heart Rate
 * Due Date       : 02/21/2015 11:59:59 pm
 *****************************************************************/

package edu.niu.cs.sridhar.assignment2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.text.DecimalFormat;


public class HeartRate extends ActionBarActivity implements View.OnClickListener {
    // Declaring the variables and components
    EditText EnterAge;
    Button Calculate,Clear,Back;
    TextView displayMaxHeartRate,displayTargetHeartRate,displayNote,Errors;
    double Age,MaxHrtRate,TargetHeartRate1,TargetHeartRate2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.heart_rate);

        // Assigning the variables to each components of the view
        EnterAge = (EditText) findViewById(R.id.enterAge);
        displayMaxHeartRate = (TextView) findViewById(R.id.outputMaxHeart);
        displayTargetHeartRate = (TextView) findViewById(R.id.outputTargetHeart);
        displayNote = (TextView) findViewById(R.id.outputNote);
        Calculate = (Button) findViewById(R.id.btnCalculate);
        Calculate.setOnClickListener(this);
        Clear = (Button) findViewById(R.id.btnClear);
        Clear.setOnClickListener(this);
        Back = (Button) findViewById(R.id.btnBack);
        Errors = (TextView) findViewById(R.id.textError);

        // Creating an Intent for main activity and starting it
        Back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), MainActivity.class);
                startActivity(i);
            }
        });
 }

    @Override
    public void onClick(View v) {
        try {
            // Calculating the Heart rate when calculate button is clicked
            if (v.getId() == R.id.btnCalculate) {
                Errors.setText(null);
                Age = Double.valueOf(EnterAge.getText().toString());
                DecimalFormat df = new DecimalFormat("#.0");

                MaxHrtRate = 220 - Age;
                TargetHeartRate1 = (MaxHrtRate / 2);
                TargetHeartRate2 = (MaxHrtRate * 85) / 100;
                displayMaxHeartRate.setText("Your Maximum Heart Rate is    :    " +MaxHrtRate);
                displayTargetHeartRate.setText("Your Target Heart Rate is    :    " + df.format(TargetHeartRate1)+" to "+df.format(TargetHeartRate2));
                displayNote.setText("Note: These numbers are just estimates and will vary depending upon the persons health, fitness and gender. Please consult your doctor before starting a new exercise plan.");
            }

        }
        catch (Exception e) {
            Errors.setText("Please enter your age!");
        }
        // When clear button is clicked to clear the logic
        if (v.getId() == R.id.btnClear) {
            Errors.setText(null);
            EnterAge.setText(null);
            displayMaxHeartRate.setText(null);
            displayTargetHeartRate.setText(null);
            displayNote.setText(null);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
