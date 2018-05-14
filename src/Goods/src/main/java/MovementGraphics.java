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
	
	private void DisplayMovementMap(){
		System.out.println( );
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
	}

	public void DisplayShoreSide(){
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
		System.out.println("");
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
	
	public static void shipZincGraphics(){
		System.out.println("  ___/=======|");
		System.out.println(" /   |       |");
		System.out.println("|    |  / \\  |");
		System.out.println("|    |  | |__|");
		System.out.println("|    | /     |");
		System.out.println("|    | \\   __|");
		System.out.println("|    |  | |  |");
		System.out.println(" \\___|  \\ /   \\_________________");
		System.out.println("                   V V     V V");
		System.out.println("____________________V_______V__");
	}
	
	
	public static void portDepartureGraphics(){
		System.out.println("_________          |_|_|/__ /__/  /  / ");
		System.out.println("_____   /| ~     ~ | | | | | | | /  /  ");
		System.out.println("----/  //|    ~   /|_|_|_|_|_|_|/  /   ");
		System.out.println(" ~ /  //||  ~   ~ \\              _/    ");
		System.out.println("~ /  // ||   ~    \\0M0     0M0_/       ");
		System.out.println("_/  //| || ~    ~ |\\    ____/o      `~ ");
		System.out.println(" _ //~| ||___      \\\\__/  o        `~ ");
		System.out.println("| |/  | ||   /|  ~   \\|     /   / ~`~   ");
		System.out.println("| ||  |_|/  /|        |  __/    /`~   ~  ");
		System.out.println("| ||       /|     ~   |        /~`  ~    ");
		System.out.println("| ||      /|  ~     `~/      ~`~`      ~ ");
		System.out.println("| ||     /| ~      `~/  / ~`~`     ~     ");
		System.out.println("|_|/    /|     ~ `~`|~`/`~`~     ~      ~");
		System.out.println("       /| ~        `~`~`~`     ~    ~    ");
		System.out.println("_____ /|     ~  ~   `~`~`   ~         ~  ");
	}
	
	public static void ContainerGraphics(){
		System.out.println("     ______ ");
		System.out.println("    /     /|");
		System.out.println("   /     /#|");
		System.out.println("  /     /##|_____");
		System.out.println(" /     /###/####/|");
		System.out.println("/_____/ ##/####/#|");
		System.out.println("|  |  | #/### /##|");
		System.out.println("|  |  |#/##  / ##/");
		System.out.println("|__|__|/____/ ##/");
		System.out.println("|  |  |  |  | #/");
		System.out.println("|  |  |  |  | /");
		System.out.println("|__|__|__|__|/\n");
	}
	
	public static void MoneyGraphics(){
		System.out.println("      _________ ");
		System.out.println("     /        /|");
		System.out.println("    /        / |");
		System.out.println("  _|--------|  |");
		System.out.println(" //8 ------ |  |");
		System.out.println("// ||&&&&&&||  |");
		System.out.println("|| ||&&&&&&||  |");
		System.out.println("|| 8|______|| /");
		System.out.println("|| /|_______|/");
		System.out.println("||/ ");
	}
	
	public static void LoadUnloadGraphics(){
		System.out.println("");
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