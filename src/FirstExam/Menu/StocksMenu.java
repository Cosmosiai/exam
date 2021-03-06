package FirstExam.Menu;

import FirstExam.WorkPlace.Stocks;
import FirstExam.exeptions.ElseExeption;

import java.io.IOException;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class StocksMenu {
    public static void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие:\n1)Показать список складов и товаров в них\n2)Добавить новый склад\n3)Удалить склад\n0)Выход в главное меню\nВводите только цифру действия");
        while (true) {
            int a = 0;
            try {
                int b = scanner.nextInt();
                a = b;
            } catch (InputMismatchException c) {
                System.out.println(c);
                ElseExeption.ElseExeption();
                System.out.println();
                menu();
            } finally {
                checker(a);
            }
        }
    }

    public static void checker(int a) throws IOException {
        switch (a) {
            case 1:
                System.out.println(Arrays.toString(Stocks.GenInfo()));
                break;
            case 2:
                Stocks.newStock();
                break;
            case 3:
                Stocks.deliteStock();
                break;
            case 0:
                Menu.menu();
                break;
            default:
                ElseExeption.ElseExeption();
                menu();
                break;
        }
    }
}
