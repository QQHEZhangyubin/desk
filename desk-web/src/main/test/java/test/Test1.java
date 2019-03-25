package test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    @Test
    public void t1(){
        //SimpleDateFormat sdf = new SimpleDateFormat("EEE MMM dd HH:mm:ss z yyyy", java.util.Locale.US);

        String location="东区";
        String classroom = "401";
        String u = location + classroom;
        System.out.println(u);

        String rqcord = "东区401";
        if (!u.equals(rqcord)){
            System.out.println("not execute");
        }
    }
}
