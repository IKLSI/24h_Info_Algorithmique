import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LecteurEnsemblePoint
{
	@SuppressWarnings("unchecked")
	public static <T> List<T> lireFichier(String nomFichier, boolean ensemblePoint3D)
	{
		String ligne = null;
		List<T> lstPoints = new ArrayList<T>();

		try
		{
			FileInputStream fluxFichier = new FileInputStream(nomFichier);
			InputStreamReader lecteurFlux = new InputStreamReader(fluxFichier, "UTF-8");
			BufferedReader fichier = new BufferedReader(lecteurFlux);

			while ((ligne = fichier.readLine()) != null)
				lstPoints.add((T) traitementLigne(ligne, ensemblePoint3D));

			fichier.close();
		}
		catch (IOException exc)
		{
			System.out.println("Erreur de lecture du fichier " + nomFichier + " : " + exc.getMessage());
		}

		return lstPoints;
	}

	private static Object traitementLigne(String ligne, boolean ensemblePoint3D)
	{
		Scanner scanner = new Scanner(ligne);

		scanner.useDelimiter(" ");

		int coordX = scanner.nextInt();
		int coordY = scanner.nextInt();

		if (ensemblePoint3D)
		{
			int coordZ = scanner.nextInt();
			scanner.close();
			return new EnsemblePoint3D(coordX, coordY, coordZ);
		}
		else
		{
			scanner.close();
			return new EnsemblePoint2D(coordX, coordY);
		}
	}
}