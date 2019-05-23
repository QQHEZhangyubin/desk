package test;

import org.apache.http.cookie.Cookie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


import java.text.SimpleDateFormat;
import java.util.*;

public class Test1 {
    @Test
    public void t1(){

    }

    @Test
    public void HttpClientTest (){
        //获取登录页面信息
           String CAS_URL = "http://172.16.50.71/user_login.html?loginName=2016021051&password=2016021051";
           String htmlDoc = HttpClient.get(CAS_URL);
         //  System.out.println(HttpClient.cookieStore.getCookies().get(0).getName());
         //  System.out.println(HttpClient.cookieStore.getCookies().get(0).getValue());
           Cookie c = HttpClient.cookieStore.getCookies().get(0);
            //获取文档
            Document doc = Jsoup.parse(htmlDoc);
          //  System.out.println(doc.toString());

            String U  = "http://172.16.50.71/personQueryZC_personalDetailQuery.html";
            String U1 = "http://172.16.50.71/attendanceSTTZ_list.html";
            String U2 = "http://172.16.50.71/attendanceZZXX_list.html";
            HttpClient.cookieStore.addCookie(c);
            String k = HttpClient.get(U2);
            Document d = Jsoup.parse(k);
            System.out.println(d.toString());
            Element j = d.getElementById("tableHeader");
        Elements jl = j.getElementsByClass("grid_header");
        //System.out.println(j.toString());
       // System.out.println(jl.toString());

        for (int i = 0; i <jl.size() ; i++) {
           // System.out.println(jl.get(i).text());
        }

        Element ll = d.getElementById("dataTable");
        Elements p = ll.getElementsByClass("grid_number");
        Elements tt = ll.getElementsByClass("grid_data");
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < p.size(); i++) {
            stringList.add(p.get(i).text());
        }
        List<String> strings = new ArrayList<>();
        for (int i = 0; i <tt.size() ; i++) {
            strings.add(tt.get(i).text());
        }
        System.out.println(stringList.size());
        System.out.println(strings.size());
        //System.out.println(strings.get(16));
        for (int jj = 0; jj<stringList.size();jj++){

            ExerciseDataQuery dataQuery = new ExerciseDataQuery();
            dataQuery.setNumid(Integer.parseInt(stringList.get(jj)));
            for (int i = 0; i < strings.size(); i++) {

            }

        }


}
}
