public class User {
    private final String name;
    private final String address;
    private final String emailAdress;
    private final Status vipStatus;


    public User(String name, String address, String emailAdress, Status vipStatus) {
        this.name = name;
        this.address = address;
        this.emailAdress = emailAdress;
        this.vipStatus = vipStatus;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Status getVipStatus() {
        return vipStatus;
    }

    enum Status {
        VIP_STATUS("VIP"),
        NORMAL_STATUS("");

        private String status;

        Status(String status) {
            this.status = status;
        }
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", emailAdress='" + emailAdress + '\'' +
                ", vipStatus=" + vipStatus +
                '}';
    }
}
