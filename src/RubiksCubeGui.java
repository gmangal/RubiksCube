import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JLabel;
import javax.swing.JPanel;

import net.miginfocom.swing.MigLayout;

public class RubiksCubeGui extends JApplet {
	/**
	 * Create the applet.
	 */
	public RubiksCubeGui() {
		getContentPane()
				.setLayout(
						new MigLayout(
								"",
								"[40][40][40,grow][40,grow][40,grow][40,grow][40,grow][40,grow][40,grow][40,grow][40,grow][40,grow][40,grow][40][40][40]",
								"[40][][-17.00][][40,grow][40][40][40,grow][40,grow][40,grow][40,grow][40][40][40][40][40][40][40]"));
		ImageIcon imgArrowDown = null;
		ImageIcon imgArrowUp = null;
		ImageIcon imgArrowRight = null;
		ImageIcon imgArrowLeft = null;
		try {
			imgArrowUp =
					new ImageIcon(
							ImageIO.read(new File("../images/arrowUp.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			imgArrowDown =
					new ImageIcon(ImageIO.read(new File(
							"../images/arrowDown.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			imgArrowLeft =
					new ImageIcon(ImageIO.read(new File(
							"../images/arrowLeft.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			imgArrowRight =
					new ImageIcon(ImageIO.read(new File(
							"../images/arrowRight.png")));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel panel_55 = new JLabel();
		panel_55 = new JLabel(imgArrowDown);
		getContentPane().add(panel_55, "cell 6 4,grow");

		JLabel panel_72 = new JLabel();
		panel_72 = new JLabel(imgArrowDown);
		getContentPane().add(panel_72, "cell 7 4,grow");

		JLabel panel_57 = new JLabel();
		panel_57 = new JLabel(imgArrowDown);
		getContentPane().add(panel_57, "cell 8 4,grow");

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel, "cell 6 5,grow");

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		getContentPane().add(panel_1, "cell 7 5,grow");

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.WHITE);
		getContentPane().add(panel_6, "cell 8 5,grow");

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		getContentPane().add(panel_2, "cell 6 6,grow");

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		getContentPane().add(panel_3, "cell 7 6,grow");

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(Color.WHITE);
		getContentPane().add(panel_7, "cell 8 6,grow");

		JLabel panel_66 = new JLabel();
		panel_66 = new JLabel(imgArrowDown);
		getContentPane().add(panel_66, "cell 3 7,grow");

		JLabel panel_67 = new JLabel();
		panel_67 = new JLabel(imgArrowDown);
		getContentPane().add(panel_67, "cell 4 7,grow");

		JLabel panel_68 = new JLabel();
		panel_68 = new JLabel(imgArrowDown);
		getContentPane().add(panel_68, "cell 5 7,grow");

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.WHITE);
		getContentPane().add(panel_4, "cell 6 7,grow");

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		getContentPane().add(panel_5, "cell 7 7,grow");

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(Color.WHITE);
		getContentPane().add(panel_8, "cell 8 7,grow");

		JLabel panel_58 = new JLabel();
		panel_58 = new JLabel(imgArrowDown);
		getContentPane().add(panel_58, "cell 9 7,grow");

		JLabel panel_59 = new JLabel();
		panel_59 = new JLabel(imgArrowDown);
		getContentPane().add(panel_59, "cell 10 7,grow");

		JLabel panel_60 = new JLabel();
		panel_60 = new JLabel(imgArrowDown);
		getContentPane().add(panel_60, "cell 11 7,grow");

		JLabel panel_54 = new JLabel();
		panel_54 = new JLabel(imgArrowRight);
		getContentPane().add(panel_54, "cell 2 8,grow");

		JPanel panel_24 = new JPanel();
		panel_24.setBackground(new Color(0, 100, 0));
		getContentPane().add(panel_24, "cell 3 8,grow");

		JPanel panel_25 = new JPanel();
		panel_25.setBackground(new Color(0, 100, 0));
		getContentPane().add(panel_25, "cell 4 8,grow");

		JPanel panel_26 = new JPanel();
		panel_26.setBackground(new Color(0, 100, 0));
		getContentPane().add(panel_26, "cell 5 8,grow");

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(Color.RED);
		getContentPane().add(panel_9, "cell 6 8,grow");

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(Color.RED);
		getContentPane().add(panel_10, "cell 7 8,grow");

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(Color.RED);
		getContentPane().add(panel_11, "cell 8 8,grow");

		JPanel panel_31 = new JPanel();
		panel_31.setBackground(Color.BLUE);
		getContentPane().add(panel_31, "cell 9 8,grow");

		JPanel panel_37 = new JPanel();
		panel_37.setBackground(Color.BLUE);
		getContentPane().add(panel_37, "cell 10 8,grow");

		JPanel panel_34 = new JPanel();
		panel_34.setBackground(Color.BLUE);
		getContentPane().add(panel_34, "cell 11 8,grow");

		JLabel panel_61 = new JLabel();
		panel_61 = new JLabel(imgArrowLeft);
		getContentPane().add(panel_61, "cell 12 8,grow");

		JLabel panel_64 = new JLabel();
		panel_64 = new JLabel(imgArrowDown);
		getContentPane().add(panel_64, "cell 2 9,grow");

		JPanel panel_27 = new JPanel();
		panel_27.setBackground(new Color(0, 100, 0));
		getContentPane().add(panel_27, "cell 3 9,grow");

		JPanel panel_28 = new JPanel();
		panel_28.setBackground(new Color(0, 100, 0));
		getContentPane().add(panel_28, "cell 4 9,grow");

		JPanel panel_29 = new JPanel();
		panel_29.setBackground(new Color(0, 100, 0));
		getContentPane().add(panel_29, "cell 5 9,grow");

		JPanel panel_12 = new JPanel();
		panel_12.setBackground(Color.RED);
		getContentPane().add(panel_12, "cell 6 9,grow");

		JPanel panel_13 = new JPanel();
		panel_13.setBackground(Color.RED);
		getContentPane().add(panel_13, "cell 7 9,grow");

		JPanel panel_14 = new JPanel();
		panel_14.setBackground(Color.RED);
		getContentPane().add(panel_14, "cell 8 9,grow");

		JPanel panel_30 = new JPanel();
		panel_30.setBackground(Color.BLUE);
		getContentPane().add(panel_30, "cell 9 9,grow");

		JPanel panel_38 = new JPanel();
		panel_38.setBackground(Color.BLUE);
		getContentPane().add(panel_38, "cell 10 9,grow");

		JPanel panel_35 = new JPanel();
		panel_35.setBackground(Color.BLUE);
		getContentPane().add(panel_35, "cell 11 9,grow");

		JLabel panel_62 = new JLabel();
		panel_62 = new JLabel(imgArrowLeft);
		getContentPane().add(panel_62, "cell 12 9,grow");

		JLabel panel_65 = new JLabel();
		panel_65 = new JLabel(imgArrowDown);
		getContentPane().add(panel_65, "cell 2 10,grow");

		JPanel panel_23 = new JPanel();
		panel_23.setBackground(new Color(0, 100, 0));
		getContentPane().add(panel_23, "cell 3 10,grow");

		JPanel panel_22 = new JPanel();
		panel_22.setBackground(new Color(0, 100, 0));
		getContentPane().add(panel_22, "cell 4 10,grow");

		JPanel panel_21 = new JPanel();
		panel_21.setBackground(new Color(0, 100, 0));
		getContentPane().add(panel_21, "cell 5 10,grow");

		JPanel panel_15 = new JPanel();
		panel_15.setBackground(Color.RED);
		getContentPane().add(panel_15, "cell 6 10,grow");

		JPanel panel_16 = new JPanel();
		panel_16.setBackground(Color.RED);
		getContentPane().add(panel_16, "cell 7 10,grow");

		JPanel panel_17 = new JPanel();
		panel_17.setBackground(Color.RED);
		getContentPane().add(panel_17, "cell 8 10,grow");

		JPanel panel_32 = new JPanel();
		panel_32.setBackground(Color.BLUE);
		getContentPane().add(panel_32, "cell 9 10,grow");

		JPanel panel_36 = new JPanel();
		panel_36.setBackground(Color.BLUE);
		getContentPane().add(panel_36, "cell 10 10,grow");

		JPanel panel_33 = new JPanel();
		panel_33.setBackground(Color.BLUE);
		getContentPane().add(panel_33, "cell 11 10,grow");

		JLabel panel_63 = new JLabel();
		panel_63 = new JLabel(imgArrowLeft);
		getContentPane().add(panel_63, "cell 12 10,grow");

		JPanel panel_18 = new JPanel();
		panel_18.setBackground(Color.YELLOW);
		getContentPane().add(panel_18, "cell 6 11,grow");

		JPanel panel_19 = new JPanel();
		panel_19.setBackground(Color.YELLOW);
		getContentPane().add(panel_19, "cell 7 11,grow");

		JPanel panel_20 = new JPanel();
		panel_20.setBackground(Color.YELLOW);
		getContentPane().add(panel_20, "cell 8 11,grow");

		JPanel panel_39 = new JPanel();
		panel_39.setBackground(Color.YELLOW);
		getContentPane().add(panel_39, "cell 6 12,grow");

		JPanel panel_40 = new JPanel();
		panel_40.setBackground(Color.YELLOW);
		getContentPane().add(panel_40, "cell 7 12,grow");

		JPanel panel_41 = new JPanel();
		panel_41.setBackground(Color.YELLOW);
		getContentPane().add(panel_41, "cell 8 12,grow");

		JPanel panel_42 = new JPanel();
		panel_42.setBackground(Color.YELLOW);
		getContentPane().add(panel_42, "cell 6 13,grow");

		JPanel panel_44 = new JPanel();
		panel_44.setBackground(Color.YELLOW);
		getContentPane().add(panel_44, "cell 7 13,grow");

		JPanel panel_43 = new JPanel();
		panel_43.setBackground(Color.YELLOW);
		getContentPane().add(panel_43, "cell 8 13,grow");

		JPanel panel_45 = new JPanel();
		panel_45.setBackground(Color.ORANGE);
		getContentPane().add(panel_45, "cell 6 14,grow");

		JPanel panel_46 = new JPanel();
		panel_46.setBackground(Color.ORANGE);
		getContentPane().add(panel_46, "cell 7 14,grow");

		JPanel panel_47 = new JPanel();
		panel_47.setBackground(Color.ORANGE);
		getContentPane().add(panel_47, "cell 8 14,grow");

		JPanel panel_48 = new JPanel();
		panel_48.setBackground(Color.ORANGE);
		getContentPane().add(panel_48, "cell 6 15,grow");

		JPanel panel_49 = new JPanel();
		panel_49.setBackground(Color.ORANGE);
		getContentPane().add(panel_49, "cell 7 15,grow");

		JPanel panel_50 = new JPanel();
		panel_50.setBackground(Color.ORANGE);
		getContentPane().add(panel_50, "cell 8 15,grow");

		JPanel panel_51 = new JPanel();
		panel_51.setBackground(Color.ORANGE);
		getContentPane().add(panel_51, "cell 6 16,grow");

		JPanel panel_52 = new JPanel();
		panel_52.setBackground(Color.ORANGE);
		getContentPane().add(panel_52, "cell 7 16,grow");

		JPanel panel_53 = new JPanel();
		panel_53.setBackground(Color.ORANGE);
		getContentPane().add(panel_53, "cell 8 16,grow");

		JLabel panel_69 = new JLabel();
		panel_69 = new JLabel(imgArrowUp);
		getContentPane().add(panel_69, "cell 6 17,grow");

		JLabel panel_70 = new JLabel();
		panel_70 = new JLabel(imgArrowUp);
		getContentPane().add(panel_70, "cell 7 17,grow");

		JLabel panel_71 = new JLabel();
		panel_71 = new JLabel(imgArrowUp);
		getContentPane().add(panel_71, "cell 8 17,grow");

	}

	public void init() {
		setSize(800, 720);
		setBackground(Color.blue);
		getContentPane().setBackground(Color.LIGHT_GRAY);
	}

	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		try {
			g.drawImage(ImageIO.read(new File("images/arrowDown.png")), 0, 0,
					null);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
