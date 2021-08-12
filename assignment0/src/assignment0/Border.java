package assignment0;

public class Border {
	int l=1000;
	int w;
	Sensor[][] sensorArr;
	
	public Border(int width){
		w=width;
		sensorArr= new Sensor[w][l];
	}
	
	public void sensorArrInit(double prob) {
		for(int i=0; i<w; i++){
			for(int j=0; j<l; j++){
				sensorArr[i][j]=new Sensor(i, j, prob);		
			}
		}	
	}
	
	public void sensorArrUpdate(int t, double prob) {
		for(int i=0; i<w; i++){
			for(int j=0; j<l; j++){
				sensorArr[i][j].sensorToggle(t, prob);	
			}
		}	
	}
	
	public static void main(String[] args) {
	}
	
}