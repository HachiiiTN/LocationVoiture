package com.tekup.mp.dao.GLOBAL;

public class AppRepo {
    static Long userID;
    static String userRole;

    public static Long getUserID() {
        return userID;
    }

    public static void setUserID(Long userID) {
        AppRepo.userID = userID;
    }

    public static String getUserRole() {
        return userRole;
    }

    public static void setUserRole(String userRole) {
        AppRepo.userRole = userRole;
    }
}
