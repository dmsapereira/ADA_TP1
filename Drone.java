import java.util.Arrays;

public class Drone {

    private Rental[] rentals;

    private Integer[] results;

    private int counter;

    public Drone(int nRents){
        this.counter = 0;
        this.rentals = new Rental[nRents];
        this.results = new Integer[nRents + 1];
    }

    public void addRental(int startTime, int duration, int price){
        this.rentals[this.counter++] = new Rental(startTime, duration, price);
    }

    private boolean compatible(int index1, int index2){
        Rental a = this.rentals[index1], b = this.rentals[index2];

        return a.getEndTime() <= b.getStartTime() || b.getEndTime() <= a.getStartTime();
    }

    private int search(int index){
        for(int i = index - 2; i > -1; i--)
            if (this.compatible(i, index)) return i;

        return -1;
    }

    private int solve(int index){
        int gain = this.rentals[index].getPrice();

        if(this.compatible(index - 1, index))
            return gain + this.results[index];
        else
            return Math.max(gain + this.results[search(index) + 1], this.results[index]);
    }

    public int fillList(){
        Arrays.sort(this.rentals);

        this.counter = 0;

        this.results[this.counter++] = 0;
        this.results[this.counter++] = this.rentals[0].getPrice();

        for(int i = 1 ; i < rentals.length; i++){
            results[this.counter++] = this.solve(i);
        }

        return this.results[counter - 1];
    }
    
}