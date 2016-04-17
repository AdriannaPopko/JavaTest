package com.example.mockdemo.app;

import static org.junit.Assert.*;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

import org.junit.Test;

import com.example.mockdemo.messenger.MessageService;

public class DynamicProxyAppTests {
	InvocationHandler ih = new MessengerHandler();
	MessageService messMock = (MessageService) Proxy.newProxyInstance(
			MessageService.class.getClassLoader(),
			new Class[] { MessageService.class }, ih);
	
	Messenger messenger = new Messenger(messMock);
	
	//checkConnection
	
	@Test
	public void testConnectionPl() {
		assertEquals(messenger.testConnection(".pl"),0);
	}
	@Test
	public void testConennectionCom(){
		assertEquals(messenger.testConnection(".com"),1);
	}
	@Test
	public void testConnectionLinkPl() {
		assertEquals(messenger.testConnection("wp.pl"),0);
	}
	@Test
	public void testConnectionRu() {
		assertEquals(messenger.testConnection(".ru"),1);
	}
	@Test
	public void TestConnectionLinkCom() {
		assertEquals(messenger.testConnection("gmail.com"),1);
	}
	@Test
	public void TestConnectionWWWLinkPl() {
		assertEquals(messenger.testConnection("www.inf.ug.edu.pl"),0);
	}
	@Test
	public void TestConnectionWWWGmailCom() {
		assertEquals(messenger.testConnection("www.gmail.com"),1);
	}
	
	//sendMessage
	
	@Test
	public void sendMessageGoodMessage() {
		assertEquals(messenger.sendMessage("wp.pl", "mess"), 0);
	}
	@Test
	public void sendMessageShortMessage() {
		assertEquals(messenger.sendMessage("wp.pl", "ww"), 2);
	}
	@Test
	public void sendMessageWrongLink() {
		assertEquals(messenger.sendMessage("youtube.com", "wiad"), 1);
	}
	@Test
	public void sendMessageWrongLinkAndMessage() {
		assertEquals(messenger.sendMessage("interia.ru", "w"), 2);
	}
	@Test
	public void sendMessageShortLink() {
		assertEquals(messenger.sendMessage("pl", "wiadomosc"), 2);
	}
}
