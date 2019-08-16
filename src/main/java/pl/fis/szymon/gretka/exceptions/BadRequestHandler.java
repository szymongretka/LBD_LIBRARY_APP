package pl.fis.szymon.gretka.exceptions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Provider 
public class BadRequestHandler implements ExceptionMapper<ConstraintViolationException> {
	
	@Override
	public Response toResponse(final ConstraintViolationException exception) {
		
		return Response.status(Status.NOT_FOUND)
				.entity(new ExceptionClass(Response.Status.BAD_REQUEST, prepareErrorList(exception)))
				.type(MediaType.APPLICATION_JSON).build(); 
	}
	
	private List<String> prepareErrorList(ConstraintViolationException exception) {
		
		List<String> errorList = new ArrayList<>();
        for (ConstraintViolation<?> cv : exception.getConstraintViolations()) {
        	StringBuilder msg = new StringBuilder(); 	
        	msg.append(cv.getPropertyPath().toString().substring(cv.getPropertyPath().toString().lastIndexOf('.') + 1));
        	msg.append(": :");
        	msg.append(cv.getMessage());
            errorList.add(msg.toString());
        }
        return errorList;
    }
	
	
}
