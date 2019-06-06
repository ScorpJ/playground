package com.arthur.redisstudy.credits.repository;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.util.Optional;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.arthur.redisstudy.RedisStudyApplicationConfig;
import com.arthur.redisstudy.credits.domain.SignInRecord;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {RedisStudyApplicationConfig.class})
public class SignInRecordRepositoryTest {
	
	@Autowired
	private SignInRecordRepository signInRecordRepository;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testGetLastSignInRecord() {
//		fail("Not yet implemented");
		
		Optional<SignInRecord> signInOpt = signInRecordRepository.getLastSignInRecord(100l);
		
		assertTrue(!signInOpt.isPresent());
//		assertNotTrue();
	}

}
