package qiqihaer.desk.www.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import qiqihaer.desk.www.entity.Seat;
import qiqihaer.desk.www.entitytmp.SeatTwo;
import qiqihaer.desk.www.service.SeatService;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping(value = "/seat")
public class SeatController {

    private final static  Logger logger = Logger.getLogger(SeatController.class);
    @Autowired
    private SeatService seatService;

    @RequestMapping("/queryseatinfo")
    @ResponseBody
    public List<SeatTwo> QuerySeatInfo(Model model){
        //TODO:根据每个房间位置和号码，查询该房间位置总数，可用数，房间名字，返回给移动端
        List<SeatTwo> seatTwos = new ArrayList<>();
        List<Seat> seats = seatService.QueryEmptySeat("东区", "101");
        int total_seat = seats.size();//东区101的所有位置数
        int avail_seat = seatService.QueryEmptyS("东区","101","c");//东区101座位状态可用的总数
        SeatTwo seatTwo = new SeatTwo(total_seat+"",avail_seat+"","东区101");
        seatTwos.add(seatTwo);
        return seatTwos;

    }


    @RequestMapping("/queryempteyseat")
    @ResponseBody
    public List<Seat> QueryEmpteySeat(Model model,
                                              @RequestParam(value = "location",required = false) String location,
                                              @RequestParam(value = "classroom",required = false) String classroom){

        List<Seat> seats = seatService.QueryEmptySeat("东区", "101");
        logger.info("查询空位置成功");
        return seats;

    }

    @RequestMapping("/chooseseat")
    @ResponseBody
    public Map<String,Object> ChooseSeat(Model model,
                           @RequestParam(value = "location",required = false) String location,
                           @RequestParam(value = "classroom",required = false) String classroom,
                           @RequestParam(value = "seatnumber",required = false) Integer seatnumber,
                           @RequestParam(value = "state",required = false) String state){
        Map map = new HashMap<String,Object>();
        state = "c";
        if (state.equals("a")){
            map.put("detail","当前座位正在被他人使用，换个位置试试吧！");
            logger.info("没有成功改变座位状态");
        }
        if (state.equals("b")){
            map.put("detail","这个位置的主人现在离开了一会，不怕被发现的话，可以暂时坐会！");
            logger.info("没有成功改变座位状态");
        }
        if (state.equals("c")){

            Seat seat = seatService.QuerySpecial("东区", "101", 3);

            int flag = seatService.ChooseSeat(seat, "a");
            System.out.println(flag);
            logger.info("成功改变座位状态");
            map.put("detail","座位已抢到手，赶紧开始繁忙的学习生活吧！");
        }
        return map;
    }

}
