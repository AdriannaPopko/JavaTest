package com.example.mockdemo.app;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import org.junit.Test;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.MessageService;
import com.example.mockdemo.messenger.SendingStatus;

public class MockitoTests {

	 MessageService mock = mock(MessageService.class);
	 Messenger mess = new Messenger(mock);
	//checkConnection
	@Test
	public void checkConnectionSuccess1() {
		when(mock.checkConnection(".pl")).thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(mess.testConnection(".pl"), 0);
		verify(mock).checkConnection(".pl");
	}

	@Test
	public void checkConnectionCom() {
		when(mock.checkConnection(".com")).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(mess.testConnection(".com"), 1);
		verify(mock).checkConnection(".com");
	}
	@Test
	public void checkConnectionLinkPl() {
		when(mock.checkConnection("wp.pl")).thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(mess.testConnection("wp.pl"), 0);
		verify(mock).checkConnection("wp.pl");
	}
	@Test
	public void checkConnectionLinkCom() {
		when(mock.checkConnection("gmail.com")).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(mess.testConnection("gmail.com"), 1);
		verify(mock).checkConnection("gmail.com");
	}
	@Test
	public void checkConnectionFullLinkpl() {
		when(mock.checkConnection("www.inf.ug.edu.pl")).thenReturn(ConnectionStatus.SUCCESS);
		assertEquals(mess.testConnection("www.inf.ug.edu.pl"), 0);
		verify(mock).checkConnection("www.inf.ug.edu.pl");
	}
	@Test
	public void checkConnectionFullLinkcom() {
		when(mock.checkConnection("www.gmail.com")).thenReturn(ConnectionStatus.FAILURE);
		assertEquals(mess.testConnection("www.gmail.com"), 1);
		verify(mock).checkConnection("www.gmail.com");
	}
	@Test
	public void sendMessageAllGood() throws MalformedRecipientException {
		when(mock.send("wp.pl", "Wynik")).thenReturn(SendingStatus.SENT);
		assertEquals(mess.sendMessage("wp.pl", "Wynik"), 0);
		verify(mock).send("wp.pl", "Wynik");
	}
	@Test
	public void sendMessageShortMessage() throws MalformedRecipientException {
		when(mock.send("wp.pl", "wp")).thenThrow(new MalformedRecipientException());
		assertEquals(mess.sendMessage("wp.pl", "wp"), 2);
		verify(mock).send("wp.pl", "wp");
	}
	@Test
	public void sendMessageShortLink() throws MalformedRecipientException {
		when(mock.send("pl", "wwpww")).thenThrow(new MalformedRecipientException());
		assertEquals(mess.sendMessage("pl", "wwpww"), 2);
		verify(mock).send("pl", "wwpww");
	}
	@Test
	public void sendMessageShortMessageAndLink() throws MalformedRecipientException {
		when(mock.send("pl", "wp")).thenThrow(new MalformedRecipientException());
		assertEquals(mess.sendMessage("pl", "wp"), 2);
		verify(mock).send("pl", "wp");
	}
	@Test
	public void sendMessageCom() throws MalformedRecipientException {
		when(mock.send(".com", "wpww")).thenReturn(SendingStatus.SENDING_ERROR);
		assertEquals(mess.sendMessage(".com", "wpww"), 1);
		verify(mock).send(".com", "wpww");
	}
}
