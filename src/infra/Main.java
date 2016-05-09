package infra;

import lejos.hardware.lcd.LCD;
import lejos.hardware.motor.EV3LargeRegulatedMotor;
import lejos.hardware.port.MotorPort;
import lejos.hardware.port.SensorPort;
import lejos.hardware.sensor.EV3IRSensor;
import motor.Moottori;


public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		EV3IRSensor irSensor = new EV3IRSensor(SensorPort.S1);
		EV3LargeRegulatedMotor largeMotora = new EV3LargeRegulatedMotor(MotorPort.A);
		EV3LargeRegulatedMotor largeMotorb = new EV3LargeRegulatedMotor(MotorPort.B);
		EV3LargeRegulatedMotor largeMotorc = new EV3LargeRegulatedMotor(MotorPort.C);
		EV3LargeRegulatedMotor largeMotord = new EV3LargeRegulatedMotor(MotorPort.D);
		Moottori moottorit = new Moottori(largeMotora, largeMotorb, largeMotorc, largeMotord);
		Infrapunaluokka checkerThread = new Infrapunaluokka(irSensor);
		checkerThread.start();
		LCD.drawString("Lopetus ENTER", 0, 4);
		}

	}

