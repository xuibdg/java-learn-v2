package v4.b2c.java_learn_v2.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import v4.b2c.java_learn_v2.entity.UserEntity;
import v4.b2c.java_learn_v2.repository.UserRepository;

@Controller
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserRepository userRepository;

    // Endpoint untuk menampilkan semua pengguna
    @GetMapping
    public String getAllUsers(Model model) {
        model.addAttribute("users", userRepository.findAll());
        return "user-list";  // Mengembalikan view "user-list"
    }

    // Endpoint untuk menampilkan form pendaftaran pengguna baru
    @GetMapping("/new")
    public String createUserForm(Model model) {
        model.addAttribute("user", new UserEntity());  // Form kosong untuk entitas User
        return "user-form";  // Mengembalikan view "user-form"
    }

    // Endpoint untuk menyimpan pengguna baru
    @PostMapping
    public String createUser(@ModelAttribute UserEntity userEntity) {  // Menggunakan @ModelAttribute
        userRepository.save(userEntity);  // Simpan pengguna ke database
        return "redirect:/users";  // Redirect ke daftar pengguna setelah disimpan
    }

    // Endpoint untuk menampilkan detail pengguna
    @GetMapping("/{userId}")
    public String getUserById(@PathVariable String userId, Model model) {
        UserEntity user = userRepository.findById(userId).orElse(null);
        model.addAttribute("user", user);
        return "user-detail";  // Mengembalikan view "user-detail"
    }

    @DeleteMapping("/{userId}")
    public String deleteUser(@PathVariable String userId) {  // Menggunakan @ModelAttribute
        userRepository.deleteById(userId);  // Simpan pengguna ke database
        return "redirect:/users";  // Redirect ke daftar pengguna setelah disimpan
    }
}


