public class U1 extends Rocket{
    private double randomNum = Math.random();

    public U1(double cost,int shipWeight,int maxWeight,int currentWeight){
        super(cost,shipWeight,maxWeight,currentWeight);
    }

    public boolean launch(){
        double explosionLaunch = 0.05*(getCurrentWeight()/(getMaxWeight()-getShipWeight()));
        return(randomNum>explosionLaunch);
    }

    public boolean land(){
        double explosionLand = 0.01*(getCurrentWeight()/(getMaxWeight()-getShipWeight()));
        return(randomNum>explosionLand);
    }
}