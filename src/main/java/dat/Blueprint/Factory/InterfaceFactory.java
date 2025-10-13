package dat.Blueprint.Factory;

import java.io.Serializable;

public interface InterfaceFactory<ID extends Serializable> {
    ID parseId(String idString);

}
