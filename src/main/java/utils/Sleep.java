package utils;

/**
 * Created by admin on 10/16/2016.
 */
public class Sleep {
    public static void sleep(long seconds){
        try{
            Thread.sleep(seconds);
        }
        catch(InterruptedException ie){
        }
    }
}
