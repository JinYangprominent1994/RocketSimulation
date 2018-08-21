import java.util.ArrayList;
import java.io.File;
import java.util.Scanner;

public class Simulation {
    public ArrayList loadItems(String pathname) throws Exception {
        File file = new File(pathname);
        Scanner scanner = new Scanner(file);
        ArrayList<Item> itemsList = new ArrayList<>();//new ArrayList to store items
        while (scanner.hasNextLine()) {
            Item item = new Item();
            String content = scanner.nextLine();
            String[] itemContent = content.split("=");
            item.setName(itemContent[0]);
            item.setWeight(Integer.parseInt(itemContent[1]));
            itemsList.add(item);
        }
        return itemsList;
    }

    public ArrayList<U1> loadU1(ArrayList<Item> itemListU1) {
        ArrayList<U1> allU1 = new ArrayList<>();//allU1 ArrayList to store all U1 rocket
        //开始的时候创建一个
        U1 rocketU1 = new U1(1.0, 10000, 18000, 0);
        for (int i = 0; i < itemListU1.size(); i++) {
            Item currentItem = itemListU1.get(i);
            //如果火箭已经装满了, 即不可以携带货物了
            if (!rocketU1.canCarry(currentItem)) {
                //新建个火箭用来携带货物
                rocketU1 = new U1(1.0, 10000, 18000, 0);
                //并且把它存储
                allU1.add(rocketU1);
            }
            //当火箭可以携带货物时，就继续携带
            while (rocketU1.canCarry(currentItem)) {
                //携带货物
                rocketU1.carry(currentItem);
            }
        }
        return allU1;
    }

    public ArrayList<U2> loadU2(ArrayList<Item> itemListU2) {
        ArrayList<U2> allU2 = new ArrayList<>();//allU2 ArrayList to store all U2 rocket
        //开始的时候创建一个
        U2 rocketU2 = new U2(1.2, 18000, 29000, 0);
        for (int i = 0; i < itemListU2.size(); i++) {
            Item currentItem = itemListU2.get(i);
            //如果火箭已经装满了, 即不可以携带货物了
            if (!rocketU2.canCarry(currentItem)) {
                //新建个火箭用来携带货物
                rocketU2 = new U2(1.2, 18000, 29000, 0);
                //并且把它存储
                allU2.add(rocketU2);
            }
            //当火箭可以携带货物时，就继续携带
            while (rocketU2.canCarry(currentItem)) {
                //携带货物
                rocketU2.carry(currentItem);
            }
        }
        return allU2;
    }

    public double runSimulationU1(ArrayList<U1> rocket) {
        double totalCost = 0.0;
        for (int i = 0; i < rocket.size(); i++) {
            if (rocket.get(i).launch() && rocket.get(i).land()) {
                totalCost += rocket.get(i).getCost();
            } else {
                i -= 1;
            }
        }
        return totalCost;
    }

    public double runSimulationU2(ArrayList<U2> rocket) {
        double totalCost = 0.0;
        for (int i = 0; i < rocket.size(); i++) {
            if (rocket.get(i).launch() && rocket.get(i).land()) {
                totalCost += rocket.get(i).getCost();
            } else {
                i -= 1;
            }
        }
        return totalCost;
    }
}