package qiqihaer.desk.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qiqihaer.desk.www.dao.SeatMapper;
import qiqihaer.desk.www.entity.Seat;
import qiqihaer.desk.www.service.SeatService;

import java.util.List;

@Service
public class SeatServiceimpl implements SeatService {
    @Autowired
    private SeatMapper seatMapper;


    @Override
    public List<Seat> QueryEmptySeat(String location, String classroom) {
        Seat seat = new Seat();
        seat.setLocation(location);
        seat.setClassroom(classroom);
        return seatMapper.select(seat);
    }

    @Override
    public int ChooseSeat(Seat seat,String state) {
        seat.setState(state);
        return seatMapper.updateByPrimaryKeySelective(seat);
    }

    @Override
    public Seat QuerySpecial(String location, String classroom, Integer seatnumber) {
        Seat seat = new Seat();
        seat.setLocation(location);
        seat.setClassroom(classroom);
        seat.setSeatnumber(seatnumber);
        return seatMapper.selectOne(seat);
    }
}
