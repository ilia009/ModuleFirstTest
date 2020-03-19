import java.math.BigDecimal;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

public class Busket {

    private CopyOnWriteArrayList<Good> goods;

    public Busket(CopyOnWriteArrayList<Good> goods) {
        this.goods = goods;

    }

    public Busket(Busket busket){
        this.goods = busket.getGoods();
    }

    public BigDecimal getTotalPrice(){

        return goods.stream()
                .map(Good::getPrice)
                .reduce(BigDecimal.ZERO, BigDecimal::add);
    }

    public Busket copyBusket(){

        Busket busketCloned = new Busket(goods);
        for (Good good: this.getGoods()){
            busketCloned.getGoods().add(good.clone());
        }
        System.out.println("Cloned goods: ");
        for (Good good: busketCloned.getGoods()){
            System.out.print(good +" ");;
        }

        return busketCloned;
    }

    public void removeExpenciveGods(double price){
        goods.removeIf(good -> good.getPrice().doubleValue()>price);
    }

    public CopyOnWriteArrayList<Good> getGoods() {
        return goods;
    }

    public Busket setGoods(CopyOnWriteArrayList<Good> goods) {
        this.goods = goods;
        return this;
    }

    @Override
    public String toString() {
        return "Busket{" +
                "goods=" + goods +
                '}';
    }
}
