package com.ejemplos.testing.serenity.tasks.search;

import net.serenitybdd.core.pages.WebElementFacade;
import net.serenitybdd.screenplay.targets.Target;

class SearchForm {
//Cuidado porque estoy definiendo un parametro que en este caso es para la Wikipedia solamente
	static Target SEARCH_FIELD = Target.the("search field").locatedBy("#searchInput");


}
