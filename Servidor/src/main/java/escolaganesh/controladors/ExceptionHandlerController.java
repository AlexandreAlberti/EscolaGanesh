package escolaganesh.controladors;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler({ Exception.class, RuntimeException.class })
	public ModelAndView handleError(HttpServletRequest req, Exception ex) {
		System.out.println(req.getRequestURL());
		ModelAndView mav = new ModelAndView();
		mav.addObject("message", "Sorry, we couldn't find what you are looking for." + ex.getMessage());
		mav.addObject("path", req.getRequestURL());
		mav.addObject("timestamp", SimpleDateFormat.getInstance().format(new Date()));
		mav.setViewName("error");
		return mav;
	}
}