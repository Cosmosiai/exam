package FirstExam.Menu;

import FirstExam.exeptions.ElseExeption;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Menu {
    boolean v;

    public static void menu() throws IOException {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Выберите действие:\n1)Работа с товарами\n2)Работа со складами\n0)Выход из программы\nВводите только цифру действия");
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
            }
            if (checker(a)) {
                break;
            }
        }
    }

    public static boolean checker(int a) throws IOException {
        if (a == 1) {
            GoodsMenu.menu();
        } else if (a == 2) {
            StocksMenu.menu();
        } else if (a == 0) {
            System.out.println("Спасибо за пользование нашей программой!\nДо свидания!");

        } else {
            ElseExeption.ElseExeption();
            menu();
        }
        return true;
    }


}
