// Link : https://www.interviewbit.com/problems/hotel-bookings-possible/
public class Solution {
    public boolean hotel(ArrayList<Integer> arrive, ArrayList<Integer> depart, int K) {
        ArrayList<Pair> merge = convertPair(arrive, depart);
        Collections.sort(merge);
        int check = 0;
        for(int i = 0; i < merge.size(); i++){
            if(merge.get(i).time == 'A'){
                check++;
                if(check > K)return false;
            }
            else check--;
        }  
        return true ;
    }
    public ArrayList<Pair> convertPair(ArrayList<Integer> arrive, ArrayList<Integer> depart){
        ArrayList<Pair> timing = new ArrayList<Pair>();
        for(int i = 0; i < arrive.size(); i++){
            if(arrive.get(i) != depart.get(i)){
                timing.add(new Pair(arrive.get(i), 'A'));
                timing.add(new Pair(depart.get(i), 'D'));
            }
        }
        return timing;
    }
    static class Pair implements Comparable <Pair>{
        int val;
        Character time;
    Pair(int val, Character time){
        this.val = val;
        this.time = time;
    }
    public int compareTo(Pair b){
        return val - b.val;
    }
    }
}
