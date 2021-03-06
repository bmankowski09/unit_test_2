package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {

        List<Mama> mamas = new ArrayList<>();

        try {
            File file = new File("src/com/company/mamy.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String[] data = reader.nextLine().split(" ");
                mamas.add(new Mama(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2])));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        }

        List<Dziecko> noworodki = new ArrayList();

        try {
            File childFile = new File("src/com/company/dzieci.txt");
            Scanner childReader = new Scanner(childFile);
            while (childReader.hasNextLine()) {
                String[] data = childReader.nextLine().split(" ");
                Mama mama = mamas.stream()
                        .filter(m -> m.getId() == Integer.parseInt(data[6]))
                        .findAny()
                        .orElse(null);

                Dziecko dziecko = new Dziecko(Integer.parseInt(data[0]), data[1],
                                                                data[2], new SimpleDateFormat("yyyy-MM-dd").parse(data[3]),
                                                                Integer.parseInt(data[4]),
                                                                Integer.parseInt(data[5]), mama);

                noworodki.add(dziecko);
                if (mama != null) {
                    mama.addDziecko(dziecko);
                }
            }


            childReader.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error");
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        System.out.println(noworodki);

        zad1(noworodki);

        zad2(noworodki);

        zad3(noworodki);

        zad4(noworodki);

        zad5(noworodki);


    }

    private static void zad5(List<Dziecko> noworodki) {
        System.out.println("zad5");
        Set<Date> dates = new HashSet<>();
        for (Dziecko d : noworodki) {
            for (Dziecko d2 : noworodki) {
                if (d.getMama().getId() == d2.getMama().getId() &&
                        d.getBornDate().equals(d2.getBornDate()) &&
                        d.getId() != d2.getId()) {
                    dates.add(d.getBornDate());
                }
            }
        }
        dates.forEach(System.out::println);
        System.out.println();

    }

    private static void zad4(List<Dziecko> noworodki) {
        System.out.println("zad4");
        noworodki.stream()
                .filter(dziecko -> dziecko.getMama().getName().equals(dziecko.getName()))
                .forEach(dziecko -> System.out.println(dziecko.getName() + " " + dziecko.getBornDate()));
        System.out.println();
    }

    private static void zad3(List<Dziecko> noworodki) {
        System.out.println("zad3");
        noworodki.stream()
                .filter(dziecko -> dziecko.getWeight() > 4000)
                .filter(dziecko -> dziecko.getMama().getAge() < 25)
                .forEach(dziecko -> System.out.println(dziecko.getMama().getName()));
        System.out.println();

    }

    private static void zad2(List<Dziecko> noworodki) {
        System.out.println("zad2");
        noworodki.stream()
                .map(Dziecko::getBornDate)
                .collect(Collectors.groupingBy(s -> s, Collectors.counting()))
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .ifPresent(System.out::println);
        System.out.println();

    }

    private static void zad1(List<Dziecko> noworodki) {
        System.out.println("zad1");
        Dziecko chlopiec = noworodki.stream()
                .filter(dziecko -> dziecko.getSex().equals("s"))
                .max(Comparator.comparing(Dziecko::getHeight))
                .orElse(null);

        System.out.println(chlopiec.getName() + " " + chlopiec.getHeight() + "cm");

        Dziecko dziewczynka = noworodki.stream()
                .filter(dziecko -> dziecko.getSex().equals("c"))
                .max(Comparator.comparing(Dziecko::getHeight))
                .orElse(null);

        System.out.println(dziewczynka.getName() + " " + dziewczynka.getHeight() + "cm");
        System.out.println();

    }


}


//        Pliki noworodki.txt oraz mamy.txt zawieraj?? dane o dzieciach i ich matkach.
//        W pliku noworodki.txt ka??dy wiersz zawiera nast??puj??ce informacje o jednym dziecku, rozdzielone znakami odst??pu:
//        identyfikator, p??e?? (c ??? c??rka, s ??? syn), imi??, data urodzenia, waga [g], wzrost [cm] oraz identyfikator matki.
//                Przyk??ad:
//        1 c Agnieszka 20-lis-1999 2450 48 33
//        W pliku mamy.txt ka??dy wiersz zawiera informacje o jednej kobiecie, rozdzielone znakami odst??pu: identyfikator matki, imi??, wiek.
//        Przyk??ad:
//        1 Agata 25
//        Identyfikator matki z pliku noworodki.txt odpowiada identyfikatorowi w pliku mamy.txt.
//                Wykorzystuj??c dane zawarte w plikach mamy.txt i noworodki.txt oraz dost??pne narz??dzia informatyczne, wykonaj poni??sze polecenia.
//
//        Podaj imi?? i wzrost najwy??szego ch??opca oraz imi?? i wzrost najwy??szej dziewczynki.
//        Uwaga: Jest tylko jeden taki ch??opiec i tylko jedna taka dziewczynka.
//
//
//        W kt??rym dniu urodzi??o si?? najwi??cej dzieci? Podaj dat?? i liczb?? dzieci.
//        Uwaga: Jest tylko jeden taki dzie??.
//
//                Podaj imiona kobiet w wieku poni??ej 25 lat, kt??re urodzi??y dzieci o wadze powy??ej 4000 g.

//                Podaj imiona i daty urodzenia dziewczynek, kt??re odziedziczy??y imi?? po matce.

//        W pliku noworodki.txt zapisane s?? informacje o narodzinach bli??ni??t. Bli??ni??ta mo??na rozpozna?? po tej samej dacie urodzenia i tym samym identyfikatorze matki.
//                Pami??taj, ??e przyk??adowo Jacek i Agatka oraz Agatka i Jacek to ta sama para. Mo??esz za??o??y??, ??e w danych nie ma ??adnych trojaczk??w, czworaczk??w, itd.
//                Podaj daty, w kt??rych urodzi??y si?? bli??ni??ta.

