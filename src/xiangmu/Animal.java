package xiangmu;

public class Animal {
  private  String type;
  private  String name;
   private int age;
   
   
   public void setType(String type) {
	this.type = type;
}
   public String getType() {
	   return type;
   }
   
   
   public void setName(String name) {
		this.name = name;
	}
	   public String getName() {
		   return name;
	   }
	   
	   
	   public void setAge(int age) {
			this.age = age;
		}
		   public int getAge() {
			   return age;
		   }  
		   
	public void introduace() {
		System.out.println("我是"+type+name+" "+"年龄是"+age);
	}	   
		   
	
	public Animal (String name) {
		this.name = name;
	}
	
	public Animal (String type,String name) {
		this(name);
		this.type = type;
	}
	
	public Animal (String type,String name,int age) {
		this(type, name);
		this.age = age;
	}
	
   
   public void eat() {
	System.out.println("吃饭");
}
	public void sleep() {
		System.out.println("睡觉");
	}
	public void play() {
		System.out.println("玩耍");
	}
}
