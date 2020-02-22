package com.tekup.mp.dao.GLOBAL;

public class _public {
    static Long userID;
    static String userRole;

    public static Long getUserID() {
        return userID;
    }

    public static void setUserID(Long userID) {
        _public.userID = userID;
    }

    public static String getUserRole() {
        return userRole;
    }

    public static void setUserRole(String userRole) {
        _public.userRole = userRole;
    }
}
