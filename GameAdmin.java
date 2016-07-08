import java.io.Console;

public class GameAdmin {
	
	private int MAX_ITEM;
	private String mItem;
 
	public GameAdmin(){
		promptForItem();
		
	}
	
	private void promptForItem() {
        
		
		Console console = System.console();
       
        mItem = console.readLine("Enter The name of the Item to load in the Jar:  ");
        
        
        checkMaxItem();
        
    }
	
	public void checkMaxItem(){
		
		Console console = System.console();
		
		try{
	        
		    MAX_ITEM = Integer.parseInt(console.readLine("Enter Maximum Number of %s:  ", mItem));   
		       
		      }catch (NumberFormatException ex) {
		    	 
		    	  checkMaxItem();  
		    	   
		      }
		
	}
	
	
	
	public String getItem(){
		
		return mItem;
	}
	
	public int getMaxItem(){
		
		return MAX_ITEM;
	}

}
