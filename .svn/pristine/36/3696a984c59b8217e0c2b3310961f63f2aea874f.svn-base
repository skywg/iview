package test;

public class Test {
	static int total = 10000;
	static int perid = 12;
	static double ratio = 1.8;
	public static void main(String[] args) {
		double ext = 0d;
		double tmp = total;
		for(int i=1;i<=perid;i++){
			tmp = total * i/12;
			ext+=(tmp*0.01*ratio*(13-i)/12);
			System.out.println(ext);
		}
		System.out.println(ext-75*perid*0.5);
	}
}
