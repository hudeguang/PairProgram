package forth;

import java.util.Random;

public class homework {
	public int max;
	
	public homework(int max)
	{
		this.max=max;
	}
	public int PRandom()
	{	
		int a=0;
		Random random = new Random();
		a = random.nextInt();
		a=Math.abs(a%this.max);
		return a;	
	}
	public double DRandom()
	{
		int b=0;
		double c;
		Random random_double = new Random();
		b=random_double.nextInt();
		b=Math.abs(b%(this.max*10));
		c=b/10.0;
		return c;
	}

}

