import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;

public class EnsemblePoint3D
{
	private static HashMap<String, List<EnsemblePoint3D>> ensemblePointsCoordonneesXZIdentique = new HashMap<String, List<EnsemblePoint3D>>();
	private static HashMap<String, List<EnsemblePoint3D>> ensemblePointsCoordonneesYZIdentique = new HashMap<String, List<EnsemblePoint3D>>();
	private static HashMap<String, List<EnsemblePoint3D>> ensemblePointsCoordonneesZIdentique  = new HashMap<String, List<EnsemblePoint3D>>();
	private static HashMap<String, List<EnsemblePoint3D>> ensemblePointsCoordonneesXYIdentique = new HashMap<String, List<EnsemblePoint3D>>();

	private int coordX;
	private int coordY;
	private int coordZ;

	public EnsemblePoint3D(int coordX, int coordY, int coordZ)
	{
		this.coordX = coordX;
		this.coordY = coordY;
		this.coordZ = coordZ;

		// Ajout du point dans la liste des points ayant la même coordonnée X

		if (ensemblePointsCoordonneesXZIdentique.containsKey(coordX + " " + coordZ))
			ensemblePointsCoordonneesXZIdentique.get(coordX + " " + coordZ).add(this);
		else
		{
			List<EnsemblePoint3D> listePoints = new ArrayList<EnsemblePoint3D>();
			listePoints.add(this);
			ensemblePointsCoordonneesXZIdentique.put(coordX + " " + coordZ, listePoints);
		}

		// Ajout du point dans la liste des points ayant la même coordonnée Y

		if (ensemblePointsCoordonneesYZIdentique.containsKey(coordY + " " + coordZ))
			ensemblePointsCoordonneesYZIdentique.get(coordY + " " + coordZ).add(this);
		else
		{
			List<EnsemblePoint3D> listePoints = new ArrayList<EnsemblePoint3D>();
			listePoints.add(this);
			ensemblePointsCoordonneesYZIdentique.put(coordY + " " + coordZ, listePoints);
		}

		// Ajout du point dans la liste des points ayant la même coordonnée Z

		if (ensemblePointsCoordonneesZIdentique.containsKey(coordZ + ""))
			ensemblePointsCoordonneesZIdentique.get(coordZ + "").add(this);
		else
		{
			List<EnsemblePoint3D> listePoints = new ArrayList<EnsemblePoint3D>();
			listePoints.add(this);
			ensemblePointsCoordonneesZIdentique.put(coordZ + "", listePoints);
		}

		// Ajout du point dans la liste des points ayant la même coordonnée XY

		if (ensemblePointsCoordonneesXYIdentique.containsKey(coordX + " " + coordY))
			ensemblePointsCoordonneesXYIdentique.get(coordX + " " + coordY).add(this);
		else
		{
			List<EnsemblePoint3D> listePoints = new ArrayList<EnsemblePoint3D>();
			listePoints.add(this);
			ensemblePointsCoordonneesXYIdentique.put(coordX + " " + coordY, listePoints);
		}
	}

	public int getCoordX() { return this.coordX; }

	public int getCoordY() { return this.coordY; }

	public int getCoordZ() { return this.coordZ; }

	public boolean equalsCoordX(EnsemblePoint3D point) { return this.coordX == point.getCoordX(); }

	public boolean equalsCoordY(EnsemblePoint3D point) { return this.coordY == point.getCoordY(); }

	public boolean equalsCoordZ(EnsemblePoint3D point) { return this.coordZ == point.getCoordZ(); }

	public boolean equals(EnsemblePoint3D point) { return this.coordX == point.getCoordX() && this.coordY == point.getCoordY() && this.coordZ == point.getCoordZ(); }

	public static List<EnsemblePoint3D> getEnsemblePointsCoordonneesXZIdentique(int coordX, int coordZ) { return ensemblePointsCoordonneesXZIdentique.get(coordX + " " + coordZ); }

	public static List<EnsemblePoint3D> getEnsemblePointsCoordonneesYZIdentique(int coordY, int coordZ) { return ensemblePointsCoordonneesYZIdentique.get(coordY + " " + coordZ); }

	public static List<EnsemblePoint3D> getEnsemblePointsCoordonneesZIdentique(int coordZ) { return ensemblePointsCoordonneesZIdentique.get(coordZ + ""); }

	public static List<EnsemblePoint3D> getEnsemblePointsCoordonneesXYIdentique(int coordX, int coordY) {
		return ensemblePointsCoordonneesXYIdentique.get(coordX + " " + coordY);
	}

	@Override
	public String toString() { return this.coordX + " " + this.coordY + " " + this.coordZ; }

	public void nonValide()
	{
		ensemblePointsCoordonneesXZIdentique.get(this.coordX + " " + this.coordZ).remove(this);
		ensemblePointsCoordonneesYZIdentique.get(this.coordY + " " + this.coordZ).remove(this);
		ensemblePointsCoordonneesZIdentique.get(this.coordZ + "").remove(this);
		ensemblePointsCoordonneesXYIdentique.get(this.coordX + " " + this.coordY).remove(this);
	}
}