package controllers;

import play.*;
import play.mvc.*;

import java.util.*;

import models.*;

//para trabajar con login
//public class Application extends GlobalController {
public class Application extends Controller {

	public static void index() {
		//inicializa();
		render();
	}

	public static void list(String search, Integer size, Integer page) {
		List<Usuario> docen = null;
		page = page != null ? page : 1;
		if (search.trim().length() == 0) {
			docen = Usuario.all().fetch(page, size);
		} else {
			search = search.toLowerCase();
			docen = Usuario.find(
					"lower(nombre) like ?1 OR lower(cedula) like ?2 ",
					"%" + search + "%", "%" + search + "%").fetch(page, size);
		}
		render(docen, search, size, page);
		System.out.println("Si se llama a la funcion");
	}

	public void inicializa() {
		UsuarioProfesor usuario1 = new UsuarioProfesor();
		usuario1.cedula = "0502594428";
		usuario1.email = "alexcevallos08asd";
		usuario1.esInactivo = false;
		usuario1.email = "alexcevallos08asd";
		// Calendar test=
		// usuario1.fecIng=23122014;
		usuario1.nombre = "santo";
		usuario1.password = "cedsdf";
		usuario1.userName = "aceva";
		usuario1.save();
	}

}