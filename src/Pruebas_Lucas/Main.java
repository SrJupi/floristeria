package Pruebas_Lucas;

import java.util.Scanner;

import static Pruebas_Lucas.Floristeria.loadFloristeria;
import static Pruebas_Lucas.Floristeria.saveFloristeria;

public class Main {
    public static void main(String[] args) {
        Floristeria floristeria = new Floristeria();
        Scanner sc = new Scanner(System.in);
        String input;

        boolean isOn = true;

        //bucle para mantener el programa activo hasta que el usuario escriba exit
        //he creado algunas opciones para probar:
        //add = adiciona un producto al "stock"
        //print = imprime el stock por el tipo de objeto
        //stock = imprime la suma del stock
        //save = guarda la floristeria en un archivo txt
        //load = carga la floristeria
        while (isOn){
            System.out.println("Options: exit, add, print, stock, save, load");
            input = sc.nextLine();
            if (input.equals("exit"))
            {
                isOn = false;
            }
            if (input.equals("add"))
            {
                System.out.println("Buy new Tree, Flower or Decoration?");
                input = sc.nextLine();
                floristeria.addItemToStock(input);
            }
            if (input.equals("print"))
            {
                floristeria.getStock();
            }
            if (input.equals("stock"))
            {
                floristeria.getStockValue();
            }
            if (input.equals("save"))
            {
                saveFloristeria(floristeria);
            }
            if (input.equals("load"))
            {
                Floristeria tmp = loadFloristeria();
                if (tmp != null){
                    floristeria = tmp;
                }

            }

        }

    }
}
