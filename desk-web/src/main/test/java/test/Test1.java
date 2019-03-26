package test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    @Test
    public void t1(){
        SimpleDateFormat df = new SimpleDateFormat("yyyy_MM_dd_HH_MM_SS");
        SimpleDateFormat dfTime = new SimpleDateFormat("yyyy-MM-dd:HH:MM:SS  ");
        String fileName=df.format(new Date())+".png";
        System.out.println(fileName);
    }
}
