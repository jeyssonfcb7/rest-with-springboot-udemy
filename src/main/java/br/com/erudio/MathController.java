package br.com.erudio;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.erudio.exception.UnsuportedMathOperationException;

@RestController
public class MathController {
	
	
	@RequestMapping(value="/sum/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sum(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double sum = convertToDouble(numberOne) + convertToDouble(numberTwo);
		return sum;
		
	}
	
	@RequestMapping(value="/sub/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double sub(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double sub = convertToDouble(numberOne) - convertToDouble(numberTwo);
		return sub;
		
	}
	
	@RequestMapping(value="/mul/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double mul(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double mul = convertToDouble(numberOne) * convertToDouble(numberTwo);
		return mul;
		
	}
	
	@RequestMapping(value="/div/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double div(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		Double div;	
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		if (convertToDouble(numberTwo) == 0){
			throw new UnsuportedMathOperationException("you cannot divide a number by zero");
		}
			else {
			div = convertToDouble(numberOne) / convertToDouble(numberTwo);
			}
		
		
		return div;
		
	}
	
	@RequestMapping(value="/avg/{numberOne}/{numberTwo}", method=RequestMethod.GET)
	public Double avg(@PathVariable("numberOne") String numberOne, @PathVariable("numberTwo") String numberTwo) throws Exception {
		if(!isNumeric(numberOne) || !isNumeric(numberTwo)) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double avg = convertToDouble(numberOne) + convertToDouble(numberTwo);
		
		return avg/2;
	}
	
	@RequestMapping(value="/sqrt/{numberOne}", method=RequestMethod.GET)
	public Double sqrt(@PathVariable("numberOne") String numberOne) throws Exception {
		if(!isNumeric(numberOne) ) {
			throw new UnsuportedMathOperationException("Please set a numeric value");
		}
		Double sqrt =  Math.sqrt(convertToDouble(numberOne));
		
		return sqrt;
	}
	
	
	private Double convertToDouble(String strNumber) {
		if(strNumber == null) return 0D;
		String number = strNumber.replace(",",".");
		if(isNumeric(number)) return Double.parseDouble(number);
		return 0D;
	}

	private boolean isNumeric(String strNumber) {
		if(strNumber == null) return false;
		String number = strNumber.replace(",",".");	
		return number.matches("[-+]?[0-9]*\\.?[0-9]+");
	}
}

