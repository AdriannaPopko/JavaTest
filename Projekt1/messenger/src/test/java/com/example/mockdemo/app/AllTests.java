package com.example.mockdemo.app;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ DynamicProxyAppTests.class, EasyMockAppTests.class,
		MockitoTests.class, UnitTests.class })
public class AllTests {

}
