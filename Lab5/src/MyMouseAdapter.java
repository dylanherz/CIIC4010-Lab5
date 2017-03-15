import java.awt.Color;
import java.awt.Component;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import javax.swing.JFrame;

public class MyMouseAdapter extends MouseAdapter {
	private Random generator = new Random();
	public void mousePressed(MouseEvent e) {
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame) c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			myPanel.mouseDownGridX = myPanel.getGridX(x, y);
			myPanel.mouseDownGridY = myPanel.getGridY(x, y);
			myPanel.repaint();
			break;
		case 3:		//Right mouse button
			Component c2 = e.getComponent();
			while (!(c2 instanceof JFrame)) {
				c2 = c2.getParent();
				if (c2 == null) {
					return;
				}
			}
			JFrame myFrame2 = (JFrame) c2;
			MyPanel myPanel2 = (MyPanel) myFrame2.getContentPane().getComponent(0);
			Insets myInsets2 = myFrame2.getInsets();
			int x12 = myInsets2.left;
			int y12 = myInsets2.top;
			e.translatePoint(-x12, -y12);
			int x2 = e.getX();
			int y2 = e.getY();
			myPanel2.x = x2;
			myPanel2.y = y2;
			int gridX2 = myPanel2.getGridX(x2, y2);
			int gridY2 = myPanel2.getGridY(x2, y2);
	
			myPanel2.repaint();
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
	public void mouseReleased(MouseEvent e) {
		
		Color[] colorCollection = new Color[5];
		colorCollection[0] = Color.YELLOW;
		colorCollection[1] = Color.MAGENTA;
		colorCollection[2] = Color.BLACK;
		colorCollection[3] = new Color(0x964B00);
		colorCollection[4] = new Color(0xB57EDC);
		
		switch (e.getButton()) {
		case 1:		//Left mouse button
			Component c = e.getComponent();
			while (!(c instanceof JFrame)) {
				c = c.getParent();
				if (c == null) {
					return;
				}
			}
			JFrame myFrame = (JFrame)c;
			MyPanel myPanel = (MyPanel) myFrame.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets = myFrame.getInsets();
			int x1 = myInsets.left;
			int y1 = myInsets.top;
			e.translatePoint(-x1, -y1);
			int x = e.getX();
			int y = e.getY();
			myPanel.x = x;
			myPanel.y = y;
			int gridX = myPanel.getGridX(x, y);
			int gridY = myPanel.getGridY(x, y);
		
			if ((myPanel.mouseDownGridX == -1) || (myPanel.mouseDownGridY == -1)) {
				//Had pressed outside
				//Do nothing
			} else {
				if ((gridX == -1) || (gridY == -1)) {
					//Is releasing outside
					//Do nothing
				} else {
					if ((myPanel.mouseDownGridX != gridX) || (myPanel.mouseDownGridY != gridY)) {
						//Released the mouse button on a different cell where it was pressed
						//Do nothing
					} else {
						//Released the mouse button on the same cell where it was pressed
						if ((gridX == 0) || (gridY == 0)) {
							
							if ((gridX == 0) && (gridY != 0 && gridY != 10)){
								for (int i = 1; i < 10; i++) {
									
									int randomNumber = generator.nextInt(5);
									Color newColor = null;
									
									switch (randomNumber) {
									
									case 0:
										newColor = Color.YELLOW;
										break;
									case 1:
										newColor = Color.MAGENTA;
										break;
									case 2:
										newColor = Color.BLACK;
										break;
									case 3:
										newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									case 4:
										newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									}
									myPanel.colorArray[i][gridY] = newColor;
									myPanel.repaint();
								}
							}
						
							else if ((gridX != 0) && gridY == 0){
								for (int i = 1; i < 10; i++) {
									
									int randomNumber = generator.nextInt(5);
									Color newColor = null;
									
									switch (randomNumber) {
									
									case 0:
										newColor = Color.YELLOW;
										break;
									case 1:
										newColor = Color.MAGENTA;
										break;
									case 2:
										newColor = Color.BLACK;
										break;
									case 3:
										newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									case 4:
										newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									}
									myPanel.colorArray[gridX][i] = newColor;
									myPanel.repaint();
								}
							}
							else if (gridX == 0 && gridY == 10){
								
								for (int i = 4; i <= 6; i++) {
									for (int j = 4; j <= 6; j++) {
									
									int randomNumber = generator.nextInt(5);
									Color newColor = null;
									
									switch (randomNumber) {
									
									case 0:
										newColor = Color.YELLOW;
										break;
									case 1:
										newColor = Color.MAGENTA;
										break;
									case 2:
										newColor = Color.BLACK;
										break;
									case 3:
										newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									case 4:
										newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									}
									myPanel.colorArray[i][j] = newColor;
									myPanel.repaint();
									}
								}
							}
							else  {
								for (int i = 1; i < 10; i++) {
									
									int randomNumber = generator.nextInt(5);
									Color newColor = null;
									
									switch (randomNumber) {
									
									case 0:
										newColor = Color.YELLOW;
										break;
									case 1:
										newColor = Color.MAGENTA;
										break;
									case 2:
										newColor = Color.BLACK;
										break;
									case 3:
										newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									case 4:
										newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
										break;
									}
									myPanel.colorArray[i][i] = newColor;
									myPanel.repaint();
								}
							}
							
						
						
						}else {
							
							int randomNumber = generator.nextInt(5);
							Color oldColor = myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY];
							Color newColor = null;
							
							while (colorCollection[randomNumber].equals(oldColor)){
								randomNumber = generator.nextInt(5);
								
							}
							switch (randomNumber) {
							
							case 0:
								newColor = Color.YELLOW;
								break;
							case 1:
								newColor = Color.MAGENTA;
								break;
							case 2:
								newColor = Color.BLACK;
								break;
							case 3:
								newColor = new Color(0x964B00);   //Brown (from http://simple.wikipedia.org/wiki/List_of_colors)
								break;
							case 4:
								newColor = new Color(0xB57EDC);   //Lavender (from http://simple.wikipedia.org/wiki/List_of_colors)
								break;
							}
							myPanel.colorArray[myPanel.mouseDownGridX][myPanel.mouseDownGridY] = newColor;
							myPanel.repaint();
						}
					}
				}
			}
			myPanel.repaint();
			break;
		
		case 3:		//Right mouse button
			Component c2 = e.getComponent();
			while (!(c2 instanceof JFrame)) {
				c2 = c2.getParent();
				if (c2 == null) {
					return;
				}
			}
			JFrame myFrame2 = (JFrame)c2;
			MyPanel myPanel2 = (MyPanel) myFrame2.getContentPane().getComponent(0);  //Can also loop among components to find MyPanel
			Insets myInsets2 = myFrame2.getInsets();
			int x12 = myInsets2.left;
			int y12 = myInsets2.top;
			e.translatePoint(-x12, -y12);
			int x2 = e.getX();
			int y2 = e.getY();
			myPanel2.x = x2;
			myPanel2.y = y2;
			int gridX2 = myPanel2.getGridX(x2, y2);
			int gridY2 = myPanel2.getGridY(x2, y2);
			
			if (gridX2< 0 && gridY2 <0){
				
				
				int randomNumber2 = generator.nextInt(3);
				Color NotOnTheGrid = null;
				
				Color oldColor2 = myPanel2.colorArray[0][0];
				
				while (colorCollection[randomNumber2].equals(oldColor2)){
					
					randomNumber2 = generator.nextInt(3);
				}
				
				switch (randomNumber2) {
				case 0: 
					NotOnTheGrid = Color.BLUE;
					break;
				
				case 1: 
					
					NotOnTheGrid = Color.GREEN;
					break;
					
				case 2:
					
					NotOnTheGrid = Color.CYAN;
					break;
					
				}
				
				for (int i = 0; i < 10; i++) {
					
					myPanel2.colorArray[i][0] = NotOnTheGrid;
				
				}
				myPanel2.repaint();
				
				for (int j = 0; j < 11; j++) {
					
					myPanel2.colorArray[0][j] = NotOnTheGrid;
				}
				myPanel2.repaint();
			}
			
			break;
		default:    //Some other button (2 = Middle mouse button, etc.)
			//Do nothing
			break;
		}
	}
}