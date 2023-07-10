package com.example._183_abschlussprojekt;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class UnsecurePasswordEncoder implements PasswordEncoder {
    private static final Logger logger = LogManager.getLogger(UnsecurePasswordEncoder.class);

    @Override
    public String encode(CharSequence rawPassword) {
        String encodedPassword = md5encodeString(rawPassword.toString());
        logger.info("Encoded password: {}", encodedPassword);
        return encodedPassword;
    }

    @Override
    public boolean matches(CharSequence passwordToCheck, String encodedPassword) {
        String inputPassword = md5encodeString(passwordToCheck.toString());
        boolean isMatch = inputPassword.equals(encodedPassword);
        logger.info("Password match result: {}", isMatch);
        return isMatch;
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

            logger.info("MD5 Hash: {}", md5Hash);


        } catch (NoSuchAlgorithmException e) {
            logger.error("MD5 algorithm not found", e);

        }

        return md5Hash;
    }
}
