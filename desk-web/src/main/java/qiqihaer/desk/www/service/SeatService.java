package qiqihaer.desk.www.service;

import qiqihaer.desk.www.entity.Seat;

import java.util.List;

public interface SeatService {
    //查询空座位
    List<Seat> QueryEmptySeat(String location,String classroom);
    //改变座位状态
    int ChooseSeat(Seat seat,String state);

    //查询某一个具体位置
    Seat QuerySpecial(String location,String classroom,Integer seatnumber);

}
