package com.arthur.common.strategy;

import static org.junit.Assert.assertEquals;

import org.junit.Rule;
import org.junit.Test;
import org.junit.contrib.java.lang.system.SystemOutRule;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.arthur.common.BasicTestConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=BasicTestConfig.class)
public class StrategyHelperTest {

	@Rule
	public final SystemOutRule systemOutRule = new SystemOutRule().enableLog();
	
	@Autowired
	private TestServiceHelper testServiceHelper;
	
	@Test
	public void test() {
		
		testServiceHelper.getStrategyHandler("myTestService1").doService();
//	    assertEquals("doService in myTestService1\r\n", systemOutRule.getLog());
	    assertEquals("doService in myTestService1"+System.lineSeparator(), systemOutRule.getLog());
	    systemOutRule.clearLog();    
		testServiceHelper.getStrategyHandler("myTestService2").doService();
	    assertEquals("doService in myTestService2"+System.lineSeparator(), systemOutRule.getLog());
		
	}

}
