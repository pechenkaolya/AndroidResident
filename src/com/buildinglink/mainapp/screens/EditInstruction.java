package com.buildinglink.mainapp.screens;

import com.buildinglink.mainapp.common.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import org.openqa.selenium.By;

public class EditInstruction extends NewInstruction {
    public EditInstruction(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    @AndroidFindBy (id= ":id/type")
    private AndroidElement instructionType;

   // private By instructionType = By.id((Server.setEndpoint()+":id/type"));

    private NewInstruction newInstruction = new NewInstruction(driver);

    public void tapInstructionTypeField(){
        instructionType.click();
    }

    @Override
    public EditInstruction typeInstructions(String instructions)
    {
        driver.findElement(instructionsField).clear();
        super.typeInstructions(instructions);
        return this;
    }


}
