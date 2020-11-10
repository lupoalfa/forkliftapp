package ca.frozen.rpicameraviewer.activities;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import ca.frozen.rpicameraviewer.R;

public class StartActivity extends AppCompatActivity {

    private Button btn_dialog;
    private Button btn_home;

    int[] checkedBoxes = new int[8];
    int checked_sum = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);



        for(int i=0; i<checkedBoxes.length;i++){
            checkedBoxes[i] = 0;
        }

        final CheckBox checkBox_1 = (CheckBox) findViewById(R.id.checkBox1_start);
        final CheckBox checkBox_2 = (CheckBox) findViewById(R.id.checkBox2_start);
        final CheckBox checkBox_3 = (CheckBox) findViewById(R.id.checkBox3_start);
        final CheckBox checkBox_4 = (CheckBox) findViewById(R.id.checkBox4_start);
        final CheckBox checkBox_5 = (CheckBox) findViewById(R.id.checkBox5_start);
        final CheckBox checkBox_6 = (CheckBox) findViewById(R.id.checkBox6_start);
        final CheckBox checkBox_7 = (CheckBox) findViewById(R.id.checkBox7_start);
        final CheckBox checkBox_8 = (CheckBox) findViewById(R.id.checkBox8_start);

        checkBox_1.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkBox_1.isChecked()){
                    checkedBoxes[0] = 1;
                }
                else{
                    checkedBoxes[0] = 0;
                }
            }
        });
        checkBox_2.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkBox_2.isChecked()){
                    checkedBoxes[1] = 1;
                }
                else{
                    checkedBoxes[1] = 0;
                }
            }
        });
        checkBox_3.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkBox_3.isChecked()){
                    checkedBoxes[2] = 1;
                }
                else{
                    checkedBoxes[2] = 0;
                }
            }
        });
        checkBox_4.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkBox_4.isChecked()){
                    checkedBoxes[3] = 1;
                }
                else{
                    checkedBoxes[3] = 0;
                }
            }
        });
        checkBox_5.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkBox_5.isChecked()){
                    checkedBoxes[4] = 1;
                }
                else{
                    checkedBoxes[4] = 0;
                }
            }
        });
        checkBox_6.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkBox_6.isChecked()){
                    checkedBoxes[5] = 1;
                }
                else{
                    checkedBoxes[5] = 0;
                }
            }
        });
        checkBox_7.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkBox_7.isChecked()){
                    checkedBoxes[6] = 1;
                }
                else{
                    checkedBoxes[6] = 0;
                }
            }
        });
        checkBox_8.setOnClickListener(new CheckBox.OnClickListener(){
            @Override
            public void onClick(View v) {
                if(checkBox_8.isChecked()){
                    checkedBoxes[7] = 1;
                }
                else{
                    checkedBoxes[7] = 0;
                }
            }
        });

        btn_dialog = (Button)findViewById(R.id.btn_dialog);
        btn_dialog.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            AlertDialog.Builder ad = new AlertDialog.Builder(StartActivity.this);
            ad.setIcon(R.mipmap.ic_launcher_forklift);
            ad.setTitle("< 공지사항 >");
            ad.setMessage("지게차 점검일자 : 11.06(금)\n\n지게차 점검 시간 : 19:00 ~ 21:00\n\n지게차 점검 대상 : 지게차 A, B, C, D 팀\n\n담당자 : 관리부 대리 김민수 TEL.053-420-0000\n");

            ad.setNegativeButton("확인", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.dismiss();

                }
            });
            ad.show();
        }
    });
        btn_home = findViewById(R.id.btn_home);
        btn_home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 오류시 우선 점검
                checked_sum = 0;

                for(int i = 0; i < checkedBoxes.length; i++){
                    checked_sum += checkedBoxes[i];
                }

                if(checked_sum == 8){
                    Intent intent = new Intent(StartActivity.this, MainActivity.class);
                    startActivity(intent);
                }
                else{
                    String msg = "체크리스트의 모든 항목을 체크해주세요!";
                    Toast.makeText(getApplicationContext(),msg,Toast.LENGTH_LONG).show();
                }

            }

        });
    }


}