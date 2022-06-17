package WorkPlace;

import Fast.f;

import java.io.IOException;

public class Soap extends MotherOfGoods{
    private int weight;

    public Soap(String name, String type, int volume, int amount, int weight) {
        super(name, "soap", 125, amount);
        this.weight = weight;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public void CheckPlace() throws IOException {
        super.CheckPlace();
    }
}
