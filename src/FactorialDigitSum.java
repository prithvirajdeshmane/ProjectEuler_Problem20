
public class FactorialDigitSum {

	public static void main(String[] args) {
		Long startTime = System.nanoTime();
		
		int limit = 100;
		int[] num = new int[400];

		num = initNumArray(num);

		num[num.length - 1] = 1;

		for (int j = 2; j <= limit; j++) 
		{
			int carry = 0;
			for (int i = num.length-1; i >= 0; i--) 
			{
				if(num[i] == -1 && carry == 0) break;
				
				if(num[i] == -1 && carry != 0)
				{
					num[i] = carry % 10;
					carry /= 10;
				}
				else if(num[i] != -1)
				{
					int tempProd = (j * num[i]) + carry;

					int digit = tempProd % 10;
					carry = tempProd / 10;
					
					num[i] = digit;
				}
			}
		}
		
		//displayNum(num);
		
		System.out.println("Sum: " + findSum(num));
		System.out.println("Time taken: " + (System.nanoTime() - startTime));
	}

	private static int[] initNumArray(int[] num)
	{
		for (int i = 0; i < num.length; i++) {
			num[i] = -1;
		}
		return num;
	}
	
	private static int findSum(int[] num)
	{
		int sum = 0;
		
		for (int i = 0; i < num.length; i++) {
			if(num[i] != -1)
			{
				sum += num[i];
			}
		}
		
		return sum;
	}

	private static void displayNum(int[]num)
	{
		for (int i = 0; i < num.length; i++) {
			if(num[i] != -1)
			{
				System.out.print(num[i]);
			}
		}
		System.out.println("\n");
	}
}
