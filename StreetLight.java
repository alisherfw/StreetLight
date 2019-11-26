import java.awt.Canvas;
import java.awt.Color;
import java.awt.image.BufferStrategy;
import java.awt.Graphics;
import javax.swing.JFrame;
import java.awt.Font;

public class StreetLight extends JFrame {
	private Canvas canvas = new Canvas();
	public StreetLight() {
		setVisible(true);
		setBounds(0, 0, 600, 400);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		add(canvas);
		canvas.createBufferStrategy(2);
		BufferStrategy bufferstrategy = canvas.getBufferStrategy();

		int i = 0, x = 0;
		while(true) {
			if(x>=35) {
				x = 0;
			}
			Graphics g = bufferstrategy.getDrawGraphics();
			super.paint(g);
			g.setColor(Color.DARK_GRAY);
			g.fillRect(0, 0, getWidth(), getHeight());			
		
			g.setColor(Color.BLACK);
			g.fillRect(190, 0, 120, 310);
			g.setColor(Color.DARK_GRAY);
			g.drawOval(200, 0, 100, 100);
			g.setColor(Color.DARK_GRAY);
			g.drawOval(200, 100, 100, 100);
			g.setColor(Color.DARK_GRAY);
			g.drawOval(200, 200, 100, 100);
			i++;
			if(i == 450) {
				x++;
				i=0;
			}
			if(x>=0 && x<20) {
			g.setColor(Color.RED);
			g.fillOval(200, 0, 100, 100);
			g.setColor(Color.WHITE);
        	g.setFont(new Font("arial", Font.PLAIN, 14));
        	g.drawString("Sekund: " + (20-x),  10, 30);

				if(x>15 && x<20) {
					g.setColor(Color.YELLOW);
					g.fillOval(200, 100, 100, 100);
				}
			}
			if(x>=20 && x<30) {

			g.setColor(Color.WHITE);
        	g.setFont(new Font("arial", Font.PLAIN, 14));
        	g.drawString("Sekund: " + (30-x),  10, 30);
			g.setColor(Color.GREEN);
			g.fillOval(200, 200, 100, 100);
			}

			if(x>=30 && x<35) {
				g.setColor(Color.WHITE);
        		g.setFont(new Font("arial", Font.PLAIN, 14));
        		g.drawString("Sekund: " + "--",  10, 30);
				g.setColor(Color.YELLOW);
				g.fillOval(200, 100, 100, 100);
				g.setColor(Color.YELLOW);
				g.fillOval(200, 100, 100, 100);
			}

			g.dispose();
			bufferstrategy.show();
		}

	}
	
	public static void main(String[] args) {
		new StreetLight();
	}
}