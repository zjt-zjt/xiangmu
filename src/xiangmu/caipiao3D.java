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
		System.out.println("1.�鿴���");
		System.out.println("2.��ֵ");
		System.out.println("3.��ѡ");
		System.out.println("4.��ѡ");
		System.out.println("5.�鿴����Ĳ�Ʊ");
		System.out.println("6.����");
		System.out.println("0.�˳�");
		System.out.println("������");
		
	}
	
	public static void shuru() {
		
		Scanner scanner =new Scanner(System.in);
		int  n = scanner.nextInt();
		if(n<=6) {
			 System.out.println("������ȷ");
		}
		while(n>6) {
			 System.out.println("���������������");
			 n =scanner.nextInt();
			 
		 }
		 
		 
		} 
		 
		//��ʾ���
	public static void money() {
		System.out.println("�û����Ϊ"+yue);
	}
	//��ֵ�
	public static void chongzhi() {
		System.out.println("��ֵ�����50��20����100��50����300��200");
		System.out.print("��ֵ���Ϊ");
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
			System.out.println("���Ϊ"+n); 
	}
	
	
	//��ѡ
	
	public static  void zixuan() {
		System.out.println("����3��0-9������");
		 Scanner scanner =new Scanner(System.in);
		 int a =scanner.nextInt();
		System.out.println(a);
			 System.out.println("ѡ���Ʊ����");
				System.out.println("0.ֱѡ������ʱ����3������Ҳһ�������н�1000");
				System.out.println("1.������ֻҪ����һ��˳��һ��Ҳ����160");
				yonghuxuan();
				
	}
	
	public static void yonghuxuan() {
		Scanner scanner =new Scanner(System.in);
		int  n = scanner.nextInt();
		switch(n) {
		case 0:
		System.out.println("��ѡ");	
		break;
		case 1:
		System.out.println("����");	
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
				System.out.println("�����������������");
			}
		}
	
		
	}
	}
	
	
}
