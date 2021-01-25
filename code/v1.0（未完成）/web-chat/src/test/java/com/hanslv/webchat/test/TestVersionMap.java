package com.hanslv.webchat.test;

import java.util.Map;
import java.util.Map.Entry;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import lombok.extern.slf4j.Slf4j;

/**
 * 测试版本号Map
 * @author hanslv
 *
 */
@Slf4j
public class TestVersionMap extends BaseTest{
	@Autowired
	@Qualifier("versionMap")
	private Map<String , Integer> versionMap;
	
	@Test
	public void test() {
		for(Entry<String , Integer> versionEntry : versionMap.entrySet()) log.info(versionEntry.getKey() + "," + versionEntry.getValue());
	}
}
