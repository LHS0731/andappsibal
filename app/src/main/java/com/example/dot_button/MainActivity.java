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

    private Handler handler = new Handler();

    void elevator_open(){

        SetMotorState(1, 0,10);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //열리는동작 1초

        SetMotorState(0, 0,10);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //멈추는동작 1초

        SetMotorState(1, 1,10);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //닫히는동작 1초
        SetMotorState(0, 1,10);
        //멈춤
    }

    void elevator_move_up(int btnum){
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
        SetMotorState(1, 0,3);
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SetMotorState(0, 1,10);
    }

    void elevator_running_down (int second){
        SetMotorState(1, 1,3);
        try {
            Thread.sleep(1000 * second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        SetMotorState(0, 1,10);
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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

        str1 = "warning";
        str2 = "system error";

        lcd_str[0] = "1st floor";
        lcd_str[1] = "2nd floor";
        lcd_str[2] = "3th floor";
        lcd_str[3] = "4th floor";
        lcd_str[4] = "5th floor";
        lcd_str[5] = "6th floor";
        lcd_str[6] = "7th floor";
        lcd_str[7] = "8th floor";
        lcd_str[8] = "9th floor";

        num = 1;
        x = false;
        ReceiveDotValue(1);

    }


    @Override
    public void onClick(View view) {
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
                if(num<3){
                    new Thread(){
                        public void run(){
                            elevator_move_up(3);
                            ReceiveTextLcdValue(lcd_str[2], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_up(3-num);
                        }
                    }.start();
                    break;
                }
                if(num>3){
                    new Thread(){
                        public void run(){
                            elevator_move_down(3);
                            ReceiveTextLcdValue(lcd_str[2], " ");
                            elevator_open();
                        }
                    }.start();
                    new Thread(){
                        public void run(){
                            elevator_running_down(num-3);
                        }
                    }.start();
                    break;
                }
                num = 3;
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
                    ReceiveDotValue(10);
                    SetMotorState(0,1,10);
                    ReceiveTextLcdValue(str1, str2);
                    ReceiveBuzzerValue(1);
                    x = true;
                }
                else
                {
                    num =1;
                    ReceiveDotValue(1);
                    ReceiveTextLcdValue(" ", " ");
                    ReceiveBuzzerValue(0);
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

    static {
        System.loadLibrary("native-lib");
    }
}