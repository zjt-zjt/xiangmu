package xiangmu;



public class Cup {
	private String type;
	private String color;
	private int price;
	private String size;
	
	public void setType(String type) {
		this.type = type;
	}
	public String getType() {
		return type;
	}
	
	
	public void setSize(String size) {
		this.size = size;
	}
	public String getSize() {
		return size;
	}
	
	
	public void setColor(String color) {
		this.color = color;
	}
	public String getColor() {
		return color;
	}
	
	public void setPrice(int price) {
		this.price = price;
	}
	public int getPrice() {
		return price;
	}
	
	public void introduce() {
		System.out.println(type+size+color+price);
	}
	
    public Cup(String size) {
		this.size = size;
		
	}
	public Cup(String size,String color) {
		this(size);
		this.color = color;
	}
	
	public Cup(String size,String color,int price) {
		this(size,color);
		this.price = price;
	}
	
	public Cup(String size,String color,int price,String type) {
		this(size,color,price);
		this.type = type;
	}
	
	public void drink() {
		System.out.println("ºÈË®");

	}
	public void Heatpreservation() {
		System.out.println("±£ÎÂ");
	}


}
