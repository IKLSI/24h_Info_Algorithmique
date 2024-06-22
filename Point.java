public class Point
{
	private int coordX;
	private int coordY;
	private int coordZ;

	public Point(int coordX, int coordY)
	{
		this.coordX = coordX;
		this.coordY = coordY;
	}

	public Point(int coordX, int coordY, int coordZ)
	{
		this.coordX = coordX;
		this.coordY = coordY;
		this.coordZ = coordZ;
	}

	public int getCoordX() { return coordX; }

	public int getCoordY() { return coordY; }

	public int getCoordZ() { return coordZ; }

	public void setCoordX(int coordX) { this.coordX = coordX; }

	public boolean equalsCoordX(Point point) { return this.coordX == point.getCoordX(); }

	public boolean equalsCoordY(Point point) { return this.coordY == point.getCoordY(); }

	public boolean equalsCoordZ(Point point) { return this.coordZ == point.getCoordZ(); }

	public boolean equals(Point point) { return this.coordX == point.getCoordX() && this.coordY == point.getCoordY(); }

	public boolean equalsPoint3D(Point point) { return this.coordX == point.getCoordX() && this.coordY == point.getCoordY() && this.coordZ == point.getCoordZ(); }
}