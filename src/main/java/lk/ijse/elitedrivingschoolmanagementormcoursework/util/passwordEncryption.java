package lk.ijse.elitedrivingschoolmanagementormcoursework.util;

import org.mindrot.jbcrypt.BCrypt;

public class passwordEncryption {

    public static String hashPassword(String plainPassword) {
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt(12));
    }

    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}