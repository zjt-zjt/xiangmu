package xiangmu;

public class homework {
public static void main(String[] args) {
	Computer computer = new Computer();
	computer.type = "联想";
	computer.color = "黑色";
	computer.price = 3500;
	computer.size = 15.6;
	computer.game();
	computer.study();
	computer.movie();
	Computer computer1 = new Computer();
	computer1.type = "戴尔";
	computer1.color = "白色";
	computer1.price = 4000;
	computer1.size = 14.0;
	
	
	Cup cup = new Cup();
	cup.color = "黑色";
	cup.type = "保温";
	cup.size = "500ml";
	cup.price =20;
	cup.drink();
	cup.Heatpreservation();
	Cup cup1 = new Cup();
	cup1.color = "黑色";
	cup1.type = "保温";
	cup1.size = "500ml";
	cup1.price =20;
	
	Shoe shoe =new Shoe();
	shoe.color = "黑色";
	shoe.type = "运动鞋";
	shoe.size = 41;
	shoe.brand = "anta";
	shoe.beautiful();
	shoe.keepwarm();
	Shoe shoe1 =new Shoe();
	shoe1.color = "黑色";
	shoe1.type = "运动鞋";
	shoe1.size = 41;
	shoe1.brand = "anta";
	
	
	Animal animal = new Animal();
	animal.name = "猴子";
	animal.age = 5;
	animal.type = "陆上";
	animal.eat();
	animal.sleep();
	animal.play();
	Animal animal1 = new Animal();
	animal1.name = "猴子";
	animal1.age = 5;
	animal1.type = "陆上";
	
	Car car = new Car();
	car.color ="红色";
	car.appearance = "好看";
	car.brand = "宝马";
	car.price = 500000;
	car.Travelisconvenient();
	car.cool();
	
	Car car1 = new Car();
	car1.color ="红色";
	car1.appearance = "好看";
	car1.brand = "宝马";
	car1.price = 500000;

	
	
}
	
}
