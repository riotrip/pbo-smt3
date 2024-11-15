public class Mac extends Laptop {
    private String security;

    public Mac() {

    }

    public Mac(String merk, int kecProsesor, int sizeMemory, String jnsProsesor, String jnsBaterai, String security) {
        super(merk, kecProsesor, sizeMemory, jnsProsesor, jnsBaterai);
        this.security = security;
    }

    public void tampilMac() {
        tampilLaptop();
        System.out.println("Security: " + security);
    }
}
