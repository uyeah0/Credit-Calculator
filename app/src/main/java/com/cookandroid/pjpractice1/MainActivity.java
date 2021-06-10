package com.cookandroid.pjpractice1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintSet;

import android.content.ClipData;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Switch swStart;
    EditText edName, edAttend,edMExam, edFExam, edHW;
    RadioGroup rdoGp;
    RadioButton rdoBtnF, rdoBtnS, rdoBtnT;
    Button btnScore, btnClear;
    LinearLayout layout1,layout2,layout4,layout5,layout6,layout7 ,layout8;
    TextView layout3;
    View dlg;
    ImageView dlgImgView;
    int grade;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("간단 학점계산기");


        layout1 = findViewById(R.id.layout1);
        layout2 = findViewById(R.id.layout2);
        layout3 = findViewById(R.id.layout3);
        layout4 = findViewById(R.id.layout4);
        layout5 = findViewById(R.id.layout5);
        layout6 = findViewById(R.id.layout6);
        layout7 = findViewById(R.id.layout7);
        layout8 = findViewById(R.id.layout8);
        swStart = findViewById(R.id.swStart);
        edName = findViewById(R.id.edName);
        edMExam = findViewById(R.id.edMExam);
        edFExam = findViewById(R.id.edFExam);
        edAttend = findViewById(R.id.edAttend);
        edHW = findViewById(R.id.edHW);
        rdoGp = findViewById(R.id.rdoGp);
        rdoBtnF = findViewById(R.id.rdoBtnF);
        rdoBtnS = findViewById(R.id.rdoBtnS);
        rdoBtnT = findViewById(R.id.rdoBtnT);
        btnScore = findViewById(R.id.btnScore);
        btnClear = findViewById(R.id.btnClear);


        layout1.setVisibility(View.INVISIBLE);
        layout2.setVisibility(View.INVISIBLE);
        layout3.setVisibility(View.INVISIBLE);
        layout4.setVisibility(View.INVISIBLE);
        layout5.setVisibility(View.INVISIBLE);
        layout6.setVisibility(View.INVISIBLE);
        layout7.setVisibility(View.INVISIBLE);
        layout8.setVisibility(View.INVISIBLE);


        swStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(swStart.isChecked()){
                    layout1.setVisibility(View.VISIBLE);
                    layout2.setVisibility(View.VISIBLE);
                    layout3.setVisibility(View.VISIBLE);
                    layout4.setVisibility(View.VISIBLE);
                    layout5.setVisibility(View.VISIBLE);
                    layout6.setVisibility(View.VISIBLE);
                    layout7.setVisibility(View.VISIBLE);
                    layout8.setVisibility(View.VISIBLE);

                }else{
                    layout1.setVisibility(View.INVISIBLE);
                    layout2.setVisibility(View.INVISIBLE);
                    layout3.setVisibility(View.INVISIBLE);
                    layout4.setVisibility(View.INVISIBLE);
                    layout5.setVisibility(View.INVISIBLE);
                    layout6.setVisibility(View.INVISIBLE);
                    layout7.setVisibility(View.INVISIBLE);
                    layout8.setVisibility(View.INVISIBLE);

                }
            }
        });

        btnScore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name = edName.getText().toString();

                double MExam = Double.parseDouble(edMExam.getText().toString());
                double FExam = Double.parseDouble(edFExam.getText().toString());
                double HW = Double.parseDouble(edHW.getText().toString());
                double attend = Double.parseDouble(edAttend.getText().toString());
                double total = (MExam*0.3) + (FExam*0.3) + (HW*0.2) + (attend*0.2);


                dlg = (View) View.inflate(MainActivity.this, R.layout.dlg, null);
                dlgImgView = dlg.findViewById(R.id.dlgImgView);
                AlertDialog.Builder dlgView = new AlertDialog.Builder(MainActivity.this);
                dlgView.setView(dlg);
                dlgView.setTitle("학점계산기");


                rdoGp.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                    @Override
                    public void onCheckedChanged(RadioGroup radioGroup, int i) {
                        switch (i){
                            case R.id.rdoBtnF: grade = 1;break;
                            case R.id.rdoBtnS: grade = 2;break;
                            case R.id.rdoBtnT: grade = 3;break;
                        }
                    }
                });

                dlgView.setMessage(grade + "학년 " + name + "학생의 총점 : " + total);
                if(total >= 90) dlgImgView.setImageResource(R.drawable.alphabet_a);
                else if( total>= 80) dlgImgView.setImageResource(R.drawable.alphabet_b);
                else if( total >= 70) dlgImgView.setImageResource(R.drawable.alphabet_c);
                else dlgImgView.setImageResource(R.drawable.alphabet_f);

                dlgView.setPositiveButton("확인", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Toast.makeText(getApplicationContext(),"확인",Toast.LENGTH_LONG).show();
                    }
                });
                dlgView.show();
            }
        });

        btnClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                swStart.setChecked(false);
                edName.setText(null);
                edMExam.setText(null);
                edFExam.setText(null);
                edHW.setText(null);
                edAttend.setText(null);
                rdoGp.clearCheck();
                layout1.setVisibility(View.INVISIBLE);
                layout2.setVisibility(View.INVISIBLE);
                layout3.setVisibility(View.INVISIBLE);
                layout4.setVisibility(View.INVISIBLE);
                layout5.setVisibility(View.INVISIBLE);
                layout6.setVisibility(View.INVISIBLE);
                layout7.setVisibility(View.INVISIBLE);
                layout8.setVisibility(View.INVISIBLE);

            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        MenuInflater menu1 = getMenuInflater();
        menu1.inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        super.onOptionsItemSelected(item);

        switch (item.getItemId()){
            case R.id.itemClear:{
                swStart.setChecked(false);
                edName.setText(null);
                edMExam.setText(null);
                edFExam.setText(null);
                edHW.setText(null);
                edAttend.setText(null);
                rdoGp.clearCheck();
                layout1.setVisibility(View.INVISIBLE);
                layout2.setVisibility(View.INVISIBLE);
                layout3.setVisibility(View.INVISIBLE);
                layout4.setVisibility(View.INVISIBLE);
                layout5.setVisibility(View.INVISIBLE);
                layout6.setVisibility(View.INVISIBLE);
                layout7.setVisibility(View.INVISIBLE);
                layout8.setVisibility(View.INVISIBLE);
                break;
            }
            case R.id.itemFinish: finish(); break;
        }

        return true;
    }
}