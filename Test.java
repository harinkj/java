import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
public class Test {
	public static void main(String[] args) throws Exception{
		try {
			Robot robot = new Robot();
			// Creates the delay of 5 min be default
			String delayMins = "5";
			String breaktime = "NONE";
			int breakit = 0;
			if (args.length > 0){
				delayMins = args[0];
				breaktime = args[1];
			}
			int delayMillisec = Integer.parseInt(delayMins) * 60000; // converting minutes to milliseconds
			if(!"NONE".equals(breaktime)){
				breakit = Integer.parseInt(breaktime) / Integer.parseInt(delayMins) ; // converting minutes to milliseconds
			}
			System.out.println(" delay minutes ="+delayMins+" breaktime="+breakit);
			int i=0;
			while(true){
				if(breakit != 0){
					if(i >= breakit) break;
				}
				robot.mouseMove( 100,  100) ;
				Thread.currentThread().sleep(delayMillisec);
				robot.mouseMove( 500,  600) ;
				i++;
			}
		} catch (AWTException e) {
			e.printStackTrace();
		}
	}
}
