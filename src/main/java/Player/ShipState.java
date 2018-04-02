package src.main.java.Player;

enum ShipStatus{
	AtSea, InPort
}

public class ShipState{
	ShipStatus ss;
		
	public String GetState(){
		return "" + this.ss;
	}
	
	public void SetState(ShipStatus ss){
		this.ss = ss;
	}
	
	public void SetInPort(){
		this.ss = ss.InPort;
	}
	
	public void SetAtSea(){
		this.ss = ss.AtSea;
	}
	
}