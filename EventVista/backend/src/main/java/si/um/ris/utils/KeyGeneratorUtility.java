package si.um.ris.utils;

import java.security.KeyPair;
import java.security.KeyPairGenerator;

/**
 * Created by Uporabnik on 22. 01. 2024
 *
 * @author : Gal Dvorsak
 * @version : 1.0
 */
public class KeyGeneratorUtility {

    public static KeyPair generateRsaKey() {

        KeyPair keyPair;

        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(2048);
            keyPair = keyPairGenerator.generateKeyPair();
        } catch (Exception e) {
            throw new IllegalStateException();
        }

        return keyPair;
    }
}
