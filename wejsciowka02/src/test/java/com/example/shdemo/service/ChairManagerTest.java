package com.example.shdemo.service;
import wejsciowka01.example.shdemo.domain.IList;
import wejsciowka01.example.shdemo.domain.Chair;
import wejsciowka01.example.shdemo.service.ChairManager;
import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import static org.easymock.EasyMock.createMock;
import static org.easymock.EasyMock.expect;
import static org.easymock.EasyMock.replay;
import static org.easymock.EasyMock.verify;

import org.junit.Before;
import org.junit.Test;

public class ChairManagerTest {


	String name1="Krzesło biurowe";
	float price1=40;
	String name2="Krzesło bujane";
	float price2=200;
	final double DELTA = 1e-15;
	
	private ChairManager chairManager;
	private IList mock;
	private Chair chair = new Chair(name1,price1);
	private List<Chair> chairs;
	
	@Before
	public void setUp() {
		mock = createMock(IList.class);
		chairManager = new ChairManager(mock);
	}
	
	
	@Test
	public void checkAdding() {
		expect(mock.addNewChair(chair)).andReturn(true).atLeastOnce();
		replay(mock);
		assertTrue(chairManager.addNewChair(chair));
		verify(mock);
	}
	
	
	@Test
	public void checkDeleting() {
		expect(mock.deleteChair(chair)).andReturn(true).atLeastOnce();
		replay(mock);
		assertTrue(chairManager.deleteChair(chair));
		verify(mock);
	}
	
	@Test
	public void checkGetAll() {
		expect(mock.getAll()).andReturn(chairs);
		replay(mock);
		assertEquals(chairs, chairManager.getAllChairs());
		verify(mock);
	}
	
	@Test
	public void checkGetByChairName() {
		expect(mock.getByName(name1)).andReturn(chair);
		replay(mock);
		assertEquals(chair, chairManager.getByName(name1));
		verify(mock);
	}
	
	
	
}
