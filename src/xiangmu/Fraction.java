package xiangmu;

public class Fraction {
  private int top;
  private int bottom;
  
  
  public Fraction(int top,int bottom) {
	  if(bottom ==0) {
		  System.out.println("分母给定错误，不能为0");
		  this.top = 0;
	  }else {
		  this.top = top;
	  }

	  this.bottom = bottom;
  }


  public int getTop() {
	  return top;
  }


  public void setTop(int top) {
	  this.top = top;
  }


  public int getBottom() {
	  return bottom;
  }


  public void setBottom(int bottom) {
	  this.bottom = bottom;
  } 


public Fraction add(Fraction other) {
	int top = this.top*other.bottom+this.bottom*other.top;
	int bottom = this.bottom*other.bottom;
	Fraction newFraction = new Fraction(top, bottom);
	newFraction.reduce();
}
  


  public void reduce() {
	int gcd = getGcd(this.top, this.bottom);
	  this.top/=gcd;
	  this.bottom/=gcd;
	  
}
  
	private int getGcd(int t,int b) {
		int temp = t%b;
		while(temp!=0) {
			t=b;
			b=temp;
			temp = t%b;
		}
		
		return b;
	}
  
  
	
}
