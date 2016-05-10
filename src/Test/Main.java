package Test;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import lejos.hardware.sensor.EV3TouchSensor;
import lejos.utility.Delay;
import motor.Moottori;
import sensorit.Infrapunaluokka;
import sensorit.kosketussensoriluokka;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S2);
		EV3TouchSensor touchSensor = new EV3TouchSensor(SensorPort.S1);
		EV3LargeRegulatedMotor largeMotora = new EV3LargeRegulatedMotor(MotorPort.A);
		EV3LargeRegulatedMotor largeMotorb = new EV3LargeRegulatedMotor(MotorPort.B);
		EV3LargeRegulatedMotor largeMotorc = new EV3LargeRegulatedMotor(MotorPort.C);
		EV3LargeRegulatedMotor largeMotord = new EV3LargeRegulatedMotor(MotorPort.D);
		Moottori moottorit = new Moottori(largeMotora, largeMotorb, largeMotorc, largeMotord);
		kosketussensoriluokka kosketussensori = new kosketussensoriluokka(touchSensor);
		Infrapunaluokka checkerThread = new Infrapunaluokka(irSensor);
		

			LCD.drawString("Aloitetaan", 0, 0);
			Delay.msDelay(1000);
			
			checkerThread.start();
			
		}

	}

