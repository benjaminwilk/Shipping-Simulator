package src.main.java;

public class ShoreSide{

	public ShoreSide(){
		Abstract.rotatePorts(MenuDisplays.getShoreOptionMenu());
		parseShoreMenu(Abstract.scannerInt());
	}

	private void parseShoreMenu(int userDecision){
		switch(userDecision){
			case 1:
				System.out.println("Case 1");
				break;
			case 2:
				System.out.println("Case 2");
				break;
			case 3:
			
				break;
			case 4:
			
				break;
		}
	}
}