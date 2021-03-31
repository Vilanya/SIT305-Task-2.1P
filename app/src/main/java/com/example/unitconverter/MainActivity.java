package com.example.unitconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    EditText editText;
    //initialize the image buttons here
    ImageButton metreButton;
    ImageButton tempButton;
    ImageButton weightButton;

    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        editText = (EditText) findViewById(R.id.editTextNumberDecimal2);

        TextView textView1 = findViewById(R.id.textView1);
        TextView textView2 = findViewById(R.id.textView2);
        TextView textView3 = findViewById(R.id.textView3);
        TextView textView4 = findViewById(R.id.textView4);
        TextView textView5 = findViewById(R.id.textView5);
        TextView textView6 = findViewById(R.id.textView6);


        metreButton = (ImageButton) findViewById(R.id.metreButton);
        metreButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (parent.getItemAtPosition(pos).equals("Metres")){
                    //convert the value from edit text and display
                    float num = Integer.parseInt(editText.getText().toString());
                    textView1.setText(String.format("%.2f", num*100));
                    textView4.setText("Centimetres");
                    textView2.setText(String.format("%.2f", num*3.281));
                    textView5.setText("Foot");
                    textView3.setText(String.format("%.2f", num*39.37));
                    textView6.setText("Inches");
                }
                else{
                    Toast.makeText(getApplicationContext(),"Please select the correct conversion icon.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        tempButton = (ImageButton) findViewById(R.id.tempButton);
        tempButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (parent.getItemAtPosition(pos).equals("Celsius")){
                    //convert the value from edit text and display
                    float num = Integer.parseInt(editText.getText().toString());
                    textView1.setText(String.format("%.2f", (num*9/5)+32));
                    textView4.setText("Fahrenheit");
                    textView2.setText(String.format("%.2f", num+273.15));
                    textView5.setText("Kelvin");
                    textView3.setText("");
                    textView6.setText("");

                }
                else{
                    //display a warning
                    Toast.makeText(getApplicationContext(),"Please select the correct conversion icon.",Toast.LENGTH_SHORT).show();
                }
            }
        });

        weightButton = (ImageButton) findViewById(R.id.weightButton);
        weightButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (parent.getItemAtPosition(pos).equals("Kilograms")){
                    //convert the value from edit text and display
                    float num = Integer.parseInt(editText.getText().toString());
                    textView1.setText(String.format("%.2f", num*1000));
                    textView4.setText("Gram");
                    textView2.setText(String.format("%.2f", num*35.275));
                    textView5.setText("Ounce(Oz)");
                    textView3.setText(String.format("%.2f", num*2.205));
                    textView6.setText("Pound(lb)");
                }
                else{
                    //display a warning
                    Toast.makeText(getApplicationContext(),"Please select the correct conversion icon.",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.units_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

    }


}
