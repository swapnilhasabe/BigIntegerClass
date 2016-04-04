import java.util.*;

public class BigNumber {
	List<Long> digit;
	List<Long> number; 	
	static long b=10;   
	
	BigNumber(){

	}
	BigNumber(String s){
	
		digit=new ArrayList<>();
		for(int i=s.length()-1;i>=0;i--){
			digit.add((long) Character.getNumericValue(s.charAt(i)));

		}

	}//constructor1
	BigNumber(long num){
		number=new ArrayList<>();
		while(num!=0){
			number.add(num%b);
			num=num/b;
		}

	}//constructor 2
	public String toString(){
		String str ="";
		int size=digit.size()-1;

		while(digit.get(size)==0){
			size=size-1;
			if(size==-1){ 
				size=0;           
				break;
			}
		}
		//if digit contains all zeros
		while(size>=0){
			str+=Long.toString(digit.get(size));	
			size--;
		}
		return str;		
	}
	//addition of two numbers
	BigNumber add(BigNumber a,BigNumber b){
		BigNumber c=new BigNumber("");
		int aLength=a.digit.size();
		int bLength=b.digit.size();
		int count1=0;int count2=0; 
		long carry=0; 
		long sum=0;
		while(count1<aLength&&count2<bLength){
			sum=a.digit.get(count1)+b.digit.get(count2)+carry;
			c.digit.add(sum%10);
			carry=sum/10; 
			count1++;
			count2++;
		}
		while(count1<aLength){
		
			sum=a.digit.get(count1)+carry;
			c.digit.add(sum%10);
			carry=sum/10;
			count1++;
		}
		while(count2<bLength){
			sum=b.digit.get(count2)+carry;
			c.digit.add(sum%10);
			carry=sum/10;
			count2++;
		}
		if(carry!=0) 
			c.digit.add(carry);

		return c;

	}
//helper function for checking signbit
	public boolean checkSign(String s){
		if(s.charAt(0)=='-'){
			return true;
		}
	return false;
	}
	
	//helper function to check which number is greater
	public boolean isGreater(BigNumber a,BigNumber b){
		 int lengthOfNumber1=a.digit.size();
		 int lengthOfNumber2=b.digit.size();
		if(lengthOfNumber1>lengthOfNumber2){
			return true;			
		}
		else if(lengthOfNumber2==lengthOfNumber1){
			int i=lengthOfNumber1-1;   //set index at last element of arraylist
			int j=lengthOfNumber2-1;
			while(i>=0&&j>=0){
				if(a.digit.get(i)>b.digit.get(j)) return true;      //check MST bit
				else if(a.digit.get(i)==b.digit.get(j)){              //if MST bit equal then check next element
					i--;j--;
				}
				else return false;
			}
		}
		else{
			return false;
		}
		return true;           //if they are equal 
		
		  
	}
	
	//function for subtracting two numbers
	BigNumber subtract(BigNumber a,BigNumber b){
		BigNumber c=new BigNumber("");
		int aLength=a.digit.size();
		int bLength=b.digit.size();
		int count1=0;int count2=0; 
	
		long sum=0;
		while(count1<aLength&&count2<bLength){
			if(a.digit.get(count1)>=b.digit.get(count2)){
				sum=a.digit.get(count1)-b.digit.get(count2);
				c.digit.add(sum);
				
			}else{
				a.digit.set(count1+1, a.digit.get(count1+1)-1);
				sum=(10+a.digit.get(count1))-b.digit.get(count2);
				c.digit.add(sum);
			}  

			count1++;
			count2++;

		}

		while(count1<aLength){
			if(a.digit.get(count1)<0){
				a.digit.set(count1+1, a.digit.get(count1+1)-1);
				c.digit.add(a.digit.get(count1)+10);
			}
			else
			c.digit.add(a.digit.get(count1));
			count1++;
		}
		


		return c;


	}

	//multiplication of two numbers
	BigNumber product(BigNumber a,BigNumber b){
		BigNumber c=new BigNumber("");
		BigNumber d=new BigNumber("");

		d.digit.add(0L);
		int aLength=a.digit.size();
		int bLength=b.digit.size();
		int count1;int count2;
		long carry=0;long sum=0,i; 
		for(count1=0;count1<aLength;count1++){
			i=0;
			while(i<count1){
				c.digit.add(0L);
				i++;
			}
			for(count2=0;count2<bLength;count2++){
				sum=(a.digit.get(count1)*b.digit.get(count2))+carry;
				c.digit.add(sum%10);
				carry=sum/10;
			}
			if(carry!=0){
				c.digit.add(carry);
			    carry=0;
			}
			d=add(c, d);
			c.digit.clear();
			
		}
		return d;

	}
	//calculate power of number
	BigNumber power(BigNumber a,long n){
		BigNumber half=new BigNumber("");
		BigNumber result=new BigNumber("");
		if(n==0) {
		a.digit.add(1L);	
		return a;        //if power 0 then answer is always 1
		}
		else if(n==1){		
		return a;       //if power is 1 then answer is itself
		}
		else{
		half=power(a,n/2);
		result=product(half, half);
		
		if(n%2==0){
			return result;
		}else{
		
			return product(result,a);	
		}
		}	
	} 			
//this function is under development
	BigNumber powerLevel2(BigNumber x,BigNumber n){
	long base=10;
	BigNumber result;
	int d=n.digit.size();
	long a0=n.digit.get(0);
	if(d==1){		
		return x.power(x, a0);
	}else{
	
		BigNumber s=shift(n); 		
		 result=powerLevel2(x, s);
		return x.product(x.power(result, base), x.power(x, a0));
	}
		
		
	}
	
private BigNumber shift(BigNumber n) {
	// TODO Auto-generated method stub
	n.digit.remove(0);
	return n;
}

 
	
}
