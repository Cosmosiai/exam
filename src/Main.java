import Menu.Menu;
import exeptions.ElseExeption;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        System.out.println("Добро пожаловать в консольную систему управления складами!");
        Menu.menu();
    }
}
