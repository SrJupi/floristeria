package Pruebas_Lucas;

public class Tree extends Product {
    private float height;

    public Tree(float height, float price)
    {
        setHeight(height);
        setPrice(price);
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }
}
