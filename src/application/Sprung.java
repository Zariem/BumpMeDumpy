package application;

public class Sprung extends Thread{
	
	static boolean fertig = true;
	boolean hochpunkt = false;
	
	int sprunghoehe = 100;
	static int ursprung = 430;
	static int sprungposition = ursprung;
	
	public Sprung(){
		
	}

	public void run(){
		fertig = false;
		int verzoegerung;
		while(fertig == false){
			Sprung();
			
			verzoegerung=3;
			
			try{
				Thread.sleep(verzoegerung);
			}
			catch(Exception e){
			}
		}
		
		hochpunkt = false;
	}
	public void Sprung(){
		if(hochpunkt == false){
			sprungposition --;
		}
		if(sprungposition == (ursprung-sprunghoehe)){
			hochpunkt = true;
		}
		if(hochpunkt == true && sprungposition <= ursprung){
			sprungposition ++;
			if(sprungposition == ursprung){
				fertig = true;
			}
		}
	}
}


















