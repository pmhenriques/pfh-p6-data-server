package pt.uc.dei.paj.providers;

import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class EncryptPasswordProvider {

    public String encryptPassword(String password) {
        String encryptedPassword = Hashing.sha256()
                .hashString(password, StandardCharsets.UTF_8)
                .toString();
        return encryptedPassword;
    }
}
