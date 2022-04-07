package com.ejemplos.testing.serenity.tasks.footer;

import java.util.List;

import org.openqa.selenium.By;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.targets.Target;

public class Footer {

	public static Target FOOTER_ITEM = Target.the("footer").locatedBy("//footer");
    public static Target LINK_PRIVACIDAD =   Target.the("link de privacidad").located(By.linkText("Privacidad")).inside(FOOTER_ITEM);
    public static Target LINK_TERMINOS   =   Target.the("link de terminos").located(By.linkText("Terminos")).inside(FOOTER_ITEM);
    public static Target LINK_CONTACTO   =   Target.the("link de contacto").located(By.linkText("Contacto")).inside(FOOTER_ITEM);

    public static Target LINK_PRIVACIDAD2 =   Target.the("link de privacidad").located(By.linkText("Privacy")).inside(FOOTER_ITEM);
    public static Target LINK_TERMINOS2   =   Target.the("link de terminos").located(By.linkText("Terms")).inside(FOOTER_ITEM);
    public static Target LINK_CONTACTO2   =   Target.the("link de contacto").located(By.linkText("Contact")).inside(FOOTER_ITEM);


}