package com.hanslv.webchat.test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.hanslv.webchat.Starter;

/**
 * 测试基类
 * @author hanslv
 *
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes= {Starter.class})
public class BaseTest {

}
