package qiqihaer.desk.www.entitytmp;

public class SeatTwo {
    /**
     * roomid : 东区101
     * total_seat : 3
     * avail_seat : 0
     */

    private String roomid;
    private String total_seat;
    private String avail_seat;

    public SeatTwo(String roomid, String total_seat, String avail_seat) {
        this.roomid = roomid;
        this.total_seat = total_seat;
        this.avail_seat = avail_seat;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getTotal_seat() {
        return total_seat;
    }

    public void setTotal_seat(String total_seat) {
        this.total_seat = total_seat;
    }

    public String getAvail_seat() {
        return avail_seat;
    }

    public void setAvail_seat(String avail_seat) {
        this.avail_seat = avail_seat;
    }
}
