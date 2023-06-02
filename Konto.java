public class Konto implements Bankomat {
    private double saldo;
    private String login;
    private String haslo;
    private int PIN;

    public Konto(String login, String haslo, double saldo, int PIN) {
        this.login = login;
        this.haslo = haslo;
        this.saldo = saldo;
        this.PIN = PIN;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public void setHaslo(String haslo) {
        this.haslo = haslo;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public String getLogin() {
        return login;
    }

    public String getHaslo() {
        return haslo;
    }

    public int getPIN() {
        return PIN;
    }


    @Override
    public void test() {
        System.out.println("╔═══════════════════════════╗");
        System.out.println("║       Witamy w banku      ║");
        System.out.println("║                           ║");
        System.out.println("║        Szmallenium        ║");
        System.out.println("╚═══════════════════════════╝");

    }
    public void wybor(){

        System.out.println("╔═══════════════════════════╗");
        System.out.println("║  1 - Wypłać               ║");
        System.out.println("║  2 - Stan konta           ║");
        System.out.println("║  3 - Koniec               ║");
        System.out.println("╚═══════════════════════════╝");

    }

    @Override
    public String toString() {
        return "Konto{" +
                "saldo=" + saldo +
                ", login='" + login + '\'' +
                ", haslo='" + haslo + '\'' +
                ", PIN=" + PIN +
                '}';
    }
}
