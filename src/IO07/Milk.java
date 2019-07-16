package IO07;

public class Milk extends Decorate {

    private Drink drink;

    public Milk(Drink drink) {
        this.drink = drink;
    }

    @Override
    public int cost() {
        return drink.cost() + 3;
    }

    @Override
    public String info() {
        return drink.info() + "加牛奶";
    }
}
