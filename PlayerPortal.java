import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class PlayerPortal {
	
	private	 int mGuess, mMisses, mBlanks;
	private  String mName;
	
	private  Jar mJar;
	private  GameAdmin gameAdmin;
	
	private  Console console = System.console();
	
	private String highScore = "";
 
	public PlayerPortal(Jar mJar, GameAdmin gameAdmin){
		this.mJar = mJar;
		this.gameAdmin = gameAdmin;
		
	}
	
	
	public void guessMe(){
		
		 
			int newGuess = 0;
			
			highLow();
		
			try{
	  		
				newGuess = Integer.parseInt(console.readLine("%s please guess again between 1 and %d:  ", mName, mJar.getMaxItem()));
				
				
	  		
	  		}catch (NumberFormatException ex){
	  			
	  			mBlanks ++;
	  			
	  			System.out.printf("%s your guess should be a number!!!!!!!!. \n", mName);	
	  			newGuess = 0;
	  		
	  		}
			
			mGuess = newGuess;
			
			
			
		
	}
	
	public void Play(){
	  	  
			mName = console.readLine("Enter Your name:  ");
	       
			System.out.printf("Welcome %s please guess how many %s are in the Jar.  \n", mName, gameAdmin.getItem());
			
			
			System.out.printf("Current least number of tries is by %s.  \n", HighScore());
			
	       
			try{
				
			mGuess = Integer.parseInt(console.readLine("Your guess should be between 1 and %d, Enter your Guess:  ", mJar.getMaxItem()));
			
			
			
			}catch  (NumberFormatException ex){
				
				System.out.printf("Your guess should be a number....: \n");
				mGuess = 0;
				mBlanks ++;
				
				
			}
		
	  	  while (!isSolved() || CheckMaxItem()){
	  		 
	  		guessMe();
	  	  } 
	  	   
	  	 
	  		  
	  		System.out.println("You Win the Jar, Enjoy the Goodies!!! \n");
	  		
	  		System.out.printf("%s you guessed %d times and got it right...  \n", mName, mMisses - mBlanks);
	  		
	  		WriteScore();
	  		  
	  		
	  	  
	    }
	
	public boolean PlayAgain(){
		
		boolean playAgain = false;
		
		String consent = console.readLine("Would you like to play again?? enter [Yes] or [No]:");
		
		if (consent == "Yes"){
			
			System.out.println("You play  again !!! \n");
			
			playAgain = true;
			
			
			
			this.mGuess = 0;
			
			
		}
		
		
		
		return playAgain;
		
		
		
	}
	
	
	public void highLow(){
		
		
		
		
		if (mGuess < mJar.getmItemCount() && !(mGuess == 0) ){
			
			System.out.printf("%s your guess is lower than the answer  \n", mName);
		
		}
		
		if (mGuess > mJar.getmItemCount() && !CheckMaxItem() ){
			
			System.out.printf("%s your guess is higher than the answer  \n", mName);
		
		}
		
	}
	
	public String HighScore(){
		
		FileReader file = null;
		BufferedReader reader = null;
		
		try {
			
			file = new FileReader("Highscore.txt");
			reader = new BufferedReader(file);
			return reader.readLine();
			
		} catch (IOException e) {
			return "0";
		}
		finally{
			
			try {
				if (reader != null)
				reader.close();
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
		
		
		
		
	}
	
	public void WriteScore(){
		
		if ((mMisses - mBlanks) < Integer.parseInt(HighScore().split(": ")[1]) ){
		
		highScore = mName + ": " + (mMisses - mBlanks);  
		
		File scoreFile = new File("Highscore.txt");
		try {
			scoreFile.createNewFile();
		} catch (IOException e) {
			
			e.printStackTrace();
		}
		
		FileWriter file = null;
		BufferedWriter writer = null;
		
		try {
			
			file = new FileWriter("Highscore.txt");
			writer = new BufferedWriter(file);
			writer.write(highScore);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		finally {
			
			
				if (writer != null)
					try {
						writer.close();
					} catch (IOException e) {
						
						e.printStackTrace();
					}
			
		}
		}
		
	}
	
	public boolean CheckMaxItem(){
		
		boolean checkMaxItem = false;
		
		if (mGuess > mJar.getMaxItem()){
			
			
			
			checkMaxItem = true;
			
			
		}
		return checkMaxItem;
		
	}
	    
	    public  boolean isSolved(){
			
	    	boolean solved = false;
	    		
	    	if (getGuessed() == mJar.getmItemCount()){
	    		
	    		  solved = true;
	    	} 
	    		mMisses ++;
	    		  return solved;
	    	
	    }
	   
	   
	
	public String getPlayerName(){
		
		return mName;
	}
	
	public int getGuessed(){
		
		return mGuess;
	}
	
	public int getMisses(){
		
		return mMisses;
	}


	public int getmBlanks() {
		return mBlanks;
	}


	

}