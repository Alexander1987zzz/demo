package com.example;

import com.example.dto.UserDto;
import com.example.generic.GenericMapper;
import com.example.generic.GenericService;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements GenericService<UserDto, Long, UserFilter> {

    private final UserRepository repository;
    private final GenericMapper<UserDto, User> mapper;

    public Page<UserDto> findAll(UserFilter filter, Pageable pageable) {
        Specification<User> spec = UserSpecification.buildUserFilter(filter);
        return repository.findAll(spec, pageable).map(mapper::toDto);
    }

    @Override
    public UserDto create(UserDto dto) {
        if (repository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        User entity = mapper.toEntity(dto);
        User saved = repository.save(entity);
        return mapper.toDto(saved);
    }

    @Override
    public Optional<UserDto> findById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto);
    }

    @Override
    public UserDto update(Long id, UserDto dto) {
        User existing = repository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("User not found with id: " + id));

        if (!existing.getEmail().equals(dto.getEmail()) && repository.existsByEmail(dto.getEmail())) {
            throw new IllegalArgumentException("Email already exists");
        }

        mapper.updateEntity(dto, existing);
        User updated = repository.save(existing);
        return mapper.toDto(updated);
    }

    @Override
    public void delete(Long id) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException("User not found with id: " + id);
        }
        repository.deleteById(id);
    }
}
