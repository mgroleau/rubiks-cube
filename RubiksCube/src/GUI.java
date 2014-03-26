import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class GUI extends JFrame {
	private Cube rubik;
	private View view;

	private final int WINDOW_WIDTH = 900;
	private final int WINDOW_HEIGHT = 600;

	private JButton x, y, z, u, d, l, r, f, b, m, scramble, solve;
	private JCheckBox ccw;
	private ButtonHandler buttonHandler = new ButtonHandler();

	private JPanel cubeDisplay, buttonDisplay;
	private JPanel[] display = new JPanel[9];
	
	private SwingWorker<Boolean, Void> scrambler;

	public GUI(Cube cube) {
		rubik = cube;
		view = new View(rubik);

		
			
		setTitle("Rubik's Cube");
		setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		x = new JButton("X");
		y = new JButton("Y");
		z = new JButton("Z");
		u = new JButton("U");
		d = new JButton("D");
		l = new JButton("L");
		r = new JButton("R");
		f = new JButton("F");
		b = new JButton("B");
		m = new JButton("M");
		scramble = new JButton("Scramble");
		solve = new JButton("Solve");
		x.addActionListener(buttonHandler);
		y.addActionListener(buttonHandler);
		z.addActionListener(buttonHandler);
		u.addActionListener(buttonHandler);
		d.addActionListener(buttonHandler);
		l.addActionListener(buttonHandler);
		r.addActionListener(buttonHandler);
		f.addActionListener(buttonHandler);
		b.addActionListener(buttonHandler);
		m.addActionListener(buttonHandler);
		scramble.addActionListener(buttonHandler);
		solve.addActionListener(buttonHandler);
		ccw = new JCheckBox("Counter Clockwise");

		buttonDisplay = new JPanel();
		cubeDisplay = new JPanel();
		buttonDisplay.setLayout(new GridLayout(14, 1));
		cubeDisplay.setLayout(new GridLayout(1, 1));
		cubeDisplay.add(view);

		buttonDisplay.add(x);
		buttonDisplay.add(y);
		buttonDisplay.add(z);
		buttonDisplay.add(u);
		buttonDisplay.add(d);
		buttonDisplay.add(l);
		buttonDisplay.add(r);
		buttonDisplay.add(f);
		buttonDisplay.add(b);
		buttonDisplay.add(m);
		buttonDisplay.add(scramble);
		buttonDisplay.add(solve);
		buttonDisplay.add(ccw);

		/*
		 * for (int i = 0; i < 9; i++) { display[i] = new JPanel();
		 * display[i].setBorder(BorderFactory.createEtchedBorder());
		 * display[i].setBackground(new Color(255,150,0));
		 * cubeDisplay.add(display[i]); }
		 */

		setLayout(new BorderLayout());
		add(cubeDisplay, BorderLayout.CENTER);
		add(buttonDisplay, BorderLayout.EAST);
		setVisible(true);
	}

	private class ButtonHandler implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String actionCommand = e.getActionCommand();
			char[] up = rubik.getUp();
			char[] down = rubik.getDown();
			char[] left = rubik.getLeft();
			char[] right = rubik.getRight();
			char[] front = rubik.getFront();
			char[] back = rubik.getBack();
			char temp1, temp2, temp3;

			if (actionCommand == "X") {
				r.doClick();
				l.doClick();
				l.doClick();
				l.doClick();
				m.doClick();
			}

			if (actionCommand == "Y") {
				if (ccw.isSelected()) {
					rubik.setLeft(back);
					rubik.setRight(front);
					rubik.setFront(left);
					rubik.setBack(right);
					rubik.setDown(Cube.rotate(down, 0));
					rubik.setUp(Cube.rotate(up, 1));
				} else {
					rubik.setLeft(front);
					rubik.setRight(back);
					rubik.setFront(right);
					rubik.setBack(left);
					rubik.setDown(Cube.rotate(down, 1));
					rubik.setUp(Cube.rotate(up, 0));
				}
			}

			if (actionCommand == "Z") {
				if (ccw.isSelected()) {
					y.doClick();
					x.doClick();
					y.doClick();
					y.doClick();
					y.doClick();
				} else {
					y.doClick();
					x.doClick();
					x.doClick();
					x.doClick();
					y.doClick();
					y.doClick();
					y.doClick();
				}
			}

			if (actionCommand == "U") {
				if (ccw.isSelected()) {
					up = Cube.rotate(up, 1);
					temp1 = right[0];
					temp2 = right[1];
					temp3 = right[2];
					right[0] = front[0];
					right[1] = front[1];
					right[2] = front[2];
					front[0] = left[0];
					front[1] = left[1];
					front[2] = left[2];
					left[0] = back[0];
					left[1] = back[1];
					left[2] = back[2];
					back[0] = temp1;
					back[1] = temp2;
					back[2] = temp3;
					rubik.setUp(up);
					rubik.setFront(front);
					rubik.setBack(back);
					rubik.setLeft(left);
					rubik.setRight(right);
				} else {
					up = Cube.rotate(up, 0);
					temp1 = left[0];
					temp2 = left[1];
					temp3 = left[2];
					left[0] = front[0];
					left[1] = front[1];
					left[2] = front[2];
					front[0] = right[0];
					front[1] = right[1];
					front[2] = right[2];
					right[0] = back[0];
					right[1] = back[1];
					right[2] = back[2];
					back[0] = temp1;
					back[1] = temp2;
					back[2] = temp3;
					rubik.setUp(up);
					rubik.setFront(front);
					rubik.setBack(back);
					rubik.setLeft(left);
					rubik.setRight(right);
				}
			}

			if (actionCommand == "D") {
				if (ccw.isSelected()) {
					down = Cube.rotate(down, 1);
					temp1 = left[6];
					temp2 = left[7];
					temp3 = left[8];
					left[6] = front[6];
					left[7] = front[7];
					left[8] = front[8];
					front[6] = right[6];
					front[7] = right[7];
					front[8] = right[8];
					right[6] = back[6];
					right[7] = back[7];
					right[8] = back[8];
					back[6] = temp1;
					back[7] = temp2;
					back[8] = temp3;
					rubik.setDown(down);
					rubik.setFront(front);
					rubik.setBack(back);
					rubik.setLeft(left);
					rubik.setRight(right);
				} else {
					down = Cube.rotate(down, 0);
					temp1 = right[6];
					temp2 = right[7];
					temp3 = right[8];
					right[6] = front[6];
					right[7] = front[7];
					right[8] = front[8];
					front[6] = left[6];
					front[7] = left[7];
					front[8] = left[8];
					left[6] = back[6];
					left[7] = back[7];
					left[8] = back[8];
					back[6] = temp1;
					back[7] = temp2;
					back[8] = temp3;
					rubik.setDown(down);
					rubik.setFront(front);
					rubik.setBack(back);
					rubik.setLeft(left);
					rubik.setRight(right);
				}
			}

			if (actionCommand == "F") {
				if (ccw.isSelected()) {
					front = Cube.rotate(front, 1);
					temp1 = right[0];
					temp2 = right[3];
					temp3 = right[6];
					right[0] = down[2];
					right[3] = down[1];
					right[6] = down[0];
					down[0] = left[2];
					down[1] = left[5];
					down[2] = left[8];
					left[2] = up[8];
					left[5] = up[7];
					left[8] = up[6];
					up[6] = temp1;
					up[7] = temp2;
					up[8] = temp3;
					rubik.setFront(front);
					rubik.setUp(up);
					rubik.setDown(down);
					rubik.setLeft(left);
					rubik.setRight(right);
				} else {
					front = Cube.rotate(front, 0);
					temp1 = left[8];
					temp2 = left[5];
					temp3 = left[2];
					left[2] = down[0];
					left[5] = down[1];
					left[8] = down[2];
					down[0] = right[6];
					down[1] = right[3];
					down[2] = right[0];
					right[0] = up[6];
					right[3] = up[7];
					right[6] = up[8];
					up[6] = temp1;
					up[7] = temp2;
					up[8] = temp3;
					rubik.setFront(front);
					rubik.setUp(up);
					rubik.setDown(down);
					rubik.setLeft(left);
					rubik.setRight(right);
				}
			}

			if (actionCommand == "B") {
				if (ccw.isSelected()) {
					back = Cube.rotate(back, 1);
					temp1 = left[6];
					temp2 = left[3];
					temp3 = left[0];
					left[0] = down[6];
					left[3] = down[7];
					left[6] = down[8];
					down[6] = right[8];
					down[7] = right[5];
					down[8] = right[2];
					right[2] = up[0];
					right[5] = up[1];
					right[8] = up[2];
					up[0] = temp1;
					up[1] = temp2;
					up[2] = temp3;
					rubik.setBack(back);
					rubik.setUp(up);
					rubik.setDown(down);
					rubik.setLeft(left);
					rubik.setRight(right);
				} else {
					back = Cube.rotate(back, 0);
					temp1 = right[2];
					temp2 = right[5];
					temp3 = right[8];
					right[2] = down[8];
					right[5] = down[7];
					right[8] = down[6];
					down[6] = left[0];
					down[7] = left[3];
					down[8] = left[6];
					left[0] = up[2];
					left[3] = up[1];
					left[6] = up[0];
					up[0] = temp1;
					up[1] = temp2;
					up[2] = temp3;
					rubik.setBack(back);
					rubik.setUp(up);
					rubik.setDown(down);
					rubik.setLeft(left);
					rubik.setRight(right);
				}
			}

			if (actionCommand == "L") {
				if (ccw.isSelected()) {
					left = Cube.rotate(left, 1);
					temp1 = down[0];
					temp2 = down[3];
					temp3 = down[6];
					down[0] = back[8];
					down[3] = back[5];
					down[6] = back[2];
					back[8] = up[0];
					back[5] = up[3];
					back[2] = up[6];
					up[0] = front[0];
					up[3] = front[3];
					up[6] = front[6];
					front[0] = temp1;
					front[3] = temp2;
					front[6] = temp3;
					rubik.setLeft(left);
					rubik.setUp(up);
					rubik.setFront(front);
					rubik.setBack(back);
					rubik.setDown(down);
				} else {
					left = Cube.rotate(left, 0);
					temp1 = up[0];
					temp2 = up[3];
					temp3 = up[6];
					up[0] = back[8];
					up[3] = back[5];
					up[6] = back[2];
					back[8] = down[0];
					back[5] = down[3];
					back[2] = down[6];
					down[0] = front[0];
					down[3] = front[3];
					down[6] = front[6];
					front[0] = temp1;
					front[3] = temp2;
					front[6] = temp3;
					rubik.setLeft(left);
					rubik.setUp(up);
					rubik.setFront(front);
					rubik.setBack(back);
					rubik.setDown(down);
				}
			}

			if (actionCommand == "R") {
				if (ccw.isSelected()) {
					right = Cube.rotate(right, 1);
					temp1 = up[2];
					temp2 = up[5];
					temp3 = up[8];
					up[2] = back[6];
					up[5] = back[3];
					up[8] = back[0];
					back[6] = down[2];
					back[3] = down[5];
					back[0] = down[8];
					down[2] = front[2];
					down[5] = front[5];
					down[8] = front[8];
					front[2] = temp1;
					front[5] = temp2;
					front[8] = temp3;
					rubik.setRight(right);
					rubik.setUp(up);
					rubik.setFront(front);
					rubik.setBack(back);
					rubik.setDown(down);
				} else {
					right = Cube.rotate(right, 0);
					temp1 = down[2];
					temp2 = down[5];
					temp3 = down[8];
					down[2] = back[6];
					down[5] = back[3];
					down[8] = back[0];
					back[6] = up[2];
					back[3] = up[5];
					back[0] = up[8];
					up[2] = front[2];
					up[5] = front[5];
					up[8] = front[8];
					front[2] = temp1;
					front[5] = temp2;
					front[8] = temp3;
					rubik.setRight(right);
					rubik.setUp(up);
					rubik.setFront(front);
					rubik.setBack(back);
					rubik.setDown(down);
				}
			}

			if (actionCommand == "M") {
				if (ccw.isSelected()) {
					temp1 = up[1];
					temp2 = up[4];
					temp3 = up[7];
					up[1] = back[7];
					up[4] = back[4];
					up[7] = back[1];
					back[7] = down[1];
					back[4] = down[4];
					back[1] = down[7];
					down[1] = front[1];
					down[4] = front[4];
					down[7] = front[7];
					front[1] = temp1;
					front[4] = temp2;
					front[7] = temp3;
					rubik.setUp(up);
					rubik.setFront(front);
					rubik.setBack(back);
					rubik.setDown(down);
				} else {
					temp1 = down[1];
					temp2 = down[4];
					temp3 = down[7];
					down[1] = back[7];
					down[4] = back[4];
					down[7] = back[1];
					back[7] = up[1];
					back[4] = up[4];
					back[1] = up[7];
					up[1] = front[1];
					up[4] = front[4];
					up[7] = front[7];
					front[1] = temp1;
					front[4] = temp2;
					front[7] = temp3;
					rubik.setUp(up);
					rubik.setFront(front);
					rubik.setBack(back);
					rubik.setDown(down);
				}
			}

			if (actionCommand == "Scramble") {
				scrambler = new SwingWorker<Boolean, Void>() {
					public Boolean doInBackground() {
						for (int i = 0; i < 25; i++) {
							int j = (int) (Math.random() * 6) ;
							switch (j) {
							case 0:
								r.doClick();
								break;
							case 1:
								l.doClick();
								break;
							case 2:
								u.doClick();
								break;
							case 3:
								d.doClick();
								break;
							case 4:
								f.doClick();
								break;
							case 5:
								b.doClick();
								break;
							}
							try {
								Thread.sleep(100);
							} catch (InterruptedException e1) {

							}
						}
						return true;
					}

					public void done() {
						
					}
				};
				
				scrambler.execute();
			}
			if (actionCommand == "Solve") {
				rubik.reset();
			}
			view.repaint();	
		}
	}
}
