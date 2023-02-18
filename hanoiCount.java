import java.util.*;
class hanoiCount {
	static int exetime = 0;
	public static int hanoi(int mem[][], int stepCount, int t, int d) {
		int tmp = 0;
		if(t == 3) {
			return (int)Math.pow(2, d)-1;
		}else if(d < t){
			return 2*d-1;
		//�d��
		}else if(mem[t][d]!=0){
			return mem[t][d];
		}else {
			for(int mid=d-1 ; mid>=t-2 ; mid--) {
				//�p�����X��(�ɶ������צ���)
				exetime++;
				if(mid == d-1) {
					stepCount = hanoi(mem, stepCount, t,d-mid)*2 + 
							hanoi(mem, stepCount, t-1,mid);
				}else {
					tmp = hanoi(mem, stepCount, t,d-mid)*2 + 
							hanoi(mem, stepCount, t-1,mid);
					if(tmp < stepCount) {
						stepCount = tmp;
						mem[t][d] = stepCount;
					}
				}
			}
			return stepCount;
		}
	}
	public static void main(String args[]) {
		Scanner input = new Scanner(System.in);
		//�W
		int tower = input.nextInt();
		//�Фl
		int disk = input.nextInt();
		int t = tower, d = disk, stepCount = 0;
		//�O����L���ȥH�K����d��
		int[][] mem = new int[t+1][d+1];
		
		System.out.println(tower + " tower " + disk + " disk: "
				+ hanoi(mem, stepCount, t, d));
		System.out.println("execution time: " + exetime);
	}
}