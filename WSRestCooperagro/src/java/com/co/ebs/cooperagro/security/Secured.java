
package com.co.ebs.cooperagro.security;

import static java.lang.annotation.ElementType.METHOD;
import java.lang.annotation.Retention;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;
import java.lang.annotation.Target;
/**
 *
 * @author Brian Cardenas
 */
@javax.ws.rs.NameBinding
@Retention(RUNTIME)
@Target({ TYPE, METHOD })
public @interface Secured {
    
}
