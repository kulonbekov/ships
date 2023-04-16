package kg.mega.ships.services;

import java.util.List;

public interface BaseService<Dto> {
    Dto save(Dto dto);

    Dto findById(String name);

    List<Dto> findAll();

    Dto update(Dto dto);

    Dto delete(String name);
}
