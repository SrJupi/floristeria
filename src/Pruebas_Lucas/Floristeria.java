package Pruebas_Lucas;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Floristeria implements Serializable {
    //"stock" mientras no lo creamos
    private ArrayList<Product> stock = new ArrayList<>();

    //fabrica de objetos
    private ProductsFactory fabrica = new ProductsFactory();

    //metodo para imprimir lo que hay en stock
    public void getStock() {
        for (Product p :
                stock) {
            System.out.println(p.getClass());
        }
    }

    //metodo para imprimir el valor del stock
    public void getStockValue() {
        float totalStock = 0;
        for (Product p :
                stock) {
            totalStock += p.getPrice();
        }
        System.out.printf("Total stock value: %.2f%n", totalStock);
    }

    //metodo para adicionar objeto al stock
    public void addItemToStock(String productType){
        Product newProduct = fabrica.getProduct(productType);
        stock.add(newProduct);
    }

    //metodo para guardar la floristeria
    //creo que seria mejor ponerlo en otra clase, como una clase Save/Load
    //pero lo he hecho junto solo para probar
    public static void saveFloristeria(Object serObj) {

        try {
            FileOutputStream fileOut = new FileOutputStream(System.getProperty("user.dir")
                    + "\\floristeria.txt");
            ObjectOutputStream objectOut = new ObjectOutputStream(fileOut);
            objectOut.writeObject(serObj);
            objectOut.close();
            System.out.println("The Object was successfully written to "
                    + System.getProperty("user.dir") + "\\floristeria.txt");

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    //metodo para cargar la floristeria
    //creo que seria mejor ponerlo en otra clase, como una clase Save/Load
    //pero lo he hecho junto solo para probar
    public static Floristeria loadFloristeria() {

        if(Files.exists(Path.of(System.getProperty("user.dir") + "\\floristeria.txt"))){
            try {

                InputStream fileIn = Files.newInputStream(Path.of(System.getProperty("user.dir")
                        + "\\floristeria.txt"));
                ObjectInputStream objectIn = new ObjectInputStream(fileIn);
                Object returnFloristeria = objectIn.readObject();
                objectIn.close();
                System.out.println("The Object was successfully read at: " + System.getProperty("user.dir")
                        + "\\floristeria.txt");
                return (Floristeria) returnFloristeria;

            } catch (Exception ex) {
                System.out.println("Object could not be read: "+ System.getProperty("user.dir")
                        + "\\floristeria.txt");
                return null;
            }
        }else{
            System.out.println("Save file does not exist");
            return null;
        }
    }

}
