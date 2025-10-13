package dat.Blueprint.Unit;

import java.lang.annotation.Annotation;
import java.util.Set;

public interface InterfaceUnit {
    Class<?> getUnitClass();
    UnitType getUnitType();
    boolean hasAnnotation(Class<? extends Annotation> annotationClass);
    Set<AbstractUnit> getUnits();

}
