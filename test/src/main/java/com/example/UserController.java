package com.example;


import com.example.dto.UserDto;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public Page<UserDto> getAll(
            UserFilter filter,
            @PageableDefault Pageable pageable) {
        return service.findAll(filter, pageable);
    }

//    @PostMapping
//    public UserDto create(@RequestBody UserDto dto) {
//        return service.create(dto);
//    }
//
//    @GetMapping("/{id}")
//    public UserDto getById(@PathVariable Long id) {
//        return service.findById(id)
//                .orElseThrow(() -> new EntityNotFoundException("User not found"));
//    }
//
//    @PutMapping("/{id}")
//    public UserDto update(@PathVariable Long id, @RequestBody UserDto dto) {
//        return service.update(id, dto);
//    }
//
//    @DeleteMapping("/{id}")
//    public void delete(@PathVariable Long id) {
//        service.delete(id);
//    }
}
