package Menu;

import WorkPlace.Stocks;
import exeptions.ElseExeption;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class GoodsMenu{

    public static void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Выберите действие:\n1)Добавление товара на склад\n2)Добавление группы товаров на склад\n3)Удаление товара со склада\n4)Удаление группы товаров со склада\n5)Показать типы товаров и их количество\n0)Выход в главное меню\nВводите только цифру действия");
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
                break;
            case 2:
                break;
            case 3:
                break;
            case 4:
                break;
            case 5:
                Stocks.findInfo();
                break;
            case 0:
                Menu.menu();
                break;
            default:
                ElseExeption.ElseExeption();
                menu();
        }
    }

}