package assignment0;

import java.util.Random;


public class Clock {
	
	public static void main(String[] args) {
		
		fileop dataPlot = new fileop();
		dataPlot.CreateFileDemo();
		
		
		double prob_arr[]= {0.1, 0.3, 0.5, 0.7, 0.9};
		int width_arr[]= {5, 10, 15, 20, 25};
		for(int prob_index=0; prob_index<prob_arr.length; prob_index++) {
			for(int width_index=0; width_index<width_arr.length; width_index++) {
				int t_avg=0;
				int AC_wins=0;
				double prob=prob_arr[prob_index];
				int width=width_arr[width_index];
				for(int iter=0; iter<10; iter++) {
					
					Border board=new Border(width);	
					board.sensorArrInit(prob);
					
					Random rand = new Random();
					int inf_x=rand.nextInt(1000);
					Infiltrator natasha=new Infiltrator(inf_x);	
					
					
					int t=0;
					while((natasha.caught==false) && (natasha.y<(board.w-1))) {
						for (int i=0; i<board.w; i++) {				      
							for(int j=0; j<board.l; j++) {
								board.sensorArrUpdate(t, prob);
							}
						}
						natasha.infiltratorMovement(t, board.l, prob);
						if(board.sensorArr[natasha.y][natasha.x].state==true) {
							natasha.caught=true;
							System.out.println("time= "+t+" prob= "+prob+" w= "+board.w);
							t_avg+=t;
							break;
						}
						t+=10;
					}
					if(natasha.caught==false) {
						System.out.println("time= "+t+" prob= "+prob+" w= "+board.w);
						t_avg+=t;
						AC_wins+=1;
					}
				}
				t_avg/=10;
				System.out.println("time_avg= "+t_avg+" prob= "+prob+" w= "+width+" AC wins= "+AC_wins);
				dataPlot.AppendFileDemo(t_avg,prob,width,AC_wins);
				
				

			}
				
		}
		
		

	}

}