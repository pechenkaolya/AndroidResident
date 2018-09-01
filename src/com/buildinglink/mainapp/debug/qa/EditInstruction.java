package com.buildinglink.mainapp.debug.qa;

import com.buildinglink.mainapp.common.Server;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import org.openqa.selenium.By;

public class EditInstruction extends NewInstruction {
    public EditInstruction(AppiumDriver<MobileElement> driver) {
        this.driver = driver;
    }

    private By instructionType = By.id((Server.setUpEndpoint()+":id/type"));

    private NewInstruction newInstruction = new NewInstruction(driver);

    public void tapInstructionTypeField(){
        driver.findElement(instructionType).click();
    }

    @Override
    public EditInstruction typeInstructions(String instructions)
    {
        driver.findElement(instructionsField).clear();
        super.typeInstructions(instructions);
        return this;
    }


}
