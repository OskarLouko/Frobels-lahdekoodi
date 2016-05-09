package motor;

import lejos.hardware.motor.EV3LargeRegulatedMotor;

public class Moottori {

	
	private static EV3LargeRegulatedMotor largeMotora;
	private static EV3LargeRegulatedMotor largeMotorb;
	private static EV3LargeRegulatedMotor largeMotorc;
	private static EV3LargeRegulatedMotor largeMotord;
	
	
	public Moottori(EV3LargeRegulatedMotor largeMotora, EV3LargeRegulatedMotor largeMotorb,EV3LargeRegulatedMotor largeMotorc,EV3LargeRegulatedMotor largeMotord){
		
		Moottori.largeMotora = largeMotora;
		Moottori.largeMotorb = largeMotorb;
		Moottori.largeMotorc = largeMotorc;
		Moottori.largeMotord = largeMotord;
		
	}
	
	public static void liikuta(int remoteCommand){
		
		switch (remoteCommand) {
		
		case 1:
			
			largeMotorc.backward();
			largeMotorb.backward();
	
			break;
		
		case 2:
			
			largeMotorc.forward();
			largeMotorb.forward();
			
			break;
			
		case 3:
			
			largeMotorc.forward();
			largeMotorb.backward();
		
			break;
			
		case 4:
			
			largeMotorb.forward();
			largeMotorc.backward();
			
			break;
			
		case 5:
			
			largeMotord.forward();
			
			break;
			
		case 8:
			
			largeMotord.backward();
			
			break;
			
		case 10:
			
			largeMotora.forward();
			
			break;
			
		case 11:
			
			largeMotora.backward();
			
			break;
		}
	}
		

	public static void pysayta(int remoteCommand) {
		
		largeMotora.stop();
		largeMotorb.stop();
		largeMotorc.stop();
		largeMotord.stop();
		
	}
	
	
	
	
	
	

	
}

