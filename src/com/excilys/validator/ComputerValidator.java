package com.excilys.validator;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.joda.time.DateTime;

import com.excilys.dto.ComputerDTO;

public class ComputerValidator {



	public ComputerValidator(ComputerDTO cdto) {
		// TODO Auto-generated constructor stub

	}

	/**
	 * Valide les champs d'un Computer:
	 * champ 1 => name
	 * champ 2 => introducedDate
	 * champ 3 => discontinuedDate
	 * champ 4 => idCompany
	 * Code d'erreur:
	 * 1 => Champ vide
	 * 2 => Valeur erroné
	 * 3 => Date doit être supérieur
	 * @return
	 */
	public static HashMap<Integer, Integer> validate(ComputerDTO cdto){
		HashMap<Integer, Integer> errorMap = new HashMap<>();

		//Pattern checkDate = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)");
		Pattern checkDate = Pattern.compile("[0-9]{4}-[0-1][0-9]-[0-3][0-9]");

		// Validation du nom de Computer
		if((cdto.getName().equals(""))||(cdto.getName()==null))
			errorMap.put(1, 1);

		// Validation du format des dates
		Matcher m = checkDate.matcher(cdto.getIntroducedDate());
		if((!m.matches())||(!checkDay(cdto.getIntroducedDate()))){
			errorMap.put(2, 2);
		}
		else{
			// On verifie le format de la date
			m = checkDate.matcher(cdto.getDiscontinuedDate());
			if((!m.matches())||(!checkDay(cdto.getDiscontinuedDate()))){
				errorMap.put(3, 2);
			}else{
				// On verifie quel est supérieur à l'autre date
				DateTime intro = new DateTime(cdto.getIntroducedDate());
				DateTime disc = new DateTime(cdto.getDiscontinuedDate());
				if(intro.isAfter(disc)){
					errorMap.put(3, 3);
				}
			}

		}

		// Verification sur idCompany
		if(Integer.parseInt(cdto.getIdCompany())<0)
			errorMap.put(4, 2);		

		return errorMap;
	}
	
	/**
	 * Valide les champs d'un Computer:
	 * champ 1 => name
	 * champ 2 => introducedDate
	 * champ 3 => discontinuedDate
	 * champ 4 => idCompany
	 * Code d'erreur:
	 * 1 => Champ vide
	 * 2 => Valeur erroné
	 * 3 => Date doit être supérieur
	 * @return
	 */
	public static HashMap<String, Integer> validateField(ComputerDTO cdto){
		HashMap<String, Integer> errorMap = new HashMap<>();

		//Pattern checkDate = Pattern.compile("(0?[1-9]|[12][0-9]|3[01])-(0?[1-9]|1[012])-((19|20)\\d\\d)");
		Pattern checkDate = Pattern.compile("[0-9]{4}-[0-1][0-9]-[0-3][0-9]");

		// Validation du nom de Computer
		if((cdto.getName().equals(""))||(cdto.getName()==null))
			errorMap.put("name", 1);

		// Validation du format des dates
		Matcher m = checkDate.matcher(cdto.getIntroducedDate());
		if((!m.matches())||(!checkDay(cdto.getIntroducedDate()))){
			errorMap.put("introducedDate", 2);
		}
		else{
			// On verifie le format de la date
			m = checkDate.matcher(cdto.getDiscontinuedDate());
			if((!m.matches())||(!checkDay(cdto.getDiscontinuedDate()))){
				errorMap.put("discontinuedDate", 2);
			}else{
				// On verifie quel est supérieur à l'autre date
				DateTime intro = new DateTime(cdto.getIntroducedDate());
				DateTime disc = new DateTime(cdto.getDiscontinuedDate());
				if(intro.isAfter(disc)){
					errorMap.put("discontinuedDate", 3);
				}
			}

		}

		// Verification sur idCompany
		if(Integer.parseInt(cdto.getIdCompany())<0)
			errorMap.put("company", 2);		

		return errorMap;
	}
	
	/**
	 * Verifie qu'un chaine est un nombre positif
	 * @param sNumber
	 * @return
	 */
	public static boolean isPositifNumber(String sNumber){
		Pattern checkNumber = Pattern.compile("^[0-9]*$");
		Matcher m = checkNumber.matcher(sNumber);
		return m.matches();
	}

	/**
	 * Validate date format with regular expression
	 * @param date date address for validation
	 * @return true valid date fromat, false invalid date format
	 */
	public static boolean checkDay(final String date){


		String day = date.split("-")[2].trim();
		String month = date.split("-")[1].trim();
		int year = Integer.parseInt(date.split("-")[0].trim());

		if (day.equals("31") && 
				(month.equals("4") || month .equals("6") || month.equals("9") ||
						month.equals("11") || month.equals("04") || month .equals("06") ||
						month.equals("09"))) {
			return false; // only 1,3,5,7,8,10,12 has 31 days
		} else if (month.equals("2") || month.equals("02")) {
			// année bissextile
			if(year % 4==0){
				if(day.equals("30") || day.equals("31")){
					return false;
				}else{
					return true;
				}
			}else{
				if(day.equals("29")||day.equals("30")||day.equals("31")){
					return false;
				}else{
					return true;
				}
			}
		}else{				 
			return true;				 
		}	    
	}

}
