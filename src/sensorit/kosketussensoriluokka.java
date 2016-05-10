package sensorit;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;
import motor.Moottori;


public class kosketussensoriluokka {

	
	private static EV3TouchSensor ts;
	

	public kosketussensoriluokka(EV3TouchSensor sensori) {

		this.ts = sensori;

	}
	
		
	public static void tarkista(int remoteCommand){
		
		float[] sample = new float[ts.sampleSize()];
		
		ts.fetchSample(sample, 0);
		
		if(sample[0] == 1){
			
			LCD.clear();
	        LCD.drawString("VAARA", 5, 4);
	        Button.LEDPattern(8);
			Moottori.pysayta(remoteCommand);
	        Delay.msDelay(5000);
	        LCD.clear();
	        LCD.drawString("VAARA OHI", 5, 4);
	        Button.LEDPattern(1);
	        Delay.msDelay(1000);
	        LCD.clear();
	        Button.LEDPattern(0);
	        
	        

		}
		
		
	}
	
	

	
	
}
	
	
	
	
	
//	SensorMode touch = ts.getTouchMode();{
	
//	if(ts.sampleSize()== 1){
//		
//		LCD.drawString("debugkosk", 0, 0);
//		Delay.msDelay(1000);
//	}
	
	
//	}
	
	
	
//	public void huomaanosto(){
//		
//    	// try again
//		
//		 LCD.drawString("Finished", 3, 4);
//    }
   


