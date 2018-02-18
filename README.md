# tdd

TDD(Test driven development) is a development approach keeping tests one step ahead of the code to help drive the design of your system.
The idea of this approach is you are designing and developing your code in conjunction with test in order to achieve more structured and modular design which supports automated testing upfront. Thus TDD is also referred to as test driven design.

TDD gives reliability so that we won't have significant issues introduced in the subsequent releases of your project. It doesn't completely remove risk but it goes a long way to reduce it.

Problems with traditional approach
----------------------------------
In the earlier days of automated unit testing developers often write their functional code and then figure out how to write the unit tests to validate the assumptions made in how the code should function. For ex, in a typical web application a developer used to write a functional flow which spans multiple layers like controller, service and dao and then try to figure out how to write unit tests. Here are the few problems with this approach.

1)The complete omission of thought in regrads to how the testing would be performed --> Developer often forget to identify the complexity of their method because of this. A method should do only one thing. If it gets complex it has to be broken down. If developer identify this too late and has the intention to break it down, he may run out of time. Over long streches it may become inefficient to try to simplify code later as there may be more people touching the code to enhance the system, the complexity grows.

2)Benefits of automation missed --> With automation developers are able to add and revise the code with certainity that they do not unintentionally break functionality or change assumptions previously held when creating the code. The further you defer automation, the more likely that changes made in future development unintentionally break something.

3)Time crunch encountered in projects --> The more an application is tested upfront the greate gauge a developer have on how much effort is remaining to complete the project. Thus, when you save the tests until the end developers encounter few scenarios like this.<br>
	a) Developer may run out of time to automate any tests. The code is functional, the dead line has approached and it becomes difficult to justify additional time as the stakeholders view everything as functional within the system.<br>
	b)Developer may have underestimate the true effort of testing and it has become more complicated because developer did not design the system with this in mind.

4)Mountain of work to implement the automated unit test --> Saving all the testing to the end leads to the feeling of a daunting effort once developer starts testing. Developer typically tries to figure out how to work around more complexity and become frustrated with the lack of structure he encounters because of the thinking how the test can be broken down and work in conjunction with the design of the code.

Benefits of TDD
---------------
1)TDD brings in more balance because developers don't do too much of coding or testing in disproportionate manner.<br>
2)Consistent repeatability of test execution. Once test is written it can be repeatedly executed without any effort.<br>
3)Upfront design with testing in mind. It makes developer identify the code smell(something in the code which indicates a potential issue) early.

Red/Green/Refactor
------------------
A command pattern used in TDD is called Red/Green/Refactor. Here are the steps<br>
1)Write a statement(or statements) resulting in a failing test. <br>
2)Implement the functionality, this should result in a success test, fixing all the issues found in step 1.<br>
3)Refactor the code as needed to simplify the design. 

Note: If developer refactors the code, the test should still pass. Depending on the complexity of the code, developer may need to refactor the test as well. If no refactor remains, continue on with the test method repeating this pattern until all aspects of the method functionality are complete.

Terminology
-----------
Here are some of the general terms used in TDD.<br>
1)xUnit Testing --> This is a generic reference to automated unit testing using a unit test framework. JUnit is an implementation of a xUnit Testing framework being adapted from earlier versions of small talk unit testing framework.<br>
2)Class-Under-Test --> An automated unit test should focus on testing functionality of the methods in a single class. It is advisable to have one or more test classes for a single functional class. The class being tested in this case, is referred to as Class-Under-Test.<br>
3)Method-Under-Test --> This is the target method that a single JUnit test method will be executing to verify the functionality and validate assumptions made during development of the functional code. Developer should strive to test no more than one Method-Under-Test with in a single JUnit test method.<br>
4)Test Fixture --> This term encompasses the setup of data for use in a test. This may be setup of an object in a certain state or it may encompass the setup of database to support the test execution. The best practice is to setup the fixture at the beginning of each test and tear at the end.

Common myths about TDD
-----------------------
1)Doesn't all this testing double the development?
Ans: If a developer wants to ensure quality in the system it needs to be unit tested. If tests are not automated then there is no way to unit test the system in a repeatable and consistent manner. Overtime testing manually by the developer will be of more effort than creating automated tests upfront. These automated tests will become part of the build process to help facilitate the repeated testing of all changes. This way, developer will get away from the subjectivity of what tests the tester is going to execute in manual testing. So, these automated tests gives reliability.

Note: The greatest amount of cost in a system is in the overall support, not the upfront development.

2)How to write all tests before writing a single line of functional code?
Ans: This is the complete misinterpretation of the test first concept. 
	a)Red/Green/Refactor concept describes the true intent. 
	b)As developer is developing the code, he identifies the cases for Method-Under-Test that need to be captured. stub these important cases into methods. i.e. creating empty methods in the test class to make sure developer is capturing the important conditions(or cases).
	c)During development some already passed unit tests may fail. Add them as failed test cases.
	
Note: Testing frameworks typically support the ability to ignore test cases. It is recommonded doing these in stub methods, so the execution results give feedback that work is remaining and developer don't forget to complete them later.

Java test frameworks
--------------------
Mockito --> This will help in mocking and stubbing of dependent interfaces and objects help in implementing mock patterns in test code.<br>
DBUnit --> This framework covers sql based database data fixture setup and tear down and validation of data manipulations occuring as a result of the Method-Under-Test being executed.<br>
PowerMockito --> This framework contains extended mocking capabilities not supporting directly in mockito like testing private , static methods etc.

JUnit testing concepts
----------------------
JUnit is a framework for java developers to write automated unit tests. Developers write unit tests with the purpose of executing functionality within the corresponding class. A good unit test follows four steps.

1)setup --> Establishment of data in fixtures needed to execute the test. For ex, testing methods involves instantiating objects used as parameters to be passed into the Method-Under-Test or setting object dependencies used with in this method for it to properly execute as expected. Other examples include setup data in a database or creating files for use in the Method-Under-Test.

2)execution --> Invocation of the Method-Under-Test. Generally a Class-Under-Test contains multiple Method-Under-Test. In most of the scenarios, a test class contains all Method-Under-Test that belong to a Class-Under-Test. In some scenarios, a test class might contain methods that belong to logical grouping of multiple classes based on functionality. This judgement is purely based on the situation. So, bear in mind it is important to keep your test classes manageable.

3)verification --> verification involves the assertion of the result returned from the Method-Under-Test. This is typically the most important part of the test but often more overlooked. As a general approach, testing code should verify the resulting object as well as any data set on this object by the Method-Under-Test. This helps in ensuring developer coded correctly ensuring the test code covered in later iterations of development when others starts changing the code.

4)teardown --> clearing any data in fixtures created during setup. This typically involves removing of any persistent data created for the test or release of resources acquired which are not required or don't want to leak like db connection or deleting any files that might have created during test execution.

JUnit core contructs
--------------------
Junit classes are standard java classes. Here are the core constructs from org.junit package.<br>
1)@Test --> Test classes are marked with @Test annotation. This annotation informs the framework of the methods in the testing class that will execute methods on that Class-Under-Test and perform verification. This allows the test runner program to coordinate execution and display the pass/fail indicator for each of the tests.

2)Verification Methods --> Verification is handled in the test method directly or indirectly. Junit provides two general approaches for performing these verifications.<br>
	a) org.junit.Assert --> This class contains a set of static methods which trigger the test to fail when resulting evaluations returns false.<br>
	b)HamcrestMatcherAssert --> It is an additional library providing extensions to Junit's assertion mechanism. This provides an alternative for declaring assertions that are more readable. For ex,
		
		//JUnit
		Assert.assertEquals("Brown", customer.lastName());
		Assert.assertTrue(customer.lastName().startsWith("Brown"));
		
		//Hamcrest 
		MatcherAssert.assertThat(customer.lastName(), IsEqual.equalTo("Brown"));
		MatcherAssert.assertThat(customer.lastName(), StringStartsWith.startsWith("Brown"));
	c)@Before/@BeforeClass --> The test class may also contain setup and teardown steps. This often happens when there redundancy in the actions across multiple tests. The framework provides constructs that removes redundancy in test classes. The method level annotation @Before is used to handle test setup steps before each test method is executed. Similary, @BeforeClass can be applied to a staic method and will run once before the first test annotated method is executed.
	D)@After/@AfterClass --> @After is used to handle teardown after each @Test annotated method is executed. @AfterClass annotation allows to perform final set of teardown steps after the last @Test annotated method execution.

Note: Class level annotation are good for resources that are more expensive to create and lengthen the time needed for setup and teardown.

Mocking concepts
----------------
There are few scenarios like transformation of objects need dependencies. But, more often Method-Under-Test leverage dependencies from other layers of the system or external system. Testing these methods with dependencies in place can become complicated and unpredictable. For ex, a service class often depends on dao class. Testing the service class create few challengs like below.<br>
1)Live database connection needed. --> If connection is not available while the testing is focusing on service class then testing become stalled based on component not relavant to the true Class-Under-Test.<br>
2)Multiple testers developing simultaneously --> Multiple developers may be testing the dao layer simultaneously and this may result in conflicts. This may also be faced when working with external systems.<br>
3)Incomplete dependency implementation --> The dependent component interface is available but the component's implementation is not yet done.

Mocking framework gives control. This will allows to replace the dependencies on implementation classes with a mocked implementation during the test execution. They help solve the problems of database dependency, external dependencies etc.

Mocking options
---------------
1)One way to implement mocking is to create a mocked implementation of the interface or extension of the dependency. This approach is tedious because it requires a bit of coding to account for the many different conditions that needs to be tested and create obscure tests because many of the details related to test conditions are in a seperate class.<br>
2)Another way to leverage a mocking framework like Mockito, which provides a mocked implementation without creating a dedicated class. The api's use dynamic proxies or similar feature to provide each generic implementation of the dependent interface or extension of the dependent class.

Note: Some of the famous mocking frameworks for java include Mockito, EasyMock, JMock. Additionally frameworks like spring contains their own sets of mocking capabilities that can be used independently or inconjuction with these frameworks.

Mockito Overview
----------------
Mockito provides capabilities that help support the four stages of unit testing cycle. This mostly focuses on first three stages i.e. setup, execution and verification.<br>
1)During setup phase use the framework to create mocks and declare how the dependencies should behave when called during execution in the Method-Under-Test. For ex,

	//creating the mock
	OrderDao mockOrderDao = Mockito.mock(OrderDao.class);
	//stubbing method
	Mockito.when(mockOrderDao.findById(idValue)).thenReturn(orderFixture);
	
2)During execution the mocks go into a method that responds to request made by the Method-Under-Test. The mocks will react to specific set of parameters to control the behavior of interfaction and any result returned.<br>
3)During verification the framework provides capabilities to ensure mocks will be interacted in the manner test is intended. The most core operations centered around the mockito class and set of static methods it provides.

	Mockito.verify(mockOrderDao).findById(idValue)

Creating Mock instances
-----------------------
Creating mock objects using the static method mock is good, but when used repeatedly it creates more redundant code. There alternative appoaches available.<br>
1)First option is to create this as class level variable and initialize it in the setup method. For ex,

	class OrderServiceTest{
		
		private OrderDao mockOrderDao;
		
		@Before
		public void setup(){
			this.mockOrderDao = Mockito.mock(OrderDao.class);
		}
	}

2)Second option is to use @Mock annotation and calling initMocks method of MockitoAnnotations inside setup method. Consider the below code.

	class OrderServiceTest{
		
		@Mock
		private OrderDao mockOrderDao;
		
		@Before
		public void setup() {
			MockitoAnnotations.initMocks(this);
		}
	}

Note: In the above example using Mock annotation, when more mock objects are present then we see the real benifits of this method.

3)Third way is to write a mockito annotation intialization into a base class for the tests.

MockSettings
------------
Sometimes the mock instance needs to have more complex capabilities. Suppose we have a dependency that implement multiple interfaces. As we know the best practice is not code to the implementations, it does happen sometimes. The MockSettings interface provides added control for mock creation.<br>
Using extraInterfaces method will take variable no of interfaces which the resulting mock will implement.Consider the below code.

	MockSettings settings = Mockito.withSettings();
	OrderDao mockOrderDao = Mockito.mock(OrderDao.class, settings.extraInterfaces(OrderFilter.class));

Note: MockSettings.name() can be used to log name when any verification fails.

Stubbing method calls
---------------------
Method stubbing in mockito provides capabilities to define how method calls behave using when/then pattern. 

Using the Mockito class we specify a method invocation against the mock as the argument to the 'when' method call. This call returns an instance of OngoingStub<T>, specifying how the invocation behaves. OngoingStub is a generic type, the specific type of the instance is derived from the return type of the operation being called on the method. For ex,

	Mockito.when(mockOrderDao.findById(idValue)).thenReturn(orderFixture);

In the above statement the OngoingStub type is the type of orderFixture. We use the instance of OngoingStub to specify what return upon invocation of the operation. OngoingStub supports the following operations.

1)thenReturn(...) --> used to return an object or value based on the return type of the operation being stubbed. Lets consider the below example where OrderController invokes OrderService.
	
	class OrderController {
		public List<OrderSummary> getCustomerOrderSummary(long custid){
			...
		}
	}
	
	interface OrderService{
		List<OrderSummary> getOrderSummary(long custid){
			....
		}
	}
	
Let's see the test method of OrderControllerTest.

	@Test
	public void test_getCustomerOrderSummary_success(){
		List<OrderSummary> orderSummaryFixtureList = ...;
		
		OngoingStub<List<Summary>> invocationStub = Mockito.when(mockOrderService.getOrderSummary(customerid));
		invocationStub.thenReturn(orderSummaryFixtureList);
	}
	
2)thenThrow(...) --> We often face the scenarios where exceptions occurs in the code and need to deal with testing this to ensure code behaves as expected. When using non-automated approach this is very difficult to test. thenThrow() specifies mock invocation should result in exception thrown.<br>
This operation expects an instance of exception as a parameter and stores it to be thrown later during the execution. Consider the below example.

	Mockito.when(mockOrderDao.findById(idValue)).thenThrow(new OrderServiceException("Test error reason"));

Note: When stubbing the call the api is not intelligent enough to know what type of exception the operation supports. Thus, when tried to attempt an exception that is not supported by throws statement of the operation then a RuntimeException occurs during test execution.

Void methods
------------
The OngoingStub instances retrieve from when method invocation allow us to specify whether to return a value or throw an exception. Methods returning void change this. For normal circumstances we don't need to stub calls to void methods invocation as there is nothing to happen conditionally because there is no response to impact behavior. But, sometimes void methods may throw exception. Mockito provides an alternative for this stubbing. Mockito provides the static method doThrow(...) which returns an instance of "Stubber" rather than OngoingStub. Using Stubber call the method when to declare the mock method triggering the exception to throw. It reverses the order of when/then focusing on the declaration of outcome first. Consider the below code.

	Stubber stubber = Mockito.doThrow(new OrderServiceException("Test error reason"));
	stubber.when(mockOrderService.processOrder(orderFixture));

Note: The above code is more often writtern in single line through method chaining like below.
	
	Mockito.doThrow(new OrderServiceException("Test error reason")).when(mockOrderService.processOrder(orderFixture));
	
3)thenCallRealMethod(...) --> when mocking a class, delegate calls to the Class-Under-Test with thenCallRealMethod(..). There are some mocking scenarios that require lot of setup, this will be useful. Consider the below syntax.

	Mockito.when(mockOrderService.getCustomerOrderSummary()).thenCallRealMethod();

4)thenAnswer(...) --> With answering we don't specify thenReturn or thenThrow, instead we specify thenAnswer implementing IAnswer interface to handle resulting responses for the mocked operation invocations. Inside this implementation, we evaluate parameters to control what is returned. This ties into a concept called argument matching. Argument matching is the mechanism that allows us to return different results across subsequent calls to the same mocked operation with different parameter values. These are advised to avoid, but occassionally they are very useful.

	Mockito.when(mockObject.targetMethod(Mockito.any(String.class))).thenAnswer(new Answer(){
		Object answer(InvocationOnMock invocation){
			...
		}
	});

Verifications
-------------
Mocktio.verify() is used for verification. This method returns a proxied object based on the type passed in allowing to declare operation to be invoked during the execution of the test. Consider the below example.

	//setup
	Mockito.when(mockOrderService.getCustomerOrderSummary()).thenReturn(orderList);
	//verification
	OrderService verificationProxy = Mockito.verify(mockOrderService);
	verificationProxy.getOrderSummary(customerid);

Note: The verification steps already written in a single line through method chaining like below.

	Mockito.verify(mockOrderService).getOrderSummary(customerid);

Note: Verification doesn't always have the corresponding stubbed methods, especially when the method being mocked returns void. We may want to verify if the method is being called, but has no need to stub it and return a value.

VerificationMode
----------------
VerificationMode is an object allows to specify the no of times we expect the mocked operation to be called. The following code verifies if Method-Under-Test is called 2 times.
	
	Mockito.verify(mockOrderService, VerificationSettings.times(2)).getOrderSummary(customerid);

Mockito supports various operations for returning the appropriate VerificationMode instance. Here are few.<br>
1)times(n) --> specifies the no of times the mock operation is called.<br>
2)atLeastOnce() --> declares that the method must be called at least once but may be called more times than that.<br>
3)atLeast(n) --> specifies the min no of times the mocked operation is called.<br>
4)atMost(n) -->  specifies the max no of times the mocked operation is called.<br>
5)never() --> It is the 0 verification setting. i.e. operation on the mock is never called during the execution of test. Typically used when testing alternative paths of the code.

Verifying no interaction globally
---------------------------------
This may go beyond the single operation declaring that the mock should not have any operations invoked. Like never() these are typically used to test the alternative paths of code. Consider the below code.

	Mockito.verify(...).zeroInterfactions();
	
There may be have been certain operations called on the mock but no others were expected in the alternative paths of the code. This is typically the result of an exception being thrown or during an if else condition that bypasses regular interaction. Consider the below code.

	Mockito.verify(...).noMoreInteractions();
	
