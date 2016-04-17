package com.example.mockdemo.app;

import static org.junit.Assert.*;

import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageServiceSimpleImpl;
import com.example.mockdemo.messenger.SendingStatus;

public class UnitTests {

	MessageServiceSimpleImpl mess = new MessageServiceSimpleImpl();
	//checkConnection
	@Test
	public void checkConnectionPl() {
		assertEquals(mess.checkConnection("wp.pl"), ConnectionStatus.SUCCESS);
	}
	@Test
	public void checkConnectionCom() {
		assertEquals(mess.checkConnection("gmail.com"), ConnectionStatus.FAILURE);
	}
	@Test
	public void checkConnectionLinkPl() {
		assertEquals(mess.checkConnection("wp.pl"),ConnectionStatus.SUCCESS);
	}
	@Test
	public void testConnectionRu() {
		assertEquals(mess.checkConnection(".ru"),ConnectionStatus.FAILURE);
	}
	@Test
	public void TestConnectionLinkCom() {
		assertEquals(mess.checkConnection("gmail.com"),ConnectionStatus.FAILURE);
	}
	@Test
	public void TestConnectionWWWLinkPl() {
		assertEquals(mess.checkConnection("www.inf.ug.edu.pl"),ConnectionStatus.SUCCESS);
	}
	@Test
	public void TestConnectionWWWGmailCom() {
		assertEquals(mess.checkConnection("www.gmail.com"),ConnectionStatus.FAILURE);
	}
	//sendMessage
		@Test(expected = MalformedRecipientException.class)
		public void sendMessageShortMessage() throws MalformedRecipientException{
			mess.send("wp.pl", "ww");
		}
		@Test
		public void sendMessageWrongLink()throws MalformedRecipientException {
			assertEquals(mess.send("youtube.com", "wiad"), SendingStatus.SENDING_ERROR);
		}
		@Test(expected = MalformedRecipientException.class)
		public void sendMessageWrongLinkAndMessage()throws MalformedRecipientException {
			mess.send("interia.ru", "w");
		}
		@Test(expected = MalformedRecipientException.class)
		public void sendMessageShortLink() throws MalformedRecipientException{
			mess.send("pl", "wiadomosc");
		}
}
