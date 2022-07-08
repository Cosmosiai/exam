package FirstExam.WorkPlace;

import java.io.FileWriter;
import java.io.IOException;

import static FirstExam.Fast.f.a;

public class Goods extends MotherOfGoods {

    private int ShampooVolume;

    public Goods(String name, String type, int volume, int amount, int shampooVolume) {
        super(name, "shampoo", 250, amount);
        ShampooVolume = shampooVolume;
    }


    public int getShampooVolume() {
        return ShampooVolume;
    }

    public static void SafeGoods(Goods h) throws IOException {
        System.out.println("Вы хотите добавить товар к существующему или к новому складу?");
        String b = a.nextLine();
        FileWriter fl = new FileWriter(b+".txt",true);
        fl.write(h.getName()+" | "+h.getType()+" | "+h.getVolume()+" | "+" | "+h.getAmount()+" | "+" | "+h.getShampooVolume());
    }
}

