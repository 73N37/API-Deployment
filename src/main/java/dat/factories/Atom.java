package dat.factories;
import java.io.Serializable;

public abstract class Atom<ID extends Serializable> {

    protected ID id;

    public ID getId(){
        return id;
    }
}
