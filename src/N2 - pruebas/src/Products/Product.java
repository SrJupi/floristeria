package Products;

public abstract class Product {

    //private static final long serialVersionUID = 1L;
    protected float price;
    /*Se puede poner en la clase Producto la var TableName, pero lo implemento en las subclases para darle "final"
    con lo que necesita cada tipo de objeto, ej TABLE_NAME = "flower_table".
     */
    protected String InsertQuery;

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public abstract float setInitialPrice();

    public abstract String getTABLE_NAME();

    public abstract String getInsertQuery();


}


