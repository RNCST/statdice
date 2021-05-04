package statdice;

import java.util.Random;

public class StatsRun {
	Random r = new Random();
	StatsVO sVO = new StatsVO();
	int stats[] = new int[4];

	void roll() {
		for (int i = 0; i < stats.length;i++) {
			stats[i] = r.nextInt(10) + 1; 
		}
	}

	void run() {
		for (int i = 0; i < 2; ) {
			i=0;
			roll();
			if ((stats[0] + stats[1] + stats[2] + stats[3] == 25)) {
				i++;
			}
			if (stats[0] >= 4 && stats[1] >= 4 && stats[2] >= 4 && stats[3] >= 4) {
				i++;
			}
		}
		sVO.setPow(stats[0]);
		sVO.setDex(stats[1]);
		sVO.setInt(stats[2]);
		sVO.setLuck(stats[3]);
	}

	void print() {
		System.out.println("당신의 Pow stat은 " +sVO.getPow() + " ");
		System.out.println("당신의 Dex stat은 " +sVO.getDex() + " ");
		System.out.println("당신의 Int stat은 " +sVO.getInt() + " ");
		System.out.println("당신의 Luck stat은 "+sVO.getLuck() + " ");
	}

	String runs() {
		run();
		return "당신의 Pow stat은 "+sVO.getPow()  +", "+ "\n" +
		       "Dex stat은 "+sVO.getDex()  +", "+  "\n" +
		       "Int stat은 "+sVO.getInt()  +", "+  "\n" +
		       "Luck stat은 "+sVO.getLuck() +"입니다. "+  "\n" +
		       "(stats sum=30 && minstat=5)";
	}
	public static void main(String[] args) {
		StatsRun sr = new StatsRun();
		sr.run();
		sr.print();
	}
}
