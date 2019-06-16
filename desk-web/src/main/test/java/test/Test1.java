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
    public void T110(){
        String u = "http://pswn9tut0.bkt.clouddn.com/1560662531369.jpg,http://pswn9tut0.bkt.clouddn.com/1560662531381.jpg,http://pswn9tut0.bkt.clouddn.com/1560662531372.jpg,http://pswn9tut0.bkt.clouddn.com/1560662531364.jpg,http://pswn9tut0.bkt.clouddn.com/1560662531370.jpg,http://pswn9tut0.bkt.clouddn.com/1560662531382.jpg";
        String[] gfdsg = u.split(",");
        System.out.println(gfdsg.length);
        List<String> d = Arrays.asList(gfdsg);
        for (String s : d){
            System.out.println(s);
        }
    }
    @Test
    public void t1(){
        //预约明天座位的代码
        String url_login = "http://172.16.47.84/Login.aspx?__EVENTTARGET=&__EVENTARGUMENT=&__VIEWSTATE=%2FwEPDwUJODE2Mzg3MTk0ZGTiyMF48vnOd3k6J7zu3Z26Lhf%2Bt0nElGTEKl9fwh3L8g%3D%3D&__EVENTVALIDATION=%2FwEWBAKm8rLABwLs0bLrBgLs0fbZDAKM54rGBkCiS2WHGa6%2BEL0Kh6yO5Ah09T75GOA5NPCLw47Aiepp&TextBox1=2016213039&TextBox2=610001&Button1=%E7%99%BB++++++%E5%BD%95";
        String htmlDoc = HttpClient.get(url_login);
        System.out.println(htmlDoc);
        Cookie c = HttpClient.cookieStore.getCookies().get(0);
        System.out.println(c.getValue());
        HttpClient.cookieStore.addCookie(c);

        String hh = "http://172.16.47.84/DayNavigation.aspx?__EVENTTARGET=&__EVENTARGUMENT=&__LASTFOCUS=&__VIEWSTATE=%2FwEPDwUJMTAxMjgzNTc0D2QWAgIDD2QWBgIFDxBkZBYBAgFkAgcPEA8WBh4ORGF0YVZhbHVlRmllbGQFBnNlYXRpZB4NRGF0YVRleHRGaWVsZAUIbG9jYXRpb24eC18hRGF0YUJvdW5kZ2QQFQke5Lic5Yy65Zu%2B5Lmm6aaG6Ieq5Lmg5a6kMjAx5a6kHuS4nOWMuuWbvuS5pummhuiHquS5oOWupDQwMeWupB7kuK3ljLrlm77kuabppoboh6rkuaDlrqQxMDHlrqQe5Lit5Yy65Zu%2B5Lmm6aaG6Ieq5Lmg5a6kMjAx5a6kHuS4reWMuuWbvuS5pummhuiHquS5oOWupDIwNuWupB7kuK3ljLrlm77kuabppoboh6rkuaDlrqQyMTHlrqQe6KW%2F5Yy65Zu%2B5Lmm6aaG6Ieq5Lmg5a6kMjA35a6kHuilv%2BWMuuWbvuS5pummhuiHquS5oOWupDQwMeWupB7opb%2FljLrlm77kuabppoboh6rkuaDlrqQ0MDjlrqQVCQcxMjAxMDAxBzE0MDEwMDEHMjEwMTAwMQcyMjAxMDAxBzIyMDYwMDEHMjIxMTAwMQczMjA3MDAxBzM0MDEwMDEHMzQwODAwMRQrAwlnZ2dnZ2dnZ2cWAWZkAgkPDxYCHgRUZXh0BQY1Ny8xODhkZGRHJjYrYELGFA6J4cFtBQxA4JPRkMQ%2Fsqdb%2FZUtchCeBA%3D%3D&__EVENTVALIDATION=%2FwEWFAL4u7ekCQLs0bLrBgLs0fbZDAKPwd2MAQLpu8rPDwKt6srPDwLytq6nDwK6p%2BzQCwK6p5TSCwKVpujRCwKVpuzQCwKVpvCRCAKetsSdCgL0p%2BTRCAL0p5TSCwL0p8CRDwL9h9mtDgKM54rGBgK7q7GGCALWlM%2BbAq%2BM7W46mWWS5QSnCHTnrYVVK6Bzf9wDWMnIutbWFpnp&TextBox1=938&TextBox2=800&ddlDay=%E6%98%8E%E6%97%A5&ddlRoom=1201001&txtSeats=57%2F188&Button2=%E6%89%8B%E5%8A%A8%E9%80%89%E5%BA%A7";
        String htmlDosc = HttpClient.get(hh);
        System.out.println(htmlDosc);

        List<Cookie> c1 = HttpClient.cookieStore.getCookies();
        System.out.println(c1.size());
        //System.out.println(c1.getValue());
       // HttpClient.cookieStore.addCookie(c1);
        String tommorrow = "http://172.16.47.84/ClickVerifyCode.aspx?seatid=1201153";
        String result = HttpClient.get(tommorrow);
        System.out.println(result);
        String tommorrowf = "http://172.16.47.84/Skip.aspx";
        String resultf = HttpClient.get(tommorrowf);
        System.out.println(resultf);
/*
        String CAS_URL = "http://172.16.47.84/AppSTom.aspx?roomid=1201&hei=938&wd=1920";
        String htmlDocv = HttpClient.get(CAS_URL);
        //Cookie c = HttpClient.cookieStore.getCookies().get(0);
       // HttpClient.cookieStore.addCookie(c);
        Document d = Jsoup.parse(htmlDocv);
        //System.out.println(d.toString());
        Elements imgTags = d.select("img[src]");
       // System.out.println("=====imgsTag====="+imgTags);
        System.out.println("total account == " + (imgTags.size()-2));
        for (Element element : imgTags){
            String src2 = element.attr("src");

            System.out.println(src2);
        }

        Elements aTags = d.select("a[href]");
        // System.out.println("=====imgsTag====="+imgTags);
        System.out.println("total account == " + aTags.size());
        for (Element element : aTags){
            String src2 = element.attr("href");

            System.out.println(src2);
        }*/
    }


    @Test
    public void t2(){
        //预约今天座位的代码
        String url_login = "http://172.16.47.84/Login.aspx?__EVENTTARGET=&__EVENTARGUMENT=&__VIEWSTATE=%2FwEPDwUJODE2Mzg3MTk0ZGTiyMF48vnOd3k6J7zu3Z26Lhf%2Bt0nElGTEKl9fwh3L8g%3D%3D&__EVENTVALIDATION=%2FwEWBAKm8rLABwLs0bLrBgLs0fbZDAKM54rGBkCiS2WHGa6%2BEL0Kh6yO5Ah09T75GOA5NPCLw47Aiepp&TextBox1=2016213039&TextBox2=610001&Button1=%E7%99%BB++++++%E5%BD%95";
        String htmlDoc = HttpClient.get(url_login);
        System.out.println(htmlDoc);
        Cookie c = HttpClient.cookieStore.getCookies().get(0);
        System.out.println(c.getValue());
        HttpClient.cookieStore.addCookie(c);

        String response = "http://172.16.47.84/SkipToday.aspx?seatid=1201151";
        String result = HttpClient.get(response);
        System.out.println(result);

        String CAS_URL = "http://172.16.47.84/AppSTod.aspx?roomid=1201&hei=938&wd=1920";
        String htmlDoc2 = HttpClient.get(CAS_URL);
        //Cookie c = HttpClient.cookieStore.getCookies().get(0);
        // HttpClient.cookieStore.addCookie(c);
        Document d = Jsoup.parse(htmlDoc2);
        //System.out.println(d.toString());
        Elements imgTags = d.select("img[src]");
        // System.out.println("=====imgsTag====="+imgTags);
        System.out.println("total account == " + (imgTags.size()-2));
        for (Element element : imgTags){
            String src2 = element.attr("src");

            System.out.println(src2);
        }

        Elements aTags = d.select("a[href]");
        // System.out.println("=====imgsTag====="+imgTags);
        System.out.println("total account == " + aTags.size());
        for (Element element : aTags){
            String src2 = element.attr("href");

            System.out.println(src2);
        }

        ///////////////


    }



    @Test
    public void t3(){
        //取消今天座位的代码
        String url_login = "http://172.16.47.84/Login.aspx?__EVENTTARGET=&__EVENTARGUMENT=&__VIEWSTATE=%2FwEPDwUJODE2Mzg3MTk0ZGTiyMF48vnOd3k6J7zu3Z26Lhf%2Bt0nElGTEKl9fwh3L8g%3D%3D&__EVENTVALIDATION=%2FwEWBAKm8rLABwLs0bLrBgLs0fbZDAKM54rGBkCiS2WHGa6%2BEL0Kh6yO5Ah09T75GOA5NPCLw47Aiepp&TextBox1=2016213039&TextBox2=610001&Button1=%E7%99%BB++++++%E5%BD%95";
        String htmlDoc = HttpClient.get(url_login);
        System.out.println(htmlDoc);
        Cookie c = HttpClient.cookieStore.getCookies().get(0);
        System.out.println(c.getValue());
        HttpClient.cookieStore.addCookie(c);

        String cancel = "http://172.16.47.84/InfoSearch.aspx?ScriptManager1=UpdatePanel1%7CGridView1%24ctl02%24Button2&__EVENTTARGET=&__EVENTARGUMENT=&__VIEWSTATE=bZS80fdM4PelB1wklplayCxDVovse7q7Peq8VYGPNATX7cfSCL5a%2Ble%2F%2BnjwjDHLweSBvB0MbP2nB9hha8iFLmSK0obj2pmxb7MU3bHn6Ef1EO%2BSEPYBEO7DWdpbN0WF3Z%2Fec21n%2FUWgriLlfSCjvQ17xUeDBq9uSa7qd%2BrJvJGZGBPLHo7xo29D4cprddO8l2qKzLvv5rJnZH861KrYpzmLKGtv2tD52VgeyXrwLXhk9kaQS1pq5T9hss%2B9W28QLga9O%2BxDzbsIfjkVophPV09ZPU78eV45gSBG3BaOnpOapA5sOY4WBHWMagARCyN0J8Ng%2F8b1ZtbOcjSQ2XaBu0XJUSeTeY8ozNMe8QuWDEoBtOg95PCbm5RfTI3CpkQTMwN8HdJ9JhpCzp6lweTWovsA90GVYINxe8UyjnqYaiXdAUI0RuF3rNxGaAwkn4ftcyvazfdQbl6KmoGmNouSJYP8xQetHNAxEm%2Bprf95aAfQPT6pPMVJwW1GXDxLgbVHd%2FcxkblUmBma%2BeReL47ReoY4gpbAi5eUFTusMSVtNIiWhSBx3DBsCn%2Biw7%2FMNIt4wGyPr4wWMDxotEma8viQWCjZ5FqajYZO2yfsvqIhHD86NgxXHmVDXXXUDoTUVfrH%2BhZk9n7mJS3GouaawBZcsk8nJHpcIAhW34yMQfmqL3uaQe3OlZu9ynH1NIVAICE%2FkG4qfCskMCi9EkmJZXUuThrEUpYmfRLJiindpBJ2T6pBWFQLhGOMhOZX72kS90riPlXPugmalTZ1L6mxF55nZ8f6lPgdSqpNA5U4w8OGzAk%3D&__VIEWSTATEENCRYPTED=&__EVENTVALIDATION=WYGMSYcjeuoprUnUOsWkvhu1geTGUSf5GxW4ejqRlf8%3D&TextBox7=&__ASYNCPOST=true&GridView1%24ctl02%24Button2=%E5%8F%96%E6%B6%88%E9%A2%84%E7%BA%A6";
        String result = HttpClient.get(cancel);
        System.out.println(result);
        ///////////////


    }

    @Test
    public void t4(){
        //取消明天座位的代码
        String url_login = "http://172.16.47.84/Login.aspx?__EVENTTARGET=&__EVENTARGUMENT=&__VIEWSTATE=%2FwEPDwUJODE2Mzg3MTk0ZGTiyMF48vnOd3k6J7zu3Z26Lhf%2Bt0nElGTEKl9fwh3L8g%3D%3D&__EVENTVALIDATION=%2FwEWBAKm8rLABwLs0bLrBgLs0fbZDAKM54rGBkCiS2WHGa6%2BEL0Kh6yO5Ah09T75GOA5NPCLw47Aiepp&TextBox1=2016213039&TextBox2=610001&Button1=%E7%99%BB++++++%E5%BD%95";
        String htmlDoc = HttpClient.get(url_login);
        System.out.println(htmlDoc);
        Cookie c = HttpClient.cookieStore.getCookies().get(0);
        System.out.println(c.getValue());
        HttpClient.cookieStore.addCookie(c);

        String cancel = "http://172.16.47.84/InfoSearch.aspx?ScriptManager1=UpdatePanel2%7CGridView2%24ctl02%24Button2&__EVENTTARGET=&__EVENTARGUMENT=&__VIEWSTATE=bZS80fdM4PelB1wklplayCxDVovse7q7Peq8VYGPNATX7cfSCL5a%2Ble%2F%2BnjwjDHLweSBvB0MbP2nB9hha8iFLrQz1QDHDzhvopfRV%2BF8MjROBKW9hYv4iDU9sGNSf21Jp4Gbb9tshrCHF6hcspPMA7N02SW%2BZSwS7c6SemNxj3i8vboP0fLWe2rCAB304MG4Ei2VA8Dxu8egJk9wgxduC%2FjDgEH0O4z%2B7yXWTERXo2DKNnD4Yy6Xt9y%2FeMP47tCey6ypJc7FNd2m5gWSzrMJQsRR985T11QgYXbMob3kZLcxHbHBskyRPljQRPTohXAXEmDDJv7Wfcn9NigT5ixv3r1T4PZ615QHRfsGgiOr5olwiN2xTJp6DJ%2Fs6kFij%2F1P4gI8zMIcxhLmr0IuHMtGXpr1V5mJZVYdFJTg5%2FWFpTPTj%2FnOapvopnsbVw9jnR6kohuo72xzH%2BoDfuB4wTBVOjmGJG%2FzeeF2ywxnMlJkO8cRLZAsVeKuVlzS0DLyzGtaio3pcXLF3yK5gxNcZtVFu6Atlk1Vp%2BwwzMHcjlWz0zrrN6w7ClzRgXOI7kndDRSNrrpaN2%2BQ0MmAKQih%2B0yKoIZvhZ6Cr7MAMjyMODNRBbAf1nFySUovmwNpD0vU4jQc2gWf3HNCt%2ForVxzGUbaAlVUtxL%2FwWcgrFKTQkPtmxFxAinh4oZIjfg5U7I7g8qh3D%2FFroeDkoERsXMLcpjbUBwbSKL3n1BWlBhXA%2BiN3vXnZuvV3ebnSnH0YQwgaPuuB2%2BDaYyCIoyhe8wJ9Z5LrA4QTVPfA5PKBWdNWVxKB9bw%3D&__VIEWSTATEENCRYPTED=&__EVENTVALIDATION=PDhMrQZqSBQLsxcty5YsNFYbPw%2Ba%2BKE7aw2ANW5X3Gk%3D&TextBox7=&__ASYNCPOST=true&GridView2%24ctl02%24Button2=%E5%8F%96%E6%B6%88%E9%A2%84%E7%BA%A6";
        String result = HttpClient.get(cancel);
        System.out.println(result);
        ///////////////


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
