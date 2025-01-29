package studio2;

public class Ruin {

	public static void main(String[] args) {
		int startAmount = 2;
		double winChance = 0.7;
		int winLimit = 10;
		int totalSimulations = 500;
		boolean ruin = false;
		String happy = "";
		int countWin = 0;
		int countLoss = 0;
		double expectedRuin;
		double alpha = (1- winChance)/winChance;
	
		
		
		for (int counter = 1; counter <= totalSimulations; counter++) {
			startAmount = 2;
			ruin = false;
			
			
			while ((startAmount < winLimit) && (ruin != true)) {
			
				
			double randomNum = Math.random();	
				if (randomNum > winChance) {
					startAmount--;
					
				}
				else {
					startAmount++;
				}
				
				if(startAmount == 0) {
					ruin = true;
				}
				
				
				
				
				
			
				
			}
			 
			if (ruin == true) { 
				happy = "LOSE";
				countLoss++;
			}
			if (ruin != true) {
				happy = "WIN";
				countWin++;
			}
			System.out.println("Simulation " + counter + ": " +  startAmount + " " + happy);
			
		}
		
		System.out.println("Losses: " + countLoss + " Simulations: " + totalSimulations);
		
		if(winChance == 0.5) {
			expectedRuin = (startAmount/winLimit);

		}
		
		else {
			expectedRuin = ((Math.pow(alpha,startAmount)- Math.pow(alpha, winLimit))/ (1 - Math.pow(alpha,  winLimit)));
		}
		
		System.out.println("Ruin rate from simulation: " + ((countLoss)/totalSimulations) + " Expected Ruin rate: " + expectedRuin);
		

	}

}
