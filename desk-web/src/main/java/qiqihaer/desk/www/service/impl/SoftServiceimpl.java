package qiqihaer.desk.www.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import qiqihaer.desk.www.dao.Soft2Mapper;
import qiqihaer.desk.www.entity.Soft2;
import qiqihaer.desk.www.service.SoftService;

@Service
public class SoftServiceimpl implements SoftService {
    @Autowired
    private Soft2Mapper softMapper;
    @Override
    public Soft2 UpdateSoftWare() {
        Soft2 t = new Soft2();
        int count = softMapper.selectCount(t);
        Soft2 t1 = new Soft2();
        t1.setIdsoft(count);
        return softMapper.selectOne(t1);
    }
}
