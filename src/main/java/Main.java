import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Main {
    public static void main(String[] args) {

        Good banana = new Good("Banana", 01, "", BigDecimal.valueOf(33.0));
        Good monitor = new Good("Monitor", 02, "desc2", BigDecimal.valueOf(90.0));
        Good rabbit = new Good("Rabbit", 03, "", BigDecimal.valueOf(190.0));
        Good car = new Good("Car", 04, "", BigDecimal.valueOf(910.0));
        Good phone = new Good("Phone", 05, "", BigDecimal.valueOf(930.0));

        User user1 = new User("name1", "address1", "email@.ru", User.Status.VIP_STATUS);
        User user2 = new User("name2", "address2", "email@.ru", User.Status.NORMAL_STATUS);
        User user3 = new User("name3", "address3", "email@.ru", User.Status.NORMAL_STATUS);

        List<User> users = new ArrayList<>();
        users.add(user1);
        users.add(user2);
        users.add(user3);

        CopyOnWriteArrayList<Good> goods = new CopyOnWriteArrayList<>();
        goods.add(banana);
        goods.add(monitor);
        goods.add(rabbit);
        goods.add(car);
        goods.add(phone);

        Busket busket = new Busket(goods);
        busket.getGoods().add(banana);
        busket.getGoods().add(phone);
        busket.getGoods().add(banana);

        Shop shop = new Shop();
        shop.setUsers(users);
        shop.setGoods(goods);

        // get VIP users
        System.out.println("The VIP users: " + shop.getVipUsers());

        //create busketForUser
        shop.createBusketForUser(user1);

        //get busketForUser
        System.out.println("The busket for user: " + shop.getBusketForUser(user1));

        //clone busket
        Busket newBusket = busket.copyBusket();

        //remove expencive goods from goods
        busket.removeExpenciveGods(100);

        //get goods by filters
        System.out.println("Filtering goods + " + shop.getGoodsByTitleAndPrice("Banana", 1111.0));

        //write bill to file
        Bill bill = new Bill();
        shop.writeBillToFile(bill);

        //getTotalPrice
        System.out.println("Total price " + busket.getTotalPrice());

        //get user with busket
        System.out.println("User with active busket " + shop.getUsersWithBusket());

        //get bill for user
        System.out.println("Bill work " + shop.getBillForUser(user1));


    }


}
