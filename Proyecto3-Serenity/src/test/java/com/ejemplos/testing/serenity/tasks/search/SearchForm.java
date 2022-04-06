package com.ejemplos.testing.serenity.tasks.search;

import net.serenitybdd.screenplay.targets.Target;

class SearchForm {
//Cuidado porque estoy definiendo un parametro que en este caso es para la Wikipedia solamente
	static Target SEARCH_FIELD = Target.the("search field").locatedBy("#searchInput");
	// aqui podrias definir otros elementos que usarias en la busqueda
	// O puedes separarlo.
	// Fijate que en este ejemplo tenemos la busqueda por un lado y lo del H1 por otro

	// en cucumber (sin screenplay) habria sido algo como
	// static By SEARCH_FIELD = By.cssSelector("#searchInput");

}
