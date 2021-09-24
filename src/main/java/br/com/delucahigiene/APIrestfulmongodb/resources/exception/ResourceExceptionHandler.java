package br.com.delucahigiene.APIrestfulmongodb.resources.exception;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;

import br.com.delucahigiene.APIrestfulmongodb.services.ObjectNotFoundException;

@ControllerAdvice
public class ResourceExceptionHandler {
	
	
	public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException erro, HttpServletRequest request) {
		
		HttpStatus status = HttpStatus.NOT_FOUND;
		StandardError err = new StandardError(System.currentTimeMillis(), status.value(), "Valor não encontrado", erro.getMessage(), request.getRequestURI());
		return ResponseEntity.status(status).body(err);
		
	}
	
	

}
