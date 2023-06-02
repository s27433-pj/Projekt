import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sejf sejf = new Sejf();
        sejf.setGotowka(900);

        Konto[] konta = new Konto[4];
        konta[0] = new Konto("Login", "Haslo", 90, 1234);
        konta[1] = new Konto("Login", "Haslo", 190, 3040);
        konta[2] = new Konto("Login", "Haslo", 390, 1227);
        konta[3] = new Konto("Login", "Haslo", 1090, 5870);

        boolean kartaZablokowana = false;
        int liczbaProb = 0;

        konta[0].test();

        System.out.println("Wprowadź kartę");
        System.out.println("Podaj PIN:");

        while (true) {
            while (!kartaZablokowana && liczbaProb < 3) {
                int pin = scanner.nextInt();
                int indeksKonta = -1;

                for (int i = 0; i < konta.length; i++) {
                    if (pin == konta[i].getPIN()) {
                        indeksKonta = i;
                        break;
                    }
                }

                if (indeksKonta != -1) {
                    System.out.println("Poprawny PIN.\n");

                    while (true) {

                        konta[0].wybor();

                        int opcja = scanner.nextInt();

                        switch (opcja) {
                            case 1:
                                System.out.println("Wybrano opcję 1");
                                System.out.println("Kwota do wypłaty: ");
                                double kwota = scanner.nextDouble();
                                if (konta[indeksKonta].getSaldo() == 0) {
                                    System.out.println("Brak środków na koncie");
                                } else if (kwota > sejf.getGotowka()) {
                                    System.out.println(Bankomat.ConsoleColors.RED + "Brak wystarczających środków w bankomacie, bankomat jest zablokowany do czasu uzupełnienia środków" + Bankomat.ConsoleColors.RESET);
                                    System.exit(0);
                                } else if (kwota > konta[indeksKonta].getSaldo()) {
                                    System.out.println("Brak wystarczających środków na koncie. Wybierz kwotę poniżej " +
                                            Bankomat.ConsoleColors.RED + konta[indeksKonta].getSaldo() + "PLN" + Bankomat.ConsoleColors.RESET);
                                } else if (kwota <= konta[indeksKonta].getSaldo()) {
                                    konta[indeksKonta].setSaldo(konta[indeksKonta].getSaldo() - kwota);
                                    sejf.setGotowka(sejf.getGotowka() - kwota);
                                    System.out.println("Na koncie pozostało środków do wypłaty: " + konta[indeksKonta].getSaldo() + "PLN\n");
                                }
                                break;
                            case 2:
                                System.out.println("Wybrano opcję 2");
                                System.out.println("Saldo: " + konta[indeksKonta].getSaldo() + "PLN\n");
                                break;
                            case 3:
                                System.out.println("Wybrano opcję 3");
                                System.exit(0);
                                break;
                            default:
                                System.out.println("Nieprawidłowa opcja");
                                break;
                        }
                    }
                } else {
                    liczbaProb++;
                    System.out.println("Błędny PIN. Pozostało prób: " + (3 - liczbaProb));

                    if (liczbaProb == 3) {
                        kartaZablokowana = true;
                        System.out.println("Karta została zablokowana.");
                        System.exit(0);
                    }
                }
            }
        }
    }
}
