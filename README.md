# tdd

TDD(Test driven development) is a development approach keeping tests one step ahead of the code to help drive the design of your system.
The idea of this approach is you are designing and developing your code in conjunction with test in order to achieve more structured and modular design which supports automated testing upfront. Thus TDD is also referred to as test driven design.

TDD gives reliability so that we won't have significant issues introduced in the subsequent releases of your project. It doesn't completely remove risk but it goes a long way to reduce it.

Problems with traditional approach
----------------------------------
In the earlier days of automated unit testing developers often write their functional code and then figure out how to write the unit tests to validate the assumptions made in how the code should function. For ex, in a typical web application a developer used to write a functional flow which spans multiple layers like controller, service and dao and then try to figure out how to write unit tests. Here are the few problems with this approach.

1)The complete omission of thought in regrads to how the testing would be performed --> Developer often forget to identify the complexity of their method because of this. A method should do only one thing. If it gets complex it has to be broken down. If developer identify this too late and has the intention to break it down, he may run out of time. Over long streches it may become inefficient to try to simplify code later as there may be more people touching the code to enhance the system, the complexity grows.

2)Benefits of automation missed --> With automation developers are able to add and revise the code with certainity that they do not unintentionally break functionality or change assumptions previously held when creating the code. The further you defer automation, the more likely that changes made in future development unintentionally break something.

3)Time crunch encountered in projects --> The more an application is tested upfront the greate gauge a developer have on how much effort is remaining to complete the project. Thus, when you save the tests until the end developers encounter few scenarios like this.
	a) Developer may run out of time to automate any tests. The code is functional, the dead line has approached and it becomes difficult to justify additional time as the stakeholders view everything as functional within the system.
	b)Developer may have underestimate the true effort of testing and it has become more complicated because developer did not design the system with this in mind.

4)Mountain of work to implement the automated unit test --> Saving all the testing to the end leads to the feeling of a daunting effort once developer starts testing. Developer typically tries to figure out how to work around more complexity and become frustrated with the lack of structure he encounters because of the thinking how the test can be broken down and work in conjunction with the design of the code.

Benefits of TDD
---------------
1)TDD brings in more balance because developers don't do too much of coding or testing in disproportionate manner.
2)Consistent repeatability of test execution. Once test is written it can be repeatedly executed without any effort.
3)Upfront design with testing in mind. It makes developer identify the code smell(something in the code which indicates a potential issue) early.

Red/Green/Refactor
------------------
A command pattern used in TDD is called Red/Green/Refactor. Here are the steps
1)Write a statement(or statements) resulting in a failing test. 
2)Implement the functionality, this should result in a success test, fixing all the issues found in step 1.
3)Refactor the code as needed to simplify the design. 

Note: If developer refactors the code, the test should still pass. Depending on the complexity of the code, developer may need to refactor the test as well. If no refactor remains, continue on with the test method repeating this pattern until all aspects of the method functionality are complete.

Terminology
-----------
Here are some of the general terms used in TDD.
1)xUnit Testing --> This is a generic reference to automated unit testing using a unit test framework. JUnit is an implementation of a xUnit Testing framework being adapted from earlier versions of small talk unit testing framework.
2)Class-Under-Test --> An automated unit test should focus on testing functionality of the methods in a single class. It is advisable to have one or more test classes for a single functional class. The class being tested in this case, is referred to as Class-Under-Test.
3)Method-Under-Test --> This is the target method that a single JUnit test method will be executing to verify the functionality and validate assumptions made during development of the functional code. Developer should strive to test no more than one Method-Under-Test with in a single JUnit test method.
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
Mockito --> This will help in mocking and stubbing of dependent interfaces and objects help in implementing mock patterns in test code.
DBUnit --> This framework covers sql based database data fixture setup and tear down and validation of data manipulations occuring as a result of the Method-Under-Test being executed.
PowerMockito --> This framework contains extended mocking capabilities not supporting directly in mockito like testing private , static methods etc.

JUnit testing concepts
----------------------
JUnit is a framework for java developers to write automated unit tests. Developers write unit tests with the purpose of executing functionality within the corresponding class. A good unit test follows four steps.
1)setup --> Establishment of data in fixtures needed to execute the test.
2)execution
3)verification
4)teardown

