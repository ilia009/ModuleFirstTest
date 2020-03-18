import java.math.BigDecimal;
import java.util.List;

public class Busket {

    private List<Good> goods;

    public Busket(){

    }

    public Busket(List<Good> goods) {
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

        Busket busketCloned = new Busket();
        for (Good good: this.getGoods()){
            busketCloned.getGoods().add(good.clone());
        }

        return busketCloned;
    }

    public void removeExpenciveGods(double price){
        goods.removeIf(good -> good.getPrice().doubleValue()>price);
    }

    public List<Good> getGoods() {
        return goods;
    }

    public Busket setGoods(List<Good> goods) {
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
