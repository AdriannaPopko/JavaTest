package com.example.mockdemo.app;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

import com.example.mockdemo.messenger.ConnectionStatus;
import com.example.mockdemo.messenger.MalformedRecipientException;
import com.example.mockdemo.messenger.SendingStatus;

public class MessengerHandler implements InvocationHandler {


	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		if ("checkConnection".equals(method.getName())) 
		{
			if(!(args[0].toString().endsWith(".pl")))
			return ConnectionStatus.FAILURE;
			else return ConnectionStatus.SUCCESS;
		}
		if("send".equals(method.getName()))
		{
			if(args[1]==null|| args[1].toString().length()<3)
			
				throw new MalformedRecipientException();

			
				
			if(args[0]==null || args[0].toString().length()<4)
				throw new MalformedRecipientException();
			if(!(args[0].toString().endsWith(".pl")))
				return SendingStatus.SENDING_ERROR;
							else return SendingStatus.SENT;
		}
		return null;
	}

}
