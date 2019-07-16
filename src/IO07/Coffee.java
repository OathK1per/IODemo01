package IO07;

public class Coffee implements Drink {
    @Override
    public int cost() {
        return 10;
    }

    @Override
    public String info() {
        return "一杯咖啡";
    }
}
