package utilities;

import org.testng.annotations.DataProvider;

public class DataProvidor {
	@DataProvider(name = "TestData") 
	public Object[][] tData(){
	
		return new Object[][] {
			{"Vodafone"}, 
			{"Vudafoone"}, 
			{"Vodafone Stores"}, 			
			{"Vodafone Images"}, 
			{" vodafone logo"}, //Page 2 and 3 usually differ in number of links
		};
	}
}
