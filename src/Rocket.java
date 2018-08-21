public class Rocket implements SpaceShip{
    private double cost;
    private int shipWeight;
    private int maxWeight;
    private int currentWeight;

    public Rocket(double cost,int shipWeight,int maxWeight,int currentWeight){
        this.cost = cost;
        this.shipWeight = shipWeight;
        this.maxWeight = maxWeight;
        this.currentWeight = currentWeight;
    }

    public double getCost(){
        return cost;
    }

    public int getShipWeight(){
        return shipWeight;
    }

    public int getMaxWeight(){
        return maxWeight;
    }

    public int getCurrentWeight(){
        return currentWeight;
    }

    public boolean launch(){
        return true;
    }

    public boolean land(){
        return true;
    }

    public boolean canCarry(Item currentItem){
        return(currentWeight+currentItem.getWeight()<maxWeight-shipWeight);
    }

    public int carry(Item currentItem) {
        currentWeight += currentItem.getWeight();
        return currentWeight;
    }
}