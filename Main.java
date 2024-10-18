public class Main {
    public static void main(String[] args) {
        Komputer kom = new Komputer("LG", 5, 8, "Intel i2");
        Laptop lp = new Laptop("Asus", 10, 16, "Ryzen3", "Lithium-polymer");
        PC pc = new PC("Dell", 6, 32, "Intel i3", 20);
        Mac mac = new Mac("Apple", 12, 64, "Ryzen 5", "Lithium-ion", "Face ID");
        Windows win = new Windows("MSI", 12, 32, "Intel Celeron", "NIkel", "Wireless");

        kom.tampilData();
        System.out.println();

        lp.tampilLaptop();
        System.out.println();

        pc.tampilPC();
        System.out.println();

        mac.tampilMac();
        System.out.println();

        win.tampilWindows();
    }
}