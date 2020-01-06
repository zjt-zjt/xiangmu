package xiangmu;

public class homework2 {

	public static void main(String[] args) {
//		Animal animal = new Animal();
//		animal .setAge(5);
//		animal.getAge();
//		animal.setName("袋鼠");
//	    animal.getName(); 
//	    animal .setType("陆地");
//        animal.getType();
//        animal.introduace();
//        Animal animal2 = new Animal("老虎");
//        animal2.introduace();
//        
//        Animal animal3 = new Animal("陆地", "老虎");
//        animal3.introduace();
//        Animal animal4 = new Animal("陆地", "老虎", 2);
//        animal4.introduace();
//           Cup cup = new Cup();	
//           cup.setPrice(5);
//           cup.getPrice();
//           cup.setColor("红色");
//           cup.getColor();
//           cup.setSize("300ml");
//           cup.getSize();
//           cup.setType("保温");
//           cup.getType();
//           cup.introduce();
//		    Cup cup = new Cup("500ml");
//		    cup.introduce();
//		    Cup cup1 = new Cup("500ml", "黑色");
//		    cup1.introduce();
//		    Cup cup2 =new Cup("500ml", "黑色", 5);
//		    cup2.introduce();
//		    Cup cup3 = new Cup("500ml", "黑色", 5, "保温");
//		    cup.introduce();
		
		    
		    
//		    
//		    Shoe shoe = new Shoe();	
//          shoe.setBrand("anta");
//          shoe.getBrand();
//          shoe.setColor("红色");
//          shoe.getColor();
//          shoe.setSize(40.5);
//          shoe.getSize();
//          shoe.setType("运动鞋");
//          shoe.getType();
//          shoe.introduce();
		
		Shoe shoe = new Shoe("anta");
		shoe.introduce();
		
		Shoe shoe1 = new Shoe("anta", 40.5);
		shoe1.introduce();
		
		Shoe shoe2 = new Shoe("anta", 40.5, "黑色");
		shoe2.introduce();
		
		Shoe shoe3 = new Shoe("anta", 40.5, "黑色", "运动鞋");
		shoe3.introduce();
		
	}

}
