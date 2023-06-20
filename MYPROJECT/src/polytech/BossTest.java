package polytech;

class Enermy{
	int hp;
	int ap;
	
	void attack() {
		System.out.println("attack");
		
	}
}

class Boss extends Enermy{
	void powerup(int hp, int ap) {
		System.out.println("powerup!!");
	}
}


public class BossTest {

	public static void main(String[] args) {
		Boss lastboss = new Boss();
		
		lastboss.attack();
		lastboss.powerup(10, 10);

	}

}
