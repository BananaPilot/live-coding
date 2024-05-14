package com.pasqualehorse.livecoding.controller;

import com.pasqualehorse.livecoding.controller.dto.*;
import com.pasqualehorse.livecoding.service.UserService;
import jakarta.validation.Valid;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/user")
public class UserController {

    public UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    @ResponseStatus(value = HttpStatus.CREATED)
    public WithIdResponseDto createUser(@RequestBody @Valid CreateUserRequestDto request) {
        return userService.createUser(request);
    }

    @GetMapping("/{id}")
    public UserResponseDto getUser(@PathVariable("id") Long id) {
        return userService.getUser(id);
    }

    @GetMapping
    public ListUserDto showAll() {
        return userService.showAll();
    }

    @PutMapping("/{id}")
    public UserResponseDto modifyUser(@PathVariable Long id, @RequestBody CreateUserRequestDto createUserRequestDto) {

        return userService.modifyAll(id, createUserRequestDto);
    }

    @GetMapping("/getPage")
    public ListUserDto getPage(@RequestParam int page, @RequestParam int size) {

        return userService.getPage(page, size);

    }

    @GetMapping("/like-user")
    public ListUserDto listUserDto(@RequestParam String username) {
        return userService.getLikeUsername(username);
    }

    @GetMapping("/getPageUser")
    public ListUserDto getPageUser(@RequestParam String username, @RequestParam int page, @RequestParam int pageSize) {

        return userService.getPageUser(username, page, pageSize);

    }

	@PostMapping(value = "/{Userid}/add-picture", consumes = {MediaType.MULTIPART_FORM_DATA_VALUE})
    public BaseResponse addPicture(@RequestPart MultipartFile file, @PathVariable long Userid) {
        return userService.postPicture(file, Userid);
    }

    @GetMapping("/{userId}/download")
    public ResponseEntity<Resource> getPicture (@PathVariable Long userId) {

        return userService.downloadPicture(userId);

    }


}
