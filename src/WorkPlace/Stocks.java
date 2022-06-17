package WorkPlace;

import Menu.StocksMenu;
import exeptions.ElseExeption;

import java.io.*;
import java.util.Arrays;

import static Fast.f.a;

public class Stocks {

    private static int StockNum = 1;
    private final int volume = 50;
    static String b;

    public static void newStock() throws IOException {
        System.out.println("Укажите сколько вы собираетесь занять складов");
        int count = a.nextInt();
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
                System.out.println("Удаление закончено\n");
                StocksMenu.menu();
            }
        }
    }

    public static void GenInfo() throws IOException {
        File f=null;
        try {
            File g = new File("/home/IdeaProjects/exam");
            f=g;
        }catch (NullPointerException c){
            System.out.println("Здесь вышла бы ошибка. Укажите путь до папки этого проекта!");
            b=a.nextLine();
            File g = new File(b);
            f = g;
        }
        FilenameFilter filter = new FilenameFilter() {
            @Override
            public boolean accept(File f, String name) {
                return name.endsWith(".txt");
            }
        };
        String[] pathnames = f.list(filter);
        System.out.println(Arrays.toString(pathnames));
        StocksMenu.menu();
    }
}
