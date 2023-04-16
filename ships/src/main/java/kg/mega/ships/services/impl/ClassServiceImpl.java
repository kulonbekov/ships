package kg.mega.ships.services.impl;

import kg.mega.ships.mappers.ClassMapper;
import kg.mega.ships.models.dtos.ClassDto;
import kg.mega.ships.models.entities.Class;
import kg.mega.ships.repository.ClassRep;
import kg.mega.ships.services.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassRep classRep;
    private ClassMapper classMapper = ClassMapper.INSTANCE;


    @Override
    public ClassDto save(ClassDto classDto) {
        Class aClass = classMapper.toEntity(classDto);
        aClass = classRep.save(aClass);
        return classMapper.toDto(aClass);
    }

    @Override
    public ClassDto findById(String name) {
        return classMapper.toDto(classRep.findById(name).orElseThrow(()
                -> new RuntimeException("Class not found")));
    }

    @Override
    public List<ClassDto> findAll() {
        return classMapper.toDtos(classRep.findAll());
    }

    @Override
    public ClassDto update(ClassDto classDto) {
        return null;
    }

    @Override
    public ClassDto delete(String name) {
        return null;
    }
}
