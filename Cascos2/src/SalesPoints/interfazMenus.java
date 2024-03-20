package SalesPoints;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MenuAdminExceptionHandler implements MenuExceptionHandler {

    @Override
    public int handleMenuException(int menu) throws IOException {
        while (true) {
            try {
                BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
                menu = Integer.parseInt(in.readLine());
                if (menu == 1 || menu == 2 || menu == 3) {
                    break;
                }
                System.out.println("Digite un número válido");
            } catch (Exception e) {
                System.out.println("Digite una opción valida");
            }
        }
        return menu;
    }
}
