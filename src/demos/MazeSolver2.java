package demos;

import java.io.IOException;

import org.jointheleague.ecolban.rpirobot.IRobotAdapter;
import org.jointheleague.ecolban.rpirobot.IRobotInterface;
import org.jointheleague.ecolban.rpirobot.SimpleIRobot;

public class MazeSolver2 extends IRobotAdapter {
	//Sonar sonar = new Sonar();
	
	public MazeSolver2(IRobotInterface iRobot) {
		super(iRobot);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Try event listner, revn Monday 2030");
		IRobotInterface base = new SimpleIRobot();
		MazeSolver2 rob = new MazeSolver2(base);
		rob.setup();
		while(rob.loop()){}
		rob.shutDown();	
	}
	
	private void setup() throws Exception {
		//SETUP CODE GOES HERE!!!!!
	}
	
	private boolean loop() throws Exception{
		//LOOP CODE GOES HERE!!!!!
		readSensors(100);
		int[] lightBumpReadings = getLightBumps();
		driveDirect(300, 300);
		//driveDirect(500,350);
		
		if(lightBumpReadings[0]>0){
			driveDirect(175,100);
			sleep(300);
			
		}
		if(lightBumpReadings[1]>0){
			driveDirect(150,100);
			sleep(300);
		}
		if(lightBumpReadings[2]>0){
			driveDirect(125,100);
			sleep(300);
		}
		if(lightBumpReadings[3]>0){
			driveDirect(100,125);
			sleep(300);
		}
		if(lightBumpReadings[4]>0){
			driveDirect(100,150);
			sleep(300);
		}
		if(lightBumpReadings[5]>0){
			driveDirect(100,175);
			sleep(300);
		}
		
		if(lightBumpReadings[2]>0 && lightBumpReadings[3]>0){
			driveDirect(0,500);
			sleep(750);
			if(lightBumpReadings[2]>0 && lightBumpReadings[3]>0){
				driveDirect(0,500);
				sleep(1500);
				if(lightBumpReadings[2]>0 && lightBumpReadings[3]>0){
					driveDirect(0,500);
					sleep(750);
				}else{
					driveDirect(300,300);
				}
			}else{
				driveDirect(300,300);
			}
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
