package Pom_Classes;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInfoPage {
	WebDriver driver;
	public OrganizationInfoPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath="//img[@title='Create Organization...']")
	private WebElement createorgplusbtn;
	public WebElement getCreateorgplusbtn() {
		return createorgplusbtn;
	}
    @FindBy(xpath="//input[@class='txtBox']")
	private WebElement searchbox;
	public WebElement getSearchbox() {
		return searchbox;
	}
	@FindBy(name="search_field")
	private WebElement OrganizationDD;
	public WebElement getOrganizationDD() {
		return OrganizationDD;
	}
	@FindBy(name="submit")
	private WebElement finalsearch;
	public WebElement getfinalsearch() {
		return finalsearch;
	}
	@FindBy(xpath="//select[@name='industry']")
	private WebElement industryDD;
	public WebElement getindustryDD() {
		return industryDD;
	}
	@FindBy(xpath="//select[@name='accounttype']")
	private WebElement TypeDD;
	public WebElement getTypeDD() {
		return TypeDD;
	}
	@FindBy(xpath="//select[@name='rating']")
	private WebElement ratingDD;
	public WebElement getRatingDD() {
		return ratingDD;
	}
	@FindBy(xpath="//table[@class='lvt small']//tr")
	private List<WebElement> allorgTableData;
	public List<WebElement> getAllorgTableData() {
		return allorgTableData;
	}
	@FindBy(xpath="//table[@class='lvt small']//tr/td[3]")
	private List<WebElement> thirdRowData;
	public List<WebElement> getThirdRowData() {
		return thirdRowData;
	}
	@FindBy(xpath="//table[@class='lvt small']//tr[\"+j+\"]/td[3]")
	private WebElement orgNameColumn;
	public WebElement getOrgNameColumn() {
		return orgNameColumn;
	}
	@FindBy(xpath="//table[@class='lvt small']//tr[\"+j+\"]/td[1]")
	private WebElement allCheckboxesOforg;
	public WebElement getAllCheckboxesOforg() {
		return allCheckboxesOforg;
	}
	@FindBy(xpath="//table[@class='lvt small']//tr[last()]")
	private WebElement lastRowOfOrgtable;
	public WebElement getLastRowOfOrgtable() {
		return lastRowOfOrgtable;
	}
	@FindBy(xpath="//table[@class='lvt small']//tr[last()]//td[last()]")
	private WebElement lastRowLastColumnOfOrgtable;
	public WebElement getlastRowLastColumnOfOrgtable() {
		return lastRowLastColumnOfOrgtable;
	}
}

	
	
	


