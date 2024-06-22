import java.util.ArrayList;
import java.util.List;

public class PB1
{
	public static void main(String[] args)
	{
		List<EnsemblePoint2D> lstPoints = new ArrayList<EnsemblePoint2D>();
		boolean formeIdentifiee = false;

		lstPoints = LecteurEnsemblePoint.lireFichier("./data/1-1.txt", false);

		for (EnsemblePoint2D ensemblePoint : lstPoints)
		{
			if (!formeIdentifiee)
			{
				if (EnsemblePoint2D.getEnsemblePointsCoordonneesXIdentique(ensemblePoint.getCoordX()).size() > 1
						&& EnsemblePoint2D.getEnsemblePointsCoordonneesYIdentique(ensemblePoint.getCoordY()).size() > 1)
				{
					for (EnsemblePoint2D pointX : EnsemblePoint2D.getEnsemblePointsCoordonneesXIdentique(ensemblePoint.getCoordX()))
					{
						if(!ensemblePoint.equals(pointX) && EnsemblePoint2D.getEnsemblePointsCoordonneesYIdentique(pointX.getCoordY()).size() > 1)
						{
							for (EnsemblePoint2D pointY : EnsemblePoint2D.getEnsemblePointsCoordonneesYIdentique(ensemblePoint.getCoordY()))
							{
								if(!ensemblePoint.equals(pointY) && EnsemblePoint2D.getEnsemblePointsCoordonneesXIdentique(pointY.getCoordX()).size() > 1)
								{
									for (EnsemblePoint2D point4 : EnsemblePoint2D.getEnsemblePointsCoordonneesYIdentique(pointX.getCoordY()))
									{
										if(!pointX.equals(point4) && !pointY.equals(point4) && !ensemblePoint.equals(point4))
										{
											if(point4.getCoordX() == pointY.getCoordX() && point4.getCoordY() == pointX.getCoordY())
											{
												// Affiche les coordonnées des 4 points selon le format demandé

												System.out.println(ensemblePoint.getCoordX() + " " + ensemblePoint.getCoordY());
												System.out.println(pointX.getCoordX() + " " + pointX.getCoordY());
												System.out.println(pointY.getCoordX() + " " + pointY.getCoordY());
												System.out.println(point4.getCoordX() + " " + point4.getCoordY());
												formeIdentifiee = true;

												break;
											}
										}
									}
								}
							}
						}
					}
				}
			}

			ensemblePoint.nonValide();
		}
	}
}