package isometrie;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;

public class Block3D {

	private Vector3D base;
	private int sizeX, sizeY, sizeZ;

	public Block3D(Vector3D base, int size1, int size2, int size3) {
		super();
		this.base = base;
		this.sizeX = size1;
		this.sizeY = size2;
		this.sizeZ = size3;
	}

	public Vector3D getBase() {
		return base;
	}

	public Vector3D[] get3dPoints() {
		Vector3D[] ret = new Vector3D[8];

		ret[0] = new Vector3D(base);
		ret[1] = new Vector3D(base.getX() + sizeX, base.getY(), base.getZ());
		ret[2] = new Vector3D(base.getX(), base.getY() + sizeY, base.getZ());
		ret[3] = new Vector3D(base.getX() + sizeX, base.getY() + sizeY, base.getZ());
		ret[4] = new Vector3D(base.getX(), base.getY(), base.getZ() + sizeZ);
		ret[5] = new Vector3D(base.getX(), base.getY() + sizeY, base.getZ() + sizeZ);
		ret[6] = new Vector3D(base.getX() + sizeX, base.getY(), base.getZ() + sizeZ);
		ret[7] = new Vector3D(base.getX() + sizeX, base.getY() + sizeY, base.getZ() + sizeZ);

		return ret;
	}

	public Point[] getIsoPoints() {
		Point[] ret = new Point[8];
		Vector3D[] points3d = this.get3dPoints();

		for (int i = 0; i < points3d.length; i++) {
			ret[i] = Block3D.Point3dToIso(points3d[i]);
		}

		return ret;
	}

	public static Point Point3dToIso(Vector3D v) {
		int x, y;

		x = (int) (1 * v.getX() + -1 * v.getY() + 0 * v.getZ());
		y = (int) (0.5 * v.getX() + 0.5 * v.getY() + -1 * v.getZ());

		return new Point(x, y);
	}

	public void draw(Graphics g) {
		Point[] points = this.getIsoPoints();

		g.setColor(Color.BLUE);

		g.drawLine((int) points[0].getX(), (int) points[0].getY(), (int) points[1].getX(), (int) points[1].getY());
		g.drawLine((int) points[0].getX(), (int) points[0].getY(), (int) points[2].getX(), (int) points[2].getY());
		g.drawLine((int) points[1].getX(), (int) points[1].getY(), (int) points[3].getX(), (int) points[3].getY());
		g.drawLine((int) points[2].getX(), (int) points[2].getY(), (int) points[3].getX(), (int) points[3].getY());

		g.drawLine((int) points[4].getX(), (int) points[4].getY(), (int) points[6].getX(), (int) points[6].getY());
		g.drawLine((int) points[6].getX(), (int) points[6].getY(), (int) points[7].getX(), (int) points[7].getY());
		g.drawLine((int) points[7].getX(), (int) points[7].getY(), (int) points[5].getX(), (int) points[5].getY());
		g.drawLine((int) points[5].getX(), (int) points[5].getY(), (int) points[4].getX(), (int) points[4].getY());

		g.drawLine((int) points[0].getX(), (int) points[0].getY(), (int) points[4].getX(), (int) points[4].getY());
		g.drawLine((int) points[1].getX(), (int) points[1].getY(), (int) points[6].getX(), (int) points[6].getY());
		g.drawLine((int) points[2].getX(), (int) points[2].getY(), (int) points[5].getX(), (int) points[5].getY());
		g.drawLine((int) points[3].getX(), (int) points[3].getY(), (int) points[7].getX(), (int) points[7].getY());

	}

}
