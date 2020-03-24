public class Rental implements Comparable<Rental>{
    
    private int startTime;

    private int duration;

    private int endTime;

    private int price;

    public Rental(int startTime, int duration, int price){
        this.startTime = startTime;
        this.duration = duration;
        this.endTime = this.startTime + this.duration;
        this.price = price;
    }

    public int getStartTime() {
        return this.startTime;
    }

    public int getDuration() {
        return this.duration;
    }


    public int getEndTime() {
        return this.endTime;
    }

    public int getPrice() {
        return this.price;
    }

    @Override
    public int compareTo(Rental r) {
        return this.endTime - r.getEndTime();
    }

    
}