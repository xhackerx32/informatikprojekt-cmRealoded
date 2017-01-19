import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.BasicGame;
import org.newdawn.slick.Color;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;

public class Main extends BasicGame{
	
	public static double gamma = 6.67408*Math.pow(10, -11);
	public static double r1X=0;
	public static double r1Y=6371*Math.pow(10, 3);
	public static double r1Betrag=r1Y;
	public static double startPunktX=0;
	public static double startPunktY=0;
	public static double masseErde =5.972*Math.pow(10, 24);
	public static double masseStern =5.972*Math.pow(10, 12);
	double komponenteX=10.12345;
	double komponenteY=10;
	float komponenteXF;
	float komponenteYF;
	long start=0;
	float ortXS=400;
	float ortYS=400;
	
	@Override
	public void init(GameContainer gc) throws SlickException {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update(GameContainer gc, int arg1) throws SlickException {
		// TODO Auto-generated method stub

		if(komponenteX==10.12345)
		{
		start = System.currentTimeMillis();
		}
		
		long end = System.currentTimeMillis();
		double t = (end - start)*Math.pow(10, -3);
		double beschleunigungX1 = 0;
		double beschleunigungX2 = gamma*masseStern*Math.pow(ortXS-komponenteX+ortYS-komponenteY, -1)*(ortXS-komponenteX)*Math.pow(Math.pow(ortXS-komponenteX,2)+Math.pow(ortYS-komponenteY,2), -0.5);
		komponenteX = (double)1 / 2 *beschleunigungX1 *Math.pow(t, 2) +startPunktX+(double)1 / 2 *beschleunigungX2 *Math.pow(t, 2);
		double beschleunigungY1=gamma*masseErde*Math.pow(r1Y, -2)*r1Y*Math.pow(r1Betrag, -1);
		double beschleunigungY2 = gamma*masseStern*Math.pow(ortXS-komponenteX+ortYS-komponenteY, -1)*(ortYS-komponenteY)*Math.pow(Math.pow(ortXS-komponenteX,2)+Math.pow(ortYS-komponenteY,2), -0.5);
		komponenteY= (double)1 / 2 *beschleunigungY1 *Math.pow(t, 2) +startPunktY+(double)1 / 2 *beschleunigungY2 *Math.pow(t, 2);
		
		komponenteXF =(float)komponenteX;
		komponenteYF =(float)komponenteY;
		System.out.println(komponenteX);
		System.out.println(komponenteY);
		
	}
	
	@Override
	public void render(GameContainer gc, Graphics g) throws SlickException {
		// TODO Auto-generated method stub
		g.setBackground(Color.white);
		g.setColor(Color.red);
		g.fillOval(komponenteXF, komponenteYF, 130, 150);
		g.fillOval(ortXS, ortYS, 50, 50);
	}

	public Main(String title) {
		super(title);
	}	
	
	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new Main("Crazy Machines"));
			app.setDisplayMode(500, 500, false);
			//app.setTargetFrameRate(60);
			app.setVSync(true);
			app.start();
			}
		catch (SlickException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
	}

	

}
