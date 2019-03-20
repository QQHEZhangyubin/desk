package qiqihaer.desk.www.service;

import qiqihaer.desk.www.entity.Record;
import qiqihaer.desk.www.entity.Seat;
import qiqihaer.desk.www.entity.TmpRecord;

public interface RecordService {
    //插入预约作为记录(插入到record表)
    int InsertRecord(Record record);
    // 插入预约作为记录(插入到tmprecord表)
    int InsertTmpRecord(TmpRecord tmpRecord);

    //根据seatid得到暂时表对象
    TmpRecord GetTmpRecordbySeatid(Seat seat);

    int updateTmprecord(TmpRecord tmpRecord);

    int deleteTmpRecord(TmpRecord tmpRecord);

    //根据seatid得到记录表对象
    Record getRecordByseatid(Seat seat);

    int updateRecord(Record record);

    //根据userid查找是否存在tmprecord对象
    int selectRecordbyuserid(String userid);

    //根据userid查找是否存在tmprecord对象
    TmpRecord selectRecordbyuserid2(String userid);
}
