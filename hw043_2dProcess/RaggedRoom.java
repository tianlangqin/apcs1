/**
 * Tianlang Qin
 * hw043
 * worked with no one 
 * helped by no one 
   Represent a room whose file sizes vary

   meanings of...
      persons: a reference to an array of references to
               an array of integers.
      persons[3]
      persons[3][2]
 */
public class RaggedRoom {

    // person number at a particular file and rank
    private int[][] persons;

    /**
       @return a string representation of this instance

       based heavily on work contributed by Zidane of pd 2,
       in Piazza@241
     */
    public String toString() {
        String result;
        result =   "number of files: "
                 + persons.length + System.lineSeparator()
                 + "files" + System.lineSeparator()
                 ;
        // show each file, with its number, ranks, and persons
        for( int file = 0; file < persons.length; ++file ){
            result += file + "    ranks:  ";

            // show each rank number in this file
            for( int rank = 0; rank < persons[file].length; ++rank)
                result +=  rank + "  ";

           // show each person number in this file
           result += System.lineSeparator() + "     person: ";
           for( int rank = 0; rank < persons[file].length; ++rank)
               result += persons[file][rank] + "  ";

            result += System.lineSeparator() + System.lineSeparator();
        }
        return result;
    }


// -------------  accessors  -------------

    /**
       maxPersonNumber
       @return the largest person number in the room
     */
    public /* instance */ int maxPersonNumber() {
        if (persons.length != 0 && persons[0].length != 0)
            return persons[persons.length - 1][persons[persons.length -1].length - 1];
        return 0;
    }


    /**
       file
       @return the file that holds the "personNumber"
       contract: method to be invoked with 
                 0= < "personNumber" <= maxPersonNumber
     */
    public /* instance */ int file( int personNumber) {
        for (int i = 0; i < persons.length; i++) {
            for (int j = 0; j < persons[i].length; j++) {
                if (persons[i][j] == personNumber)
                    return i;
            }
        }
        return -1;
    }


    /**
       rank
       @return the rank that holds the "personNumber"
       contract: method to be invoked with 
                 0= < "personNumber" <= maxPersonNumber
     */
    public /* instance */ int rank( int personNumber) {
        for (int i = 0; i < persons.length; i++) {
            for (int j = 0; j < persons[i].length; j++) {
                if (persons[i][j] == personNumber)
                    return j;
            }
        }
        return -1;
    }


// -------------  constructors -------------

    /**
      Construct an instance
      with the given "fileLengths"
     */
    public RaggedRoom( int[] fileLengths) {
        persons = new int[fileLengths.length][];

        for( int file = 0; file < fileLengths.length; ++file)
            persons[ file] = new int[ fileLengths[ file]];

        populate();
    }


    /**
      Construct an instance
      with magic numbers matching room 307. Ugh.
     */
    public RaggedRoom() {
        persons = new int[5][];

        persons[0] = new int[8];
        persons[1] = new int[6];
        persons[2] = new int[6];
        persons[3] = new int[7];
        persons[4] = new int[7];

        populate();
    }


    /**
      square room
     */
    public RaggedRoom( int extent) {
        this( extent, extent);
    }


    /**
      Construct an instance
      representing a rectangular room.
     */
    public RaggedRoom( int files, int ranks) {
        persons = new int[files][ranks];
        populate();
    }


    /**
       Populate the "persons" array with consecutive
       person numbers, starting at 0.

       courtesy of Zidane of pd 2, in Piazza@241
     */
    private  /* instance */ void populate() {
        int personNumber = 0;
        for( int file = 0; file < persons.length; ++file )
            for( int rank = 0; rank < persons[file].length; ++rank)
                persons[file][rank] = personNumber++;
    }
}