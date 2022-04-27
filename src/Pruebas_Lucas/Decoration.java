package Pruebas_Lucas;

public class Decoration extends Product {
    public enum material{
        plastic,
        wood
    };
    private material decoration_material;

    public Decoration(material material, float price)
    {
        setDecoration_material(material);
        setPrice(price);
    }

    public material getDecoration_material() {
        return decoration_material;
    }

    public void setDecoration_material(material decoration_material) {
        this.decoration_material = decoration_material;
    }
}
