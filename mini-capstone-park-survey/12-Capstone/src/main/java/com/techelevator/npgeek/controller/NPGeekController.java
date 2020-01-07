package com.techelevator.npgeek.controller;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.techelevator.Park;
import com.techelevator.ParkDAO;
import com.techelevator.Survey;
import com.techelevator.SurveyDAO;
import com.techelevator.WeatherDAO;

@Controller
public class NPGeekController {
	
	@Autowired
	private ParkDAO parkDAO;
	
	@Autowired
	private WeatherDAO weatherDAO;
	
	@Autowired
	private SurveyDAO surveyDAO;

	@RequestMapping("/")
	public String displayHomePage(ModelMap modelMap) {
		modelMap.put("parks", parkDAO.getListOfAllParks());
		return "homePage";
	}
	
	@GetMapping("/Survey")
	public String displaySurveyPage(ModelMap modelMap) {
		if (modelMap.containsAttribute("formData") == false) {
			Survey empty = new Survey();
			modelMap.put("formData", empty);
		}
		Survey states = new Survey();
		modelMap.put("states", states.getSTATE_ARRAY());
		modelMap.put("parks", parkDAO.getListOfAllParks());
		return "Survey";
	}
	
	@GetMapping("/parkRanking")
	public String displayParkRankingPage(ModelMap modelMap) {
		modelMap.put("parks", surveyDAO.getListOfFavorites());
		return "parkRanking";
	}
	
	@RequestMapping("/parkRanking") //make post mapping
	public String dispalyParkRankingPage(@Valid @ModelAttribute Survey survey, BindingResult result, RedirectAttributes redirectAttributes) {
		List<Park> listOfValidParks = parkDAO.getListOfAllParks();
		System.out.println(survey.getParkCode());
		for (int i = 0; i < listOfValidParks.size(); i++) {
			System.out.println(listOfValidParks.get(i).getParkCode().equals(survey.getParkCode()));
			if (survey.getParkCode() == null || !listOfValidParks.get(i).getParkCode().equals(survey.getParkCode())) {
				redirectAttributes.addFlashAttribute("formData", survey);
				redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "formData", result);
				return "redirect:/Survey";
			}
		} //need to fix the above garbage, make array containing valid park codes only rather than objects, then compare?
		
		
		if (result.hasErrors()) {
			for (ObjectError error : result.getAllErrors()) {
				System.out.println(error.getDefaultMessage());
			}
			
			redirectAttributes.addFlashAttribute("formData", survey);
			redirectAttributes.addFlashAttribute(BindingResult.MODEL_KEY_PREFIX + "formData", result);
			return "redirect:/Survey";
		}
		
		surveyDAO.createNewSurvey(survey);
		return "redirect:/parkRanking";
	}
	
	@GetMapping("/parkDetail")
	public String displayParkDetail(ModelMap modelMap, @RequestParam String parkCode) {
		modelMap.put("selectedPark", parkDAO.getParkByCode(parkCode));
		modelMap.put("weather", weatherDAO.getWeatherForPark(parkCode));
		return "parkDetail";
	}
	
	@PostMapping("/parkDetail")
	public String switchTemp(ModelMap modelMap, @RequestParam int tempChoice, @RequestParam String parkCode, HttpSession session) {
		modelMap.put("selectedPark", parkDAO.getParkByCode(parkCode));
		modelMap.put("weather", weatherDAO.getWeatherForPark(parkCode));
		
		session.setAttribute("tempChoice", tempChoice);
		
		return "redirect:/parkDetail?parkCode=" + parkCode;
	}
}
