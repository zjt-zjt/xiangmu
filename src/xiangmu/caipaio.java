package xiangmu;

import java.util.Random;
import java.util.Scanner;

import javax.lang.model.util.AbstractTypeVisitor6;

public class caipaio {

	static Scanner scanner = new Scanner(System.in);
	static int  money =100;
	static boolean exit =false;
	static int maxcount=30;//定义最大可购买彩票
	static int[][]lotteryarray=new int[maxcount][4];//动态初始化二维数组存的所有彩票
	static int currentindex=0;//当前彩票在二维数组的位置
	public static void main(String[] args) {
		
		while(true) {
			if(exit) {
				break;
			}
			menu();
			System.out.println("请选择");
			int num =getuserchoose();
			handleuserchoose(num);
		}
		
		
	}
	
	
	//主页面
public static void menu() {
	System.out.println("..............主页面................................");
	System.out.println("..............1.显示余额.................................");
	System.out.println("..............2充值................................");
	System.out.println("..............3自选彩票.................................");
	System.out.println("..............4机选彩票.................................");
	System.out.println("..............5显示购买彩票.................................");
	System.out.println("..............6开奖.................................");
	System.out.println("..............0退出.................................");
}
	
	public static int getuserchoose() {
		int n=0;
		while(true) {
			
			n =scanner.nextInt();
			if(n>=0&&n<=6) {
				break;
			}
			else {
				System.out.println("输入有误，请重新输入");
			}
		}
		return n;
	}
	
public static void recharge() {
	System.out.println("充值活动");
	System.out.println("充50送20，充100送50，充200送100");
	System.out.println("请输入充值金额");
	int input=0;
	while(true) {
		input = scanner.nextInt();
		if(input>0) {
			break;
		}else {
			System.out.println("输入错误，请重新输入");
		}
	}
	int n=handlerecharge(input);
	money+=n;
	System.out.println("充值成功，现在余额为"+money);
}	
	
	public static int handlerecharge(int n) {
		if(n>=50&&n<100) {
			n+=20;
		}else if(n>=100&&n<200){
			n+=50;
		}else if(n>=200) {
			n+=100;
		}
		return n;
	}
	//获得所选彩票类型
	public static int typegetlottery () {
		int n=0;
		n=scanner.nextInt();
		while(true) {
			if(n==1||n==2) {
				break;
			}else {
			System.out.println("输入类型有误，请重新输入");	
			}
		}
		return n;
	}
	
	//自选
	public static void buylotterymuself() {
		System.out.println("请选择彩票类型，1.自选 2.组六");
		 int type=typegetlottery();
		 int num1=0;
		 int num2=0;
		 int num3=0;
		 System.out.println("请输入0-9的3个数字");
		 while(true) {
			num1 = scanner.nextInt() ;
			num2 = scanner.nextInt() ;
			num3 = scanner.nextInt() ;
			if(num1>=0&&num1<=9&&num2>=0&&num2<=9&&num3>=0&&num3<=9) {
				break;
			}else {
				System.out.println("输入错误，请重新输入");
			}
		 }
		int[] lottery = {num1,num2,num3,type};//储存单张彩票
		lotteryarray[currentindex]=lottery;//把一张彩票(一组数组)放到二维数组
		currentindex++;//记录当前买了多少张彩票，确定存储位置
		money-=2;//
		System.out.println("你已成功购买的彩票，彩票是");
		for(int i=0;i<lottery.length;i++) {
			if(i!=3) {
				System.out.println(lottery[i]+" ");
			}else {
				if(lottery[3]==1) {
					System.out.println("直选");
				}else{
					System.out.println("组六");
				}
			}
			
		}
		 
	}
	
	//显示已购买彩票
	public static void buyalwayslottery() {
		for(int i=0;i<currentindex;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(lotteryarray[i][j]+" ");
			}
			if(lotteryarray[i][3]==1) {
				System.out.println("直选");
			}else {
				System.out.println("组六");
			}
		}
		
	}
	//机选
	public static void randomlottery() {
		System.out.println("请选择彩票类型 1.直选2.组六");
		int type=typegetlottery();
		System.out.println("请输入要购买的注数");
		int count=0;
		while(true) {
			count  =scanner.nextInt();
			if(count>0) {
				if(count+currentindex>maxcount) {
					System.out.println("你已购买超过最大额度，请重新输入");
				}else if(count*2<money) {
					break;
				}else{
					System.out.println("你的余额不足以购买"+count+"注，请重新输入");
				}
			}else {
				System.out.println("你输入的注数有误，请重新输入");
			}
			
		}
		Random random=new Random();
		for(int i=0;i<count;i++) {
		int num1=random.nextInt(10);
		int num2=random.nextInt(10);
		int num3=random.nextInt(10);
		int[] lottery= {num1,num2,num3,type};
		lotteryarray[currentindex]=lottery;
		currentindex++;
		
		}
		money = money-count*2;
		System.out.println("已购买"+count+"成功！");
		
	}
	
	//开奖
	public static void runlottery() {
		System.out.println("显示开奖号码");
		int[] runlottery = new int[3];
		Random random=new Random();
		for(int i=0;i<runlottery.length;i++) {
			runlottery[i]=random.nextInt(10);
			System.out.println(runlottery[i]+" ");
		}
		System.out.println();
		
		for(int i=0;i<currentindex;i++) {
			int []lottery=lotteryarray[i];
			System.out.print(lottery[0]+" "+lottery[1]+" "+lottery[2]+" ");
			if(lottery[3]==3) {
				System.out.println("组六");
				//临时数组
			int[] lot1= {runlottery[0],runlottery[1],runlottery[2]};
			int[] lot2= {lottery[0],lottery[1],lottery[2]};
			bubblesort(lot1);
			bubblesort(lot2);
			if(isequar(lot1, lot2)) {
				System.out.println("中奖160");
				money+=160;
			}else{
				System.out.println("谢谢惠顾");
			}
			}else {
				System.out.print("直选");
				if(isequar( runlottery ,lottery)) {
					System.out.println("中奖1000");
					money+=1000;
				}else{
					System.out.println("谢谢惠顾");
			}	
		}
		}
		
		//数组清空，下标归零
		lotteryarray=new int[maxcount][4];
		currentindex=0;
	}
	
	
	
	
	//比较俩个数组是否相等
	public static boolean isequar(int[]array1,int[]array2) {
		for(int i=0;i<array1.length;i++) {
			if(array1!=array2) {
				return false;
			}
		}
		return true;
	}
	
	//排序
	public static void bubblesort(int[] ary) {
		for(int i=0;i<ary.length-1;i++) {
			for(int j = 0;j<ary.length-1-i;j++) {
				if(ary[j]>ary[j+1]) {
					int type = ary[j];
					ary[j]=ary[j+1];
					ary[j+1]=type;
				}
			}
		}
	}
	
	
	
	
 public static void handleuserchoose(int n) {
	 
	 switch (n) {
	 case 1:
		 System.out.println("显示余额"+money);
		 break;

	 case 2:
     recharge();
		 break;
	 case 3:
		 if(currentindex>30) {
			 System.out.println("已购买超出最大限额，请先开奖");
			 break;
		 }
		 else if(money<2) {
			 System.out.println("余额不足");
			 break;
		 }else {
			 buylotterymuself();
		 }

		 break;
	 case 4:
     randomlottery();
		 break;
	 case 5:
        buyalwayslottery();
		 break;
	 case 6:
    runlottery();
		 break;
	 case 0:
       System.out.println("欢迎下次使用");
       exit=true;
		 break;
	}
	 
	 
 }

	
}
