import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Bill implements Serializable {
    private String userName;
    private String userAddress;
    private List<Good> goods = new ArrayList<>();
    private BigDecimal totalPrice;

    public Bill() {
    }

    public Bill(String userName, String userAddress, List<Good> goods, BigDecimal totalPrice) {
        this.userName = userName;
        this.userAddress = userAddress;
        this.goods = goods;
        this.totalPrice = totalPrice;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "userName='" + userName + '\'' +
                ", userAddress='" + userAddress + '\'' +
                ", goods=" + goods +
                ", totalPrice=" + totalPrice +
                '}';
    }
}
