package IO07;

public abstract class Decorate implements Drink {

    private Drink drink;

    public Decorate(Drink drink) {
        this.drink = drink;
    }

    protected Decorate() {
    }
}
