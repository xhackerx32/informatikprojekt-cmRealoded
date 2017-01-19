
public class Coco {

	public static void main(String[] args) {
		
		bewegungsGleichung();
	}
	
	//einige Variablen und Konstanten:
	public static double gamma = 6.67408*Math.pow(10, -11);
	public static double r1X=0;
	public static double r1Y=6371*Math.pow(10, 3);
	public static double r1Betrag=r1Y;
	public static double startPunktX=0;
	public static double startPunktY=0;
	public static double masseErde =5.972*Math.pow(10, 24);
	
	public static void bewegungsGleichung()
	{
		long start = System.currentTimeMillis();
		int n=0;
		
		for(int i =1; i<=10; i=i+1)
		{
		long end = System.currentTimeMillis();
		double t = (end - start)*Math.pow(10, -3);
		double beschleunigungX = 0;
		double komponenteX = (double)1 / 2 *beschleunigungX *Math.pow(t, 2) +startPunktX;
		double beschleunigungY=gamma*masseErde*Math.pow(r1Y, -2)*r1Y*Math.pow(r1Betrag, -1);
		double komponenteY= (double)1 / 2 *beschleunigungY *Math.pow(t, 2) +startPunktY;
		i=0;		
			
			if(t>=0.0)
			{
			System.out.println(komponenteX);
			System.out.println(komponenteY);
			n = n+1;
			}
			if(t>=3.5)
			{
				System.out.println(komponenteX);
				System.out.println(komponenteY);
				System.out.println(n);
				i=100;
			}
		
		}
	}
}
