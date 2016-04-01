import java.util.Scanner;

public class Driver {

	public static void main(String[] args) {
		int ch;

		Scanner scan=new Scanner(System.in);
		do{
			System.out.println("Select your Choice");
			System.out.println("1.Addition");
			System.out.println("2.Subtraction");
			System.out.println("3.Product");
			System.out.println("4.Power");
			System.out.println("5.PowerLevel2");
			System.out.println("6.Exit");
			ch=scan.nextInt();
			switch(ch){
			case 1:
				System.out.println("Enter a: ");
				String a=scan.next();
				BigNumber a1=new BigNumber(a);
				System.out.println("Enter b: ");
				String b=scan.next();
				BigNumber b1=new BigNumber(b);
				BigNumber example=new BigNumber();
				System.out.println(example.add(a1, b1));
				break;
			case 2:System.out.println("Enter a: ");
			BigNumber example1=new BigNumber();
			BigNumber c1,d1;
			int flag1=0,flag2=0;
			String c=scan.next();
			if(example1.checkSign(c)){
				c1=new BigNumber(c.substring(1));
			    flag1=1;
			}
			else{
				c1=new BigNumber(c);
			}
			System.out.println("Enter b: ");
			String d=scan.next();
			if(example1.checkSign(d)){
				d1=new BigNumber(d.substring(1));
			    flag2=1;                     //flag==1 means it is negative number 
			}
			else{
				d1=new BigNumber(d);
			}			
			if(c.equals(d)){          //if both String are equal
				System.out.println(0);
			    break;
			}
			
			
			if(flag1==0&&flag2==0){            //both number are positive
			     if(example1.isGreater(c1, d1)){          //if first is greater than second
			    	 System.out.println(example1.subtract(c1, d1));
			     }	
			     else System.out.println("-"+example1.subtract(d1, c1));     //if second is greater than first
			
			}
			else if((flag1==0&&flag2==1)||(flag1==1&&flag2==0)){
				System.out.println(example1.add(c1, d1));
			}
			else if(flag1==1&&flag2==1){
				if(example1.isGreater(c1, d1)){
					    System.out.println("-"+example1.subtract(c1, d1));
				}
				else
				   System.out.println(example1.subtract(d1, c1));
			}
		
			//System.out.println(example1.subtract(c1, d1));
			break;
			case 3:
				System.out.println("Enter a: ");
				String e=scan.next();
				BigNumber e1=new BigNumber(e);
				System.out.println("Enter b: ");
				String f=scan.next();
				BigNumber f1=new BigNumber(f);
				BigNumber example2=new BigNumber();
				System.out.println(example2.product(e1, f1));
				break;
			
			case 4:System.out.println("Enter a: ");
			String g=scan.next();
			BigNumber g1=new BigNumber(g);
			System.out.println("Enter b: ");
			long h=scan.nextLong();
			BigNumber example3=new BigNumber();
			System.out.println(example3.power(g1, h));
			break;
			case 5:System.out.println("Enter a: ");
			String s=scan.next();
			BigNumber s1=new BigNumber(s);
			System.out.println("Enter b: ");
			String s2=scan.next();
			BigNumber s3=new BigNumber(s2);
			BigNumber example4=new BigNumber();
			System.out.println(example4.powerLevel2(s1, s3));
			break;
			case 6:System.out.println("Exit");
			break;
			default: System.out.println("Entered Wrong Choice");
			break;
			}
		}while(ch!=6);  
		scan.close();
		System.exit(0);


	}

}
