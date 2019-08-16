package pl.fis.szymon.gretka.exceptions;

import java.util.List;

import javax.json.bind.annotation.JsonbProperty;
import javax.json.bind.annotation.JsonbPropertyOrder;
import javax.ws.rs.core.Response.Status;

@JsonbPropertyOrder(value = { "status", "errorList" })
public class ExceptionClass { 
	
	public Status status;
    public String message;
    public List<String> errorList;

    public ExceptionClass() {}

    public ExceptionClass(Status status, String message){
        this.status = status;
        this.message = message;
    }
    
    public ExceptionClass(Status status, List<String> errorList){
        this.status = status;
        this.errorList = errorList;
        
    }

    @JsonbProperty("field-errors") 
	public List<String> getErrorList() {
		return errorList;
	}

	public void setErrorList(List<String> errorList) {
		this.errorList = errorList;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
    
    
	
	
}
