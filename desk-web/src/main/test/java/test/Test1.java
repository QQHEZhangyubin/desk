package test;

import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Test1 {
    @Test
    public void t1(){
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = new Long("1553045158000");
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        System.out.println(res);
    }
}
