
public class Decoration extends Product {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public enum Material {
		PLASTIC, WOOD
	};
	
	private Material deco;

	Decoration(Material deco ,float price) {
		super(price);
		this.deco=deco;
		
	}

	public Material getDeco() {
		return deco;
	}

	public void setDeco(Material deco) {
		this.deco = deco;
	}

}
