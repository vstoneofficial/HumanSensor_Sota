package lib.usb;

public class Hiddata {

	public native int usbhidOpenDevice(int vendor, int product);
	public native void usbhidCloseDevice(int device);
	public native int usbhidSetReport(int device, byte[] buffer, int len);
	public native int usbhidGetReport(int device, int reportID,byte[] buffer,int len);
	
	public static void main(String[] args) {
		System.loadLibrary("Hiddata");
		Hiddata hiddata = new Hiddata();
		hiddata.usbhidOpenDevice(0,0);
		hiddata.usbhidCloseDevice(0);
	}
}