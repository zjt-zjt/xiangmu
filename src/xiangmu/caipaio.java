package xiangmu;

import java.util.Random;
import java.util.Scanner;

import javax.lang.model.util.AbstractTypeVisitor6;

public class caipaio {

	static Scanner scanner = new Scanner(System.in);
	static int  money =100;
	static boolean exit =false;
	static int maxcount=30;//�������ɹ����Ʊ
	static int[][]lotteryarray=new int[maxcount][4];//��̬��ʼ����ά���������в�Ʊ
	static int currentindex=0;//��ǰ��Ʊ�ڶ�ά�����λ��
	public static void main(String[] args) {
		
		while(true) {
			if(exit) {
				break;
			}
			menu();
			System.out.println("��ѡ��");
			int num =getuserchoose();
			handleuserchoose(num);
		}
		
		
	}
	
	
	//��ҳ��
public static void menu() {
	System.out.println("..............��ҳ��................................");
	System.out.println("..............1.��ʾ���.................................");
	System.out.println("..............2��ֵ................................");
	System.out.println("..............3��ѡ��Ʊ.................................");
	System.out.println("..............4��ѡ��Ʊ.................................");
	System.out.println("..............5��ʾ�����Ʊ.................................");
	System.out.println("..............6����.................................");
	System.out.println("..............0�˳�.................................");
}
	
	public static int getuserchoose() {
		int n=0;
		while(true) {
			
			n =scanner.nextInt();
			if(n>=0&&n<=6) {
				break;
			}
			else {
				System.out.println("������������������");
			}
		}
		return n;
	}
	
public static void recharge() {
	System.out.println("��ֵ�");
	System.out.println("��50��20����100��50����200��100");
	System.out.println("�������ֵ���");
	int input=0;
	while(true) {
		input = scanner.nextInt();
		if(input>0) {
			break;
		}else {
			System.out.println("�����������������");
		}
	}
	int n=handlerecharge(input);
	money+=n;
	System.out.println("��ֵ�ɹ����������Ϊ"+money);
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
	//�����ѡ��Ʊ����
	public static int typegetlottery () {
		int n=0;
		n=scanner.nextInt();
		while(true) {
			if(n==1||n==2) {
				break;
			}else {
			System.out.println("����������������������");	
			}
		}
		return n;
	}
	
	//��ѡ
	public static void buylotterymuself() {
		System.out.println("��ѡ���Ʊ���ͣ�1.��ѡ 2.����");
		 int type=typegetlottery();
		 int num1=0;
		 int num2=0;
		 int num3=0;
		 System.out.println("������0-9��3������");
		 while(true) {
			num1 = scanner.nextInt() ;
			num2 = scanner.nextInt() ;
			num3 = scanner.nextInt() ;
			if(num1>=0&&num1<=9&&num2>=0&&num2<=9&&num3>=0&&num3<=9) {
				break;
			}else {
				System.out.println("�����������������");
			}
		 }
		int[] lottery = {num1,num2,num3,type};//���浥�Ų�Ʊ
		lotteryarray[currentindex]=lottery;//��һ�Ų�Ʊ(һ������)�ŵ���ά����
		currentindex++;//��¼��ǰ���˶����Ų�Ʊ��ȷ���洢λ��
		money-=2;//
		System.out.println("���ѳɹ�����Ĳ�Ʊ����Ʊ��");
		for(int i=0;i<lottery.length;i++) {
			if(i!=3) {
				System.out.println(lottery[i]+" ");
			}else {
				if(lottery[3]==1) {
					System.out.println("ֱѡ");
				}else{
					System.out.println("����");
				}
			}
			
		}
		 
	}
	
	//��ʾ�ѹ����Ʊ
	public static void buyalwayslottery() {
		for(int i=0;i<currentindex;i++) {
			for(int j=0;j<3;j++) {
				System.out.print(lotteryarray[i][j]+" ");
			}
			if(lotteryarray[i][3]==1) {
				System.out.println("ֱѡ");
			}else {
				System.out.println("����");
			}
		}
		
	}
	//��ѡ
	public static void randomlottery() {
		System.out.println("��ѡ���Ʊ���� 1.ֱѡ2.����");
		int type=typegetlottery();
		System.out.println("������Ҫ�����ע��");
		int count=0;
		while(true) {
			count  =scanner.nextInt();
			if(count>0) {
				if(count+currentindex>maxcount) {
					System.out.println("���ѹ��򳬹�����ȣ�����������");
				}else if(count*2<money) {
					break;
				}else{
					System.out.println("��������Թ���"+count+"ע������������");
				}
			}else {
				System.out.println("�������ע����������������");
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
		System.out.println("�ѹ���"+count+"�ɹ���");
		
	}
	
	//����
	public static void runlottery() {
		System.out.println("��ʾ��������");
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
				System.out.println("����");
				//��ʱ����
			int[] lot1= {runlottery[0],runlottery[1],runlottery[2]};
			int[] lot2= {lottery[0],lottery[1],lottery[2]};
			bubblesort(lot1);
			bubblesort(lot2);
			if(isequar(lot1, lot2)) {
				System.out.println("�н�160");
				money+=160;
			}else{
				System.out.println("лл�ݹ�");
			}
			}else {
				System.out.print("ֱѡ");
				if(isequar( runlottery ,lottery)) {
					System.out.println("�н�1000");
					money+=1000;
				}else{
					System.out.println("лл�ݹ�");
			}	
		}
		}
		
		//������գ��±����
		lotteryarray=new int[maxcount][4];
		currentindex=0;
	}
	
	
	
	
	//�Ƚ����������Ƿ����
	public static boolean isequar(int[]array1,int[]array2) {
		for(int i=0;i<array1.length;i++) {
			if(array1!=array2) {
				return false;
			}
		}
		return true;
	}
	
	//����
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
		 System.out.println("��ʾ���"+money);
		 break;

	 case 2:
     recharge();
		 break;
	 case 3:
		 if(currentindex>30) {
			 System.out.println("�ѹ��򳬳�����޶���ȿ���");
			 break;
		 }
		 else if(money<2) {
			 System.out.println("����");
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
       System.out.println("��ӭ�´�ʹ��");
       exit=true;
		 break;
	}
	 
	 
 }

	
}
