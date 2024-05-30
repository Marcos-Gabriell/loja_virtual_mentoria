package br.com.marcos.lojavirtual;

import java.sql.SQLException;
import java.util.List;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import br.com.marcos.lojavirtual.model.dto.ObjectErroDTO;

@RestControllerAdvice
@ControllerAdvice
public class ControlerExcecoes extends ResponseEntityExceptionHandler{

	@ExceptionHandler(ExceptionMentoriaJava.class)
	public ResponseEntity<Object> handleExceptionCustom (ExceptionMentoriaJava ex) {
		
		ObjectErroDTO objetoErroDTO = new ObjectErroDTO();
		
		objetoErroDTO.setError(ex.getMessage());
		objetoErroDTO.setCode(HttpStatus.OK.toString());
		
		return new ResponseEntity<Object>(objetoErroDTO, HttpStatus.OK);
	}
	
	
	@ExceptionHandler({Exception.class, RuntimeException.class, Throwable.class})
	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {
		
		ObjectErroDTO erroDTO = new ObjectErroDTO();
		
		String msg = "";
		
		if(ex instanceof MethodArgumentNotValidException) {
			List<ObjectError> list = ((MethodArgumentNotValidException) ex).getBindingResult().getAllErrors();
			for(ObjectError objectError  : list) {
				msg += objectError.getDefaultMessage()+ "\n";
			}
		}else {
			msg = ex.getMessage();
		}
		
		erroDTO.setError(msg);
		erroDTO.setCode(status.value() + "==> " + status.getReasonPhrase());
		
		return new ResponseEntity<Object>(erroDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	@ExceptionHandler({DataIntegrityViolationException.class, 
		ConstraintViolationException.class, SQLException.class})
protected ResponseEntity<Object> handleExceptionDataIntegry(Exception ex){
	
	ObjectErroDTO objetoErroDTO = new ObjectErroDTO();
	
	String msg = "";
	
	if (ex instanceof DataIntegrityViolationException) {
		msg = "Erro de integridade no banco: " +  ((DataIntegrityViolationException) ex).getCause().getCause().getMessage();
	}else
	if (ex instanceof ConstraintViolationException) {
		msg = "Erro de chave estrangeira: " + ((ConstraintViolationException) ex).getCause().getCause().getMessage();
	}else
	if (ex instanceof SQLException) {
		msg = "Erro de SQL do Banco: " + ((SQLException) ex).getCause().getCause().getMessage();
	}else {
		msg = ex.getMessage();
	}
	
	objetoErroDTO.setError(msg);
	objetoErroDTO.setCode(HttpStatus.INTERNAL_SERVER_ERROR.toString()); 
	
	ex.printStackTrace();
	
	return new ResponseEntity<Object>(objetoErroDTO, HttpStatus.INTERNAL_SERVER_ERROR);
	
}
}
