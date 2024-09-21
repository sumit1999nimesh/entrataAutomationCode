package DataProvider;

import org.testng.annotations.DataProvider;

public class DataProviderforAllTests {

	 @DataProvider(name="loginDataForPropertyManager")
		public Object[][] loginDataForPropertyManager(){
			return new Object[][]{
				{"sumit","password1"},
			};
		}
	 
	 @DataProvider(name="DataforDemoform")
		public Object[][] DataforDemoform(){
			return new Object[][]{
				{"sumit","nimesh","kumar@gmail.com","LTI","1111222233","11 - 100","SDE","an Owner/Operator or Property Manager"},
			};
		}
	 
	 @DataProvider(name="DataforSubProducts")
		public Object[][] DataforSubProducts(){
			return new Object[][]{
				{"Deposit Alternative"},
			};
		}


	 @DataProvider(name="DataforSubSolutions")
		public Object[][] DataforSubSolutions(){
			return new Object[][]{
				{"Student"},
			};
		}
}
