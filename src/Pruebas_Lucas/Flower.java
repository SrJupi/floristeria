package Pruebas_Lucas;

public class Flower extends Product {
    private String color;

    public Flower(String color, float price)
    {
        setColor(color);
        setPrice(price);
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }


}
