public class PC extends Komputer {
    private int ukuranMonitor;

    public PC() {

    }

    public PC(String merk, int kecProsesor, int sizeMemory, String jnsProsesor, int ukuranMonitor) {
        super(merk, kecProsesor, sizeMemory, jnsProsesor);
        this.ukuranMonitor = ukuranMonitor;
    }

    public void tampilPC() {
        tampilData();
        System.out.println("Ukuran Monitor: " + ukuranMonitor);
    }
}
