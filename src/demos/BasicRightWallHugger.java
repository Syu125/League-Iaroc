package demos;

import java.io.IOException;

import org.jointheleague.ecolban.rpirobot.IRobotAdapter;
import org.jointheleague.ecolban.rpirobot.IRobotInterface;
import org.jointheleague.ecolban.rpirobot.SimpleIRobot;

public class BasicRightWallHugger extends IRobotAdapter {
	//Sonar sonar = new Sonar();
	
	public BasicRightWallHugger(IRobotInterface iRobot) {
		super(iRobot);
	}

	public static void main(String[] args) throws Exception {
		System.out.println("Try event listner, revn Monday 2030");
		IRobotInterface base = new SimpleIRobot();
		BasicRightWallHugger rob = new BasicRightWallHugger(base);
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
		//int[] lightBumpReadings = getLightBumps();
		driveDirect(500, 178);
		//driveDirect(500,350);
		if(isBumpRight()){
			driveDirect(-230, 280);
			sleep(200);
			
		}
		if(isBumpRight( ) && isBumpLeft()){
			driveDirect(-250,-250);
			sleep(500);
		}
		if(isBumpLeft()){
			  driveDirect(-500,-500);
			  sleep(100);
			  driveDirect(50,500);
			  sleep(300);
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
