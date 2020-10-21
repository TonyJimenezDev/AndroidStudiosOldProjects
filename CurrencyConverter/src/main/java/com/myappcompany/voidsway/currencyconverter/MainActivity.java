package com.myappcompany.voidsway.currencyconverter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;
public class MainActivity extends AppCompatActivity
{

    protected void OnConvertButton(View view)
    {


        EditText dollarEnterAmount = findViewById(R.id.dollarEnterAmount);
        TextView textView2 = findViewById(R.id.textView2);
        String amountInDollars = dollarEnterAmount.getText().toString();

        Double dollarEnterAmountDouble = Double.parseDouble(amountInDollars);
        Double amountInPesos = dollarEnterAmountDouble * 20.2;

        String amountInPesosString = String.format(Locale.ENGLISH,"%.02f", amountInPesos);
        String dollarEnterAmountString = String.format(Locale.ENGLISH, "%.02f", dollarEnterAmountDouble);

        textView2.setText("$" + AddComma(dollarEnterAmountString) + " is $" +  AddComma(amountInPesosString) + " in pesos");


        Toast.makeText(this, amountInPesos.toString(), Toast.LENGTH_SHORT).show();

    }

    private String AddComma(String digits)
    {
        String result = digits;
        if(digits.length() <= 5) return digits;

        for(int i = 1; i < (digits.length() - 1) / 3; i++)
        {

            int commaPos = digits.length() - 3 - (3 * i);

            result = result.substring(0, commaPos) + "," + result.substring(commaPos);
        }
        return result;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
