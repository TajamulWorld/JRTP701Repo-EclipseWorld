package com.nt.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/ssa-web-api")
public class SSAWebApiRestControllerOperations {
	
	@GetMapping("/find/{ssn}")
	public ResponseEntity<?> getStateBySsn (@PathVariable long ssn) {
		if(String.valueOf(ssn).length()!=9) {
			return new ResponseEntity<String>("invalid ssn", HttpStatus.BAD_REQUEST);
		}
		int stateCode = (int) ssn%100;
		String stateName = switch (String.format("%02d", stateCode)) {
	    case "01" -> "Alabama";
	    case "02" -> "Alaska";
	    case "04" -> "Arizona";
	    case "05" -> "Arkansas";
	    case "06" -> "California";
	    case "08" -> "Colorado";
	    case "09" -> "Connecticut";
	    case "10" -> "Delaware";
	    case "11" -> "District of Columbia";
	    case "12" -> "Florida";
	    case "13" -> "Georgia";
	    case "15" -> "Hawaii";
	    case "16" -> "Idaho";
	    case "17" -> "Illinois";
	    case "18" -> "Indiana";
	    case "19" -> "Iowa";
	    case "20" -> "Kansas";
	    case "21" -> "Kentucky";
	    case "22" -> "Louisiana";
	    case "23" -> "Maine";
	    case "24" -> "Maryland";
	    case "25" -> "Massachusetts";
	    case "26" -> "Michigan";
	    case "27" -> "Minnesota";
	    case "28" -> "Mississippi";
	    case "29" -> "Missouri";
	    case "30" -> "Montana";
	    case "31" -> "Nebraska";
	    case "32" -> "Nevada";
	    case "33" -> "New Hampshire";
	    case "34" -> "New Jersey";
	    case "35" -> "New Mexico";
	    case "36" -> "New York";
	    case "37" -> "North Carolina";
	    case "38" -> "North Dakota";
	    case "39" -> "Ohio";
	    case "40" -> "Oklahoma";
	    case "41" -> "Oregon";
	    case "42" -> "Pennsylvania";
	    case "44" -> "Rhode Island";
	    case "45" -> "South Carolina";
	    case "46" -> "South Dakota";
	    case "47" -> "Tennessee";
	    case "48" -> "Texas";
	    case "49" -> "Utah";
	    case "50" -> "Vermont";
	    case "51" -> "Virginia";
	    case "53" -> "Washington";
	    case "54" -> "West Virginia";
	    case "55" -> "Wisconsin";
	    case "56" -> "Wyoming";
	    default -> "Invalid ssn";
	};
	
	return new ResponseEntity<String>("My state name is :: "+stateName, HttpStatus.OK);
	
	}

}
