package com.example.mycalc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    private Button zero;
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button point;
    private Button add;
    private Button sub;
    private Button mul;
    private Button div;
    private Button percent;
    private Button pow;
    private Button root;
    private Button clear;
    private Button equal;
    private TextView data;
    private TextView result;
    private final char ADDITION='+';
    private final char SUBTRACTION='-';
    private final char MULTIPLICATION='*';
    private final char DIVISION='/';
    private final char PERCENT='%';
    private final char POW='^';
    private final char ROOT='√';
    private final char EQU=0;
    private double val1=Double.NaN;
    private double val2=Double.NaN;
    private char ACTION;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setupUIViews();

        zero.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText(data.getText().toString() +"0");
            }
        });
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText(data.getText().toString() +"1");
            }
        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText(data.getText().toString() +"2");
            }
        });
        three.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText(data.getText().toString() +"3");
            }
        });
        four.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText(data.getText().toString() +"4");
            }
        });
        five.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText(data.getText().toString() +"5");
            }
        });
        six.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText(data.getText().toString() +"6");
            }
        });
        seven.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText(data.getText().toString() +"7");
            }
        });
        eight.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText(data.getText().toString() +"8");
            }
        });
        nine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText(data.getText().toString() +"9");
            }
        });
        point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data.setText(data.getText().toString() +".");
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=ADDITION;
                result.setText(String.valueOf(val1)+"+");
                data.setText(null);
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=SUBTRACTION;
                result.setText(String.valueOf(val1)+"-");
                data.setText(null);
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=MULTIPLICATION;
                result.setText(String.valueOf(val1)+"*");
                data.setText(null);
            }
        });
        div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=DIVISION;
                result.setText(String.valueOf(val1)+"/");
                data.setText(null);
            }
        });
        percent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=PERCENT;
                val1/=100;
                //result.setText(String.valueOf(val1)+"%");
                result.setText(String.valueOf(val1));
                data.setText(null);
            }
        });
        pow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=POW;
                result.setText(String.valueOf(val1)+"^");
                data.setText(null);
            }
        });
        root.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=ROOT;
                result.setText(String.valueOf(val1)+"√");
                data.setText(null);
            }
        });
        equal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                compute();
                ACTION=EQU;
                if(Double.isNaN(val2))
                    result.setText(String.valueOf(val1));

                else
                    result.setText(result.getText().toString()+String.valueOf(val2)+"="+String.valueOf(val1));

                data.setText(null);
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(data.getText().length()>0){
                    CharSequence name = data.getText().toString();
                    data.setText(name.subSequence(0, name.length()-1));
                }
                else{
                    val1=Double.NaN;
                    val2=Double.NaN;
                    data.setText(null);
                    result.setText(null);
                }
            }
        });

    }
    private void setupUIViews(){
        zero = (Button)findViewById(R.id.btn0);
        one = (Button)findViewById(R.id.btn1);
        two = (Button)findViewById(R.id.btn2);
        three = (Button)findViewById(R.id.btn3);
        four = (Button)findViewById(R.id.btn4);
        five = (Button)findViewById(R.id.btn5);
        six = (Button)findViewById(R.id.btn6);
        seven = (Button)findViewById(R.id.btn7);
        eight = (Button)findViewById(R.id.btn8);
        nine = (Button)findViewById(R.id.btn9);
        point = (Button)findViewById(R.id.btnpoint);
        add = (Button)findViewById(R.id.btnadd);
        sub = (Button)findViewById(R.id.btnsub);
        mul = (Button)findViewById(R.id.btnmul);
        div = (Button)findViewById(R.id.btndiv);
        clear = (Button)findViewById(R.id.btnclr);
        equal = (Button)findViewById(R.id.btnequal);
        percent= (Button)findViewById(R.id.btnpercent);
        pow= (Button)findViewById(R.id.btnpow);
        root= (Button)findViewById(R.id.btnroot);
        data = (TextView)findViewById(R.id.data);
        result = (TextView)findViewById(R.id.result);
    }
    private void compute(){
        try {
            if (!Double.isNaN(val1)) {
                final DecimalFormat df = new DecimalFormat("0.00");
                val2 = Double.parseDouble(data.getText().toString());
                switch (ACTION) {
                    case ADDITION:
                        val1 = val1 + val2;
                        break;
                    case SUBTRACTION:
                        val1 = val1 - val2;
                        break;
                    case MULTIPLICATION:
                        val1 = val1 * val2;
                        break;
                    case DIVISION:
                        val1 = val1 / val2;
                        break;
                    case PERCENT:
                        val1 = val1 * val2 / 100;
                        break;
                    case POW:
                        val1 = Math.pow(val1, val2);
                        break;
                    case ROOT:
                        val1 = Math.pow(val2, (1 / val1));
                        break;
                    case EQU:
                        break;

                }
            } else {
                val1 = Double.parseDouble(data.getText().toString());

            }
        }
        catch (Exception e)
        {
            result.setText("Err ");
        }
    }

}
