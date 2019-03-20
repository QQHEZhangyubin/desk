package qiqihaer.desk.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qiqihaer.desk.www.dao.RecordMapper;
import qiqihaer.desk.www.dao.TmpRecordMapper;
import qiqihaer.desk.www.entity.Record;
import qiqihaer.desk.www.entity.Seat;
import qiqihaer.desk.www.entity.TmpRecord;
import qiqihaer.desk.www.service.RecordService;
@Service
public class RecordServiceimpl implements RecordService {
    @Autowired
    private RecordMapper recordMapper;
    @Autowired
    private TmpRecordMapper tmpRecordMapper;
    @Override
    public int InsertRecord(Record record) {
        return recordMapper.insert(record);
    }

    @Override
    public int InsertTmpRecord(TmpRecord tmpRecord) {
        return tmpRecordMapper.insert(tmpRecord);
    }

    @Override
    public TmpRecord GetTmpRecordbySeatid(Seat seat) {
        TmpRecord tmpRecord = new TmpRecord();
        tmpRecord.setTmpseatid(seat.getSeatid());
        return tmpRecordMapper.selectOne(tmpRecord);
    }

    @Override
    public int updateTmprecord(TmpRecord tmpRecord) {
        return tmpRecordMapper.updateByPrimaryKey(tmpRecord);
    }

    @Override
    public int deleteTmpRecord(TmpRecord tmpRecord) {
        return tmpRecordMapper.delete(tmpRecord);
    }

    @Override
    public Record getRecordByseatid(Seat seat) {
        Record record = new Record();
        record.setSeatid(seat.getSeatid());
        return recordMapper.selectOne(record);
    }

    @Override
    public int updateRecord(Record record) {
        return recordMapper.updateByPrimaryKey(record);
    }

    @Override
    public int selectRecordbyuserid(String userid) {
        TmpRecord t = new TmpRecord();
        t.setUsername2(userid);
        return tmpRecordMapper.selectCount(t);//返回0表示用户尚未有位置，1表示已经有位置了
    }

    @Override
    public TmpRecord selectRecordbyuserid2(String userid) {
        TmpRecord t = new TmpRecord();
        t.setUsername2(userid);
        return tmpRecordMapper.selectOne(t);
    }
}
