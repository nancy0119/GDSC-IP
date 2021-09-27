
// Time complextiy - O(n^2):

// In java function tour() takes two arguments array of petrol
// and array of distance

class Solution
{
    //Function to find starting point where the truck can start to get through
    //the complete circle without exhausting its petrol in between.
    int tour(int petrol[], int distance[])
    {
	// Your code here	
	int ans = -1;
	for(int i = 0; i < petrol.length; i++){
	    if(isPossible(petrol, distance, i)) {
	        ans = i;
	        break;
	    }
	}
	return ans;
    }
    public static boolean isPossible(int petrol[], int distance[], int idx){
        if(petrol[idx] < distance[idx])return false;
        int left = petrol[idx] - distance[idx];
        for(int i = 1; i < petrol.length; i++){
            int currIdx = (i + idx) % petrol.length;
            left += petrol[currIdx] - distance[currIdx];
            if(left < 0)return false;
        }
        return true;
    }
}