package src.main.java;

import src.main.java.Abstract.*;

import javax.swing.*;
import java.awt.event.KeyEvent;

// 80 lines wide
// 54 lines high

public class Main{
	public static void main(String[] args){
		if(args.length == 1){
			JFrame window = new JFrame();
			window.setSize(80, 54);
			window.setLayout(null);
			window.setVisible(true);
		} else {
			PrimaryLoop pl = new PrimaryLoop();
		}
		
		
	}
	
	public void keyPressed(KeyEvent e){
		int key = e.getKeyCode();
		if(key == KeyEvent.VK_Q){
			System.out.println("Goodbye");
			System.exit(0);
		}
	}

}
