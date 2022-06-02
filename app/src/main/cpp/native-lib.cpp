#include <jni.h>
#include <string>
#include <Cstring>
#include <android/log.h>
#include <fcntl.h>
#include <unistd.h>

#include "fpga-dot-font.h"
#define DOT_DEVICE "/dev/fpga_dot"


#define LINE_BUFF 16
#define MAX_BUFF 32
#define FPGA_TEXT_LCD_DEVICE "/dev/fpga_text_lcd"

int fpga_dot(int x)
{
    int i;
    int dev;
    size_t str_size;
    str_size=sizeof(fpga_number[x]);
    dev=open(DOT_DEVICE, O_RDWR);
    if(dev<0){
        __android_log_print(ANDROID_LOG_INFO, "Device Open Error", "Driver = %d", x);
    }
    else{
        __android_log_print(ANDROID_LOG_INFO, "Device Open Success", "Driver = %d", x);
        switch (x) {
            case 1:
                write(dev,fpga_number[1], str_size);
                break;
            case 2:
                write(dev,fpga_number[2], str_size);
                break;
            case 3:
                write(dev,fpga_number[3], str_size);
                break;
            case 4:
                write(dev,fpga_number[4], str_size);
                break;
            case 5:
                write(dev,fpga_number[5], str_size);
                break;
            case 6:
                write(dev,fpga_number[6], str_size);
                break;
            case 7:
                write(dev,fpga_number[7], str_size);
                break;
            case 8:
                write(dev,fpga_number[8], str_size);
                break;
            case 9:
                write(dev,fpga_number[9], str_size);
                break;
        }
        close(dev);
    }
    return 0;
}

extern "C"
JNIEXPORT jstring JNICALL
Java_com_example_dot_1button_MainActivity_ReceiveDotValue(JNIEnv *env, jobject thiz, jint i) {
    // TODO: implement ReceiveDotValue()
    __android_log_print(ANDROID_LOG_INFO, "FpgaDotExample", "dot value = %d", i);
    fpga_dot(i);
    return 0;
}

int fpga_text_lcd(const char* str1, const char* str2)
{
    int i;
    int dev;
    size_t str_size;
    int chk_size;

    unsigned char string[32];
    memset(string,0,sizeof(string));

    dev = open(FPGA_TEXT_LCD_DEVICE, O_RDWR);
    if(dev<0) {
        __android_log_print(ANDROID_LOG_INFO,"Device Open Error","Driver=%d", dev);
        return -1;
    }
    else{
        str_size=strlen(str1);
        if(str_size>0){
            strncat(reinterpret_cast<char *const>(string), str1, str_size);
            memset(string+str_size,' ', LINE_BUFF-str_size);
        }
        str_size=strlen(str2);
        if(str_size>0){
            strncat(reinterpret_cast<char *const>(string), str2, str_size);
            memset(string+LINE_BUFF+str_size,' ',LINE_BUFF-str_size);
        }
        write(dev,string,MAX_BUFF-1);
        close(dev);
    }
    return 0;
}

extern "C"
JNIEXPORT jint JNICALL
Java_com_example_dot_1button_MainActivity_ReceiveTextLcdValue(JNIEnv *env, jobject thiz,
                                                              jstring val1, jstring val2) {
    // TODO: implement ReceiveTextLcdValue()
    jint result = 0;
    const char* pstr1 = (*env).GetStringUTFChars(val1,NULL);
    __android_log_print(ANDROID_LOG_INFO,"FpgaFndExample","value=%s", pstr1);

    const char* pstr2 = (*env).GetStringUTFChars(val2,NULL);
    __android_log_print(ANDROID_LOG_INFO,"FpgaFndExample","value=%s", pstr2);

    fpga_text_lcd(pstr1, pstr2);
    __android_log_print(ANDROID_LOG_INFO,"Debug 1","Driver=%d", result);

    (*env).ReleaseStringUTFChars(val1, pstr1);
    (*env).ReleaseStringUTFChars(val2, pstr2);
    return 0;
}