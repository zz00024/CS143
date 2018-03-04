public class LetterInventory {
   
   private String data;
   private int[] numberLetter;
   
   public LetterInventory(String data) {
      this.data = data;
      // convert the string data to a string has no numberic value and no space
      data = data.toLowerCase();
      // array for number of each letter in string data
      this.numberLetter = new int[26];
      for(int z = 0; z < numberLetter.length; z++) {
         numberLetter[z] = 0;
      }
      
      for(int i =0; i<data.length(); i++) {
         // a = 97 ~ z = 122,asciII table 
         char number = data.charAt(i);
         int theIndex = (int) number;   
         for(int j =97; j <= 122; j++) {
            if(theIndex == j) {
               numberLetter[j-97] += 1;
            }
         }
      }     
   }
   
   // Returns a count of how many of this letter are in the inventory
   public int get(char letter) {
      if(!Character.isLetter(letter)) {
         throw new IllegalArgumentException("a IllegalArgumentException");
      }
      else {
         char character = letter;
         int theIndex = (int) character;
         return this.numberLetter[theIndex -97];
      }
   }
   
   // Sets the count for the given letter to the given value
   public void set (char letter, int value) {
      int number = (int) letter;
      this.numberLetter[number - 97]  = value; 
   }
   
   
   // Returns the sum of all of the counts in this inventory.
   public int size() {
      int count =0;
      for(int i = 0; i < this.numberLetter.length; i++) {
         count += this.numberLetter[i];
      }
      return count;
   }
   
   //
   public boolean isEmpty() {
      return this.size()==0;
   }
   
   public String toString() {
      String toString = "[";
      for(int i =0; i < this.numberLetter.length; i++) {
         for(int j=0; j < this.numberLetter[j] ; j++) {
            toString += (char)i+97;
         }
      }
      toString += "]";
      return toString;
   }
   
   // use object as a return type here?
   public  LetterInventoryadd(LetterInventory other) {
      this.size() += other.size();
   }
   
   // use object as a return type here?
   public LetterInventorysubtract(LetterInventory other) {
      if(this.size() < other.size()) {
         return null;
      }
      else {
         return //object?
      }
   }
   
}