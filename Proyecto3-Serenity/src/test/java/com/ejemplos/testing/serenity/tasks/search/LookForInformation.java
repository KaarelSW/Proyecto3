package com.ejemplos.testing.serenity.tasks.search;

import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
//import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import org.openqa.selenium.Keys;

public class LookForInformation {
    public static Performable about(String searchTerm) {
        return Task.where("{0} searches for '" + searchTerm + "'",
                Enter.theValue(searchTerm)
                        .into(SearchForm.SEARCH_FIELD)
                        .thenHit(Keys.ENTER)
        );
        //Si hubiera habido un boton seria
        //   Enter.theValue(searchTerm).into(SearchForm.SEARCH_FIELD),
        //   Click.on(SeachForm.SEARCH_BUTTON)
    }
}
