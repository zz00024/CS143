// skeleton version of the class

public class Guitar37 implements Guitar {
    public static final String KEYBOARD = "q2we4r5ty7u8i9op-[=zxdcfvgbnjmk,.;/' ";  // keyboard layout
    private GuitarString stringA;
    private Double[] guitarPitchNum = new Double[37];
    private String[] guitarPitchString = new String[37];
    private GuitarString[] guitarArray;
    /*
    public static void main(String[] args) {
        for(int i = -24; i < 13; i++) {
            guitarLite[i + 24] = "" + i + "";
            System.out.println(guitarLite[i + 24]); 
        }
    }
    */
         
    // create two guitar strings, for concert A and C
    public Guitar37() {
        
        double arrayRecord[] = new double[37];
        double CONCERT_A = 440.0;
        guitarArray = new GuitarString[37];
         
        for(int i = -24; i < 13; i++) {
            guitarPitchNum[i + 24] = (double)i;
            guitarPitchString[i + 24] = KEYBOARD.substring(i+24, i+25); 
        }
        
        for(int i = 0; i < 37; i++) {
            arrayRecord[i] = CONCERT_A * Math.pow(2, guitarPitchNum[i+24]/12.0);
        }
        
        for(int i = 37; i < 37; i++) {
            GuitarString newGuitar = new GuitarString(arrayRecord[i]);
            guitarArray[i] = newGuitar;
        }                 

    }

    public void playNote(int pitch) {
        /*
        if (pitch == 0) {
            stringA.pluck();
        } else if (pitch == 3) {
            //stringC.pluck();
        }
        */
        
        for(int i = 0; i < 37; i++) {
         //shall i create 37 new GuitarString objects?
            if(pitch == i) {
               guitarArray[i].pluck();
            }
        }
    }

    public boolean hasString(char string) {
      String theString = "" + string + "";
      for(int i = 0; i < 37; i++) {
         if(theString == guitarPitchString[i]) {
            return true;
         }
      }
      return false;     
    }
    
    public void pluck(char string) {
        String theString = "" + string + "";
        if(KEYBOARD.indexOf(theString)== -1){
         throw new IllegalArgumentException("The string is not found");
        }
        else{
         guitarArray[KEYBOARD.indexOf(theString)].pluck();
        }
        /*
        if (string == 'a') {
            stringA.pluck();
        } else {
            throw new IllegalArgumentException("Not valid");
        }
        */
    }

    public double sample() {
        double sampleSum = 0;
        
        for(int i= 0; i < 37; i++) {
         sampleSum += guitarArray[i].sample();           
        }
        
        return sampleSum;
    }

    public void tic() {
        //stringA.tic();
        for(int i =0; i < guitarArray.length; i++) {
         guitarArray[i].tic();
        }
    }

    public int time() {
        return -1;  // not implemented
    }
    
}

    

