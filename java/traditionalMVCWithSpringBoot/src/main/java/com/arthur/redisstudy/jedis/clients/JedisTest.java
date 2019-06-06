package com.arthur.redisstudy.jedis.clients;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.fail;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import redis.clients.jedis.BinaryJedis;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.exceptions.InvalidURIException;
import redis.clients.jedis.exceptions.JedisConnectionException;
import redis.clients.jedis.exceptions.JedisDataException;
import redis.clients.jedis.exceptions.JedisException;
import redis.clients.util.SafeEncoder;

public class JedisTest {
	
	private Jedis jedis;
	private static final String host = "54.186.146.245";
	private static final int port = 6500;
	private static final String passwd = "pass4arthur";
	
	@Before
	public void setUp() throws Exception {
		jedis = new Jedis(host,port);
		jedis.auth(passwd);
	}
	
	@After
	public void tearDown(){
		jedis.close();
	}

	@Test
	public void useWithoutConnecting() {			
		System.out.println("dbSize:"+jedis.dbSize());
	}

	@Test
	public void checkBinaryData() {
		byte[] bigdata = new byte[1777];
		for (int b = 0; b < bigdata.length; b++) {
			bigdata[b] = (byte) ((byte) b % 255);
		}
		Map<String, String> hash = new HashMap<String, String>();
		hash.put("data", SafeEncoder.encode(bigdata));

		String status = jedis.hmset("hash:foo", hash);
		assertEquals("OK", status);
		assertEquals(hash, jedis.hgetAll("hash:foo"));
	}

	@Test
	public void connectWithShardInfo() {
		JedisShardInfo shardInfo = new JedisShardInfo(host, port);
//		JedisShardInfo shardInfo = new JedisShardInfo("localhost", Protocol.DEFAULT_PORT);
		shardInfo.setPassword(passwd);
		Jedis jedis = new Jedis(shardInfo);
		jedis.get("foo");
	}

	@Test(expected = JedisConnectionException.class)
	public void timeoutConnection() throws Exception {
		jedis = new Jedis(host, port, 15000);
		jedis.auth(passwd);
		jedis.configSet("timeout", "1");
		Thread.sleep(2000);
		jedis.hmget("foobar", "foo");
	}

	@Test(expected = JedisConnectionException.class)
	public void timeoutConnectionWithURI() throws Exception {
		jedis = new Jedis(new URI("redis://:"+passwd+"@"+host+":"+port+"/2"), 15000);
		jedis.configSet("timeout", "1");
		Thread.sleep(2000);
		jedis.hmget("foobar", "foo");
	}

	@Test(expected = JedisDataException.class)
	public void failWhenSendingNullValues() {
		jedis.set("foo", null);
	}

	@Test(expected = InvalidURIException.class)
	public void shouldThrowInvalidURIExceptionForInvalidURI() throws URISyntaxException {
		Jedis j = new Jedis(new URI("localhost:6380"));
		j.ping();
		j.close();
	}

	@Test
	public void shouldReconnectToSameDB() throws IOException {
		jedis.select(1);
		jedis.set("foo", "bar");
		jedis.getClient().getSocket().shutdownInput();
		jedis.getClient().getSocket().shutdownOutput();
		assertEquals("bar", jedis.get("foo"));
	}

	@Test
	public void startWithUrlString() {
		
		jedis.select(2);
		jedis.set("foo", "bar");
		
		jedis.close();
		jedis = new Jedis("redis://:"+passwd+"@"+host+":"+port+"/2");
		assertEquals("PONG", jedis.ping());
		assertEquals("bar", jedis.get("foo"));
	}

	@Test
	public void startWithUrl() throws URISyntaxException {
	
		jedis.select(2);
		jedis.set("foo", "bar");
		jedis.close();
		jedis = new Jedis(new URI("redis://:"+passwd+"@"+host+":"+port+"/2"), 50000);
		assertEquals("PONG", jedis.ping());
		assertEquals("bar", jedis.get("foo"));
	}

	@Test
	public void shouldNotUpdateDbIndexIfSelectFails() throws URISyntaxException {
		long currentDb = jedis.getDB();
		try {
			int invalidDb = -1;
			jedis.select(invalidDb);

			fail("Should throw an exception if tried to select invalid db");
		} catch (JedisException e) {
			assertEquals(Long.valueOf(currentDb), Long.valueOf(jedis.getDB()));
		
		}
	}

	@Test
	public void allowUrlWithNoDBAndNoPassword() {
		
		jedis.close();
		jedis = new Jedis("redis://"+host+":"+port);
		jedis.auth(passwd);
		assertEquals(jedis.getClient().getHost(), host);
		assertEquals(jedis.getClient().getPort(), port);
		assertEquals(jedis.getDB()*1l, 0);
		
		jedis.close();

		jedis = new Jedis("redis://"+host+":"+port+"/");
		jedis.auth(passwd);
		assertEquals(jedis.getClient().getHost(), host);
		assertEquals(jedis.getClient().getPort(), port);
		assertEquals(jedis.getDB()*1l, 0);
	}

	@Test
	public void checkCloseable() {
		jedis.close();
		BinaryJedis bj = new BinaryJedis(host, port);
		bj.connect();
		bj.close();
	}

	@Test
	public void checkDisconnectOnQuit() {
//		Jedis jedis = new Jedis(host,port);
//		jedis.auth(passwd);
		jedis.quit();
		assertFalse(jedis.getClient().isConnected());
	}

}