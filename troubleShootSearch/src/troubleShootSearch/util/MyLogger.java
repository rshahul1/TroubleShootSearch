package troubleShootSearch.util;

public class MyLogger {

    /*DEBUG_VALUE=4 [Print to stdout everytime a visitor performs a client operation]
    DEBUG_VALUE=3 [Print to stdout everytime a new file is generated. ]
    DEBUG_VALUE=2 [Print to stdout everytime a constructor is invoked.]
    DEBUG_VALUE=1 [Print to stdout everytime a File Processor object performs read file operation.]
    DEBUG_VALUE=0 [No output should be printed from the application to stdout. It is ok to write to the output file though" ]
  */

    // FIXME: Add more enum values as needed for the assignment
    public static enum DebugLevel { VISITOR,FILE_GENERATE,CONSTRUCTOR, FILE_PROCESSOR,RELEASE,NONE};

    private static DebugLevel debugLevel;


    // FIXME: Add switch cases for all the levels
    public static void setDebugValue (int levelIn) {
        switch (levelIn) {
            case 4: debugLevel= DebugLevel.VISITOR; break;
            case 3: debugLevel= DebugLevel.FILE_GENERATE; break;
            case 2: debugLevel = DebugLevel.CONSTRUCTOR; break;
            case 1: debugLevel = DebugLevel.FILE_PROCESSOR; break;
            case 0: debugLevel= DebugLevel.RELEASE; break;
            default: debugLevel = DebugLevel.NONE; break;
        }
    }

    public static void setDebugValue (DebugLevel levelIn) {
        debugLevel = levelIn;
    }

    public static void writeMessage (String     message  ,
                                     DebugLevel levelIn ) {
        if (levelIn == debugLevel)
            System.out.println(message);
    }
    public static void Message (String message) {
        System.out.println(message);
    }

    public String toString() {
        return "The debug level has been set to the following " + debugLevel;
    }
}
