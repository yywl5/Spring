package Controllers.potatob6.Errors;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class GlobalExceptionPage implements HandlerExceptionResolver {
    @Override
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        request.setAttribute("code", response.getStatus());
        ModelAndView modelAndView = new ModelAndView("potatob6/Errors/error");
        request.setAttribute("message", ex.getMessage());
        return modelAndView;
    }
}
