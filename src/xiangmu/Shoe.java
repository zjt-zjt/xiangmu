package xiangmu;

public class Shoe {
   private  String brand;
   private  String color;
   private  double size;
    private String type;
	
    public void setBrand(String brand) {
		this.brand = brand;
	}
    public String getBrand() {
    	return brand;
    }
    
    
    public void setType(String type) {
		this.type = type;
	}
    public String getType() {
    	return type;
    }
    
    
    public void setColor(String color) {
		this.color = color;
	}
    public String getColor() {
    	return color;
    }
    
    public void setSize(double size) {
		this.size = size;
	}
    public double getSize() {
    	return size;
    }
    
    public void introduce() {
		System.out.println(size+color+brand+type);
	}
    
   
    
    
    public Shoe(String brand) {
		this(brand, 0, null, null);
	}
	
	public Shoe(String brand,double size) {
		this(brand, size, null, null);
	}
	public Shoe(String brand,double size,String color) {
		this(brand, size, color, null);
		
	}
	
	public Shoe(String brand,double size,String color,String type) {
		
		this.type = type;
		this.brand = brand;
		this.size = size;
		this.color = color;
	}
    
    
    
    
    
     public void keepwarm() {
		System.out.println("±£≈Ø");
	}
	
	public void beautiful() {
		System.out.println("√¿π€");
	}
}
