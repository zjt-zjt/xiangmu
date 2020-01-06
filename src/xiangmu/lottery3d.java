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
			System.out.println("��ѡ��");
			int num =usechoose();
			handlechoose(num);
			}
		}
		

	}
	
	//���˵�
	public static void menu() {
		System.out.println(".....................3Dlottery....................");
		System.out.println("......................1.��ʾ���..........................................................");
		System.out.println(".......................2.��ֵ.............................................................");
		System.out.println(".......................3.��ѡ...........................................................");
		System.out.println("........................4.��ѡ...........................................................");
		System.out.println(".........................5.��ʾ�ѹ����Ʊ........................................");
		System.out.println("...........................6.����...................................................");
		System.out.println("............................0.�˳�.................................................");
	}
	

	public static int usechoose() {
		int n=0;
		while (true) {
			n = scanner.nextInt();
			if(n>=0&n<=6) {
				break;
			}else{
				System.out.println("�����������������");
			}
			
		}
		
		    return n;
	}
	
	//��ֵ
	public static void recharge() {
		System.out.println("��ֵ�");
		System.out.println("��50��20����100��50����200��100");
		System.out.println("��ֵ���");
		int input=0;
		while(true){
			input = scanner.nextInt();
		if(input>0) {
			break;
		}else {
			System.out.println("�����������������");
		}
		
		}
		int n =handlerecharge(input);
		money+=n;
		System.out.println("��ֵ�ɹ������Ϊ"+money);
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
	
	//��ѡ
	public static void choosemyself() {
		System.out.println("��ѡ�����ͣ�1.ֱѡ2.����");
		int type = typechoose();
		int num1 = 0;
		int num2 = 0;
		int num3 = 0;
		System.out.println("������3��0-9������");
		while(true) {
			num1=scanner.nextInt();
			num2=scanner.nextInt();
			num3=scanner.nextInt();
			if((num1>=0&&num1<=9)&&(num2<=9&&num2>=0)&&(num3<=9&&num3>=0)) {
				break;
			}else {
				System.out.println("�����������������");
			}
		}
		int[] lottery = {num1,num2,num3,type};
		lotteryarray[currentidex] = lottery;
		currentidex++;
		money-=2;
		System.out.println("���ѳɹ������Ʊ����Ʊ��");
		for(int i=0;i<lottery.length;i++) {
			if(i!=3) {
				System.out.println(lottery[i]+" ");
			}else {
				if(lottery[3]==1) {
					System.out.println("ֱѡ");
				}else {
					System.out.println("����");
				}
			}
		}
	}
	
	//��ѡ
	public static void randomchoose() {
		System.out.println("��ѡ���Ʊ����1.ֱѡ2.��ѡ");
		int type = typechoose();
		System.out.println("��ѡ�����ע��");
		int count = 0;
		while(true) {
			count = scanner.nextInt();
			if(count>0) {
			if(count+currentidex>maxcount) {
				System.out.println("���ѹ��򳬹�����ȣ�����������");
				
			}else if(count*2<money) {
				break;
			}else {
				System.out.println("���������"+count+"����������");
			}
		}else {
			System.out.println("�����������������");
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
			System.out.println("���ѳɹ�����"+count);
		}
		
		
	}
	
	//����
	public static void runLottery() {
		System.out.println("��ʾ��������");
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
				System.out.println("����");
				int[] lot1 = {runLottery[0],runLottery[1],runLottery[2],				};
				int[] lot2 = {lottery[0],lottery[1],lottery[2]};
				compare(lot1);
				compare(lot2);
				if(equial(lot1, lot2)) {
					System.out.println("�н�160");
					money+=160;
				}else {
					System.out.println("лл�ݹ�");
				}
			}else {
				System.out.println("ֱѡ");
				if(equial(runLottery, lottery)) {
					System.out.println("�н�1000");
					money+=1000;
				}else {
					System.out.println("лл�ݹ�");
				}
			}
		}
		
	}
	
	
	//�Ƚ���������
	public static boolean equial(int[] ary1,int[] ary2) {
		for(int i =0;i<ary1.length;i++) {
			if(ary1!=ary2) {
				return false;
			}
		}
		return true;
	}
	
	
	//����
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
	
	//��ò�Ʊ����
	public static int typechoose() {
		int n = 0;
		while(true){
			n=scanner.nextInt();
		if(n==1||n==2) {
			break;
		}else {
			System.out.println("������������������");
		}
		}
		return n;
	}
	
	//�鿴�ѹ����Ʊ
	public static void buyAlwaysLottery() {
		for (int i = 0;i<currentidex;i++) {
			for(int j = 0;j<3;j++) {
				System.out.println(lotteryarray[i][j]+" ");
			}
			if(lotteryarray[i][3]==1) {
				System.out.println("ֱѡ");
			}else {
				System.out.println("����");
			}
		}
	}
	
	
	public static void handlechoose(int n) {
		switch (n) {
		case 1:
			System.out.println("��ʾ���"+money);
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
			System.out.println("��ӭ�´�ʹ��");
			exit = true;
			break;
		

		
		}
	}
	
}
