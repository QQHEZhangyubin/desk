package qiqihaer.desk.www.controller;


import org.apache.http.cookie.Cookie;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qiqihaer.desk.www.common.HttpClient;
import qiqihaer.desk.www.entity.ExerciseDataQuery;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
@RequestMapping("queryexercise")
public class ExerciseControlller {

    @RequestMapping("/zaocao")
    @ResponseBody
    public List<ExerciseDataQuery> getZaoCao(@RequestParam(value = "xuehao",required = false) String xuehao){
        String CAS_URL = "http://172.16.50.71/user_login.html?loginName="+xuehao+"&password="+xuehao;
        System.out.println(CAS_URL);
        HttpClient.get(CAS_URL);
        Cookie c = HttpClient.cookieStore.getCookies().get(0);//得到访问者的cookie值
        String U  = "http://172.16.50.71/personQueryZC_personalDetailQuery.html";
        HttpClient.cookieStore.addCookie(c);
        String k = HttpClient.get(U);
        Document d = Jsoup.parse(k);
        //找分页
        String sudg = d.getElementById("PageNavBar").getElementById("PageSelectorMemo").text();
        String g = sudg.substring(sudg.length() - 3, sudg.length() - 1);
        String regEx="[^0-9]";
        Pattern ph = Pattern.compile(regEx);
        Matcher m = ph.matcher(g);
        System.out.println( m.replaceAll("").trim());
        int totoalrecord = Integer.parseInt(m.replaceAll("").trim());
        int flag = totoalrecord > 20 ? 2 :1;


        List<ExerciseDataQuery> exerciseDataQueries = new ArrayList<>();
        Element ll = d.getElementById("dataTable");
        Elements p = ll.getElementsByClass("grid_number");
        Elements tt = ll.getElementsByClass("grid_data");
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < p.size(); i++) {
            stringList.add(p.get(i).text());//添加每行数据的序号
        }
        List<String> strings = new ArrayList<>();
        for (int i = 0; i <tt.size() ; i++) {
            strings.add(tt.get(i).text());//添加每行数据的内容
        }
        System.out.println(stringList.size());
        System.out.println(strings.size());
        for (int jj = 0; jj<stringList.size();jj++) {
            ExerciseDataQuery dataQuery = new ExerciseDataQuery();
            dataQuery.setNumid(Integer.parseInt(stringList.get(jj)));
            for (int i = 6*jj; i < 6*(jj+1); i++) {
                System.out.println(strings.get(i));
                dataQuery.setXuehao(strings.get(i));
                i++;
                dataQuery.setName(strings.get(i));
                i++;
                dataQuery.setCardId(strings.get(i));
                i++;
                dataQuery.setD(strings.get(i));
                i++;
                dataQuery.setIsvalid(strings.get(i));
                i++;
            }
            exerciseDataQueries.add(dataQuery);
        }
          if (flag ==2){
            String U2  = "http://172.16.50.71/personQueryZC_personalDetailQuery.html?pageNum=2";
            HttpClient.cookieStore.addCookie(c);//添加的cookie值不变
            String k2 = HttpClient.get(U2);
            Document d2 = Jsoup.parse(k2);
            Element E2 = d2.getElementById("dataTable");
            Elements p2 = E2.getElementsByClass("grid_number");
            Elements t2 = E2.getElementsByClass("grid_data");
            List<String> stringList2 = new ArrayList<>();
            for (int i = 0; i < p2.size(); i++) {
                stringList2.add(p2.get(i).text());//添加每行数据的序号
            }
            List<String> strings2 = new ArrayList<>();
            for (int i = 0; i <t2.size() ; i++) {
                strings2.add(t2.get(i).text());//添加每行数据的内容
            }
            System.out.println(stringList2.size());
            System.out.println(strings2.size());
            for (int jj = 0; jj<stringList2.size();jj++) {
                ExerciseDataQuery dataQuery = new ExerciseDataQuery();
                dataQuery.setNumid(Integer.parseInt(stringList2.get(jj)));
                for (int ii = 6*jj; ii < 6*(jj+1); ii++) {
                   System.out.println(strings.get(ii));
                    dataQuery.setXuehao(strings2.get(ii));
                    ii++;
                    dataQuery.setName(strings2.get(ii));
                    ii++;
                    dataQuery.setCardId(strings2.get(ii));
                    ii++;
                    dataQuery.setD(strings2.get(ii));
                    ii++;
                    dataQuery.setIsvalid(strings2.get(ii));
                    ii++;
                }
                exerciseDataQueries.add(dataQuery);
            }
        }

        return exerciseDataQueries;
    }



    ////////////////////////////////////////////
    @RequestMapping("/zhizhu")
    @ResponseBody
    public List<ExerciseDataQuery> getZhizhu(@RequestParam(value = "xuehao",required = false) String xuehao){
        String CAS_URL = "http://172.16.50.71/user_login.html?loginName="+xuehao+"&password="+xuehao;
        System.out.println(CAS_URL);
        HttpClient.get(CAS_URL);
        Cookie c = HttpClient.cookieStore.getCookies().get(0);//得到访问者的cookie值
        String U2 = "http://172.16.50.71/attendanceZZXX_list.html";
        HttpClient.cookieStore.addCookie(c);
        String k = HttpClient.get(U2);
        Document d = Jsoup.parse(k);
        //找分页
        String sudg = d.getElementById("PageNavBar").getElementById("PageSelectorMemo").text();
        String g = sudg.substring(sudg.length() - 3, sudg.length() - 1);
        String regEx="[^0-9]";
        Pattern ph = Pattern.compile(regEx);
        Matcher m = ph.matcher(g);
        System.out.println( m.replaceAll("").trim());
        int totoalrecord = Integer.parseInt(m.replaceAll("").trim());
        int flag = totoalrecord > 20 ? 2 :1;

        List<ExerciseDataQuery> exerciseDataQueries = new ArrayList<>();
        Element ll = d.getElementById("dataTable");
        Elements p = ll.getElementsByClass("grid_number");
        Elements tt = ll.getElementsByClass("grid_data");
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < p.size(); i++) {
            stringList.add(p.get(i).text());//添加每行数据的序号
        }
        List<String> strings = new ArrayList<>();
        for (int i = 0; i <tt.size() ; i++) {
            strings.add(tt.get(i).text());//添加每行数据的内容
        }
        System.out.println(stringList.size());
        System.out.println(strings.size());
        for (int jj = 0; jj<stringList.size();jj++) {
            ExerciseDataQuery dataQuery = new ExerciseDataQuery();
            dataQuery.setNumid(Integer.parseInt(stringList.get(jj)));
            for (int i = 8*jj; i < 8*(jj+1); i++) {
                System.out.println(strings.get(i));
                dataQuery.setXuehao(strings.get(i));
                i++;
                dataQuery.setName(strings.get(i));
                i++;
                dataQuery.setCardId(strings.get(i));
                i++;
                String date = strings.get(i);//得到刷卡日期
                i++;
                String datetime = strings.get(i);//得到刷卡具体时间
                dataQuery.setD(date +" "+ datetime);
                i++;
                dataQuery.setIsvalid(strings.get(i));
                i++;
                i++;
            }
            exerciseDataQueries.add(dataQuery);
        }
        if (flag == 2){
            String Uu2 = "http://172.16.50.71/attendanceZZXX_list.html?pageNum=2";
            HttpClient.cookieStore.addCookie(c);//添加的cookie值不变
            String k2 = HttpClient.get(Uu2);
            Document d2 = Jsoup.parse(k2);
            Element E2 = d2.getElementById("dataTable");
            Elements p2 = E2.getElementsByClass("grid_number");
            Elements t2 = E2.getElementsByClass("grid_data");
            List<String> stringList2 = new ArrayList<>();
            for (int i = 0; i < p2.size(); i++) {
                stringList2.add(p2.get(i).text());//添加每行数据的序号
            }
            List<String> strings2 = new ArrayList<>();
            for (int i = 0; i <t2.size() ; i++) {
                strings2.add(t2.get(i).text());//添加每行数据的内容
            }
            System.out.println(stringList2.size());
            System.out.println(strings2.size());
            for (int jj = 0; jj<stringList2.size();jj++) {
                ExerciseDataQuery dataQuery = new ExerciseDataQuery();
                dataQuery.setNumid(Integer.parseInt(stringList2.get(jj)));
                for (int ii = 8*jj; ii < 8*(jj+1); ii++) {
                    System.out.println(strings.get(ii));
                    dataQuery.setXuehao(strings2.get(ii));
                    ii++;
                    dataQuery.setName(strings2.get(ii));
                    ii++;
                    dataQuery.setCardId(strings2.get(ii));
                    ii++;
                    String date2 = strings2.get(ii);//得到刷卡日期
                    ii++;
                    String datetime2 = strings2.get(ii);//得到刷卡具体时间
                    dataQuery.setD(date2 + " "+datetime2);
                    ii++;
                    dataQuery.setIsvalid(strings2.get(ii));
                    ii++;
                    ii++;
                }
                exerciseDataQueries.add(dataQuery);
            }
        }
        return  exerciseDataQueries;
    }











    //////////////////////////////////////////////////////



    @RequestMapping("/kuozhan")
    @ResponseBody
    public List<ExerciseDataQuery> getKuozhan(@RequestParam(value = "xuehao",required = false) String xuehao){
        String CAS_URL = "http://172.16.50.71/user_login.html?loginName="+xuehao+"&password="+xuehao;
        System.out.println(CAS_URL);
        HttpClient.get(CAS_URL);
        Cookie c = HttpClient.cookieStore.getCookies().get(0);//得到访问者的cookie值
        String U2 = "http://172.16.50.71/attendanceSTTZ_list.html";
        HttpClient.cookieStore.addCookie(c);
        String k = HttpClient.get(U2);
        Document d = Jsoup.parse(k);
        //找分页
        String sudg = d.getElementById("PageNavBar").getElementById("PageSelectorMemo").text();
        String g = sudg.substring(sudg.length() - 3, sudg.length() - 1);
        String regEx="[^0-9]";
        Pattern ph = Pattern.compile(regEx);
        Matcher m = ph.matcher(g);
        System.out.println( m.replaceAll("").trim());
        int totoalrecord = Integer.parseInt(m.replaceAll("").trim());
        int flag = totoalrecord > 20 ? 2 :1;

        List<ExerciseDataQuery> exerciseDataQueries = new ArrayList<>();
        Element ll = d.getElementById("dataTable");
        Elements p = ll.getElementsByClass("grid_number");
        Elements tt = ll.getElementsByClass("grid_data");
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < p.size(); i++) {
            stringList.add(p.get(i).text());//添加每行数据的序号
        }
        List<String> strings = new ArrayList<>();
        for (int i = 0; i <tt.size() ; i++) {
            strings.add(tt.get(i).text());//添加每行数据的内容
        }
        System.out.println(stringList.size());
        System.out.println(strings.size());
        for (int jj = 0; jj<stringList.size();jj++) {
            ExerciseDataQuery dataQuery = new ExerciseDataQuery();
            dataQuery.setNumid(Integer.parseInt(stringList.get(jj)));
            for (int i = 8*jj; i < 8*(jj+1); i++) {
                System.out.println(strings.get(i));
                dataQuery.setXuehao(strings.get(i));
                i++;
                dataQuery.setName(strings.get(i));
                i++;
                dataQuery.setCardId(strings.get(i));
                i++;
                String date = strings.get(i);//得到刷卡日期
                i++;
                String datetime = strings.get(i);//得到刷卡具体时间
                dataQuery.setD(date +" "+ datetime);
                i++;
                dataQuery.setIsvalid(strings.get(i));
                i++;
                i++;
            }
            exerciseDataQueries.add(dataQuery);
        }
        if (flag == 2){
            String Uu2 = "http://172.16.50.71/attendanceSTTZ_list.html?pageNum=2";
            HttpClient.cookieStore.addCookie(c);//添加的cookie值不变
            String k2 = HttpClient.get(Uu2);
            Document d2 = Jsoup.parse(k2);
            Element E2 = d2.getElementById("dataTable");
            Elements p2 = E2.getElementsByClass("grid_number");
            Elements t2 = E2.getElementsByClass("grid_data");
            List<String> stringList2 = new ArrayList<>();
            for (int i = 0; i < p2.size(); i++) {
                stringList2.add(p2.get(i).text());//添加每行数据的序号
            }
            List<String> strings2 = new ArrayList<>();
            for (int i = 0; i <t2.size() ; i++) {
                strings2.add(t2.get(i).text());//添加每行数据的内容
            }
            System.out.println(stringList2.size());
            System.out.println(strings2.size());
            for (int jj = 0; jj<stringList2.size();jj++) {
                ExerciseDataQuery dataQuery = new ExerciseDataQuery();
                dataQuery.setNumid(Integer.parseInt(stringList2.get(jj)));
                for (int ii = 8*jj; ii < 8*(jj+1); ii++) {
                    System.out.println(strings.get(ii));
                    dataQuery.setXuehao(strings2.get(ii));
                    ii++;
                    dataQuery.setName(strings2.get(ii));
                    ii++;
                    dataQuery.setCardId(strings2.get(ii));
                    ii++;
                    String date2 = strings2.get(ii);//得到刷卡日期
                    ii++;
                    String datetime2 = strings2.get(ii);//得到刷卡具体时间
                    dataQuery.setD(date2 + " "+datetime2);
                    ii++;
                    dataQuery.setIsvalid(strings2.get(ii));
                    ii++;
                    ii++;
                }
                exerciseDataQueries.add(dataQuery);
            }
        }
        return  exerciseDataQueries;
    }
}
