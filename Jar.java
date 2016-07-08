
import java.util.Random;


public class Jar {
 
  private int MAX_ITEM = 12;
  private String mItemName;
  private int mItemCount;
  
  
  
  
  public void load () {
  
	  	Random random = new Random();
	    int ranNum;
	  	 ranNum = 1 + random.nextInt(MAX_ITEM);
	    
	  	mItemCount = ranNum;
    
  }
  
  
  
  public void setMaxItem(int maxItem){
	  MAX_ITEM = maxItem;
	  
  }
  
  public void setItem(String itemName){
	  mItemName = itemName;
	  
  }
   
  public String getItemName() {
    return mItemName;
  }
  public int getMaxItem() {
	    return MAX_ITEM;
	  }



  public int getmItemCount() {
	return mItemCount;
  	}
  
 


}