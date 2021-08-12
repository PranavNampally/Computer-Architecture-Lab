package assignment0;

import java.util.Random;
public class Clock {
	
	public static void main(String[] args) {
		double probs[]= {0.1, 0.4, 0.6, 0.8, 0.9};
		int widths[]= {5, 10, 15, 20, 25};
		for(int prob_index=0; prob_index<5; prob_index++) {
			for(int width_index=0; width_index<5; width_index++) {
				double prob=probs[prob_index];
				int width=widths[width_index];
				
				Border board=new Border(width);	
				board.sensorArrInit(prob);
				
				Random rand = new Random();
				int inf_x=rand.nextInt(1000);
				Infiltrator natasha=new Infiltrator(inf_x);	
				
//				for (int i=0; i<board.w; i++) {				      Printing to debug
//					for(int j=0; j<board.l; j++) {
//						if(board.sensorArr[i][j].state==true) {
//							System.out.print("1 ");
//						}
//						else {
//							System.out.print("0 ");
//						}
//					}
//					System.out.print("\n");
//				}
//				System.out.print(natasha.x + " " + natasha.y + "\n");
				
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
						System.out.println("Surprise MF"+" time= "+t+" prob= "+prob+" w= "+board.w);
						break;
					}
					t+=1;
				}
				if(natasha.caught==false) {
					System.out.println("I have outsmarted your outsmartedness"+" time= "+t+" prob= "+prob+" w= "+board.w);
				}
			}
		}
		
		

	}

}
