package test;

import org.apache.http.cookie.Cookie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;


import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Test1 {
    @Test
    public void t1(){

    }

    @Test
    public void HttpClientTest (){
        //获取登录页面信息
          // String CAS_URL = "http://172.16.50.71/user_login.html?loginName=2017037013&password=2017037013";
          String CAS_URL = "http://172.16.50.71/user_login.html?loginName=2016021051&password=2016021051";
           String htmlDoc = HttpClient.get(CAS_URL);
           Cookie c = HttpClient.cookieStore.getCookies().get(0);
           String U  = "http://172.16.50.71/personQueryZC_personalDetailQuery.html";
           String U1 = "http://172.16.50.71/attendanceSTTZ_list.html";
           String U2 = "http://172.16.50.71/attendanceZZXX_list.html";
           HttpClient.cookieStore.addCookie(c);
           String k = HttpClient.get(U2);
           //boolean m = true;
           Document d = Jsoup.parse(k);
           System.out.println(d.toString());
           Element j = d.getElementById("tableHeader");
           Elements jl = j.getElementsByClass("grid_header");
           Element ll = d.getElementById("dataTable");
           Elements p = ll.getElementsByClass("grid_number");
           Elements tt = ll.getElementsByClass("grid_data");
           /////////////////////////

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
        List<ExerciseDataQuery> exerciseDataQueries = new ArrayList<>();
        /////////////////////////

        for (int jj = 0; jj<stringList.size();jj++){
            ExerciseDataQuery dataQuery = new ExerciseDataQuery();
            dataQuery.setNumid(Integer.parseInt(stringList.get(jj)));
              /* if ("执行的是查询早操"){
                    for (int i = 6*jj; i < 6*(jj+1); i++) {
                        //  System.out.println(strings.get(i));
                        dataQuery.setXuehao(strings.get(i));
                        i++;
                        dataQuery.setName(strings.get(i));
                        i++;
                        dataQuery.setCardId(strings.get(i));
                        i++;
                        dataQuery.setDaTe(strings.get(i));
                        i++;
                        dataQuery.setDateTime(strings.get(i));
                        i++;
                        dataQuery.setIsvalid(strings.get(i));
                        i++;
                    }

               }else {*/
            for (int i = 8*jj; i < 8*(jj+1); i++) {
                //  System.out.println(strings.get(i));
                dataQuery.setXuehao(strings.get(i));
                i++;
                dataQuery.setName(strings.get(i));
                i++;
                dataQuery.setCardId(strings.get(i));
                i++;
                dataQuery.setD(strings.get(i));
                i++;
                dataQuery.setD2(strings.get(i));
                i++;
                dataQuery.setIsvalid(strings.get(i));
                i++;
                i++;
            }
            //}
            exerciseDataQueries.add(dataQuery);
        }
        ///////////////////////

           //找分页
           String sudg = d.getElementById("PageNavBar").getElementById("PageSelectorMemo").text();
        String g = sudg.substring(sudg.length() - 3, sudg.length() - 1);
           String regEx="[^0-9]";
          Pattern ph = Pattern.compile(regEx);
         Matcher m = ph.matcher(g);
         System.out.println( m.replaceAll("").trim());
         if ( Integer.parseInt(m.replaceAll("").trim()) > 20){
             String Uu  = "http://172.16.50.71/personQueryZC_personalDetailQuery.html?pageNum=2";
             String Uu1 = "http://172.16.50.71/attendanceSTTZ_list.html?pageNum=2";
             String Uu2 = "http://172.16.50.71/attendanceZZXX_list.html?pageNum=2";
             HttpClient.cookieStore.addCookie(c);
             String kk = HttpClient.get(U2);
             //boolean m = true;
             Document dd = Jsoup.parse(k);
             System.out.println(dd.toString());
             Element jj = dd.getElementById("tableHeader");
             Elements jjl = j.getElementsByClass("grid_header");
             Element lll = d.getElementById("dataTable");
             Elements po = lll.getElementsByClass("grid_number");
             Elements ttt = lll.getElementsByClass("grid_data");
             List<String> stringListt = new ArrayList<>();
             for (int i = 0; i < p.size(); i++) {
                 stringListt.add(p.get(i).text());
             }
             List<String> stringss = new ArrayList<>();
             for (int i = 0; i <tt.size() ; i++) {
                 stringss.add(tt.get(i).text());
             }
             System.out.println(stringListt.size());
             System.out.println(stringss.size());

         }



        for (ExerciseDataQuery e: exerciseDataQueries){
            System.out.println(e.getNumid()+", " + e.getXuehao() + "," +e.getName()+","+e.getCardId()+","+e.getD()+","+e.getD2()+"," + e.getIsvalid());
        }
    }
}
