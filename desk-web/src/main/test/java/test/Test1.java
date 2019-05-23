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

            Element j = d.getElementById("tableHeader");
        Elements jl = j.getElementsByClass("grid_header");
        System.out.println(j.toString());
        System.out.println(jl.toString());

        for (int i = 0; i <jl.size() ; i++) {
            //System.out.println(jl.get(i).attributes().toString());
            System.out.println(jl.get(i).text());
        }

        Element ll = d.getElementById("dataTable");
        Elements p = ll.getElementsByClass("grid_number");
        Elements tt = ll.getElementsByClass("grid_data");
        for (int i = 0; i < p.size(); i++) {
            System.out.println(p.get(i).text());
        }
        ExerciseDataQuery exerciseDataQuery = null;
        List<ExerciseDataQuery> exerciseDataQueryList = new ArrayList<>();
        int kk = 1;
        for (int i = 0; i <tt.size() ; i++) {

            if (i%8 != 0 || i == 0  ){
                exerciseDataQuery = new ExerciseDataQuery();
                System.out.print(tt.get(i).text()+",");
                exerciseDataQuery.setName(tt.get(i).text());
                i++;
                exerciseDataQuery.setCardId(tt.get(i).text());
                i++;
                exerciseDataQuery.setDaTe(tt.get(i).text());
                i++;
                exerciseDataQuery.setDateTime(tt.get(i).text());
                i++;
                exerciseDataQuery.setIsvalid(tt.get(i).text());
                i++;
                i++;

                //exerciseDataQuery.setNumid(kk);
                //kk++;
            }else {
                System.out.println();
                exerciseDataQueryList.add(exerciseDataQuery);
            }

        }
        System.out.println(exerciseDataQueryList.size());

        //System.out.println(exerciseDataQueryList.get(1).getDateTime());

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
