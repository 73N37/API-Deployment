package dat.routes;

import dat.dtos.AbstractDTO;
import dat.entities.AbstractEntity;

import java.io.Serializable;

public interface InterfaceRoutes<   Entity  extends AbstractEntity,
                                    DTO     extends AbstractDTO,
                                    ID      extends Serializable>
{}
