package circles;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class CirclesFrame extends JFrame {

	private static final long serialVersionUID = 1L;

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI(); 
			}
		});
	}
	
	private static void createAndShowGUI() {
		
		JFrame f = new JFrame("Circles");
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
		f.getContentPane().add(new CirclesPanel());
		f.pack();
		f.setVisible(true);
		
	} 

	class MyPanel extends JPanel {

		private static final long serialVersionUID = 1L;

		public MyPanel() {
			setBorder(BorderFactory.createLineBorder(Color.black));
		}

		public Dimension getPreferredSize() {
			return new Dimension(360,230);
		}

		public void paintComponent(Graphics g) {
			super.paintComponent(g);    

		}

	}

}
