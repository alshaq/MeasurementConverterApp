package com.example.shaqu.measurementconverterapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends Activity implements AdapterView.OnItemSelectedListener {

    String[] conversionType = {"Miles to Kilometers","Kilometers to Miles",
            "Inches to Centimeters", "Centimeters to Inches"};
    TextView unit1;
    TextView unit2;
    EditText num1;
    TextView num2;
    Button cal_button;

    double result = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cal_button =(Button)findViewById(R.id.btbCal);
        num1 = (EditText)findViewById(R.id.etNumber);
        num2=(TextView) findViewById(R.id.txtResult);
        unit1 = (TextView)findViewById(R.id.txtFirstUnit);
        unit2 = (TextView)findViewById(R.id.txtSecondUnit);
        Spinner units_Spin = (Spinner) findViewById(R.id.unitsSpin);
        units_Spin.setOnItemSelectedListener(this);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,conversionType);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        units_Spin.setAdapter(adapter);


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        displayResult(position);
        switch (position){
            case 0:
                unit1.setText("Miles");
                unit2.setText("Kilometers");
                break;
            case 1:
                unit2.setText("Miles");
                unit1.setText("Kilometers");
                break;
            case 2:
                unit1.setText("Inches");
                unit2.setText("Centimeters");
                break;
            case 3:
                unit1.setText("Centimeters");
                unit2.setText("Inches");

                break;
            default:
                unit1.setText("Miles");
                unit2.setText("Kilometers");
                break;
    }

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }


    public double convertMilestoKilo(double num){
        double result = num * 1.6093;
        return result;
    }

    public double convertKilotoMiles(double num){
        double result = num * 0.6214;
        return result;
    }
    public double convertInchtoCenti(double num){
        double result = num * 2.54;
        return result;
    }
    public double convertCentitoInch(double num){
        double result = num * 0.3937;
        return result;
    }
    public void displayResult(int choice) {
       final int option = choice;
        cal_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (option){
                    case 0:
                        result = convertMilestoKilo(Double.parseDouble(num1.getText().toString()));
                        break;
                    case 1:
                        result = convertKilotoMiles(Double.parseDouble(num1.getText().toString()));
                        break;
                    case 2:
                        result =convertInchtoCenti(Double.parseDouble(num1.getText().toString()));
                        break;
                    case 3:
                        result =convertCentitoInch(Double.parseDouble(num1.getText().toString()));
                        break;
                    default:
                        result = convertMilestoKilo(Double.parseDouble(num1.getText().toString()));
                        break;
                }
                num2.setText(Double.toString(result));
            }
        });


    }
}
