package WorkPlace;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public abstract class MotherOfGoods {
    private static int id;
    private String name;
    private String type;
    private static int volume;
    private static int amount;

    public MotherOfGoods(String name, String type, int volume, int amount) {
        this.name = name;
        this.type = type;
        this.volume = volume;
        this.amount = amount;
        id++;
    }


    public static int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public int getVolume() {
        return volume;
    }

    public int getAmount() {
        return amount;
    }

    public void CheckPlace() throws IOException {
        if (getAmount() * getVolume() > 50) {
            System.out.println("Склад будет переполнен. Создайте новый");
            Stocks.newStock();
        }
    }


}
