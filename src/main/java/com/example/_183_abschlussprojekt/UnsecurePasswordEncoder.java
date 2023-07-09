package com.example._183_abschlussprojekt;

import org.springframework.security.crypto.password.PasswordEncoder;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UnsecurePasswordEncoder implements PasswordEncoder {
    @Override
    public String encode(CharSequence rawPassword) {
        return md5encodeString(rawPassword.toString());
    }

    @Override
    public boolean matches(CharSequence passwordToCheck, String encodedPassword) {
        return md5encodeString(passwordToCheck.toString()).equals(encodedPassword);
    }

    public String md5encodeString(String rawString) {
        String md5Hash = null;
        try {
            // Create an instance of MessageDigest with MD5 algorithm
            MessageDigest md = MessageDigest.getInstance("MD5");

            // Convert the input string to bytes
            byte[] inputBytes = rawString.getBytes();

            // Compute the MD5 hash
            byte[] hashBytes = md.digest(inputBytes);

            // Convert the hash bytes to a hexadecimal representation
            StringBuilder sb = new StringBuilder();
            for (byte b : hashBytes) {
                sb.append(String.format("%02x", b));
            }
            md5Hash = sb.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return md5Hash;
    }
}
