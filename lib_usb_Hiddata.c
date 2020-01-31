#include "lib_usb_Hiddata.h"
JNIEXPORT jint JNICALL Java_lib_usb_Hiddata_usbhidOpenDevice
(JNIEnv *env, jobject thisj, jint vendor, jint product)
{
  printf("Called usbhidOpenDevice\n");
  return 0;
}
JNIEXPORT void JNICALL Java_lib_usb_Hiddata_usbhidCloseDevice
(JNIEnv *env, jobject thisj, jint device)
{
  printf("Called usbhidCloseDevice\n");
  return ;
}
JNIEXPORT jint JNICALL Java_lib_usb_Hiddata_usbhidSetReport
(JNIEnv *env, jobject thisj, jint device, jbyteArray buffer, jint len)
{
  printf("Called usbhidSetReport\n");
  return 0;
}
JNIEXPORT jint JNICALL Java_lib_usb_Hiddata_usbhidGetReport
(JNIEnv *env, jobject thisj, jint device, jint reportID, jbyteArray buffer, jint len)
{
  printf("Called usbhidGetReport\n");
  return 0;
}