import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws Exception{
        double rocketU1Cost=0.0;
        double rocketU2Cost=0.0;
        Simulation simulation = new Simulation();
        ArrayList<Item> itemPhase1 = simulation.loadItems("phase-1.txt");
        ArrayList<Item> itemPhase2 = simulation.loadItems("phase-2.txt");
        rocketU1Cost+=simulation.runSimulationU1(simulation.loadU1(itemPhase1));
        rocketU1Cost+=simulation.runSimulationU1(simulation.loadU1(itemPhase2));
        System.out.println("The Total cost of Rocket U1 is:");
        System.out.println(rocketU1Cost);
        rocketU2Cost+=simulation.runSimulationU2(simulation.loadU2(itemPhase1));
        rocketU2Cost+=simulation.runSimulationU2(simulation.loadU2(itemPhase2));
        System.out.println("The Total cost of Rocket U2 is:");
        System.out.println(rocketU2Cost);
    }
}