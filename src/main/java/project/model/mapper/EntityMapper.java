package project.model.mapper;

import java.util.List;

public interface EntityMapper <D, E>{
    E toEntity(D d);
    List<E> toEntityList(List<D> ds);
    D toDto(E e);
    List<D> toDtoList(List<E> es);
}
