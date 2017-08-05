package com.sagarpayne;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sagarpayne.web.i18n.I18NService;

@RunWith(SpringRunner.class)
@SpringBootTest
public class FullstackApplicationTests {

	
	@Autowired
	private I18NService i18NService;
	
	@Test
	public void testMessageByLocalService() throws Exception
	{
		String er = "Bootstrap starter template new !";
		String msgId= "index.main.callout";
		String actual = i18NService.getMessage(msgId);
		Assert.assertEquals("Wrong Data",er,actual);
	}
	
}
