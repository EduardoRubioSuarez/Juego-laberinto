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
	public int player_x=100, player_y=280,last_pressed=0;
	public Juego() {
		
		this.setVisible(true);
		this.setSize(650,590);
		this.setTitle("Ventana Perrona");
		this.setLayout(null);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//PANEL DE FONDO
		JPanel panelsito = new JPanel();
		panelsito.setBounds(0,0,650,550);
		panelsito.setOpaque(true);
		panelsito.setLayout(new BorderLayout());
		panelsito.setBackground(Color.decode("#000000"));
		this.add(panelsito);

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
		
		
		///////////////ACA SE DIBUJAN LOS GRÁFICOS////////////////
		panelsito.add(new MyGraphics());
		
		panelsito.setFocusable(true);
		panelsito.requestFocus();
		
		panelsito.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				System.out.println(e.getKeyCode());
				last_pressed = e.getKeyCode();
				
				if(last_pressed==87 && player_y>0) {
					player_y -= 10;
				}
				if(last_pressed==83 && player_y<480) {
					player_y += 10;
				}
				if(last_pressed==68 && player_x<600) {
					player_x += 10;
				}
				if(last_pressed==65 && player_x>0) {
					player_x -= 10;
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
	    
	    Rect fondo = new Rect(10, 10, 615, 500,Color.white);
	    g.setColor(fondo.c);
		g.fillRect(fondo.x,fondo.y,fondo.w,fondo.h);
	    
	    
	    Rect r = new Rect(player_x, player_y, 30, 30,Color.red);
	    g.setColor(r.c);
		g.fillRect(r.x,r.y,r.w,r.h);
		
		
		Rect p = new Rect(300,60,40,300,Color.decode("#D55400"));
		g.setColor(p.c);
		g.fillRect(p.x,p.y,p.w,p.h);
		
		System.out.println(r.colision(p));
		
	    }
	}
}
