package pages;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class JUnitExamPage {

	WebDriver driver;

	public JUnitExamPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.CSS, using = "input[name='allbox']")
	WebElement TOGGLE_ALL_CHECKBOX;

	@FindBy(how = How.CSS, using = "input[name='todo[0]']")
	WebElement TOGGLE_FIRST_CHECKBOX;

	@FindBy(how = How.CSS, using = "input[value='Remove']")
	WebElement REMOVE_BUTTON;

	@FindBy(how = How.CSS, using = "input[name='data']")
	WebElement ADD_CHECKBOX_INPUT_FIELD;

	@FindBy(how = How.CSS, using = "input[value='Add']")
	WebElement ADD_CHECKBOX_BUTTON;

	public void clickOnToggleAllCheckBox() {

		TOGGLE_ALL_CHECKBOX.click();
	}

	public ArrayList<WebElement> CheckBoxArrayListOfElements() {

		ArrayList<WebElement> checkBoxELementsArrayList = new ArrayList<WebElement>();
		
		// the purpose of this method is returning an Array list that contains all the elements 
		// of the check boxes found on our page 
		
		
		// our CSS selector of type='checkbox'  gives us the size of the check boxes list including toggle all check box
		// we have two variables i and j because the id of the check box doesn't change ,if we create 100 check boxes
		// then we delete the first 99 the id of the 100th will stay 100 even if it stays alone 
		

		int j = 0; // we get out of the loop when variable reach the size of the check box -1 because toggle all is included 
		int i = 0; // variable i keeps incrementing to cover all the id's of the check boxes
		


			while (j != driver.findElements(By.cssSelector("input[type='checkbox']")).size()-1) {
				
				String css = "input[name='todo[" + i + "]']";
				if (driver.findElements(By.cssSelector(css)).size() != 0) {
					checkBoxELementsArrayList.add(driver.findElement(By.cssSelector(css)));
					j++;
				}
				css = "input[name='todo[" + i + "]']";
				i++;
			}
//		}
		return checkBoxELementsArrayList;
	}

	public void checkBoxVerification() {

		ArrayList<WebElement> checkBoxELementsArrayList = new ArrayList<WebElement>();
		checkBoxELementsArrayList = CheckBoxArrayListOfElements();

		System.out.println("The number of check boxes is : " + checkBoxELementsArrayList.size());
		int count = 0;

		for (int j = 0; j < checkBoxELementsArrayList.size(); j++) {
			if (checkBoxELementsArrayList.get(j).isSelected()) {
				System.out.println("Checkbox" + j + "is selected");
				count++;
			} else {
				System.out.println("Checkbox" + j + "is not selected");
			}
		}
		if (checkBoxELementsArrayList.size() == count) {
			System.out.println("All check boxes are selected");
		} else {
			System.out.println("Some check boxes are NOT selected");
		}
	}

	public void clickOnRemoveButton() {
		REMOVE_BUTTON.click();
	}

	public void SelectCheckBox(int checkBoxIndex) {
		ArrayList<WebElement> checkBoxELementsArrayList = new ArrayList<WebElement>();
		checkBoxELementsArrayList = CheckBoxArrayListOfElements();

		if (checkBoxIndex < checkBoxELementsArrayList.size()) {

			checkBoxELementsArrayList.get(checkBoxIndex).click();

			if (checkBoxELementsArrayList.get(checkBoxIndex).isSelected()) {
				System.out.println("The check box " + checkBoxIndex + " is selected ");
			}
		} else {
			System.out.println("no check box in the index provided");
		}
	}

	public void verifyThatCheckBoxIsRemoved(int checkBoxIndex) {

		ArrayList<WebElement> checkBoxELementsArrayList = new ArrayList<WebElement>();
		checkBoxELementsArrayList = CheckBoxArrayListOfElements();

		if (checkBoxELementsArrayList.size() > checkBoxIndex || checkBoxELementsArrayList.size() == 0) {

			System.out.println("the check box  " + checkBoxIndex + " has been succesfully removed ");
		} else {

			System.out.println(" check box not found ");
		}

	}

	public boolean verifyThatCheckBoxesExist() {

		ArrayList<WebElement> checkBoxELementsArrayList = new ArrayList<WebElement>();
		checkBoxELementsArrayList = CheckBoxArrayListOfElements();

		if (checkBoxELementsArrayList.size() == 0) {
			return false;
		} else
			return true;
	}

	public void add3CheckBoxes() throws Exception {

		for (int i = 0; i < 3; i++) {
			ADD_CHECKBOX_INPUT_FIELD.sendKeys("Test" + i);
			ADD_CHECKBOX_BUTTON.click();
			Thread.sleep(500);
		}
	}

	public void verifyNoCheckboxExist() {
		ArrayList<WebElement> checkBoxELementsArrayList = new ArrayList<WebElement>();
		checkBoxELementsArrayList = CheckBoxArrayListOfElements();
		if (checkBoxELementsArrayList.size() == 0) {
			System.out.println("No check box Exists,All the checkboxes has been removed");
		} else {
			System.out.println("one or more check boxes still exists on the page");
		}
	}

}
