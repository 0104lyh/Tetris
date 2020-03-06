package game;

import java.util.Comparator;

public class ScoreComparator implements Comparator<User>{
	public int compare(User o1, User o2) {
		// TODO Auto-generated method stub
		return o2.getScore()-o1.getScore();
	}
}
