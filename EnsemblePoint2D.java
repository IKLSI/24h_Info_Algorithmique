import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class EnsemblePoint2D
{
	private static HashMap<Integer, List<EnsemblePoint2D>> ensemblePointsCoordonneesXIdentique  = new HashMap<Integer, List<EnsemblePoint2D>>();
	private static HashMap<Integer, List<EnsemblePoint2D>> ensemblePointsCoordonneesYIdentique  = new HashMap<Integer, List<EnsemblePoint2D>>();
	private static HashMap<Integer, List<EnsemblePoint2D>> ensemblePointsCoordonneesZIdentique  = new HashMap<Integer, List<EnsemblePoint2D>>();
	private static HashMap<String , List<EnsemblePoint2D>> ensemblePointsCoordonneesXYIdentique = new HashMap<String , List<EnsemblePoint2D>>();

	private int coordX;
	private int coordY;
	private int coordZ = 0;

	public EnsemblePoint2D(int coordX, int coordY)
	{
		this.coordX = coordX;
		this.coordY = coordY;

		// Ajout du point dans la liste des points ayant la même coordonnée X

		if (ensemblePointsCoordonneesXIdentique.containsKey(coordX))
			ensemblePointsCoordonneesXIdentique.get(coordX).add(this);
		else
		{
			List<EnsemblePoint2D> lstPoints = new ArrayList<EnsemblePoint2D>();
			lstPoints.add(this);
			ensemblePointsCoordonneesXIdentique.put(coordX, lstPoints);
		}

		// Ajout du point dans la liste des points ayant la même coordonnée Y

		if (ensemblePointsCoordonneesYIdentique.containsKey(coordY))
			ensemblePointsCoordonneesYIdentique.get(coordY).add(this);
		else
		{
			List<EnsemblePoint2D> lstPoints = new ArrayList<EnsemblePoint2D>();
			lstPoints.add(this);
			ensemblePointsCoordonneesYIdentique.put(coordY, lstPoints);
		}
	}

	public EnsemblePoint2D(int coordX, int coordY, int coordZ)
	{
		this.coordX = coordX;
		this.coordY = coordY;
		this.coordZ = coordZ;

		// Ajout du point dans la liste des points ayant la même coordonnée X

		if (ensemblePointsCoordonneesXIdentique.containsKey(coordX))
			ensemblePointsCoordonneesXIdentique.get(coordX).add(this);
		else
		{
			List<EnsemblePoint2D> lstPoints = new ArrayList<EnsemblePoint2D>();
			lstPoints.add(this);
			ensemblePointsCoordonneesXIdentique.put(coordX, lstPoints);
		}

		// Ajout du point dans la liste des points ayant la même coordonnée Y

		if (ensemblePointsCoordonneesYIdentique.containsKey(coordY))
			ensemblePointsCoordonneesYIdentique.get(coordY).add(this);
		else
		{
			List<EnsemblePoint2D> lstPoints = new ArrayList<EnsemblePoint2D>();
			lstPoints.add(this);
			ensemblePointsCoordonneesYIdentique.put(coordY, lstPoints);
		}

		// Ajout du point dans la liste des points ayant la même coordonnée Z

		if (ensemblePointsCoordonneesZIdentique.containsKey(coordZ))
			ensemblePointsCoordonneesZIdentique.get(coordZ).add(this);
		else
		{
			List<EnsemblePoint2D> lstPoints = new ArrayList<EnsemblePoint2D>();
			lstPoints.add(this);
			ensemblePointsCoordonneesZIdentique.put(coordZ, lstPoints);
		}

		// Ajout du point dans la liste des points ayant la même coordonnée X et Y

		String coordXY = coordX + " " + coordY;

		if (ensemblePointsCoordonneesXYIdentique.containsKey(coordXY))
			ensemblePointsCoordonneesXYIdentique.get(coordXY).add(this);
		else
		{
			List<EnsemblePoint2D> lstPoints = new ArrayList<EnsemblePoint2D>();
			lstPoints.add(this);
			ensemblePointsCoordonneesXYIdentique.put(coordXY, lstPoints);
		}
	}

	public int getCoordX() { return coordX; }

	public int getCoordY() { return coordY; }
	
	public int getCoordZ() { return coordZ; }

	public static List<EnsemblePoint2D> getEnsemblePointsCoordonneesXIdentique(int coordX) { return ensemblePointsCoordonneesXIdentique.get(coordX); }

	public static List<EnsemblePoint2D> getEnsemblePointsCoordonneesYIdentique(int coordY) { return ensemblePointsCoordonneesYIdentique.get(coordY); }

	public static List<EnsemblePoint2D> getEnsemblePointsCoordonneesZIdentique(int coordZ) { return ensemblePointsCoordonneesZIdentique.get(coordZ); }

	public boolean equalsCoordX(Point point) { return this.coordX == point.getCoordX(); }

	public boolean equalsCoordY(Point point) { return this.coordY == point.getCoordY(); }

	public boolean equalsCoordZ(Point point) { return this.coordZ == point.getCoordZ(); }

	public boolean equals(Point point) { return this.coordX == point.getCoordX() && this.coordY == point.getCoordY(); }

	public boolean equalsPoint3D(Point point) { return this.coordX == point.getCoordX() && this.coordY == point.getCoordY() && this.coordZ == point.getCoordZ(); }

	public void nonValide()
	{
		EnsemblePoint2D.ensemblePointsCoordonneesXIdentique.get(this.coordX).remove(this);
		EnsemblePoint2D.ensemblePointsCoordonneesYIdentique.get(this.coordY).remove(this);

		if (this.coordZ != 0)
			EnsemblePoint2D.ensemblePointsCoordonneesZIdentique.get(this.coordZ).remove(this);
	}

	@Override
	public String toString() { return this.coordX + " " + this.coordY; }
}