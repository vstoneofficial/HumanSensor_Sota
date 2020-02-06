package lib.usb;

public class Hiddata {

	public native int usbhidOpenDevice(int vendor, int product);
	public native void usbhidCloseDevice(int device);
	public native int usbhidSetReport(int device, byte[] buffer, int len);
	public native int usbhidGetReport(int device, int reportID,byte[] buffer,int len);
	
  	public static void main(String[] args) {
    	System.loadLibrary("Hiddata");

	    try{
			Hiddata hiddata = new Hiddata();
			int dev = hiddata.usbhidOpenDevice(0x16c0,0x05df);
			if(dev==0){
				System.out.println("Sensor not found.");
			}
			else{
				System.out.println("Sensor found.");
				for(int i=0;i<30;i++){
					byte[] buffer = new byte[17];
					if(hiddata.usbhidGetReport(dev,0,buffer ,buffer.length)==0){
						System.out.println("value:"+buffer[1]);
					}
					else System.out.println("Sensor read error.");
					Thread.sleep(500);
				}
				hiddata.usbhidCloseDevice(dev);
			}
		} catch(InterruptedException e){
      		e.printStackTrace();
    	} 
  	}
}