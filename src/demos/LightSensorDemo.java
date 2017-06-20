package demos;

import java.io.IOException;

import org.jointheleague.ecolban.rpirobot.IRobotAdapter;
import org.jointheleague.ecolban.rpirobot.IRobotInterface;
import org.jointheleague.ecolban.rpirobot.SimpleIRobot;

public class LightSensorDemo extends IRobotAdapter {
	Sonar sonar = new Sonar();
	
	public LightSensorDemo(IRobotInterface iRobot) {
		super(iRobot);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Try event listner, rev Monday 2030");
		IRobotInterface base = new SimpleIRobot();
		LightSensorDemo rob = new LightSensorDemo(base);
		rob.setup();
		while(rob.loop()){}
		rob.shutDown();		
	}

	private void setup() throws Exception {
		
	}
	
	private boolean loop() throws Exception{
		readSensors(100);
		
		//getLightBumps() returns an array of length 6 (elements 0 - 5)
		//element 0 is the far left light sensor
		//element 5 is the far right light sensor
		//elements 1-4 are the sensors in between from left to right
		
		int[] lightBumpReadings = getLightBumps();
		
		//if the sensors don't detect anything, they return 0
		//otherwise they return some positive integer
		//the higher the integer the closer the object
	
		driveDirect(500,500);
		if(lightBumpReadings[3]>0){
			driveDirect(0,0);
			sleep(1000);
			driveDirect(-300,-300);
			sleep(1000);
			driveDirect(0,500);
			sleep(1500);
			driveDirect(350,30);
		}else if(lightBumpReadings[2]>0){
			driveDirect(0,0);
			sleep(1000);
			driveDirect(-300,-300);
			sleep(1000);
			driveDirect(0,500);
			sleep(1500);
			driveDirect(500,500);
		}
	
		if(lightBumpReadings[0] > 0){
			driveDirect(130, 100);
			sleep(500);
			driveDirect(0, 0);
		}else if(lightBumpReadings[1] > 0){
			driveDirect(160, 100);
			sleep(500);
			driveDirect(0, 0);
		}else if(lightBumpReadings[2] > 0){
			driveDirect(180, 100);
			sleep(500);
			driveDirect(0, 0);
	}else if(lightBumpReadings[3] > 0){
			driveDirect(100, 180);
			sleep(500);
			driveDirect(0, 0);
		}else if(lightBumpReadings[4] > 0){
			driveDirect(100, 160);
			sleep(500);
			driveDirect(0, 0);
		}else if(lightBumpReadings[5] > 0){
			driveDirect(10, 130);
			sleep(500);
			driveDirect(0, 0);
		}

		return true;
	}
	
	private void sleep(int amt){
		try {
			Thread.sleep(amt);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void shutDown() throws IOException {
		reset();
		stop();
		closeConnection();
	}
}