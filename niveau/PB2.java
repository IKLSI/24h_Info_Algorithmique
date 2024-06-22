import java.util.*;

public class PB2
{
	public static void main(String[] args)
	{
		List<EnsemblePoint2D> lstPoints = new ArrayList<EnsemblePoint2D>();
		List<List<EnsemblePoint2D>> lstPointTriangle = new ArrayList<List<EnsemblePoint2D>>();
		boolean formeIdentifiee = false;

		lstPoints = LecteurEnsemblePoint.lireFichier("./data/2-1.txt", false);

		for (int i = 0; i < lstPoints.size(); i++)
		{
			EnsemblePoint2D ensemblePoint = lstPoints.get(i);

			if (!formeIdentifiee)
			{
				if (EnsemblePoint2D.getEnsemblePointsCoordonneesXIdentique(ensemblePoint.getCoordX()).size() > 1
						&& EnsemblePoint2D.getEnsemblePointsCoordonneesYIdentique(ensemblePoint.getCoordY()).size() > 1)
				{
					List<EnsemblePoint2D> pointsCoordonneesXIdentique = EnsemblePoint2D.getEnsemblePointsCoordonneesXIdentique(ensemblePoint.getCoordX());

					for (int j = 0; j < pointsCoordonneesXIdentique.size(); j++)
					{
						EnsemblePoint2D pointX = pointsCoordonneesXIdentique.get(j);

						if(!ensemblePoint.equals(pointX) && EnsemblePoint2D.getEnsemblePointsCoordonneesYIdentique(pointX.getCoordY()).size() > 1)
						{
							List<EnsemblePoint2D> pointsCoordonneesYIdentique = EnsemblePoint2D.getEnsemblePointsCoordonneesYIdentique(pointX.getCoordY());

							for (int k = 0; k < pointsCoordonneesYIdentique.size(); k++)
							{
								EnsemblePoint2D pointY = pointsCoordonneesYIdentique.get(k);

								if(!pointX.equals(pointY) && EnsemblePoint2D.getEnsemblePointsCoordonneesXIdentique(pointY.getCoordX()).size() > 1)
								{
									List<EnsemblePoint2D> lstTemp = new ArrayList<EnsemblePoint2D>();

									lstTemp.add(ensemblePoint);
									lstTemp.add(pointX);
									lstTemp.add(pointY);

									lstPointTriangle.add(lstTemp);
								}
								else
									lstPoints.remove(pointY);
							}
						}
						else
							lstPoints.remove(pointX);
					}
				}
				else
					lstPoints.remove(ensemblePoint);
			}
		}

		for (int i = 0; i < lstPointTriangle.size(); i++)
		{
			List<EnsemblePoint2D> triangle1 = lstPointTriangle.get(i);
			EnsemblePoint2D a1 = triangle1.get(0);
			EnsemblePoint2D b1 = triangle1.get(1);
			EnsemblePoint2D c1 = triangle1.get(2);

			for (int j = 0; j < lstPointTriangle.size(); j++)
			{
				List<EnsemblePoint2D> triangle2 = lstPointTriangle.get(j);

				if (i == j)
					continue;

				EnsemblePoint2D a2 = triangle2.get(0);
				EnsemblePoint2D b2 = triangle2.get(1);
				EnsemblePoint2D c2 = triangle2.get(2);

				if ((a1.getCoordX() == a2.getCoordX() ^ a1.getCoordX() == b2.getCoordX() ^ a1.getCoordX() == c2.getCoordX() ^
					 b1.getCoordX() == a2.getCoordX() ^ b1.getCoordX() == b2.getCoordX() ^ b1.getCoordX() == c2.getCoordX() ^
					 c1.getCoordX() == a2.getCoordX() ^ c1.getCoordX() == b2.getCoordX() ^ c1.getCoordX() == c2.getCoordX()) &&
					(a1.getCoordY() == a2.getCoordY() ^ a1.getCoordY() == b2.getCoordY() ^ a1.getCoordY() == c2.getCoordY() ^ 
					 b1.getCoordY() == a2.getCoordY() ^ b1.getCoordY() == b2.getCoordY() ^ b1.getCoordY() == c2.getCoordY() ^
					 c1.getCoordY() == a2.getCoordY() ^ c1.getCoordY() == b2.getCoordY() ^ c1.getCoordY() == c2.getCoordY()))
				{
					
					System.out.println(a1);
					System.out.println(b1);
					System.out.println(c1);
					
					System.out.println(a2);
					System.out.println(b2);
					System.out.println(c2);

					System.exit(0);
				}
			}
		}
	}
}