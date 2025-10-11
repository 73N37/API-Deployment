package dat.annotations;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface IgnoreMapping {}


/*
The purpose of this annotation is to show my EntityToDTO() and dtoToEntity(),
methods what fields must be excluded from the conversion.
 */