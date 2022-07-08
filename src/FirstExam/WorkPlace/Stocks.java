package FirstExam.WorkPlace;


import FirstExam.Menu.StocksMenu;
import FirstExam.exeptions.ElseExeption;

import java.io.*;
import java.util.InputMismatchException;
import java.util.Scanner;

import static FirstExam.Fast.f.*;

public class Stocks {
    static Scanner sc = new Scanner(System.in);

    private static int StockNum = 1;
    private final int volume = 50;
    static String b;

    public static void newStock() throws IOException {
        System.out.println("Укажите сколько вы собираетесь занять складов");
        int count = 0;
        try {
            int d = sc.nextInt();
            if (d < 0) {
                StocksMenu.menu();
            }
            count = d;
        } catch (InputMismatchException i) {
            ElseExeption.ElseExeption();
            sc.nextLine();
            newStock();
        }


        for (int i = 0; i < count; i++) {
            System.out.println("Укажите уникальное имя для вашего склада");

            String StockName = a.nextLine();
            if (StockName == "") {
                StockName = a.nextLine();
            }
            FileWriter fl = new FileWriter(StockName + ".txt");
            fl.write(a.nextLine());
            fl.close();
            System.out.println(StockNum);
            StockNum++;
        }
        StocksMenu.menu();
    }

    public static void findInfo() throws IOException {
        System.out.println("Укажите название нужного склада");
        String b = a.nextLine();
        try {
            FileReader fl = new FileReader(b + ".txt");
        } catch (FileNotFoundException c) {
            System.out.println(c + "\nТакого склада нет. Хотели бы создать? Y/N");
            b = a.nextLine();
            if (b.equals("y") || b.equals("Y")) {
                Stocks.newStock();
            }
            System.out.println("Хотели бы повторить проверку?");
            b = a.nextLine();
            if (b.equals("y") || b.equals("Y")) {
                Stocks.findInfo();
            }
        }
    }

    public static void deliteStock() throws IOException {
        GenInfo();
        System.out.println("Хотите удалить все пустые склады? Y/N");
        String[] as = GenInfo();
        b = a.nextLine();
        if (b.equals("y") || b.equals("Y")) {
            for (String i :
                    as) {
                File fl=new File(i);
                if (fl.length()==0){
                    fl.delete();
                }
            }
            System.out.println("Удаление успешно завершено\n");
            StocksMenu.menu();
        }
        System.out.println("\nУкажите имя удаляемого склада. Введите 0 для отмены:");
        b = a.nextLine();
        if (b.equals("0")) {
            StocksMenu.menu();
        }
        File fl = new File(b + ".txt");
        try {
            FileReader fl1 = new FileReader(b + ".txt");
        } catch (FileNotFoundException c) {
            ElseExeption.ElseExeption();
            deliteStock();
        } finally {
            if (fl.length() != 0) {
                System.out.println("Склад несвободен. Реализуйте товар!");
                StocksMenu.menu();
            } else {
                fl.delete();
                System.out.println("Удаление закончено\n");
                StocksMenu.menu();
            }
        }
    }

    public static String[] GenInfo() throws IOException {
        File d = null;
        try {
            File g = new File("/home/akyl/IdeaProjects/exam/");
            d = g;
        } catch (NullPointerException c) {
            System.out.println("Здесь вышла бы ошибка. Укажите путь до папки этого проекта!");
            b = a.nextLine();
            File g = new File(b);
            d = g;
        }
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(".txt");
            }
        };
        String[] pathnames = d.list(filter);
        return pathnames;
    }
}
