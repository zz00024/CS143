public class LetterInventory {
   
   private String data;
   private int[] numberLetter;
   private int[] sumArray;
   
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
         if(theIndex >= 'a' && theIndex <='z') {
            numberLetter[theIndex-'a'] += 1;
         }         
      }     
   }
   
   public LetterInventory(int[] array) {
      this.sumArray = array;   
   }
   
   // Returns a count of how many of this letter are in the inventory
   public int get(char letter) {
      int theIndex = (int)letter;
      if(!(theIndex >= 'a' && theIndex <='z')) {
         throw new IllegalArgumentException("the character is no a letter");
      }
      else {
         return this.numberLetter[theIndex - 'a'];
      }
   }
   
   // Sets the count for the given letter to the given value
   public void set (char letter, int value) {
      int number = (int) letter;
      this.numberLetter[number - 'a']  = value; 
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
   public LetterInventory add(LetterInventory other) {
      int[] newString = new int[26];
      for(int i =0; i < newString.length; i++) {
         newString[i] = this.get((char)(i+97)) + other.get((char)(i+97));
      }
      LetterInventory newObject = new LetterInventory(newString);
      return newObject;
   }
   
   // use object as a return type here?
   public LetterInventory subtract(LetterInventory other) {
         int[] newString = new int[26];
         for(int i=0; i < newString.length;i++) {
            if(this.get((char)(i+97)) < other.get((char)(i+97))) {
               return null;
            }                  
            newString[i] = this.get((char)(i+97)) - other.get((char)(i+97));           
         }
         LetterInventory newObject = new LetterInventory(newString);
         return newObject;
   }
   
}