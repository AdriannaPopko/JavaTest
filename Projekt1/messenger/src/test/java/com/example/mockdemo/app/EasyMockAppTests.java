package com.example.mockdemo.app;

import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;
import static org.junit.Assert.*;

import org.easymock.EasyMockRule;
import org.easymock.Mock;
import org.easymock.TestSubject;
import org.junit.Rule;
import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;


public class EasyMockAppTests {

	@Rule
	public EasyMockRule mocks = new EasyMockRule(this);

	@Mock
	private MessageService mock;

	@TestSubject
	private Messenger mess = new Messenger(mock);
	
	//checkConnection
	@Test
	public void checkConnectionPl() {
		expect(mock.checkConnection(".pl")).andReturn(ConnectionStatus.SUCCESS);
		replay(mock);
		assertEquals(mess.testConnection(".pl"), 0);
		verify(mock);
	}
	@Test
	public void checkConnectionCom() {
		expect(mock.checkConnection(".com")).andReturn(ConnectionStatus.FAILURE);
		replay(mock);
		assertEquals(mess.testConnection(".com"), 1);
		verify(mock);
	}
	@Test
	public void checkConnectionLinkPl() {
		expect(mock.checkConnection("wp.pl")).andReturn(ConnectionStatus.SUCCESS);
		replay(mock);
		assertEquals(mess.testConnection("wp.pl"), 0);
		verify(mock);
	}
	@Test
	public void checkConnectionLinkCom() {
		expect(mock.checkConnection("gmail.com")).andReturn(ConnectionStatus.FAILURE);
		replay(mock);
		assertEquals(mess.testConnection("gmail.com"), 1);
		verify(mock);
	}
	@Test
	public void checkConnectionFullLinkpl() {
		expect(mock.checkConnection("www.inf.ug.edu.pl")).andReturn(ConnectionStatus.SUCCESS);
		replay(mock);
		assertEquals(mess.testConnection("www.inf.ug.edu.pl"), 0);
		verify(mock);
	}
	@Test
	public void checkConnectionFullLinkcom() {
		expect(mock.checkConnection("www.gmail.com")).andReturn(ConnectionStatus.FAILURE);
		replay(mock);
		assertEquals(mess.testConnection("www.gmail.com"), 1);
		verify(mock);
	}
	//sendMessage
	@Test
	public void sendMessageAllGood() throws MalformedRecipientException {
		expect(mock.send("wp.pl", "Wynik")).andReturn(SendingStatus.SENT);
		replay(mock);
		assertEquals(mess.sendMessage("wp.pl", "Wynik"), 0);
		verify(mock);
	}
	@Test
	public void sendMessageShortMessage() throws MalformedRecipientException {
		expect(mock.send("wp.pl", "wp")).andThrow(new MalformedRecipientException());
		replay(mock);
		assertEquals(mess.sendMessage("wp.pl", "wp"), 2);
		verify(mock);
	}
	@Test
	public void sendMessageShortLink() throws MalformedRecipientException {
		expect(mock.send("pl", "wwpww")).andThrow(new MalformedRecipientException());
		replay(mock);
		assertEquals(mess.sendMessage("pl", "wwpww"), 2);
		verify(mock);
	}
	@Test
	public void sendMessageShortMessageAndLink() throws MalformedRecipientException {
		expect(mock.send("pl", "wp")).andThrow(new MalformedRecipientException());
		replay(mock);
		assertEquals(mess.sendMessage("pl", "wp"), 2);
		verify(mock);
	}
	@Test
	public void sendMessageCom() throws MalformedRecipientException {
		expect(mock.send(".com", "wpww")).andReturn(SendingStatus.SENDING_ERROR);
		replay(mock);
		assertEquals(mess.sendMessage(".com", "wpww"), 1);
		verify(mock);
	}
}
