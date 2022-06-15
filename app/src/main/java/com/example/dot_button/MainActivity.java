package com.example.dot_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;

import com.example.dot_button.databinding.ActivityMainBinding;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_warning;
    private int num;
    private boolean x;
    private String str1;
    private String str2;
    private String[] lcd_str = new String[9];

    void elevator_open(){
        //엘레베이터 문이 열리는 과정이다.
        SetMotorState(1, 0,10);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //열리는동작으로 왼쪽으로 스피드10으로 1초간 회전한다.

        SetMotorState(0, 0,10);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
        }
        //멈추는 동작으로 1초간 모터를 정지한다.

        SetMotorState(1, 1,10);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //닻히는동작으로 오른쪽으로 스피드10으로 1초간 회전한다.
        SetMotorState(0, 1,10);
        //모터를 멈춘다.
    }

    void elevator_move_up(int btnum){
        //엘레베이터가 올라갈때
        //올라가려는 층수(btnum)에 대한 정보에 따라 현재 층수(num)와 비교해
        //작으면 반복문을 통해 도트패널로 숫자를 띄우고 증가시켜 원하는 층수에 도착시킴
        //층을 올라가는 시간은 1초로 정함
        int j = num;
        for(int k = btnum; j <= k; j++)
        {
            ReceiveDotValue(j);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num=btnum;
    }

    void elevator_move_down(int btnum){
        //엘레베이터가 내려갈때
        //내려가려는 층수(btnum)에 대한 정보에 따라 현재 층수(num)와 비교해
        //크면 반복문을 통해 도트패널로 숫자를 띄우고 감소시켜 원하는 층수에 도착시킴
        //층을 내려려가는 간은 1초로 정함
        int j = num;
        for(int k = btnum; j >= k; j--)
        {
            ReceiveDotValue(j);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        num=btnum;
    }

    void elevator_running_up (int second){
        //엘레베이터가 올라갈때
        //왼쪽방향으로 스피드 3만큼 회전시킨다.
        SetMotorState(1, 0,5);
        try {
            Thread.sleep(1000 * second);
            //움직이는 층수에 따라서 모터동작시간이 달라진다.
            //second는 (갈려는 층수 - 현재 층수) * 1초(층수 올라가는 속도)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SetMotorState(0, 1,10);
    }

    void elevator_running_down (int second){
        //엘레베이터가 내려갈때
        //오른쪽방향으로 스피드 3만큼 회전시킨다.
        SetMotorState(1, 1,5);
        try {
            Thread.sleep(1000 * second);
            //움직이는 층수에 따라서 모터동작시간이 달라진다.
            //second는 (현재 층수 - 갈려는 층수) * 1초(층수 내려가는 속도)
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SetMotorState(0, 1,10);
    }

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 가려는 층수마다 버튼을 만들고 클릭리스너랑 연결함. waning버튼은 비상버튼
        btn_1 = (Button)findViewById(R.id.btn_1);
        btn_1.setOnClickListener(this);
        btn_2 = (Button)findViewById(R.id.btn_2);
        btn_2.setOnClickListener(this);
        btn_3 = (Button)findViewById(R.id.btn_3);
        btn_3.setOnClickListener(this);
        btn_4 = (Button)findViewById(R.id.btn_4);
        btn_4.setOnClickListener(this);
        btn_5 = (Button)findViewById(R.id.btn_5);
        btn_5.setOnClickListener(this);
        btn_6 = (Button)findViewById(R.id.btn_6);
        btn_6.setOnClickListener(this);
        btn_7 = (Button)findViewById(R.id.btn_7);
        btn_7.setOnClickListener(this);
        btn_8 = (Button)findViewById(R.id.btn_8);
        btn_8.setOnClickListener(this);
        btn_9 = (Button)findViewById(R.id.btn_9);
        btn_9.setOnClickListener(this);
        btn_8 = (Button)findViewById(R.id.btn_8);
        btn_8.setOnClickListener(this);
        btn_9 = (Button)findViewById(R.id.btn_9);
        btn_9.setOnClickListener(this);
        btn_warning = (Button)findViewById(R.id.btn_warning);
        btn_warning.setOnClickListener(this);

        // warning 버튼 클릭시 나타나는 lcd문구
        str1 = "warning";
        str2 = "system error";

        //원하는 층에 도착시 나타나는 lcd문구
        lcd_str[0] = "1st floor";
        lcd_str[1] = "2nd floor";
        lcd_str[2] = "3th floor";
        lcd_str[3] = "4th floor";
        lcd_str[4] = "5th floor";
        lcd_str[5] = "6th floor";
        lcd_str[6] = "7th floor";
        lcd_str[7] = "8th floor";
        lcd_str[8] = "9th floor";

        //층수를 제어하는 정수 초기는 1층에서 시작한다.
        num = 1;
        //warning 버튼을 눌러서 켜기/끄기를 제어하는 bool형 변수
        x = false;
        //초기는 1층에서 시작하므로 도트에 1을 띄운다.
        ReceiveDotValue(1);

    }

    @Override
    public void onClick(View view) {
        //어떠한 버튼이 눌렸냐에 따라 switch~case문으로 전달받음
        switch (view.getId()) {
            case R.id.btn_1: {
                if(num<1){
                    new Thread(){
                        public void run(){
                            elevator_move_up(1);
                            ReceiveTextLcdValue(lcd_str[0], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_up(1-num);
                        }
                    }.start();
                    break;
                }
                if(num>1){
                    new Thread(){
                        public void run(){
                            elevator_move_down(1);
                            ReceiveTextLcdValue(lcd_str[0], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_down(num-1);
                        }
                    }.start();
                    break;
                }
                num = 1;
                break;
            }
            case R.id.btn_2: {
                if(num<2){
                    new Thread(){
                        public void run(){
                            elevator_move_up(2);
                            ReceiveTextLcdValue(lcd_str[1], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_up(2-num);
                        }
                    }.start();
                    break;
                }
                if(num>2){
                    new Thread(){
                        public void run(){
                            elevator_move_down(2);
                            ReceiveTextLcdValue(lcd_str[1], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_down(num-2);
                        }
                    }.start();
                    break;
                }
                num = 2;
                break;
            }
            case R.id.btn_3: {
                //현재층수num이 3층보다 낮으면 올라가는 함수를 이용 높으면 내려가는 함수를 이용.
                if(num<3){
                    //쓰레드방식을 이용한다.
                    //도트패널을 변화시키는 과정과 상승,하강시 모터의 움직임을 쓰레드를 이용해 동시에 작동시킴
                    new Thread(){
                        public void run(){
                            elevator_move_up(3);
                            //층에 도착시 몇층에 도착한지 lcd에 띄운다.
                            ReceiveTextLcdValue(lcd_str[2], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_up(3-num);
                            //현재층수num이 가려는 층보다 낮으면 가려는층수-현재층수만큼의 시간(초)동안 모터동작
                        }
                    }.start();
                    break;
                }
                if(num>3){
                    new Thread(){
                        public void run(){
                            elevator_move_down(3);
                            //층에 도착시 몇층에 도착한지 lcd에 띄운다.
                            ReceiveTextLcdValue(lcd_str[2], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_down(num-3);
                            //현재층수num이 가려는 층보다 높으면 현재층수-가려는 층수만큼의 시간(초)동안 모터동작
                        }
                    }.start();
                    break;
                }
                num = 3;
                //최종동작후 현재층을 num값에 저장한다.
                break;
            }
            case R.id.btn_4: {
                if(num<4){
                    new Thread(){
                        public void run(){
                            elevator_move_up(4);
                            ReceiveTextLcdValue(lcd_str[3], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_up(4-num);
                        }
                    }.start();
                    break;
                }
                if(num>4){
                    new Thread(){
                        public void run(){
                            elevator_move_down(4);
                            ReceiveTextLcdValue(lcd_str[3], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_down(num-4);
                        }
                    }.start();
                    break;
                }
                num = 4;
                break;
            }
            case R.id.btn_5: {
                if(num<5){
                    new Thread(){
                        public void run(){
                            elevator_move_up(5);
                            ReceiveTextLcdValue(lcd_str[4], " ");
                            elevator_open();
                        }
                    }.start();

                    new Thread(){
                        public void run(){
                            elevator_running_up(5-num);
                        }
                    }.start();
                    break;
                }
                if(num>5){
                    new Thread(){
                        public void run(){
                            elevator_move_down(5);
                            ReceiveTextLcdValue(lcd_str[4], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_down(num-5);
                        }
                    }.start();
                    break;
                }
                num = 5;
                break;
            }
            case R.id.btn_6: {
                if(num<6){
                    new Thread(){
                        public void run(){
                            elevator_move_up(6);
                            ReceiveTextLcdValue(lcd_str[5], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_up(6-num);
                        }
                    }.start();
                    break;
                }
                if(num>6){
                    new Thread(){
                        public void run(){
                            elevator_move_down(6);
                            ReceiveTextLcdValue(lcd_str[5], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_down(num-6);
                        }
                    }.start();
                    break;
                }
                num = 6;
                break;
            }
            case R.id.btn_7: {
                if(num<7){
                    new Thread(){
                        public void run(){
                            elevator_move_up(7);
                            ReceiveTextLcdValue(lcd_str[6], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_up(7-num);
                        }
                    }.start();
                    break;
                }
                if(num>7){
                    new Thread(){
                        public void run(){
                            elevator_move_down(7);
                            ReceiveTextLcdValue(lcd_str[6], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_down(num-7);
                        }
                    }.start();

                    break;
                }
                num = 7;
                break;
            }
            case R.id.btn_8: {
                if(num<8){
                    new Thread(){
                        public void run(){
                            elevator_move_up(8);
                            ReceiveTextLcdValue(lcd_str[7], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_up(8-num);
                        }
                    }.start();
                    break;
                }
                if(num>8){
                    new Thread(){
                        public void run(){
                            elevator_move_down(8);
                            ReceiveTextLcdValue(lcd_str[7], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_down(num-8);
                        }
                    }.start();
                    break;
                }
                num = 8;
                break;
            }
            case R.id.btn_9: {
                if(num<9){
                    new Thread(){
                        public void run(){
                            elevator_move_up(9);
                            ReceiveTextLcdValue(lcd_str[8], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_up(9-num);
                        }
                    }.start();
                    break;
                }
                if(num>9){
                    new Thread(){
                        public void run(){
                            elevator_move_down(9);
                            ReceiveTextLcdValue(lcd_str[8], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_down(num-9);
                        }
                    }.start();
                    break;
                }
                num = 9;
                break;
            }
            case R.id.btn_warning: {
                if(x == false)
                {
                    //비상벨 알람이 눌리면 led를 점등하고 "warning sysrem eroor"문구를 띄운다.
                    //또한 부저도 울린다.
                    ReceiveLedValue(1);
                    ReceiveTextLcdValue(str1, str2);
                    ReceiveBuzzerValue(1);
                    x = true;
                }
                else
                {
                    //비상벨 알람이 다시 눌리면 led를 소등하고 문구를 지운다.
                    //또한 부저도 끈다.
                    ReceiveLedValue(0);
                    ReceiveTextLcdValue(" ", " ");
                    ReceiveBuzzerValue(0);
                    ReceiveDotValue(1);
                    x = false;
                }
                break;
            }
        }
    }

    public native String ReceiveDotValue(int i);
    public native int ReceiveTextLcdValue(String ptr1, String ptr2);
    public native int ReceiveBuzzerValue(int x);
    public native String SetMotorState(int x, int y, int z);
    public native String ReceiveLedValue(int x);

    static {
        System.loadLibrary("native-lib");
    }
}