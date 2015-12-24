package poker;


import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;



/**
 * A poker hand is a list of cards, which can be of some "kind" (pair, straight, etc.)
 * 
 */
public class Hand implements Comparable<Hand> {

    public enum Kind {HIGH_CARD, PAIR, TWO_PAIR, THREE_OF_A_KIND, STRAIGHT, 
        FLUSH, FULL_HOUSE, FOUR_OF_A_KIND, STRAIGHT_FLUSH}

    private final List<Card> cards=null;

    /**
     * Create a hand from a string containing all cards (e,g, "5C TD AH QS 2D")
     */
    public Hand(String c) {
    	String[] temp;
    	temp = c.split(" ");
       for (String s: temp){
    	   cards.add(new Card(s));
       }
    }
    
    /**
     * @returns true if the hand has n cards of the same rank
	 * e.g., "TD TC TH 7C 7D" returns True for n=2 and n=3, and False for n=1 and n=4
     */
    protected boolean hasNKind(int n) {
    	   int count = 0;
    	for (Card c: cards){
    		char a_char = c.toString().charAt(0);
    	 
    	    for(int i=0;i<cards.size();i++) {
    	      if (a_char==cards.get(i).toString().charAt(0)){
    	    	  count++;
    	      }
    	    }
    	}
    	count--;
    	if (count==n){return true;}else{return false;}
    }
    
   
    
    /**
	 * Optional: you may skip this one. If so, just make it return False
     * @returns true if the hand has two pairs
     */
    public boolean isTwoPair() {
    	return false;	
    }   
    
    /**
     * @returns true if the hand is a straight 
     */
    
    public List<Card> getRanks(){
    	Collections.sort(cards,new MyCardComp());
    	return cards;
    }
    public boolean isStraight() {
  
    	boolean isStraight=false;
    	for(int i=0;i<getRanks().size()-1;i++){
    		if (getRanks().get(i).getRank().ordinal()-getRanks().get(i+1).getRank().ordinal()==1){
    			isStraight=true;
    		}else{isStraight=false;break;
    	}
    }return isStraight;
    }
    /**
     * @returns true if the hand is a flush
     */
    public boolean isFlush() {
     boolean isFlush=false;
    	for (Card c:cards){
        	if(c.getRank()==cards.get(0).getRank()){
        		isFlush=true;
        	}else{isFlush=false;break;
        }
    	
    }return isFlush;
    }
    
    @Override
    public int compareTo(Hand h) {
        //hint: delegate!
		//and don't worry about breaking ties
    	 return this.kind().compareTo(h.kind()); 
    }
    
    /**
	 * This method is already implemented and could be useful! 
     * @returns the "kind" of the hand: flush, full house, etc.
     */
    public Kind kind() {
        if (isStraight() && isFlush()) return Kind.STRAIGHT_FLUSH;
        else if (hasNKind(4)) return Kind.FOUR_OF_A_KIND; 
        else if (hasNKind(3) && hasNKind(2)) return Kind.FULL_HOUSE;
        else if (isFlush()) return Kind.FLUSH;
        else if (isStraight()) return Kind.STRAIGHT;
        else if (hasNKind(3)) return Kind.THREE_OF_A_KIND;
        else if (isTwoPair()) return Kind.TWO_PAIR;
        else if (hasNKind(2)) return Kind.PAIR; 
        else return Kind.HIGH_CARD;
    }

}
    class MyCardComp implements Comparator<Card>{

@Override
public int compare(Card o1, Card o2) {
	// TODO Auto-generated method stub
	  if (o1.getRank().ordinal()<o2.getRank().ordinal())
	      return 1;
	    else
	      return -1;
}
}