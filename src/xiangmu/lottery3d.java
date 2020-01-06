package xiangmu;

import java.io.Externalizable;
import java.util.Random;
import java.util.Scanner;

public class lottery3d {
      static int money = 100;
      static Scanner scanner = new Scanner(System.in);
      static boolean exit = false;
      static int maxcount =30;
      static int[][]lotteryarray = new int[maxcount][4];
      static  int currentidex = 0;
	public static void main(String[] args) {
		while(true) {
			
			if(exit) {
				break;
			}
			else{menu();
			System.out.println("请选择");
			int num =usechoose();
			handlechoose(num);
			}
		}
		

	}
	
	//主菜单
	public static void menu() {
		System.out.println(".....................3Dlottery....................");
		System.out.println("......................1.显示余额..........................................................");
		System.out.println(".......................2.充值.............................................................");
		System.out.println(".......................3.自选...........................................................");
		System.out.println("........................4.机选...........................................................");
		System.out.println(".........................5.显示已购买彩票........................................");
		System.out.println("...........................6.开奖...................................................");
		System.out.println("............................0.退出.................................................");
	}
	

	public static int usechoose() {
		int n=0;
		while (true) {
			n = scanner.nextInt();
			if(n>=0&n<=6) {
				break;
			}else{
				System.out.println("输入错误，请重新输入");
			}
			
		}
		
		    return n;
	}
	
	//充值
	public static void recharge() {
		System.out.println("充值活动");
		System.out.println("充50送20，充100送50，充200送100");
		System.out.println("充值金额");
		int input=0;
		while(true){
			input = scanner.nextInt();
		if(input>0) {
			break;
		}else {
			System.out.println("输入错误，请重新输入");
		}
		
		}
		int n =handlerecharge(input);
		money+=n;
		System.out.println("充值成功，余额为"+money);
	}
	
	
	public static int handlerecharge(int n) {
		if(n>=50&&n<100) {
			n+=20;
		}else if(n>=100&&n<200) {
			n+=50;
		}else if(n>=200) {
			n+=100;
		}
		return n;
	}
	
	//自选
	public static void choosemyself() {
		System.out.println("请选择类型，1.直选2.组六");
		int type = typechoose();
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		System.out.println("请输入3个0-9的数字");
		while(true) {
			num1=scanner.nextInt();
			num2=scanner.nextInt();
			num3=scanner.nextInt();
			if((num1>=0&&num1<=9)&&(num2<=9&&num2>=0)&&(num3<=9&&num3>=0)) {
				break;
			}else {
				System.out.println("输入错误，请重新输入");
			}
		}
		int[] lottery = {num1,num2,num3,type};
		lotteryarray[currentidex] = lottery;
		currentidex++;
		money-=2;
		System.out.println("你已成功购买彩票，彩票是");
		for(int i=0;i<lottery.length;i++) {
			if(i!=3) {
				System.out.println(lottery[i]+" ");
			}else {
				if(lottery[3]==1) {
					System.out.println("直选");
				}else {
					System.out.println("组六");
				}
			}
		}
	}
	
	//机选
	public static void randomchoose() {
		System.out.println("请选择彩票类型1.直选2.机选");
		int type = typechoose();
		System.out.println("请选择购买的注数");
		int count = 0;
		while(true) {
			count = scanner.nextInt();
			if(count>0) {
			if(count+currentidex>maxcount) {
				System.out.println("你已购买超过最大额度，请重新输入");
				
			}else if(count*2<money) {
				break;
			}else {
				System.out.println("你的余额不足买"+count+"请重新输入");
			}
		}else {
			System.out.println("输入错误，请重新输入");
		}
			
			Random random = new Random();
			for(int i=0;i<count;i++) {
				int num1 = scanner.nextInt(10);
				int num2 = scanner.nextInt(10);
				int num3 = scanner.nextInt(10);
			int[] lottery = {num1,num2,num3,type};
			lotteryarray[currentidex] = lottery;
			currentidex++;	
				
			}
			money = money-count*2;
			System.out.println("你已成功购买"+count);
		}
		
		
	}
	
	//开奖
	public static void runLottery() {
		System.out.println("显示开奖号码");
		int[] runLottery = new int[3];
		Random random  = new Random();
		for(int i=0; i<runLottery.length;i++) {
			runLottery[i] = random.nextInt(10);
			System.out.print(runLottery[i]+" ");
		}
		System.out.println();
		for(int i = 0;i<currentidex;i++) {
			int [] lottery = lotteryarray[i];
			System.out.print(lottery[0]+" "+lottery[1]+" "+lottery[2]+" ");
			if(lottery[3]==3) {
				System.out.println("组六");
				int[] lot1 = {runLottery[0],runLottery[1],runLottery[2],				};
				int[] lot2 = {lottery[0],lottery[1],lottery[2]};
				compare(lot1);
				compare(lot2);
				if(equial(lot1, lot2)) {
					System.out.println("中奖160");
					money+=160;
				}else {
					System.out.println("谢谢惠顾");
				}
			}else {
				System.out.println("直选");
				if(equial(runLottery, lottery)) {
					System.out.println("中奖1000");
					money+=1000;
				}else {
					System.out.println("谢谢惠顾");
				}
			}
		}
		
	}
	
	
	//比较俩个数组
	public static boolean equial(int[] ary1,int[] ary2) {
		for(int i =0;i<ary1.length;i++) {
			if(ary1!=ary2) {
				return false;
			}
		}
		return true;
	}
	
	
	//排序
	public static void compare(int[] ary) {
		for(int i =0;i<ary.length-1;i++) {
			for(int j = 0;j<ary.length-1-i;j++) {
				if(ary[j]>ary[j+1]) {
					int type = ary[j];
					ary[j] = ary[j++];
					ary[j++] = type;
				}
			}
		}
		
	}
	
	//获得彩票类型
	public static int typechoose() {
		int n = 0;
		while(true){
			n=scanner.nextInt();
		if(n==1||n==2) {
			break;
		}else {
			System.out.println("输入有误，请重新输入");
		}
		}
		return n;
	}
	
	//查看已购买彩票
	public static void buyAlwaysLottery() {
		for (int i = 0;i<currentidex;i++) {
			for(int j = 0;j<3;j++) {
				System.out.println(lotteryarray[i][j]+" ");
			}
			if(lotteryarray[i][3]==1) {
				System.out.println("直选");
			}else {
				System.out.println("组六");
			}
		}
	}
	
	
	public static void handlechoose(int n) {
		switch (n) {
		case 1:
			System.out.println("显示余额"+money);
			break;
		case 2:
			recharge();
			break;
		case 3:
			choosemyself();
			break;
		case 4:
			randomchoose();
			break;
		case 5:
			buyAlwaysLottery();
			break;
		case 6:
			runLottery();
			break;
		case 0:
			System.out.println("欢迎下次使用");
			exit = true;
			break;
		

		
		}
	}
	
}
