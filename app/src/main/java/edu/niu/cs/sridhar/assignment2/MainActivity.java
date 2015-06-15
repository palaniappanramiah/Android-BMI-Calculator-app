/******************************************************************
 * Name           : Palaniappan Ramiah, Sridhar Gerendla
 * ZID            : Z1726972, Z1728314
 * Class          : Android
 * Assignment No. : 2
 * Program Name   : MainActivity.java
 * Description    : Used to calculate the BMI
 * Due Date       : 02/21/2015 11:59:59 pm
 *****************************************************************/
package edu.niu.cs.sridhar.assignment2;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;


public class MainActivity extends ActionBarActivity implements View.OnClickListener {

    // Declaring the variables and components
    EditText Weight,Height;
    TextView displayBMI,Comments,Errors;
    Button Calculate, Clear,HeartRate;
    double Wt,Ht,Result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Assigning the variables to each components of the view
        Weight = (EditText) findViewById(R.id.enterAge);
        Height = (EditText) findViewById(R.id.enterHeight);
        displayBMI = (TextView) findViewById(R.id.outputMaxHeart);
        Comments = (TextView) findViewById(R.id.comments);
        Errors = (TextView) findViewById(R.id.textError);
        Calculate = (Button) findViewById(R.id.btnCalculate);
        Calculate.setOnClickListener(this);
        Clear = (Button) findViewById(R.id.btnClear);
        Clear.setOnClickListener(this);
        HeartRate = (Button) findViewById(R.id.btnHeartRate);

        // Creating a new Intent and starting the activity
        HeartRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(v.getContext(), HeartRate.class);
                startActivity(i);
            }
        });
    }
    @Override
    public void onClick(View v) {
        try {
            // Calculating the BMI when calculate button is clicked
            if (v.getId() == R.id.btnCalculate) {
                Errors.setText(null);
                Wt = Double.valueOf(Weight.getText().toString());
                Ht = Double.valueOf(Height.getText().toString());

                DecimalFormat df = new DecimalFormat("#.0");
                Result = ((Wt*703)/(Ht*Ht));
                displayBMI.setText("Your Body-Mass Index is    :    " + df.format(Result));
                if(Result < 18.5){
                    Comments.setText("According to your BMI, You are Underweight");
                }
                else if(18.5 < Result && Result < 24.9){
                    Comments.setText("According to your BMI, Your weight is Normal");
                }
                else if(25 < Result && Result < 29.9){
                    Comments.setText("According to your BMI, You are Overweight");
                }
                else {
                    Comments.setText("According to your BMI, You are Obese");
                }

            }
        } catch (Exception e) {
            Errors.setText("Please enter all the fields!");
        }
        // When clear button is clicked to clear the logic
        if (v.getId() == R.id.btnClear) {
            Weight.setText(null);
            Height.setText(null);
            displayBMI.setText(null);
            Comments.setText(null);
            Errors.setText(null);
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
