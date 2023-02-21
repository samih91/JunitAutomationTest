package test;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import pages.JUnitExamPage;
import util.BrowserFactory;

public class JUnitExamTest {

	WebDriver driver;

	@Test
	public void toggleAllCheckboxTest() throws Exception {

		driver = BrowserFactory.init();
		JUnitExamPage page = PageFactory.initElements(driver, JUnitExamPage.class);
		
		System.out.println("toggleAllCheckboxTest : Started");
		
		// first we confirm that at least one check box exist so we can perform our test
		// to check if the check boxes gets selected when we select toggle all check box
		if (page.verifyThatCheckBoxesExist()) {
			page.clickOnToggleAllCheckBox();
			page.checkBoxVerification();
		} 
		// we get to this step if no check box exists in our page, then we create 3
		// check boxes to test on it
		else {
			System.out.println(
					"since no checkbox exists in the page we are creating 3 check boxes to perform ToggleAllCheckboxTest");
			page.add3CheckBoxes();
			page.clickOnToggleAllCheckBox();
			page.checkBoxVerification();
		}
		BrowserFactory.teardown();
	}

	@Test 
	public void removeCheckBoxTest() throws Exception {

		
		driver = BrowserFactory.init();
		JUnitExamPage page = PageFactory.initElements(driver, JUnitExamPage.class);
		
		System.out.println("removeCheckBoxTest : Started");
		// first we confirm that at least one check box exist so we can perform our test
		// to remove it and see if it gets removed or not

		if (page.verifyThatCheckBoxesExist()) {
			int checkBoxIndex = 0; // we can change the index of the check box that we want to remove by changing
									// this variable.
			page.SelectCheckBox(checkBoxIndex);
			page.clickOnRemoveButton();
			page.verifyThatCheckBoxIsRemoved(checkBoxIndex);
		}
		// we get to this step if no check box exists in our page, then we create 3
		// check boxes to test on it
		else {

			System.out.println(
					"since no checkbox exists in the page we are creating 3 check boxes to perform removeCheckBoxTest");
			page.add3CheckBoxes();
			page.SelectCheckBox(0); // 0 is checkBoxIndex, since we create 3 new check boxes our index should be
									// less than 3
			page.clickOnRemoveButton();
			page.verifyThatCheckBoxIsRemoved(0);

		}
		BrowserFactory.teardown();
	}

	@Test
	public void toggleAllAndDeleteTest() throws Exception {
		
		driver = BrowserFactory.init();
		JUnitExamPage page = PageFactory.initElements(driver, JUnitExamPage.class);
		
			System.out.println("toggleAllAndDeleteTest : Started");
		// first we confirm that at least one check box exist so we can perform our test
		// to remove it and see if it gets removed or not

		if (page.verifyThatCheckBoxesExist()) {
			page.clickOnToggleAllCheckBox();
			page.checkBoxVerification();
			page.clickOnRemoveButton();
			page.verifyNoCheckboxExist();
		} else
		// we get to this step if no check box exists in our page, then we create 3
		// check boxes to test on it
		{
			System.out.println("since no checkbox exists in the page we are creating 3 check boxes to perform ToggleAllCheckboxTest");				
			page.add3CheckBoxes();
			page.clickOnToggleAllCheckBox();
			page.checkBoxVerification();
			page.clickOnRemoveButton();
			page.verifyNoCheckboxExist();
		}

		BrowserFactory.teardown();

	}

}
