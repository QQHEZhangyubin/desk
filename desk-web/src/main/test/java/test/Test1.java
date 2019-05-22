package test;

import org.apache.http.cookie.Cookie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.Test;


import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Test1 {
    @Test
    public void t1(){

    }

    @Test
    public void HttpClientTest (){
        //获取登录页面信息
           String CAS_URL = "http://172.16.50.71/user_login.html?loginName=2016021051&password=2016021051";
           String htmlDoc = HttpClient.get(CAS_URL);
           System.out.println(HttpClient.cookieStore.getCookies().get(0).getName());
           System.out.println(HttpClient.cookieStore.getCookies().get(0).getValue());
           Cookie c = HttpClient.cookieStore.getCookies().get(0);
            //获取文档
            Document doc = Jsoup.parse(htmlDoc);
            System.out.println(doc.toString());

            String U  = "http://172.16.50.71/personQueryZC_personalDetailQuery.html";
            String U1 = "http://172.16.50.71/attendanceSTTZ_list.html";
            String U2 = "http://172.16.50.71/attendanceZZXX_list.html";
            HttpClient.cookieStore.addCookie(c);
            String k = HttpClient.get(U2);
            Document d = Jsoup.parse(k);
            System.out.println(d.toString());
            //获取字段信息
           /*
            String _eventId = doc.select("input[name=_eventId]").attr("value");
            String username = doc.select("input[name='username']").attr("value");
            String password = doc.select("input[name='password']").attr("value");
            String execution = doc.select("input[name='execution'").attr("value");
            //地区
            String geolocation = doc.select("input[name=geolocation]").attr("value");
            String submit = doc.select("input[name=submit]").attr("value");


            System.out.println(submit);
            */

}
}
