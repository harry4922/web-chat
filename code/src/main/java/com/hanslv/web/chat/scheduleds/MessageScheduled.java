package com.hanslv.web.chat.scheduleds;

import com.hanslv.web.chat.dao.MessageInfoDao;
import com.hanslv.web.chat.entity.MessageInfoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author lvcheng
 * @version 1.0
 * @date 2023/1/3 14:32
 * @description 消息定时任务
 */
@Component
public class MessageScheduled {

    /**
     * 定时任务锁
     */
    private Lock insertMessageLock = new ReentrantLock();

    /**
     * 待持久化状态集合
     */
    @Qualifier("NPP")
    @Autowired
    private List<MessageInfoEntity> npp;

    /**
     * 备用待持久化状态集合
     */
    @Qualifier("NPPB")
    @Autowired
    private List<MessageInfoEntity> nppb;

    /**
     * 是否使用备用缓存池
     */
    @Qualifier("NPPBFlag")
    @Autowired
    private AtomicBoolean nnpbFlag;

    @Autowired
    private MessageInfoDao messageInfoDao;

    /**
     * 对未发送成功的消息进行落库处理
     */
    @Async("scheduledsExecutor")
    @Scheduled(fixedDelay = 1000)
    public void insertMessage(){
        if(insertMessageLock.tryLock()) {
            try {
                // 当前是否使用备用缓存池
                boolean isNPPB = nnpbFlag.get();
                if (isNPPB) {
                    messageInfoDao.insertBatch(nppb);
                    nppb.clear();
                } else {
                    messageInfoDao.insertBatch(npp);
                    npp.clear();
                }
                // 切换缓存池
                nnpbFlag.set(!isNPPB);
            }finally {
                insertMessageLock.unlock();
            }
        }
    }
}
