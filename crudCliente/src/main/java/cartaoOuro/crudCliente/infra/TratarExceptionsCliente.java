package cartaoOuro.crudCliente.infra;


import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.persistence.EntityNotFoundException;

@ControllerAdvice
public class TratarExceptionsCliente {

        @ExceptionHandler(NullPointerException.class)
        public ResponseEntity error0404 () {
                return ResponseEntity.notFound().build();
        }

         @ExceptionHandler(MethodArgumentNotValidException.class)
        public ResponseEntity erro400(MethodArgumentNotValidException ex) {
              return  ResponseEntity.badRequest().build();
         }


}
