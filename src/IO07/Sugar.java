package IO07;

public class Sugar extends Decorate {
    private Drink drink;

    public Sugar(Drink drink) {
        this.drink = drink;
    }

    @Override
    public int cost() {
        return drink.cost() + 2;
    }

    @Override
    public String info() {
        return drink.info() + "加蔗糖";
    }
}
