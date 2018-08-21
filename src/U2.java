public class U2 extends Rocket{
    private double randomNum = Math.random();

    public U2(double cost,int shipWeight,int maxWeight,int currentWeight){
        super(cost,shipWeight,maxWeight,currentWeight);
    }

    public boolean launch(){
        double explosionLaunch = 0.04*(getCurrentWeight()/(getMaxWeight()-getShipWeight()));
        return(randomNum>explosionLaunch);
    }
    public boolean land(){
        double explosionLand = 0.08*(getCurrentWeight()/(getMaxWeight()-getShipWeight()));
        return(randomNum>explosionLand);
    }
}