package WorkPlace;

public class Goods extends MotherOfGoods{

    private int ShampooVolume;

    public Goods(String name, String type, int volume, int amount, int shampooVolume) {
        super(name, "shampoo", 250, amount);
        ShampooVolume = shampooVolume;
    }

    public int getShampooVolume() {
        return ShampooVolume;
    }
}

