package com.example.android.calculator;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.faendir.rhino_android.RhinoAndroidHelper;
import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;


public class MainActivity extends AppCompatActivity {

    Button btn0,btn1,btn2,btn3,btn4,btn5,btn6,btn7,btn8,btn9,btnClear,btnopenBracket,btnCloseBracket,btnPercent,btDivision, btnMultiblication,btnMinus,btnPlus,btnEqual,btnDot, btnNegative,btnDelete;
    TextView inputText,outputText;
    String mathExprssion,finalResult;
    boolean  isDotpressed, isSignPressed;



    private Context context;

    private Scriptable scope;

    private RhinoAndroidHelper rhinoAndroidHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        getSupportActionBar().hide();

        setContentView(R.layout.activity_main);

        intialize();

        btn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathExprssion += "0";
                inputText.setText(mathExprssion);
                isSignPressed = false;
            }
        });

        btn1.setOnClickListener(
                new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathExprssion += "1";
                inputText.setText(mathExprssion);
                isSignPressed = false;

            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathExprssion += "2";
                inputText.setText(mathExprssion);
                isSignPressed = false;
            }
        });
        btn3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathExprssion += "3";
                inputText.setText(mathExprssion);
                isSignPressed = false;
            }
        });
        btn4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathExprssion += "4";
                inputText.setText(mathExprssion);
                isSignPressed = false;
            }
        });
        btn5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathExprssion += "5";
                inputText.setText(mathExprssion);
                isSignPressed = false;
            }
        });
        btn6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathExprssion += "6";
                inputText.setText(mathExprssion);
                isSignPressed = false;
            }
        });
        btn7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathExprssion += "7";
                inputText.setText(mathExprssion);
                isSignPressed = false;
            }
        });
        btn8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathExprssion += "8";
                inputText.setText(mathExprssion);
            }
        });
        btn9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathExprssion += "9";
                inputText.setText(mathExprssion);
                isSignPressed = false;
            }
        });
        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathExprssion = "";
                finalResult = "";
                inputText.setText(mathExprssion);
                outputText.setText(finalResult);
                isSignPressed = false;
                isDotpressed = false;
            }
        });
        btnopenBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathExprssion += "(";
                inputText.setText(mathExprssion);
            }
        });

        btnCloseBracket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathExprssion += ")";
                inputText.setText(mathExprssion);
            }
        });

        btDivision.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isSignPressed){
                    mathExprssion += "÷";
                inputText.setText(mathExprssion);
                isSignPressed = true;
                isDotpressed = false;
                }
            }
        });
        btnMultiblication.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (!isSignPressed) {
                    mathExprssion += "×";
                    inputText.setText(mathExprssion);
                    isDotpressed = false;
                    isSignPressed = true;
                }
            }
        });
        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isSignPressed) {
                    mathExprssion += "-";
                    inputText.setText(mathExprssion);
                    isSignPressed = true;
                    isDotpressed = false;
                }
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isSignPressed) {
                    mathExprssion += "+";
                    inputText.setText(mathExprssion);
                    isSignPressed = true;
                    isDotpressed = false;
                }
            }
        });
        btnEqual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mathExprssion = mathExprssion.replaceAll("×","*");
                mathExprssion = mathExprssion.replaceAll("%","/100");
                mathExprssion = mathExprssion.replaceAll("÷","/");

                Context rhino = Context.enter();
                rhino.setOptimizationLevel(-1);

                try {
                    Scriptable scriptable = rhino.initStandardObjects();
                    finalResult = rhino.evaluateString(scriptable,mathExprssion,"javascript",1,null).toString();
                }catch (Exception e){
                    finalResult="error";
                }
                outputText.setText(finalResult);

                isSignPressed = false;
                isDotpressed = false;

            }
        });
        btnDot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!isDotpressed) {
                    mathExprssion += ".";
                    isDotpressed = true;
                }

                inputText.setText(mathExprssion);
            }
        });

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mathExprssion = mathExprssion.substring(0,mathExprssion.length()-1);
                inputText.setText(mathExprssion);
            }
        });

    }

    private void intialize() {
        mathExprssion = "";
        finalResult = "";
        isDotpressed = false;
        isSignPressed = false;
        btn0 = findViewById(R.id.button0);
        btn1= findViewById(R.id.button1);
        btn2= findViewById(R.id.button2);
        btn3= findViewById(R.id.button3);
        btn4= findViewById(R.id.button4);
        btn5= findViewById(R.id.button5);
        btn6= findViewById(R.id.button6);
        btn7= findViewById(R.id.button7);
        btn8= findViewById(R.id.button8);
        btn9= findViewById(R.id.button9);
        btnClear= findViewById(R.id.button_clear);
        btnDelete= findViewById(R.id.button_delete);
        btnopenBracket= findViewById(R.id.buttn_open_backets);
        btnCloseBracket= findViewById(R.id.button_close_bracked);
        btDivision= findViewById(R.id.button_divison);
        btnMultiblication= findViewById(R.id.btn_multi);
        btnMinus= findViewById(R.id.button_minus);
        btnPlus= findViewById(R.id.button_plus);
        btnEqual= findViewById(R.id.button_equla);
        btnDot= findViewById(R.id.button_dot);
        inputText= findViewById(R.id.intput_text);
        outputText= findViewById(R.id.output_text);

    }
}
