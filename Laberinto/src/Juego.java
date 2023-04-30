import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Juego  extends JFrame{
	public int player_x=10, player_y=10,last_pressed;
	public Juego() {
		
		this.setVisible(true);
		this.setSize(655,590);
		this.setTitle("Ventana Perrona");
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//PANEL DE FONDO
		JPanel panelsito = new JPanel();
		panelsito.setSize(650,550);
		panelsito.setOpaque(true);
		panelsito.setLayout(new BorderLayout());
		panelsito.setBackground(Color.decode("#FFFFFF"));
		this.add(panelsito);
		
		//PANEL CENTRAL
		JPanel panelsitoCentral = new JPanel();
		panelsitoCentral.setOpaque(true);
		panelsitoCentral.setSize(650,590);
		panelsitoCentral.setLayout(new BorderLayout());
		panelsito.add(panelsitoCentral,BorderLayout.CENTER);
		
		///////////////ACA SE DIBUJAN LOS GRÁFICOS////////////////
		panelsitoCentral.add(new MyGraphics());

		//PANEL ABAJO
		JPanel panelAb = new JPanel();
		panelAb.setVisible(true);
		panelAb.setOpaque(true);
		panelAb.setLayout(new GridLayout());
		panelsito.add(panelAb,BorderLayout.SOUTH);
		
		JLabel eb = new JLabel(" ");
		eb.setOpaque(true);
		eb.setVisible(true);
		eb.setBackground(Color.decode("#FFFFFF"));
		panelAb.add(eb);
		
		JButton reinicio = new JButton("holaaa");
		reinicio.setVisible(true);
		reinicio.setOpaque(true);
		reinicio.setBackground(Color.gray);
		panelAb.add(reinicio);
		
		JLabel eb1 = new JLabel(" ");
		eb1.setOpaque(true);
		eb1.setVisible(true);
		eb1.setBackground(Color.decode("#FFFFFF"));
		panelAb.add(eb1);
		
		panelsitoCentral.setFocusable(true);
		panelsitoCentral.requestFocus();
		
		panelsitoCentral.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				//System.out.println(e.getKeyCode());
				last_pressed = e.getKeyCode();
				
				if(last_pressed==87 && player_y>10) {
					player_y -= 5;
				}
				if(last_pressed==83 && player_y<505) {
					player_y += 5;
				}
				if(last_pressed==68 && player_x<620) {
					player_x += 5;
				}
				if(last_pressed==65 && player_x>10) {
					player_x -= 5;
				}
				repaint();
				revalidate();
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
		});
		
		repaint();
		revalidate();
	}
	
	public class Rect{
		int x=0;
		int y=0;
		int w=0;
		int h=0;
		Color c = Color.black;
		
		Rect(int x, int y, int w, int h, Color c){
			this.x=x;
			this.y=y;
			this.w=w;
			this.h=h;
			this.c=c;
		}
		
		public Boolean colision(Rect target) {
			if(this.x<target.x + target.w && this.x + this.w > target.x && 
				this.y<target.y + target.h && this.y + this.h > target.y) {
				return true;
			}
			return false;
		}
		
	}
	
	public class MyGraphics extends JComponent{
		private static final long serialVersionUID = 1L;
		public MyGraphics() {
			setPreferredSize(new Dimension(650,550));
		}
		
	    public void paintComponent(Graphics g){
	    super.paintComponents(g);
	    
	    ////////////////////BORDES DEL MAPA////////////////////
	    Rect borde1 = new Rect(0, 0, 640, 10, Color.black);
	    g.setColor(borde1.c);
		g.fillRect(borde1.x,borde1.y,borde1.w,borde1.h);
		
	    Rect borde2 = new Rect(0, 0, 10, 540, Color.black);
	    g.setColor(borde2.c);
		g.fillRect(borde2.x,borde2.y,borde2.w,borde2.h);
		
		Rect borde3 = new Rect(630, 0, 10, 540, Color.black);
		g.setColor(borde3.c);
		g.fillRect(borde3.x,borde3.y,borde3.w,borde3.h);
		
		Rect borde4 = new Rect(0, 515, 640, 10, Color.black);
		g.setColor(borde4.c);
		g.fillRect(borde4.x,borde4.y,borde4.w,borde4.h);
		
		////////////////////SE DEFINE EL JUGADOR////////////////////
	    Rect jugador = new Rect(player_x, player_y, 10, 10,Color.red);
	    g.setColor(jugador.c);
		g.fillRect(jugador.x,jugador.y,jugador.w,jugador.h);
		
		////////////////////PAREDES EN EL MAPA////////////////////
		Rect pared1 = new Rect(10,35,100,5,Color.decode("#D55400"));
		g.setColor(pared1.c);
		g.fillRect(pared1.x,pared1.y,pared1.w,pared1.h);
		
		Rect pared2 = new Rect(130,10,5,25,Color.decode("#D55400"));
		g.setColor(pared2.c);
		g.fillRect(pared2.x,pared2.y,pared2.w,pared2.h);
		
		Rect pared3 = new Rect(180,10,5,25,Color.decode("#D55400"));
		g.setColor(pared3.c);
		g.fillRect(pared3.x,pared3.y,pared3.w,pared3.h);
		
		Rect pared4 = new Rect(155,35,5,30,Color.decode("#D55400"));
		g.setColor(pared4.c);
		g.fillRect(pared4.x,pared4.y,pared4.w,pared4.h);
		
		Rect pared5 = new Rect(110,60,100,5,Color.decode("#D55400"));
		g.setColor(pared5.c);
		g.fillRect(pared5.x,pared5.y,pared5.w,pared5.h);
		
		Rect pared6 = new Rect(105,40,5,25,Color.decode("#D55400"));
		g.setColor(pared6.c);
		g.fillRect(pared6.x,pared6.y,pared6.w,pared6.h);
		
		Rect pared7 = new Rect(205,40,5,25,Color.decode("#D55400"));
		g.setColor(pared7.c);
		g.fillRect(pared7.x,pared7.y,pared7.w,pared7.h);
		
		Rect pared8 = new Rect(205,35,110,5,Color.decode("#D55400"));
		g.setColor(pared8.c);
		g.fillRect(pared8.x,pared8.y,pared8.w,pared8.h);
		
		Rect pared9 = new Rect(335,10,5,55,Color.decode("#D55400"));
		g.setColor(pared9.c);
		g.fillRect(pared9.x,pared9.y,pared9.w,pared9.h);
		
		Rect pared10 = new Rect(275,60,65,5,Color.decode("#D55400"));
		g.setColor(pared10.c);
		g.fillRect(pared10.x,pared10.y,pared10.w,pared10.h);
		
		Rect pared11 = new Rect(240,40,5,25,Color.decode("#D55400"));
		g.setColor(pared11.c);
		g.fillRect(pared11.x,pared11.y,pared11.w,pared11.h);
		
		Rect pared12 = new Rect(275,65,5,25,Color.decode("#D55400"));
		g.setColor(pared12.c);
		g.fillRect(pared12.x,pared12.y,pared12.w,pared12.h);
		
		Rect pared13 = new Rect(155,85,125,5,Color.decode("#D55400"));
		g.setColor(pared13.c);
		g.fillRect(pared13.x,pared13.y,pared13.w,pared13.h);
		
		Rect pared14 = new Rect(130,65,5,50,Color.decode("#D55400"));
		g.setColor(pared14.c);
		g.fillRect(pared14.x,pared14.y,pared14.w,pared14.h);
		
		Rect pared15 = new Rect(130,110,55,5,Color.decode("#D55400"));
		g.setColor(pared15.c);
		g.fillRect(pared15.x,pared15.y,pared15.w,pared15.h);
		
		Rect pared16 = new Rect(180,115,5,25,Color.decode("#D55400"));
		g.setColor(pared16.c);
		g.fillRect(pared16.x,pared16.y,pared16.w,pared16.h);
		
		Rect pared17 = new Rect(130,135,55,5,Color.decode("#D55400"));
		g.setColor(pared17.c);
		g.fillRect(pared17.x,pared17.y,pared17.w,pared17.h);
		
		Rect pared18 = new Rect(205,85,5,75,Color.decode("#D55400"));
		g.setColor(pared18.c);
		g.fillRect(pared18.x,pared18.y,pared18.w,pared18.h);
		
		Rect pared19 = new Rect(105,160,105,5,Color.decode("#D55400"));
		g.setColor(pared19.c);
		g.fillRect(pared19.x,pared19.y,pared19.w,pared19.h);
		
		Rect pared20 = new Rect(105,110,5,55,Color.decode("#D55400"));
		g.setColor(pared20.c);
		g.fillRect(pared20.x,pared20.y,pared20.w,pared20.h);
		
		Rect pared21 = new Rect(75,85,55,5,Color.decode("#D55400"));
		g.setColor(pared21.c);
		g.fillRect(pared21.x,pared21.y,pared21.w,pared21.h);
		
		Rect pared22 = new Rect(50,60,25,5,Color.decode("#D55400"));
		g.setColor(pared22.c);
		g.fillRect(pared22.x,pared22.y,pared22.w,pared22.h);
		
		Rect pared23 = new Rect(50,60,5,55,Color.decode("#D55400"));
		g.setColor(pared23.c);
		g.fillRect(pared23.x,pared23.y,pared23.w,pared23.h);
		
		Rect pared24 = new Rect(50,110,60,5,Color.decode("#D55400"));
		g.setColor(pared24.c);
		g.fillRect(pared24.x,pared24.y,pared24.w,pared24.h);
		
		Rect pared25 = new Rect(75,110,5,80,Color.decode("#D55400"));
		g.setColor(pared25.c);
		g.fillRect(pared25.x,pared25.y,pared25.w,pared25.h);
		
		Rect pared26 = new Rect(10,135,40,5,Color.decode("#D55400"));
		g.setColor(pared26.c);
		g.fillRect(pared26.x,pared26.y,pared26.w,pared26.h);
		
		Rect pared27 = new Rect(50,110,55,5,Color.decode("#D55400"));
		g.setColor(pared27.c);
		g.fillRect(pared27.x,pared27.y,pared27.w,pared27.h);
		
		Rect pared28 = new Rect(45,140,5,70,Color.decode("#D55400"));
		g.setColor(pared28.c);
		g.fillRect(pared28.x,pared28.y,pared28.w,pared28.h);
		
		Rect pared29 = new Rect(45,210,140,5,Color.decode("#D55400"));
		g.setColor(pared29.c);
		g.fillRect(pared29.x,pared29.y,pared29.w,pared29.h);
		
		Rect pared30 = new Rect(80,185,25,5,Color.decode("#D55400"));
		g.setColor(pared30.c);
		g.fillRect(pared30.x,pared30.y,pared30.w,pared30.h);
		
		Rect pared31 = new Rect(130,185,5,25,Color.decode("#D55400"));
		g.setColor(pared31.c);
		g.fillRect(pared31.x,pared31.y,pared31.w,pared31.h);
		
		Rect pared32 = new Rect(155,165,5,25,Color.decode("#D55400"));
		g.setColor(pared32.c);
		g.fillRect(pared32.x,pared32.y,pared32.w,pared32.h);
		
		Rect pared33 = new Rect(160,185,50,5,Color.decode("#D55400"));
		g.setColor(pared33.c);
		g.fillRect(pared33.x,pared33.y,pared33.w,pared33.h);
		
		Rect pared34 = new Rect(205,185,5,105,Color.decode("#D55400"));
		g.setColor(pared34.c);
		g.fillRect(pared34.x,pared34.y,pared34.w,pared34.h);
		
		Rect pared35 = new Rect(180,210,5,25,Color.decode("#D55400"));
		g.setColor(pared35.c);
		g.fillRect(pared35.x,pared35.y,pared35.w,pared35.h);
		
		Rect pared36 = new Rect(155,255,55,5,Color.decode("#D55400"));
		g.setColor(pared36.c);
		g.fillRect(pared36.x,pared36.y,pared36.w,pared36.h);
		
		Rect pared37 = new Rect(155,235,5,55,Color.decode("#D55400"));
		g.setColor(pared37.c);
		g.fillRect(pared37.x,pared37.y,pared37.w,pared37.h);
		
		Rect pared38 = new Rect(105,235,55,5,Color.decode("#D55400"));
		g.setColor(pared38.c);
		g.fillRect(pared38.x,pared38.y,pared38.w,pared38.h);
		
		Rect pared39 = new Rect(75,210,5,55,Color.decode("#D55400"));
		g.setColor(pared39.c);
		g.fillRect(pared39.x,pared39.y,pared39.w,pared39.h);
		
		Rect pared40 = new Rect(45,235,5,30,Color.decode("#D55400"));
		g.setColor(pared40.c);
		g.fillRect(pared40.x,pared40.y,pared40.w,pared40.h);
		
		Rect pared41 = new Rect(50,260,55,5,Color.decode("#D55400"));
		g.setColor(pared41.c);
		g.fillRect(pared41.x,pared41.y,pared41.w,pared41.h);
		
		Rect pared42 = new Rect(105,260,5,80,Color.decode("#D55400"));
		g.setColor(pared42.c);
		g.fillRect(pared42.x,pared42.y,pared42.w,pared42.h);
		
		Rect pared43 = new Rect(130,235,5,185,Color.decode("#D55400"));
		g.setColor(pared43.c);
		g.fillRect(pared43.x,pared43.y,pared43.w,pared43.h);
		
	    }
	}
}
