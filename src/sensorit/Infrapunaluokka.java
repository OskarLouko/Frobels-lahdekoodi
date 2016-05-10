package sensorit;

import lejos.hardware.Button;

/**
 * 
 * tuodaan tarvittavat lejos importit
 *
 */
import lejos.hardware.lcd.LCD;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.robotics.RegulatedMotorListener;
import lejos.utility.Delay;
import motor.Moottori;

/**
 * 
 * luodaan infrapunaluokka, joka on Thread-luokan aliluokka
 * Thread luokka toimii taustalla koko ajan
 * 
 * @author Andrei
 *
 */
public class Infrapunaluokka extends Thread {

/**
 * 
 * esitell‰‰n sensori olio sek‰ olio k‰skyjen ilmoittamista varten
 * 
 */
	
	private EV3IRSensor infraredSensor;
	private int remoteCommand;

	/**
	 * 
	 * luokan konstruktorissa asetetaan sensori muuttuja infraredSensor
	 * 
	 * @param sensor
	 */
	public Infrapunaluokka(EV3IRSensor sensor) {

		this.infraredSensor = sensor;
		
	}
	
	/**
	 * 
	 * luokkaa luotaessa luodaan kuuntelija, joka saa kuuntelee komennon arvoa
	 * 
	 * @param listener
	 */

	public void addListener(RegulatedMotorListener listener){
		
		 remoteCommand = infraredSensor.getRemoteCommand(0);
	}
	/**
	 * palauttaa komennon arvon kutsuttaessa
	 * 
	 * @return
	 */
	public int getCommand(){
		
		return remoteCommand;
	}
	
	public void run() {

		while (!Button.ENTER.isDown()) {

			
			remoteCommand = infraredSensor.getRemoteCommand(0);
			getCommand();
			if (remoteCommand != 0) {
				
				LCD.clear();
				LCD.drawString("Painoit: " + remoteCommand, 0, 0);
				
				
				Moottori.liikuta(remoteCommand);


			} else if (remoteCommand == 0) {

				Moottori.pysayta(remoteCommand);
			}
		}
	}
}

	
