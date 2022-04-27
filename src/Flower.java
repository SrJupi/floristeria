
public class Flower extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String color;

	public Flower(String color, float price) {
		super(price);
		this.color = color;
	}

	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

}
