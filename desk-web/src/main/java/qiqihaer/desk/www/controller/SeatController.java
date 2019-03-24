package qiqihaer.desk.www.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qiqihaer.desk.www.entity.Record;
import qiqihaer.desk.www.entity.Seat;
import qiqihaer.desk.www.entity.TmpRecord;
import qiqihaer.desk.www.entitytmp.SeatTwo;
import qiqihaer.desk.www.service.RecordService;
import qiqihaer.desk.www.service.SeatService;

import java.util.*;

@Controller
@RequestMapping(value = "/seat")
public class SeatController {

    private final static  Logger logger = Logger.getLogger(SeatController.class);
    @Autowired
    private SeatService seatService;
    @Autowired
    private RecordService recordService;
    @RequestMapping("/queryseatinfo")
    @ResponseBody
    public List<SeatTwo> QuerySeatInfo(Model model){
        //TODO:根据每个房间位置和号码，查询该房间位置总数，可用数，房间名字，返回给移动端
        List<SeatTwo> seatTwos = new ArrayList<>();
        String[] locations = {"东区","西区","中区"};
        String[] classroom = {"201","401","207","401","408","101","201","206","211"};
        for (int j = 0; j <= 1 ; j++) {
                List<Seat> seats = seatService.QueryEmptySeat(locations[0], classroom[j]);
                int total_seat = seats.size();//东区的所有位置数
                int avail_seat = seatService.QueryEmptyS(locations[0], classroom[j],"c");//东区401座位状态可用的总数
                SeatTwo seatTwo = new SeatTwo(locations[0]+classroom[j],total_seat+"",avail_seat+"");
                seatTwos.add(seatTwo);
        }
        for (int j1 = 2; j1 <= 4 ; j1++) {
            List<Seat> seats = seatService.QueryEmptySeat(locations[1], classroom[j1]);
            int total_seat = seats.size();//西区的所有位置数
            int avail_seat = seatService.QueryEmptyS(locations[1], classroom[j1],"c");//东区401座位状态可用的总数
            SeatTwo seatTwo = new SeatTwo(locations[1]+classroom[j1],total_seat+"",avail_seat+"");
            seatTwos.add(seatTwo);
        }
        for (int m = 5; m <= 8 ; m++) {
            List<Seat> seats = seatService.QueryEmptySeat(locations[2], classroom[m]);
            int total_seat = seats.size();//中区的所有位置数
            int avail_seat = seatService.QueryEmptyS(locations[2], classroom[m],"c");//东区401座位状态可用的总数
            SeatTwo seatTwo = new SeatTwo(locations[2]+classroom[m],total_seat+"",avail_seat+"");
            seatTwos.add(seatTwo);
        }
        return seatTwos;
    }


    @RequestMapping("/queryempteyseat")
    @ResponseBody
    public List<Seat> QueryEmpteySeat(Model model,
                                              @RequestParam(value = "location",required = false) String location,
                                              @RequestParam(value = "classroom",required = false) String classroom){

        List<Seat> seats = seatService.QueryEmptySeat("东区", "401");
        logger.info("查询空位置成功");
        return seats;

    }

    @RequestMapping("/chooseseat")
    @ResponseBody
    public Map<String,Object> ChooseSeat(Model model,
                           @RequestParam(value = "userid",required = false) String userid,
                           @RequestParam(value = "location",required = false) String location,
                           @RequestParam(value = "classroom",required = false) String classroom,
                           @RequestParam(value = "seatnumber",required = false) Integer seatnumber,
                                         @RequestParam(value = "rqcord",required = false) String rqcord){
        Map map = new HashMap<String,Object>();
        String u = location + classroom;
        if (!u.equals(rqcord)){
            map.put("detail","扫描错误二维码");
            return map;
        }
        //先查看用户是否已经有座位
        int h = recordService.selectRecordbyuserid(userid);
        if (h == 1){
            map.put("detail","你已经有位置了！");
        }else {
            //根据location，clssroom,seatnumber找到当前座位的状态
            Seat seat = seatService.QuerySpecial(location, classroom, seatnumber);
            String state = seat.getState();
            if (state.equals("a")){
                map.put("detail","当前座位正在被他人使用，换个位置试试吧！");
                logger.info("没有成功改变座位状态");
            }
            if (state.equals("b")){
                map.put("detail","这个位置的主人现在离开了一会，不怕被发现的话，可以暂时坐会！");
                logger.info("没有成功改变座位状态");
            }
            if (state.equals("c")){
                int flag = seatService.ChooseSeat(seat, "a");
                logger.info("成功改变座位状态--抢到座位");
                //在记录表插入数据
                Record record = new Record();
                record.setUsername(userid);
                record.setStarttime(new Date());
                record.setSeatid(seat.getSeatid());
                recordService.InsertRecord(record);
                //在暂时记录表插入数据
                TmpRecord tmpRecord = new TmpRecord();
                tmpRecord.setStarttime(new Date());
                tmpRecord.setTmpseatid(seat.getSeatid());
                tmpRecord.setStatus("a");
                tmpRecord.setUsername2(userid);
                recordService.InsertTmpRecord(tmpRecord);
                map.put("detail","座位已抢到手，赶紧开始繁忙的学习生活吧！");
            }
        }
        return map;
    }

    @RequestMapping("/changestatus")
    @ResponseBody
    public Map<String,Object> ChangeStatus(Model model,
                                           @RequestParam(value = "userid",required = false) String userid,
                             @RequestParam(value = "location",required = false) String location,
                             @RequestParam(value = "classroom",required = false) String classroom,
                             @RequestParam(value = "seatnumber",required = false) Integer seatnumber){
        Map map = new HashMap<String,Object>();
        //根据userid在tmprecord找到参考座位的主键
        TmpRecord tmp = recordService.selectRecordbyuserid2(userid);
        Integer seatid = tmp.getTmpseatid();
        Seat seat = seatService.findSeatbyid(seatid);
        //Seat seat = seatService.QuerySpecial(location, classroom, seatnumber);
        int flag = seatService.ChooseSeat(seat, "b");
        if (flag == 1){
            logger.info("成功改变座位状态--暂离");
            TmpRecord tmprecord = recordService.GetTmpRecordbySeatid(seat);
            tmprecord.setStatus("b");
            recordService.updateTmprecord(tmprecord);
            map.put("change","暂离成功,记得按时回来哦！");
        }else {
            map.put("change","暂离失败，请重试！");
        }
        return map;
    }

    @RequestMapping("/enduse")
    @ResponseBody
    public Map<String,Object> Enduse(Model model,
                                       @RequestParam(value = "userid",required = false) String userid,
                                           @RequestParam(value = "location",required = false) String location,
                                           @RequestParam(value = "classroom",required = false) String classroom,
                                           @RequestParam(value = "seatnumber",required = false) Integer seatnumber){
        Map map = new HashMap<String,Object>();
        //根据location，clssroom,seatnumber找到当前座位的状态

        TmpRecord tmp = recordService.selectRecordbyuserid2(userid);
        Integer seatid = tmp.getTmpseatid();
        Seat seat = seatService.findSeatbyid(seatid);
       // Seat seat = seatService.QuerySpecial(location, classroom, seatnumber);
        int flag = seatService.ChooseSeat(seat, "c");
        if (flag == 1){
            logger.info("成功改变座位状态--结束使用");
            TmpRecord tmprecord = recordService.GetTmpRecordbySeatid(seat);
            recordService.deleteTmpRecord(tmprecord);
            Record re = recordService.getRecordByseatid(seat);
            re.setEndtime(new Date());
            recordService.updateRecord(re);
            map.put("change1","忙碌了一天的学习，放松一下吧！");
        }else {
            map.put("change1","暂离失败！");
        }
        return map;
    }

    @RequestMapping("/seemystate")
    @ResponseBody
    public Map<String,Object> seemystate(Model model,
                                         @RequestParam(value = "userid",required = false) String userid){
        Map map = new HashMap<String,Object>();
        TmpRecord tmp = recordService.selectRecordbyuserid2(userid);
        map.put("starttime",tmp.getStarttime());
        Seat s = seatService.findSeatbyid(tmp.getTmpseatid());
        map.put("location",s.getLocation());
        map.put("classroom",s.getClassroom());
        map.put("seatnumber",s.getSeatnumber());
        return map;
    }


}
