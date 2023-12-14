package com.aes.encryption.decryption.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aes.encryption.decryption.service.AESService;

@RestController
@RequestMapping("/api/aes")
public class AESController {

	@Autowired
	private AESService aesService;

	@GetMapping("/encrypt")
	public String encrypt(@RequestParam String plaintext) throws Exception {
		// SecretKey secretKey = aesService.generateAESKey();
		String secretKey = "MySecretKey";
		String salt = "MySalt";
		return aesService.encrypt(plaintext, secretKey, salt);
	}

	@GetMapping("/decrypt")
	public String decrypt(@RequestParam String ciphertext) throws Exception {
		String secretKey = "MySecretKey";
		String salt = "MySalt";
		// SecretKey secretKey = aesService.generateAESKey();
		return aesService.decrypt(ciphertext, secretKey, salt);
		
	}
}
