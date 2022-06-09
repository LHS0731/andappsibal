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
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //열리는동작 2초

        SetMotorState(0, 0,10);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //멈추는동작 3초

        SetMotorState(1, 1,10);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //닫히는동작 2초
        SetMotorState(0, 1,10);
        //멈춤
    }

    void elevator_move_up(int btnum){
        for(int k = btnum; num <= k; num++)
        {
//            ReceiveDotValue(num);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ReceiveDotValue(num);
                }
            }, 1000);
        }
        num = btnum;
    }

    void elevator_move_down(int btnum){
        for(int k = btnum; num >= k; num--)
        {
//            ReceiveDotValue(num);
//            try {
//                Thread.sleep(1000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    ReceiveDotValue(num);
                }
            }, 1000);
        }
        num = btnum;
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
                //ReceiveDotValue(1);
                if(num<1){
//                    elevator_move_up(1);
                    new Thread(){
                        public void run(){
                            for(int k = 1; num <= k; num++)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[0], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                if(num>1){
                    //elevator_move_down(1);
                    new Thread(){
                        public void run(){
                            for(int k = 1; num >= k; num--)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[0], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                num = 1;
                break;
            }
            case R.id.btn_2: {
                //ReceiveDotValue(2);
                if(num<2){
                    //elevator_move_up(2);
                    new Thread(){
                        public void run(){
                            for(int k = 2; num <= k; num++)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[1], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                if(num>2){
                    //elevator_move_down(2);
                    new Thread(){
                        public void run(){
                            for(int k = 1; num >= k; num--)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[1], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                num = 2;
                break;
            }
            case R.id.btn_3: {
                //ReceiveDotValue(3);
                if(num<3){
                    //elevator_move_up(3);
                    new Thread(){
                        public void run(){
                            for(int k = 3; num <= k; num++)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[2], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                if(num>3){
                    //elevator_move_down(3);
                    new Thread(){
                        public void run(){
                            for(int k = 3; num >= k; num--)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[2], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                num = 3;
                break;
            }
            case R.id.btn_4: {
                //ReceiveDotValue(4);
                if(num<4){
                    //elevator_move_up(4);
                    new Thread(){
                        public void run(){
                            for(int k = 4; num <= k; num++)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[3], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                if(num>4){
                    //elevator_move_down(4);
                    new Thread(){
                        public void run(){
                            for(int k = 4; num >= k; num--)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[3], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                num = 4;
                break;
            }
            case R.id.btn_5: {
                //ReceiveDotValue(5);
                if(num<5){
//                    elevator_move_up(5);
                    new Thread(){
                        public void run(){
                            for(int k = 5; num <= k; num++)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[4], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                if(num>5){
//                    elevator_move_down(5);
                    new Thread(){
                        public void run(){
                            for(int k = 5; num >= k; num--)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[4], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                num = 5;
                break;
            }
            case R.id.btn_6: {
                //ReceiveDotValue(6);
                if(num<6){
                    //elevator_move_up(6);
                    new Thread(){
                        public void run(){
                            for(int k = 6; num <= k; num++)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[5], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                if(num>6){
                    //elevator_move_down(6);
                    new Thread(){
                        public void run(){
                            for(int k = 6; num >= k; num--)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[5], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                num = 6;
                break;
            }
            case R.id.btn_7: {
                //ReceiveDotValue(7);
                if(num<7){
//                    elevator_move_up(7);
                    new Thread(){
                        public void run(){
                            for(int k = 7; num <= k; num++)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[6], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                if(num>7){
//                    elevator_move_down(7);
                    new Thread(){
                        public void run(){
                            for(int k = 7; num >= k; num--)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[6], " ");
                            elevator_open();
                        }
                    }.start();

                    break;
                }
                num = 7;
                break;
            }
            case R.id.btn_8: {
                if(num<8){
                    //elevator_move_up(8);
                    new Thread(){
                        public void run(){
                            for(int k = 8; num <= k; num++)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[7], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                if(num>8){
                    //elevator_move_down(8);
                    new Thread(){
                        public void run(){
                            for(int k = 8; num >= k; num--)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[7], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                num = 8;
                break;
            }
            case R.id.btn_9: {
                //ReceiveDotValue(9);
                if(num<9){
                    //elevator_move_up(9);
                    new Thread(){
                        public void run(){
                            for(int k = 9; num <= k; num++)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[8], " ");
                            elevator_open();
                        }
                    }.start();
                    break;
                }
                if(num>9){
                    //elevator_move_down(9);
                    new Thread(){
                        public void run(){
                            for(int k = 9; num >= k; num--)
                            {
                                ReceiveDotValue(num);
                                SystemClock.sleep(1000);
                            }
                            ReceiveTextLcdValue(lcd_str[8], " ");
                            elevator_open();
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
                    ReceiveTextLcdValue(str1, str2);
                    ReceiveBuzzerValue(1);
                    x = true;
                }
                else
                {
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