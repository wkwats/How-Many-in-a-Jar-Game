
public class Game {
	
	
	private static  Jar mJar = new Jar();
	
    
    public static void main(String[] args) {
       
    	
    	System.out.println("\n  ADMINISTRATOR SETUP: \n ====================== \n");
    	
    	System.out.println("Lets create a new Jar of Items !!");
    	 
    	GameAdmin gameAdmin = new GameAdmin();
       
        
        mJar.setMaxItem(gameAdmin.getMaxItem());
        mJar.setItem(gameAdmin.getItem());
        
        System.out.println("Loading....");
        
        mJar.load();
        
        
        
        System.out.println("\n    LETS PLAY !!: \n ==================== \n");
        
        PlayerPortal mPlayer = new PlayerPortal(mJar, gameAdmin);
        
      
        
        mPlayer.Play();
        
       
        
        
        
        
        
        
       
      
    }
    
    
}