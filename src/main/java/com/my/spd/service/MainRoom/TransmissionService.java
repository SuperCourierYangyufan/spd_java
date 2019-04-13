package com.my.spd.service.MainRoom;

import com.my.spd.message.MessageModel;
import com.my.spd.message.SO.MainRoom.TransmissionSo;

import java.util.List;

/**
 * @author 杨宇帆
 * @create 2019-04-13
 */
public interface TransmissionService {
    MessageModel saveRequestForm(List<TransmissionSo> transmissionSoList);
}
