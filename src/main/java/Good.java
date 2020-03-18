import java.math.BigDecimal;

public class Good {
    private final String title;
    private final int code;
    private final String description;
    private final BigDecimal price;


    public Good(String title, int code, String description, BigDecimal price) {
        this.title = title;
        this.code = code;
        this.description = description;
        this.price = price;
    }

    public Good(Good good) {

        this(good.getTitle(), good.getCode(), good.getDescription(), good.getPrice());
    }

    public Good clone(){
        return new Good(this);
    }

    public String getTitle() {
        return title;
    }

    public int getCode() {
        return code;
    }

    public String getDescription() {
        return description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return "Good{" +
                "title='" + title + '\'' +
                ", code=" + code +
                ", description='" + description + '\'' +
                ", price=" + price +
                '}';
    }
}
