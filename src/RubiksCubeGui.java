import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class RubiksCubeGui extends JApplet {

	private RubiksCube rc;
	private JPanel[][][] panels = new JPanel[6][3][3];
	private HashMap<Integer, Color> colorMap;

	private ImageIcon imgArrowDown = null;
	private ImageIcon imgArrowUp = null;
	private ImageIcon imgArrowRight = null;
	private ImageIcon imgArrowLeft = null;

	private JPanel panel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JPanel panel_5;
	private JPanel panel_6;
	private JPanel panel_7;
	private JPanel panel_8;
	private JPanel panel_9;
	private JPanel panel_10;
	private JPanel panel_11;
	private JPanel panel_12;
	private JPanel panel_13;
	private JPanel panel_14;
	private JPanel panel_15;
	private JPanel panel_16;
	private JPanel panel_17;
	private JPanel panel_18;
	private JPanel panel_19;
	private JPanel panel_20;
	private JPanel panel_21;
	private JPanel panel_22;
	private JPanel panel_23;
	private JPanel panel_24;
	private JPanel panel_25;
	private JPanel panel_26;
	private JPanel panel_27;
	private JPanel panel_28;
	private JPanel panel_29;
	private JPanel panel_30;
	private JPanel panel_31;
	private JPanel panel_32;
	private JPanel panel_33;
	private JPanel panel_34;
	private JPanel panel_35;
	private JPanel panel_36;
	private JPanel panel_37;
	private JPanel panel_38;
	private JPanel panel_39;
	private JPanel panel_40;
	private JPanel panel_41;
	private JPanel panel_42;
	private JPanel panel_43;
	private JPanel panel_44;
	private JPanel panel_45;
	private JPanel panel_46;
	private JPanel panel_47;
	private JPanel panel_48;
	private JPanel panel_49;
	private JPanel panel_50;
	private JPanel panel_51;
	private JPanel panel_52;
	private JPanel panel_53;
	private JLabel panel_54;
	private JLabel panel_55;
	private JLabel panel_57;
	private JLabel panel_58;
	private JLabel panel_59;
	private JLabel panel_60;
	private JLabel panel_61;
	private JLabel panel_62;
	private JLabel panel_63;
	private JLabel panel_64;
	private JLabel panel_65;
	private JLabel panel_66;
	private JLabel panel_67;
	private JLabel panel_68;
	private JLabel panel_69;
	private JLabel panel_70;
	private JLabel panel_71;
	private JLabel panel_72;

	public RubiksCubeGui() {
		rc = new RubiksCube();

		getContentPane()
				.setLayout(
						new MigLayout(
								"",
								"[40][40][40,grow][40,grow][40,grow][40,grow][40,grow][40,grow][40,grow][40,grow][40,grow][40,grow][40,grow][40][40][40]",
								"[40][][-17.00][][40,grow][40][40][40,grow][40,grow][40,grow][40,grow][40][40][40][40][40][40][40]"));

		initializeArrowImages();
		initializePanels();
		createColorMap();
		createPanelArray();
		updatePanelColors();

	}

	private void initializeArrowImages() {
		try {
			imgArrowUp =
					new ImageIcon(
							ImageIO.read(new File("../images/arrowUp.png")));
			imgArrowDown =
					new ImageIcon(ImageIO.read(new File(
							"../images/arrowDown.png")));
			imgArrowLeft =
					new ImageIcon(ImageIO.read(new File(
							"../images/arrowLeft.png")));
			imgArrowRight =
					new ImageIcon(ImageIO.read(new File(
							"../images/arrowRight.png")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void initializePanels() {
		panel_55 = new JLabel(imgArrowDown);
		panel_55.addMouseListener(new tempMouseListener());
		getContentPane().add(panel_55, "cell 6 4,grow");

		panel_72 = new JLabel(imgArrowDown);
		getContentPane().add(panel_72, "cell 7 4,grow");

		panel_57 = new JLabel(imgArrowDown);
		getContentPane().add(panel_57, "cell 8 4,grow");

		panel = new JPanel();
		getContentPane().add(panel, "cell 6 5,grow");

		panel_1 = new JPanel();
		getContentPane().add(panel_1, "cell 7 5,grow");

		panel_6 = new JPanel();
		getContentPane().add(panel_6, "cell 8 5,grow");

		panel_2 = new JPanel();
		getContentPane().add(panel_2, "cell 6 6,grow");

		panel_3 = new JPanel();
		getContentPane().add(panel_3, "cell 7 6,grow");

		panel_7 = new JPanel();
		getContentPane().add(panel_7, "cell 8 6,grow");

		panel_66 = new JLabel(imgArrowDown);
		getContentPane().add(panel_66, "cell 3 7,grow");

		panel_67 = new JLabel(imgArrowDown);
		getContentPane().add(panel_67, "cell 4 7,grow");

		panel_68 = new JLabel(imgArrowDown);
		getContentPane().add(panel_68, "cell 5 7,grow");

		panel_4 = new JPanel();
		getContentPane().add(panel_4, "cell 6 7,grow");

		panel_5 = new JPanel();
		getContentPane().add(panel_5, "cell 7 7,grow");

		panel_8 = new JPanel();
		getContentPane().add(panel_8, "cell 8 7,grow");

		panel_58 = new JLabel(imgArrowDown);
		getContentPane().add(panel_58, "cell 9 7,grow");

		panel_59 = new JLabel(imgArrowDown);
		getContentPane().add(panel_59, "cell 10 7,grow");

		panel_60 = new JLabel(imgArrowDown);
		getContentPane().add(panel_60, "cell 11 7,grow");

		panel_54 = new JLabel(imgArrowRight);
		getContentPane().add(panel_54, "cell 2 8,grow");

		panel_24 = new JPanel();
		getContentPane().add(panel_24, "cell 3 8,grow");

		panel_25 = new JPanel();
		getContentPane().add(panel_25, "cell 4 8,grow");

		panel_26 = new JPanel();
		getContentPane().add(panel_26, "cell 5 8,grow");

		panel_9 = new JPanel();
		getContentPane().add(panel_9, "cell 6 8,grow");

		panel_10 = new JPanel();
		getContentPane().add(panel_10, "cell 7 8,grow");

		panel_11 = new JPanel();
		getContentPane().add(panel_11, "cell 8 8,grow");

		panel_31 = new JPanel();
		getContentPane().add(panel_31, "cell 9 8,grow");

		panel_37 = new JPanel();
		getContentPane().add(panel_37, "cell 10 8,grow");

		panel_34 = new JPanel();
		getContentPane().add(panel_34, "cell 11 8,grow");

		panel_61 = new JLabel(imgArrowLeft);
		getContentPane().add(panel_61, "cell 12 8,grow");

		panel_64 = new JLabel(imgArrowDown);
		getContentPane().add(panel_64, "cell 2 9,grow");

		panel_27 = new JPanel();
		getContentPane().add(panel_27, "cell 3 9,grow");

		panel_28 = new JPanel();
		getContentPane().add(panel_28, "cell 4 9,grow");

		panel_29 = new JPanel();
		getContentPane().add(panel_29, "cell 5 9,grow");

		panel_12 = new JPanel();
		getContentPane().add(panel_12, "cell 6 9,grow");

		panel_13 = new JPanel();
		getContentPane().add(panel_13, "cell 7 9,grow");

		panel_14 = new JPanel();
		getContentPane().add(panel_14, "cell 8 9,grow");

		panel_30 = new JPanel();
		getContentPane().add(panel_30, "cell 9 9,grow");

		panel_38 = new JPanel();
		getContentPane().add(panel_38, "cell 10 9,grow");

		panel_35 = new JPanel();
		getContentPane().add(panel_35, "cell 11 9,grow");

		panel_62 = new JLabel(imgArrowLeft);
		getContentPane().add(panel_62, "cell 12 9,grow");

		panel_65 = new JLabel(imgArrowDown);
		getContentPane().add(panel_65, "cell 2 10,grow");

		panel_23 = new JPanel();
		getContentPane().add(panel_23, "cell 3 10,grow");

		panel_22 = new JPanel();
		getContentPane().add(panel_22, "cell 4 10,grow");

		panel_21 = new JPanel();
		getContentPane().add(panel_21, "cell 5 10,grow");

		panel_15 = new JPanel();
		getContentPane().add(panel_15, "cell 6 10,grow");

		panel_16 = new JPanel();
		getContentPane().add(panel_16, "cell 7 10,grow");

		panel_17 = new JPanel();
		getContentPane().add(panel_17, "cell 8 10,grow");

		panel_32 = new JPanel();
		getContentPane().add(panel_32, "cell 9 10,grow");

		panel_36 = new JPanel();
		getContentPane().add(panel_36, "cell 10 10,grow");

		panel_33 = new JPanel();
		getContentPane().add(panel_33, "cell 11 10,grow");

		panel_63 = new JLabel(imgArrowLeft);
		getContentPane().add(panel_63, "cell 12 10,grow");

		panel_18 = new JPanel();
		getContentPane().add(panel_18, "cell 6 11,grow");

		panel_19 = new JPanel();
		getContentPane().add(panel_19, "cell 7 11,grow");

		panel_20 = new JPanel();
		getContentPane().add(panel_20, "cell 8 11,grow");

		panel_39 = new JPanel();
		getContentPane().add(panel_39, "cell 6 12,grow");

		panel_40 = new JPanel();
		getContentPane().add(panel_40, "cell 7 12,grow");

		panel_41 = new JPanel();
		getContentPane().add(panel_41, "cell 8 12,grow");

		panel_42 = new JPanel();
		getContentPane().add(panel_42, "cell 6 13,grow");

		panel_43 = new JPanel();
		getContentPane().add(panel_43, "cell 7 13,grow");

		panel_44 = new JPanel();
		getContentPane().add(panel_44, "cell 8 13,grow");

		panel_45 = new JPanel();
		getContentPane().add(panel_45, "cell 6 14,grow");

		panel_46 = new JPanel();
		getContentPane().add(panel_46, "cell 7 14,grow");

		panel_47 = new JPanel();
		getContentPane().add(panel_47, "cell 8 14,grow");

		panel_48 = new JPanel();
		getContentPane().add(panel_48, "cell 6 15,grow");

		panel_49 = new JPanel();
		getContentPane().add(panel_49, "cell 7 15,grow");

		panel_50 = new JPanel();
		getContentPane().add(panel_50, "cell 8 15,grow");

		panel_51 = new JPanel();
		getContentPane().add(panel_51, "cell 6 16,grow");

		panel_52 = new JPanel();
		getContentPane().add(panel_52, "cell 7 16,grow");

		panel_53 = new JPanel();
		getContentPane().add(panel_53, "cell 8 16,grow");

		panel_69 = new JLabel(imgArrowUp);
		getContentPane().add(panel_69, "cell 6 17,grow");

		panel_70 = new JLabel(imgArrowUp);
		getContentPane().add(panel_70, "cell 7 17,grow");

		panel_71 = new JLabel(imgArrowUp);
		getContentPane().add(panel_71, "cell 8 17,grow");
	}

	private void createColorMap() {
		colorMap = new HashMap<Integer, Color>();
		colorMap.put(1, Color.WHITE);
		colorMap.put(2, Color.YELLOW);
		colorMap.put(3, Color.RED);
		colorMap.put(4, Color.ORANGE);
		colorMap.put(5, Color.GREEN);
		colorMap.put(6, Color.BLUE);
	}

	private void createPanelArray() {
		// Up
		panels[0][0][0] = panel;
		panels[0][0][1] = panel_1;
		panels[0][0][2] = panel_6;
		panels[0][1][0] = panel_2;
		panels[0][1][1] = panel_3;
		panels[0][1][2] = panel_7;
		panels[0][2][0] = panel_4;
		panels[0][2][1] = panel_5;
		panels[0][2][2] = panel_8;

		// Down
		panels[1][0][0] = panel_18;
		panels[1][0][1] = panel_19;
		panels[1][0][2] = panel_20;
		panels[1][1][0] = panel_39;
		panels[1][1][1] = panel_40;
		panels[1][1][2] = panel_41;
		panels[1][2][0] = panel_42;
		panels[1][2][1] = panel_43;
		panels[1][2][2] = panel_44;

		// Front
		panels[2][0][0] = panel_9;
		panels[2][0][1] = panel_10;
		panels[2][0][2] = panel_11;
		panels[2][1][0] = panel_12;
		panels[2][1][1] = panel_13;
		panels[2][1][2] = panel_14;
		panels[2][2][0] = panel_15;
		panels[2][2][1] = panel_16;
		panels[2][2][2] = panel_17;

		// Back
		panels[3][0][0] = panel_53;
		panels[3][0][1] = panel_52;
		panels[3][0][2] = panel_51;
		panels[3][1][0] = panel_50;
		panels[3][1][1] = panel_49;
		panels[3][1][2] = panel_48;
		panels[3][2][0] = panel_47;
		panels[3][2][1] = panel_46;
		panels[3][2][2] = panel_45;

		// Left
		panels[4][0][0] = panel_26;
		panels[4][0][1] = panel_29;
		panels[4][0][2] = panel_21;
		panels[4][1][0] = panel_25;
		panels[4][1][1] = panel_28;
		panels[4][1][2] = panel_22;
		panels[4][2][0] = panel_24;
		panels[4][2][1] = panel_27;
		panels[4][2][2] = panel_23;

		// Right
		panels[2][0][0] = panel_32;
		panels[2][0][1] = panel_30;
		panels[2][0][2] = panel_31;
		panels[2][1][0] = panel_36;
		panels[2][1][1] = panel_38;
		panels[2][1][2] = panel_37;
		panels[2][2][0] = panel_33;
		panels[2][2][1] = panel_35;
		panels[2][2][2] = panel_34;
	}

	private void updatePanelColors() {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 3; j++) {
				for (int k = 0; k < 3; k++) {
					panels[i][j][k].setBackground(colorMap
							.get(rc.cube[i][j][k]));
				}
			}
		}

	}

	private class tempMouseListener implements MouseListener {

		@Override
		public void mouseClicked(MouseEvent e) {
			// TODO call appropriate rotation method

		}

		@Override
		public void mousePressed(MouseEvent e) {
			// do nothing
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			// do nothing
		}

		@Override
		public void mouseEntered(MouseEvent e) {
			// do nothing
		}

		@Override
		public void mouseExited(MouseEvent e) {
			// do nothing
		}

	}

	public void init() {
		setSize(800, 720);
		setBackground(Color.blue);
		getContentPane().setBackground(Color.LIGHT_GRAY);
	}

}
