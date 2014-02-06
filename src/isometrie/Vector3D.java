package isometrie;

public class Vector3D {

	private double x, y, z;

	public Vector3D(double x, double y, double z) {
		super();
		this.x = x;
		this.y = y;
		this.z = z;
	}

	public Vector3D(Vector3D v2) {
		this.x = v2.x;
		this.y = v2.y;
		this.z = v2.z;
	}

	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getZ() {
		return z;
	}

	public Vector3D add(Vector3D v2) {
		return new Vector3D(this.x + v2.x, this.y + v2.y, this.z + v2.z);
	}

	public Vector3D mult(double d) {
		return new Vector3D(this.x * d, this.y * d, this.z * d);
	}

}
