package src.main.java;

public class MovementGraphics{
	DisplayCommands dc; //= new DisplayCommands();

	public MovementGraphics(int DistanceTraveled, int PortDistance){
		this.dc = new DisplayCommands();
		DisplayStaticAscii(dc);
		DisplayShipIconAscii(DistanceTraveled, PortDistance);
		dc.ChangeStatus(DisplayTopBottom.IconBottom);
		DisplayStaticAscii(dc);

		System.out.println();
	}

	private void DisplayShipIconAscii(int DistanceTraveled, int PortDistance){
		final String PortIconCenter =   "|--|";
		final String waterIcon = ".";
		final String boatIcon = "=";
		
		System.out.print(PortIconCenter);		
		for(int i = 0; i <= 10; i++){
			double doubleValue = (((double)DistanceTraveled / (double)PortDistance) * 10);
			int percentageTraveled = (int)(doubleValue);

			//System.out.print(percentageTraveled);
			if(percentageTraveled == i){
				System.out.print(boatIcon);
			} else {
				System.out.print(waterIcon);
			}
		}
		System.out.println(PortIconCenter);
	}

	private void DisplayStaticAscii(DisplayCommands dc){
		final String PortIconTop = "/--\\";
		final String PortIconBottom= "\\--/";
		final String waterIcon = "~";
		
		if(dc.DisplayStatus() == DisplayTopBottom.IconTop){
			System.out.print(PortIconTop);
		}
		else if(dc.DisplayStatus() == DisplayTopBottom.IconBottom){
			System.out.print(PortIconBottom);
		}
		for(int i = 0; i <= 10; i++){
			System.out.print(waterIcon);
		}
		
		if(dc.DisplayStatus() == DisplayTopBottom.IconTop){
			System.out.println(PortIconTop);
		}
		else if(dc.DisplayStatus() == DisplayTopBottom.IconBottom){
			System.out.println(PortIconBottom);
		}
	}
}

enum DisplayTopBottom{
		IconTop,
		IconBottom;
	}

class DisplayCommands{
	DisplayTopBottom dtb;
		
	public DisplayCommands(){
		this.dtb = dtb.IconTop;
	}

	public void ChangeStatus(DisplayTopBottom passedDTB){
		this.dtb = passedDTB;
	}

	public boolean Compare(DisplayTopBottom passedDTB){
		String stringDTB = "" + this.dtb;
		String StringPassed = "" + passedDTB;
		if(stringDTB.equals(StringPassed) == true){
			return true;
		} else {
			return false;
		}
	}

	public DisplayTopBottom DisplayStatus(){
		return this.dtb;
	}
}