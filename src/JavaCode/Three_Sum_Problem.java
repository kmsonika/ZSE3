package JavaCode;

public class Three_Sum_Problem 
{
	public static void main(String[] args) 
	{
		// 3 sum problem
		
		int arr[]= {1,2,3,4,5,8,9,11,15};
		int targetVal=20;
		
		for(int i=0; i<arr.length; i++)
		{
			int left=i+1;
			int right=arr.length-1;
			
			while(left<right)
			{
				int sum = arr[left] + arr[right] + arr[i];
				
				if(sum == targetVal)
				{
					System.out.println("First val "+ arr[i] + " " + arr[left] + " " + arr[right]);
					left++;
					right--;
				}
				else if(sum>targetVal)
				{
					right--;
				}
				else
				{
					left++;
				}
			}
		}
	}
}
