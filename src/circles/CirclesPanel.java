package circles;

import java.util.Random;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

public class CirclesPanel extends JPanel {

	// Default status on the "Paint" button (between "on" and "off")

	String status = "off";

	private static final long serialVersionUID = 1L;
	private JButton btnPaint;
	private JButton btnStop;

	// A random object for generating colors, coordinates and sizes

	Random rand = new Random();

	// How many circles?

	int nrCircles = 5; 

	// Generate the panel

	private JPanel panel;

	public CirclesPanel() {

		initComponents();

	}
	private void initComponents() {

		// Create a "Grid Bag Layout" where the buttons will be placed

		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{10, 103, 0, 78, 49, 81, 0};
		gridBagLayout.rowHeights = new int[]{10, 216, 29, 0};
		gridBagLayout.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);

		panel = new JPanel();
		GridBagConstraints gbc_panel = new GridBagConstraints();
		gbc_panel.anchor = GridBagConstraints.NORTHWEST;
		gbc_panel.insets = new Insets(0, 0, 5, 5);
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		add(panel, gbc_panel);

		// The "Paint" button, which activates the program 

		btnPaint = new JButton("Paint");
		btnPaint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				status = "on";

				repaint();
			}
		});
		GridBagConstraints gbc_btnRita = new GridBagConstraints();
		gbc_btnRita.anchor = GridBagConstraints.SOUTH;
		gbc_btnRita.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnRita.insets = new Insets(0, 0, 5, 5);
		gbc_btnRita.gridx = 2;
		gbc_btnRita.gridy = 1;
		add(btnPaint, gbc_btnRita);

		// A button to stop the program 

		btnStop = new JButton("Stop");
		btnStop.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				status = "off";

				repaint();
			}
		});
		GridBagConstraints gbc_btnAvsluta = new GridBagConstraints();
		gbc_btnAvsluta.anchor = GridBagConstraints.SOUTH;
		gbc_btnAvsluta.insets = new Insets(0, 0, 5, 5);
		gbc_btnAvsluta.fill = GridBagConstraints.HORIZONTAL;
		gbc_btnAvsluta.gridx = 4;
		gbc_btnAvsluta.gridy = 1;
		add(btnStop, gbc_btnAvsluta);
	}


	protected void paintComponent(Graphics gr) {

		super.paintComponent(gr);

		int x, y, diameter;
		
		if (status == "on") {
			
			for(int i = 0; i < nrCircles; i++){ 

				// Variables to generate colors (as a combination of R, G and B) 

				float r = rand.nextFloat();
				float g = rand.nextFloat();
				float b = rand.nextFloat();

				// Random colors

				Color randomColor = new Color(r, g, b);

				gr.setColor(randomColor);

				x = rand.nextInt(400); // Random X coordinates
				y = rand.nextInt(150); // Random Y coordinates
				diameter = rand.nextInt(50); // Random sizes
				gr.fillOval(x, y, diameter, diameter); // Paint the circle

			}
		}
	}
}