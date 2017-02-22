package com.nlan.appSpring;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.webAppContextSetup;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.ContextHierarchy;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.context.WebApplicationContext;

import com.nlan.appSpring.config.WebappConfig;
import com.nlan.appSpring.utils.FileUpload;
import com.nlan.appSpring.utils.ServerHDBSQL;
import com.nlan.appSpring.utils.ServerMysql;

@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextHierarchy(@ContextConfiguration(classes = WebappConfig.class))
public class BaseSpringConnectionTest {

	private static ServerHDBSQL serverServiceUtil;
	
	private static ServerMysql serverMysqlServiceUtil;
	@Autowired
	protected WebApplicationContext wac;


	@SuppressWarnings("static-access")
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		FileUpload.ROOT_IMAGES = "../../../tempFileUpload";
		serverServiceUtil = new ServerHDBSQL();
		serverServiceUtil.runAndCreateDB();
//		serverMysqlServiceUtil = new ServerMysql();
//		serverMysqlServiceUtil.runAndCreateMYSQLDB();
	}

	@SuppressWarnings("static-access")
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		serverServiceUtil.closeServer();
	}

	protected MockMvc mockMvc;

	@Before
	public void setup() throws Exception {
		this.mockMvc = webAppContextSetup(this.wac).alwaysExpect(status().isOk()).build();
		mockData();
	}

	protected void mockData() {
	}
	

	@After
	public void tearDown() throws Exception {
		mockMvc = null;
	}
	
	@Test
	public void testLog()
	{
		System.out.println("Fake test/Only to override");
	}

}
