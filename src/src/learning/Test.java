package learning;

import java.io.IOException;

public class Test {
	   
  	public static void main(String[] args) {
  		FunctionalInterfaceTest functionaInterface = (int a)->{System.out.println("hii"+3);};
  		functionaInterface.addition(3);
   		try {
   			throw new IOException("Hello");
   		} catch(Exception e) {
   			System.out.println(e.getMessage());
   		}
   	}
}
