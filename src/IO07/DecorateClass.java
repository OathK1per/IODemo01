package IO07;

/**
 * 装饰流由四部分组成
 * 1. 抽象组件
 * 2. 具体组件
 * 3. 抽象装饰类
 * 4. 具体装饰类
 *
 * 总结： 重要点，他们都要是Drink的实现类，在装饰类的constructor中加入Drink类型，然后利用fields给其方法以作用
 */
public class DecorateClass {
    public static void main(String[] args) {
        Drink drink = new Coffee();
        Drink milk = new Milk(drink);
        Drink sugar = new Sugar(milk);
        System.out.println(sugar.cost());
        System.out.println(sugar.info());
    }
}
