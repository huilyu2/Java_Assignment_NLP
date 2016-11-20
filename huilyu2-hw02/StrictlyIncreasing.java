import java.util.Scanner;

public class StrictlyIncreasing {

	public StrictlyIncreasing() {
		// TODO Auto-generated constructor stub
	}

	public static boolean isStrictlyIncreasing(double[] in)
	{
		boolean isIncreasing = true;
		for (int i = 0; i < in.length - 1; i++)
		{
			if (in[i] >= in[i+1])
				isIncreasing = false;
		}
				
		return isIncreasing;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		double[] in = {1,2,3,4,5,6,7};
		System.out.println(isStrictlyIncreasing(in));
	}

}
