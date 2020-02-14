//このソースは、VstoneMagicによって自動生成されました。
//ソースの内容を書き換えた場合、VstoneMagicで開けなくなる場合があります。
package	jp.co.mysota;
import	main.main.GlobalVariable;
import	jp.vstone.RobotLib.*;
import	jp.vstone.sotatalk.*;
import	jp.vstone.sotatalk.SpeechRecog.*;
import	lib.usb.Hiddata;

public class mymain
{

	public Hiddata hiddata;
	public int device;
	public byte[] buffer;
	public int returnValue;
	public int sensorValue;
	public mymain()																										//@<BlockInfo>jp.vstone.block.func.constructor,32,32,416,32,False,6,@</BlockInfo>
	{
																														//@<OutputChild>
		hiddata=new Hiddata();																							//@<BlockInfo>jp.vstone.block.variable,96,32,96,32,False,5,break@</BlockInfo>
																														//@<EndOfBlock/>
		device=0;																										//@<BlockInfo>jp.vstone.block.variable,160,32,160,32,False,4,break@</BlockInfo>
																														//@<EndOfBlock/>
		buffer=new byte[17];																							//@<BlockInfo>jp.vstone.block.variable,224,32,224,32,False,3,break@</BlockInfo>
																														//@<EndOfBlock/>
		/*int returnValue*/;																							//@<BlockInfo>jp.vstone.block.variable,288,32,288,32,False,2,break@</BlockInfo>
																														//@<EndOfBlock/>
		sensorValue=0;																									//@<BlockInfo>jp.vstone.block.variable,352,32,352,32,False,1,break@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
	}																													//@<EndOfBlock/>

	//@<Separate/>
	public void main()																									//@<BlockInfo>jp.vstone.block.func,32,256,1040,256,False,20,コメント@</BlockInfo>
	throws SpeechRecogAbortException {
		if(!GlobalVariable.TRUE) throw new SpeechRecogAbortException("default");

																														//@<OutputChild>
		System.loadLibrary("Hiddata");																					//@<BlockInfo>jp.vstone.block.freeproc,96,256,96,256,False,19,@</BlockInfo>
																														//@<EndOfBlock/>
		device=(int)hiddata.usbhidOpenDevice(0x16c0,0x05df);															//@<BlockInfo>jp.vstone.block.calculater,176,256,176,256,False,18,@</BlockInfo>
																														//@<EndOfBlock/>
		if(device!=0)																									//@<BlockInfo>jp.vstone.block.if,256,208,960,208,False,17,コメント@</BlockInfo>
		{
																														//@<OutputChild>
			CRobotUtil.Log(getClass().getSimpleName(), (String)"find sensor");											//@<BlockInfo>jp.vstone.block.printlog,320,208,320,208,False,15,@</BlockInfo>	@<EndOfBlock/>
			for(int i=0;i<(int)30;i++)																					//@<BlockInfo>jp.vstone.block.for,384,208,832,208,False,14,コメント@</BlockInfo>
			{
																														//@<OutputChild>
				returnValue=(int)hiddata.usbhidGetReport(device,0,buffer ,buffer.length);								//@<BlockInfo>jp.vstone.block.calculater,448,208,448,208,False,12,@</BlockInfo>
																														//@<EndOfBlock/>
				if(returnValue==0)																						//@<BlockInfo>jp.vstone.block.if,512,160,704,160,False,11,コメント@</BlockInfo>
				{
																														//@<OutputChild>
					sensorValue=(int)buffer[1];																			//@<BlockInfo>jp.vstone.block.calculater,576,160,576,160,False,8,@</BlockInfo>
																														//@<EndOfBlock/>
					CRobotUtil.Log(getClass().getSimpleName(), (String)"value:"+sensorValue);							//@<BlockInfo>jp.vstone.block.printlog,640,160,640,160,False,7,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
				}
				else
				{
																														//@<OutputChild>
					CRobotUtil.Log(getClass().getSimpleName(), (String)"cannot read sensor");							//@<BlockInfo>jp.vstone.block.printlog,576,256,576,256,False,9,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
				}
																														//@<EndOfBlock/>
				CRobotUtil.wait((int)500);																				//@<BlockInfo>jp.vstone.block.wait,768,208,768,208,False,10,コメント@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
			}																											//@<EndOfBlock/>
			hiddata.usbhidCloseDevice(device);																			//@<BlockInfo>jp.vstone.block.freeproc,896,208,896,208,False,13,@</BlockInfo>
																														//@<EndOfBlock/>
																														//@</OutputChild>
		}
		else
		{
																														//@<OutputChild>
			CRobotUtil.Log(getClass().getSimpleName(), (String)"not find sensor");										//@<BlockInfo>jp.vstone.block.printlog,320,304,320,304,False,16,@</BlockInfo>	@<EndOfBlock/>
																														//@</OutputChild>
		}
																														//@<EndOfBlock/>
																														//@</OutputChild>

	}																													//@<EndOfBlock/>

}
