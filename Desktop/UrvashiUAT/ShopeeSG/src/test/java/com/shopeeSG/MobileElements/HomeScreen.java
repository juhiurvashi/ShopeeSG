package com.shopeeSG.MobileElements;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;

public class HomeScreen {
public static AppiumDriver<WebElement> driver;
public HomeScreen()
{
	
}
public HomeScreen(AppiumDriver<WebElement> driver)
{
	this.driver=driver;
}
@AndroidFindBy(xpath="//*[@resource-id='com.shopee.sg:id/btn']")
public MobileElement startBtn;
public void clickOnStart()
{
	WebElement startBtn=driver.findElement(By.id("com.shopee.sg:id/btn"));
	startBtn.click();
}

public void clickOnCloseAd()
{
	driver.findElement(By.xpath("//android.view.ViewGroup[5]//android.widget.ImageView")).click();
}

public void clickOnShopeeMall()
{
	WebElement shopeemall=driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.shopee.sg:id/sp_bottom_navigation_layout']//android.widget.FrameLayout[3]//android.widget.ImageView[@resource-id='com.shopee.sg:id/icon']"));
	shopeemall.click();
}
public void clickOnMobile()
{
	WebElement list=driver.findElement(By.xpath("//android.widget.FrameLayout//android.widget.FrameLayout//android.widget.LinearLayout//android.widget.FrameLayout//android.widget.RelativeLayout//android.widget.LinearLayout[1]//androidx.viewpager.widget.ViewPager//android.widget.LinearLayout//android.widget.FrameLayout//android.widget.FrameLayout//android.view.ViewGroup[4]//android.view.ViewGroup[2]//android.view.ViewGroup[2]//android.view.ViewGroup[2]//android.view.ViewGroup//android.widget.ScrollView//android.view.ViewGroup//android.view.ViewGroup[1]//android.view.ViewGroup[3]//android.widget.TextView"));
	list.click();
}
public void clickOnArrow()
{
	WebElement list=driver.findElement(By.xpath("//android.widget.LinearLayout[@resource-id='com.shopee.sg:id/sp_home_tab_view']//android.view.ViewGroup[1]//android.view.ViewGroup[3]//android.widget.TextView"));
	list.click();
}
public void clickOnSeeAll()
{
	WebElement list=driver.findElement(By.xpath("//android.widget.LinearLayout[1]//androidx.viewpager.widget.ViewPager//android.widget.LinearLayout//android.widget.FrameLayout//android.widget.FrameLayout//android.view.ViewGroup[4]//android.view.ViewGroup[1]//androidx.viewpager.widget.ViewPager//android.view.ViewGroup//android.view.ViewGroup//androidx.recyclerview.widget.RecyclerView//android.view.ViewGroup[1]//android.view.ViewGroup//android.view.ViewGroup//android.view.ViewGroup//android.view.ViewGroup"));
	list.click();
}

}
