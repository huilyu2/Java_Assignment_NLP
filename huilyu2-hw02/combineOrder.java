
public class combineOrder {

	public combineOrder() {
		// TODO Auto-generated constructor stub
	}

	public static int[] combineOrder(int[] order1,int[] order2)
	{
		int[] combine = new int[order1.length];
		for(int i = 0; i < order1.length; i++)
		{
			combine[i] = order1[i] + order2[i];
		}
		return combine;
	}
	
	public static void main(String[] args){
		int[] order1 = {0,0,3,4,7};
		int[] order2 = {0,4,0,1,2};
		for(int i = 0; i < 5; i++)
		{
			System.out.print(combineOrder(order1, order2)[i] + "  ");
		}
	}
}
