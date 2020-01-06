package xiangmu;

import java.util.Scanner;
import java.util.concurrent.locks.Condition;

import javax.sql.rowset.CachedRowSet;

public class caipiao3D {

	static int yue =100;
	
	public static void main(String[] args) {
		
      caipiao();
      
      xianshi();  
      
      
	}

	public static void caipiao() {
		System.out.println("1.查看余额");
		System.out.println("2.充值");
		System.out.println("3.自选");
		System.out.println("4.机选");
		System.out.println("5.查看购买的彩票");
		System.out.println("6.开奖");
		System.out.println("0.退出");
		System.out.println("请输入");
		
	}
	
	public static void shuru() {
		
		Scanner scanner =new Scanner(System.in);
		int  n = scanner.nextInt();
		if(n<=6) {
			 System.out.println("输入正确");
		}
		while(n>6) {
			 System.out.println("输入错误，重新输入");
			 n =scanner.nextInt();
			 
		 }
		 
		 
		} 
		 
		//显示余额
	public static void money() {
		System.out.println("用户余额为"+yue);
	}
	//充值活动
	public static void chongzhi() {
		System.out.println("充值活动，充50送20，充100送50，充300送200");
		System.out.print("充值金额为");
		chongzhijine();
		
		
	}
	    

	
	public static void chongzhijine() {
		
		  Scanner scanner =new Scanner(System.in);
			int  n = scanner.nextInt();
			if(n<50) {
				n=n+100;
			}
			else if(n>=50&&n<100) {
				n=120+n;
			}
			else if(n>=100&&n<300){
				n=150+n;
			}
			else if(n>=300) {
				n=300+n;
			}
			System.out.println("余额为"+n); 
	}
	
	
	//自选
	
	public static  void zixuan() {
		System.out.println("输入3个0-9的数字");
		 Scanner scanner =new Scanner(System.in);
		 int a =scanner.nextInt();
		System.out.println(a);
			 System.out.println("选择彩票类型");
				System.out.println("0.直选，开奖时必须3个数字也一样才能中奖1000");
				System.out.println("1.组六，只要数字一样顺序不一样也能中160");
				yonghuxuan();
				
	}
	
	public static void yonghuxuan() {
		Scanner scanner =new Scanner(System.in);
		int  n = scanner.nextInt();
		switch(n) {
		case 0:
		System.out.println("自选");	
		break;
		case 1:
		System.out.println("组六");	
			break;
		}
		
	}
	
	
	public static void xianshi() {
		
		for(int i=0;i<=6;i++) {
		Scanner scanner =new Scanner(System.in);
		int  n = scanner.nextInt();
		
	
		switch(n) {
		case 1:
		   money();	
		break;
		
		case 2:
			chongzhi();	
			break;
			
		case 3:
			zixuan();	
			break;
			default: {
				System.out.println("输入错误，请重新输入");
			}
		}
	
		
	}
	}
	
	
}
