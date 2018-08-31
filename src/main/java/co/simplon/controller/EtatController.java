package co.simplon.controller;

import java.util.List;

import javax.inject.Inject;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import co.simplon.model.Etat;
import co.simplon.service.EtatServiceImpl;

@Controller
@RequestMapping("/suivietat")
@CrossOrigin(origins = {"http://localhost:4200"})
public class EtatController {

	@Inject
	EtatServiceImpl etatServiceImpl;
	
	@RequestMapping(method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.CREATED)
	@ResponseBody
	public List<Etat> listEtat() {
		List<Etat> list = etatServiceImpl.findAllEtat();
		return  list;
	};
	
}
