package dat.Instance.DTO;

import dat.Instance.Data.Data;
import lombok.Getter;

import java.io.Serializable;

@Getter
public class DTO <ID extends Serializable> extends Data {

    public ID id;

}
