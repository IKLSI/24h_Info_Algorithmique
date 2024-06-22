import java.util.ArrayList;
import java.util.List;

public class PB3
{
	public static void main(String[] args)
	{
		List<EnsemblePoint3D> lstPoints = new ArrayList<EnsemblePoint3D>();
		lstPoints = LecteurEnsemblePoint.lireFichier("./data/3-1.txt", true);

		for (EnsemblePoint3D ensemblePoint : lstPoints)
		{
			if (EnsemblePoint3D.getEnsemblePointsCoordonneesXZIdentique(ensemblePoint.getCoordX(), ensemblePoint.getCoordZ()).size() > 1
					&& EnsemblePoint3D.getEnsemblePointsCoordonneesYZIdentique(ensemblePoint.getCoordY(), ensemblePoint.getCoordZ()).size() > 1)
			{
				for (EnsemblePoint3D pointX : EnsemblePoint3D.getEnsemblePointsCoordonneesXZIdentique(ensemblePoint.getCoordX(), ensemblePoint.getCoordZ()))
				{
					if(!ensemblePoint.equals(pointX) && EnsemblePoint3D.getEnsemblePointsCoordonneesYZIdentique(pointX.getCoordY(), pointX.getCoordZ()).size() > 1)
					{
						for (EnsemblePoint3D pointY : EnsemblePoint3D.getEnsemblePointsCoordonneesYZIdentique(ensemblePoint.getCoordY(), ensemblePoint.getCoordZ()))
						{
							if(!ensemblePoint.equals(pointY) && EnsemblePoint3D.getEnsemblePointsCoordonneesXZIdentique(pointY.getCoordX(), pointY.getCoordZ()).size() > 1)
							{
								for (EnsemblePoint3D point4 : EnsemblePoint3D.getEnsemblePointsCoordonneesYZIdentique(pointX.getCoordY(), pointX.getCoordZ()))
								{
									if(!pointX.equals(point4) && !pointY.equals(point4) && !ensemblePoint.equals(point4))
									{
										if(point4.getCoordX() == pointY.getCoordX() && point4.getCoordY() == pointX.getCoordY())
										{
											if(EnsemblePoint3D.getEnsemblePointsCoordonneesXYIdentique(pointX.getCoordX(), pointX.getCoordY()).size() > 1 && 
											   EnsemblePoint3D.getEnsemblePointsCoordonneesXYIdentique(pointY.getCoordX(), pointY.getCoordY()).size() > 1 &&
											   EnsemblePoint3D.getEnsemblePointsCoordonneesXYIdentique(point4.getCoordX(), point4.getCoordY()).size() > 1)
											{
												for (EnsemblePoint3D point5 : EnsemblePoint3D.getEnsemblePointsCoordonneesXYIdentique(ensemblePoint.getCoordX(), ensemblePoint.getCoordY()))
												{
													List<EnsemblePoint3D> lstTmpCoordonneesZIdentique = EnsemblePoint3D.getEnsemblePointsCoordonneesZIdentique(point5.getCoordZ());

													if(lstTmpCoordonneesZIdentique.size() > 1)
													{
														boolean point6Identifie = false;
														EnsemblePoint3D point6 = null;

														boolean point7Identifie = false;
														EnsemblePoint3D point7 = null;

														boolean point8Identifie = false;
														EnsemblePoint3D point8 = null;

														for (EnsemblePoint3D ensemblePoint2 : lstTmpCoordonneesZIdentique)
														{
															if(EnsemblePoint3D.getEnsemblePointsCoordonneesYZIdentique(ensemblePoint2.getCoordY(), ensemblePoint2.getCoordZ()).size() > 1 &&
															   EnsemblePoint3D.getEnsemblePointsCoordonneesYZIdentique(ensemblePoint2.getCoordY(), ensemblePoint2.getCoordZ()).size() > 1)
															{
																if(!pointX.equals(ensemblePoint2) && !pointY.equals(ensemblePoint2) && !point4.equals(ensemblePoint2) && !point5.equals(ensemblePoint2))
																{
																	if(!point6Identifie && ensemblePoint2.getCoordX() == pointX.getCoordX() && ensemblePoint2.getCoordY() == pointX.getCoordY())
																	{
																		point6Identifie = true;
																		point6 = ensemblePoint2;
																	}
																	else if(!point7Identifie && ensemblePoint2.getCoordX() == pointY.getCoordX() && ensemblePoint2.getCoordY() == pointY.getCoordY())
																	{
																		point7Identifie = true;
																		point7 = ensemblePoint2;
																	}
																	else if(!point8Identifie && ensemblePoint2.getCoordX() == point4.getCoordX() && ensemblePoint2.getCoordY() == point4.getCoordY())
																	{
																		point8Identifie = true;
																		point8 = ensemblePoint2;
																	}
																}
															}
														}

														if(point6Identifie && point7Identifie && point8Identifie)
														{
															System.out.println(ensemblePoint);
															System.out.println(pointX);
															System.out.println(pointY);
															System.out.println(point4);
															System.out.println(point5);
															System.out.println(point6);
															System.out.println(point7);
															System.out.println(point8);

															System.exit(0);

															break;
														}
													}
													else
														break;
												}
											}
											else
												break;
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