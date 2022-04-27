package Pruebas_Lucas;

import java.io.Serializable;

//classe fabrica de los produtos
//la he hecho "hard-coded" solo para probar
//tenemos que ver como vamos a elegir tamaño, colores y materiales...
public class ProductsFactory implements Serializable {
    public Product getProduct(String productType){
        if(productType == null){
            return null;
        }
        if(productType.equalsIgnoreCase("Tree")){
            return new Tree(1.5f, 20);

        } else if(productType.equalsIgnoreCase("Flower")){
            return new Flower("red", 5);

        } else if(productType.equalsIgnoreCase("Decoration")){
            return new Decoration(Decoration.material.wood, 3);
        }

        return null;
    }
}
