package assignment0;

public class Infiltrator {
	int x;
	int y;
	boolean caught; //state=true=> sensor is on other wise off
	
	public Infiltrator(int x_coord) {
		x=x_coord;
		y=-1;
		caught=false;
	}
	
	public void infiltratorMovement(int t, int l, double prob) {
		if(t%10==0) {
			double temp=Math.random();
			if(this.x!=l-1 && this.x!=0) {
				if(temp<0.33) {
					this.x-=1;
				}
				else if(temp>=0.33 && temp<0.66) {
					this.x+=0;
				}
				else {
					this.x+=1;
				}
			}
			
			else if(this.x==l-1) {
				if(temp<0.5) {
					this.x-=1;
				}
				else {
					this.x+=0;
				}
			}
			
			else {
				if(temp<0.5) {
					this.x+=1;
				}
				else {
					this.x+=0;
				}
			}
			this.y+=1;
		}
	}
	
}
