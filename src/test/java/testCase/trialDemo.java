package testCase;


import util.Common.BaseClass;

public class trialDemo extends BaseClass{
	public static boolean WaitElement(int Seconds) {
		for (int i =1; i<=Seconds*1000 ; i++) {
			if (i==Seconds*1000){
				return true;
			}else {
				try {
					System.out.println(i);
					Thread.sleep(1);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
		return false;
	}
	public static void main(String[] args) {
		System.out.println(WaitElement(5));
	}
}
