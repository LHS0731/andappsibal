package com.example.dot_button;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.dot_button.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_1, btn_2, btn_3, btn_4, btn_5, btn_6, btn_7, btn_8, btn_9, btn_warning;
    private int num;
    private boolean x;
    private String str1;
    private String str2;

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
                    for(int k = 1; num <= k; num++)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 1;
                    break;
                }
                if(num>1){
                    for(int k = 1; num >= k; num--)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 1;
                    break;
                }
                num = 1;
                break;
            }
            case R.id.btn_2: {
                //ReceiveDotValue(2);
                if(num<2){
                    for(int k = 2; num <= k; num++)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 2;
                    break;
                }
                if(num>2){
                    for(int k = 2; num >= k; num--)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 2;
                    break;
                }
                num = 2;
                break;
            }
            case R.id.btn_3: {
                //ReceiveDotValue(3);
                if(num<3){
                    for(int k = 3; num <= k; num++)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 3;
                    break;
                }
                if(num>3){
                    for(int k = 3; num >= k; num--)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 3;
                    break;
                }
                num = 3;
                break;
            }
            case R.id.btn_4: {
                //ReceiveDotValue(4);
                if(num<4){
                    for(int k = 4; num <= k; num++)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 4;
                    break;
                }
                if(num>4){
                    for(int k = 4; num >= k; num--)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 4;
                    break;
                }
                num = 4;
                break;
            }
            case R.id.btn_5: {
                //ReceiveDotValue(5);
                if(num<5){
                    for(int k = 5; num <= k; num++)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 5;
                    break;
                }
                if(num>5){
                    for(int k = 5; num >= k; num--)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 5;
                    break;
                }
                num = 5;
                break;
            }
            case R.id.btn_6: {
                //ReceiveDotValue(6);
                if(num<6){
                    for(int k = 6; num <= k; num++)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 6;
                    break;
                }
                if(num>6){
                    for(int k = 6; num >= k; num--)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 6;
                    break;
                }
                num = 6;
                break;
            }
            case R.id.btn_7: {
                //ReceiveDotValue(7);
                if(num<7){
                    for(int k = 7; num <= k; num++)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 7;
                    break;
                }
                if(num>7){
                    for(int k = 7; num >= k; num--)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 7;
                    break;
                }
                num = 7;
                break;
            }
            case R.id.btn_8: {
                if(num<8){
                    for(int k = 8; num <= k; num++)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 8;
                    break;
                }
                if(num>8){
                    for(int k = 8; num >= k; num--)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 8;
                    break;
                }
                num = 8;
                break;
            }
            case R.id.btn_9: {
                //ReceiveDotValue(9);
                if(num<9){
                    for(int k = 9; num <= k; num++)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 9;
                    break;
                }
                if(num>9){
                    for(int k = 9; num >= k; num--)
                    {
                        ReceiveDotValue(num);
                        try {
                            Thread.sleep(1000);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    num = 9;
                    break;
                }
                num = 9;
                break;
            }
            case R.id.btn_warning: {
                if(x == false)
                {
                    ReceiveTextLcdValue(str1, str2);
                    x = true;
                }
                else
                {
                    ReceiveTextLcdValue(" ", " ");
                    x = false;
                }
                break;
            }
        }
    }

    public native String ReceiveDotValue(int i);
    public native int ReceiveTextLcdValue(String ptr1, String ptr2);

    static {
        System.loadLibrary("native-lib");
    }
}