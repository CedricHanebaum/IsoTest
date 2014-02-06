package isometrie;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Panel extends JPanel implements Runnable{

	private static final long serialVersionUID = 1L;
	
	private boolean running = false;
	private ArrayList<Block3D> blocks = new ArrayList<Block3D>();
	
	public Panel(){
		super();

		JFrame frame = new JFrame("Iso Test");
		Thread thread = new Thread(this);
		
		this.setBounds(0, 0, 800, 600);

		frame.setSize(this.getWidth(), this.getHeight());
		frame.setResizable(false);
		frame.setLayout(null);
		frame.add(this);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);

		thread.start();
	}
	
	@Override
	public void run() {
		this.initialize();
		while (running) {
			this.calc();
			this.repaint();
		}
		this.close();
	}

	private void initialize() {
		running = true;

		int sizeX = 30;
		int sizeY = 30;
		int sizeZ = 10;

		Block3D b01 = new Block3D(new Vector3D(400, 300, 0), sizeX, sizeY, sizeZ);
		Block3D b02 = new Block3D(new Vector3D(430, 300, 0), sizeX, sizeY, sizeZ);
		Block3D b03 = new Block3D(new Vector3D(460, 300, 0), sizeX, sizeY, sizeZ);
		Block3D b04 = new Block3D(new Vector3D(490, 300, 0), sizeX, sizeY, sizeZ);
		Block3D b05 = new Block3D(new Vector3D(520, 300, 0), sizeX, sizeY, sizeZ);
		
		Block3D b06 = new Block3D(new Vector3D(400, 180, 0), sizeX, sizeY, sizeZ);
		Block3D b07 = new Block3D(new Vector3D(430, 180, 0), sizeX, sizeY, sizeZ);
		Block3D b08 = new Block3D(new Vector3D(460, 180, 0), sizeX, sizeY, sizeZ);
		Block3D b09 = new Block3D(new Vector3D(490, 180, 0), sizeX, sizeY, sizeZ);
		Block3D b10 = new Block3D(new Vector3D(520, 180, 0), sizeX, sizeY, sizeZ);

		Block3D b11 = new Block3D(new Vector3D(520, 270, 0), sizeX, sizeY, sizeZ);
		Block3D b12 = new Block3D(new Vector3D(520, 240, 0), sizeX, sizeY, sizeZ);
		Block3D b13 = new Block3D(new Vector3D(520, 210, 0), sizeX, sizeY, sizeZ);

		Block3D b14 = new Block3D(new Vector3D(400, 270, 0), sizeX, sizeY, sizeZ);
		Block3D b15 = new Block3D(new Vector3D(400, 240, 0), sizeX, sizeY, sizeZ);
		Block3D b16 = new Block3D(new Vector3D(400, 210, 0), sizeX, sizeY, sizeZ);

		blocks.add(b01);
		blocks.add(b02);
		blocks.add(b03);
		blocks.add(b04);
		blocks.add(b05);

		blocks.add(b06);
		blocks.add(b07);
		blocks.add(b08);
		blocks.add(b09);
		blocks.add(b10);

		blocks.add(b11);
		blocks.add(b12);
		blocks.add(b13);

		blocks.add(b14);
		blocks.add(b15);
		blocks.add(b16);

	}

	private void calc() {

	}

	private void close() {

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponents(g);
		g.setColor(Color.BLACK);
		g.fillRect(0, 0, 800, 600);

		for (Block3D b: blocks) {
			b.draw(g);
		}
	}

	public static void main(String[] args) {
		new Panel();
	}

	
}
