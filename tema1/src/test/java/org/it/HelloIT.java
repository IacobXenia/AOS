package org.it;

import javax.servlet.ServletException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class HelloIT {
	 @Rule
     public ExpectedException thrown= ExpectedException.none();

     @Test
     public void throwsNothing() {
     }

     @Test
     public void throwsExceptionWithSpecificType() throws ServletException{
         thrown.expect(ServletException.class);
         throw new ServletException();
     }
 
 }

