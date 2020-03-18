import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.*;
import java.util.stream.Collectors;

public class Shop {
    private List<User> users;
    private List<Good> goods;
    private Map<User,Busket> activeBuskets;

    public Shop() {
        this.users = new ArrayList<>();
        this.goods = new ArrayList<>();
        this.activeBuskets = new HashMap<>();
    }

    public List<User> getVipUsers(){

        return users.stream().filter(user -> user.getVipStatus().equals(User.Status.VIP_STATUS))
                .collect(Collectors.toList());
    }

    public void createBusketForUser(User user) {

        Busket busket = new Busket(goods);
        if (user!= null && !activeBuskets.containsKey(user)) {
            activeBuskets.put(user, busket);
        } else
            System.out.println("where is busket for this user. All goods from new busket will added to existing busket");
            activeBuskets.get(user).setGoods(busket.getGoods());
    }

    public Busket getBusketForUser(User user){
        Optional<Busket> busket = Optional.ofNullable(activeBuskets.get(user));

        return busket.orElse(null);
    }

    public List<User> getUsersWithBusket(){
        return new ArrayList<>(activeBuskets.keySet());
    }

    public List<Good> getGoodsByTitleAndPrice(String word, double price) {
        return goods.stream()
                .filter(good -> good.getTitle().contains(word) && good.getPrice().doubleValue() < price)
                .collect(Collectors.toList());
    }

    //will rewrite in stream!
    public Bill getBillForUser(User user){
        Bill bill = new Bill();
        Busket busket = new Busket(goods);

        bill.setUserName(user.getName());
        bill.setUserAddress(user.getAddress());
        bill.setGoods(getBusketForUser(user).getGoods());
        bill.setTotalPrice(busket.getTotalPrice());

        return bill;
    }

    //may I write in JSON format?
    public void writeBillToFile(Bill bill){
        try {

            File file = new File("bill.txt");
            FileOutputStream fileOut = new FileOutputStream(file.getPath());
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(bill);
            objectOut.close();
            System.out.println("The Bill was succesfully written to a file");

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }

    public void setGoods(List<Good> goods) {
        this.goods = goods;
    }

    @Override
    public String toString() {
        return "Shop{" +
                "users=" + users +
                ", goods=" + goods +
                ", activeBuskets=" + activeBuskets +
                '}';
    }
}
