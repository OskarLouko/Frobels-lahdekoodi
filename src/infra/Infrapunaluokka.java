package infra;

import lejos.hardware.Button;
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RegulatedMotorListener;
import lejos.utility.Delay;
import motor.Moottori;

public class Infrapunaluokka extends Thread {

	private EV3IRSensor infraredSensor;
	private int remoteCommand;

	public Infrapunaluokka(EV3IRSensor sensor) {

		this.infraredSensor = sensor;
		
	}

	public void addListener(RegulatedMotorListener listener){
		
		 remoteCommand = infraredSensor.getRemoteCommand(0);
	}
	
	public int getCommand(){
		
		return remoteCommand;
	}
	
	public void run() {

		while (!Button.ENTER.isDown()) {

			
			remoteCommand = infraredSensor.getRemoteCommand(0);
			getCommand();
			if (remoteCommand != 0) {
				LCD.drawString("Painoit: " + remoteCommand, 0, 0);
				Delay.msDelay(500);
				
				Moottori.liikuta(remoteCommand);


				
			} else if (remoteCommand == 0) {

				Moottori.pysayta(remoteCommand);
			}
		}
	}
}

	
