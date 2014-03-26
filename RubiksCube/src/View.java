import java.awt.*;

import javax.swing.*;

public class View extends JPanel {
	private Cube rubik;

	public View(Cube cube) {
		rubik = cube;
	}

	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// up
		int[] a = { 360, 400, 440, 400 };
		int[] b = { 55, 15, 55, 95 };
		g.setColor(find(rubik.getUp()[0]));
		g.fillPolygon(a, b, 4);

		for(int i=0;i<4;i++){
			a[i] = a[i]-=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]+=40;
		}
		g.setColor(find(rubik.getUp()[3]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]+=(80);
		}
		g.setColor(find(rubik.getUp()[1]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]+=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]+=40;
		}
		g.setColor(find(rubik.getUp()[2]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]-=(80);
		}
		g.setColor(find(rubik.getUp()[4]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]-=(80);
		}
		g.setColor(find(rubik.getUp()[6]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]+=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]+=40;
		}
		g.setColor(find(rubik.getUp()[7]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]+=(80);
		}
		g.setColor(find(rubik.getUp()[5]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]-=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]+=40;
		}
		g.setColor(find(rubik.getUp()[8]));
		g.fillPolygon(a, b, 4);

		// front
		for(int i=0;i<4;i++){
			a[i] = a[i]-=(120);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]-=40;
		}
		a[0]+=40;
		b[0]+=40;
		a[3]+=40;
		b[3]+=40;
		
		g.setColor(find(rubik.getFront()[0]));
		g.fillPolygon(a, b, 4);

		
		for(int i=0;i<4;i++){
			b[i] = b[i]+=80;
		}
		g.setColor(find(rubik.getFront()[3]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]+=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]-=40;
		}
		g.setColor(find(rubik.getFront()[1]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]+=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]+=40;
		}
		g.setColor(find(rubik.getFront()[2]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]-=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]+=(40);
		}
		g.setColor(find(rubik.getFront()[4]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]-=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]+=(40);
		}
		g.setColor(find(rubik.getFront()[6]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]+=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]+=40;
		}
		g.setColor(find(rubik.getFront()[7]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]+=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]-=40;
		}
		g.setColor(find(rubik.getFront()[5]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			b[i] = b[i]+=80;
		}
		g.setColor(find(rubik.getFront()[8]));
		g.fillPolygon(a, b, 4);
		
		// right
		for(int i=0;i<4;i++){
			a[i] = a[i]+=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]-=120;
		}
		
		b[2]-=80;
		b[3]-=80;
		
		g.setColor(find(rubik.getRight()[0]));
		g.fillPolygon(a, b, 4);

		
		for(int i=0;i<4;i++){
			b[i] = b[i]+=80;
		}
		g.setColor(find(rubik.getRight()[3]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]+=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]-=120;
		}
		g.setColor(find(rubik.getRight()[1]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]+=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]-=40;
		}
		g.setColor(find(rubik.getRight()[2]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]-=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]+=(120);
		}
		g.setColor(find(rubik.getRight()[4]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]-=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]+=(120);
		}
		g.setColor(find(rubik.getRight()[6]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]+=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]-=40;
		}
		g.setColor(find(rubik.getRight()[7]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			a[i] = a[i]+=(40);
		}
		for(int i=0;i<4;i++){
			b[i] = b[i]-=120;
		}
		g.setColor(find(rubik.getRight()[5]));
		g.fillPolygon(a, b, 4);
		
		for(int i=0;i<4;i++){
			b[i] = b[i]+=80;
		}
		g.setColor(find(rubik.getRight()[8]));
		g.fillPolygon(a, b, 4);
		
		//outline
		g.setColor(Color.black);
		g.drawLine(400,15,520,135);
		g.drawLine(360,55,480,175);
		g.drawLine(320,95,440,215);
		g.drawLine(280,135,400,255);
		
		g.drawLine(400,15,280,135);
		g.drawLine(440,55,320,175);
		g.drawLine(480,95,360,215);
		g.drawLine(520,135,400,255);
		
		g.drawLine(280,135,280,375);
		g.drawLine(320,175,320,415);
		g.drawLine(360,215,360,455);
		g.drawLine(400,255,400,495);
		
		g.drawLine(440,215,440,455);
		g.drawLine(480,175,480,415);
		g.drawLine(520,135,520,375);
		
		g.drawLine(280,215,400,335);
		g.drawLine(280,295,400,415);
		g.drawLine(280,375,400,495);
		
		g.drawLine(520,215,400,335);
		g.drawLine(520,295,400,415);
		g.drawLine(520,375,400,495);
	}

	
	public Color find(char c) {
		Color color = null;
		switch (c) {
		case 'W':
			color = Color.WHITE;
			break;
		case 'Y':
			color = Color.YELLOW;
			break;
		case 'G':
			color = Color.GREEN;
			break;
		case 'B':
			color = Color.BLUE;
			break;
		case 'R':
			color = Color.RED;
			break;
		case 'O':
			color = new Color(255, 150, 0);
			break;
		}

		return color;
	}
}
