package src.main.java;

import java.awt.event.KeyEvent;

public class Main{
	public static void main(String[] args){
		PrimaryLoop pl = new PrimaryLoop();
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_Q){
			System.out.println("Goodbye");
			System.exit(0);
		}
	}

}
