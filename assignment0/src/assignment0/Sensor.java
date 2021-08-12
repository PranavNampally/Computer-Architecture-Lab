package assignment0;

import java.lang.Math;   

public class Sensor {
	int x;
	int y;
	boolean state; //state=true=> sensor is on other wise off
	
	public Sensor(int x_coord, int y_coord, double prob) {
		x=x_coord;
		y=y_coord;
		double temp=Math.random();
		if(temp<=prob) {
			state=true;
		}
		else {
			state=false;
		}
	}
	
	public void sensorToggle(int t, double prob) {
		if(t%10==0) {
			double temp=Math.random();
			if(temp<=prob) {
				this.state=true;
			}
			else {
				this.state=false;
			}
		}
	}
}
