package com.javarush.test.level23.lesson06.task02;

/* Рефакторинг
Отрефакторите класс Solution: вынесите все константы в public вложенный(nested) класс Constants.
Запретите наследоваться от Constants.
*/
public class Solution
{

    public final static class Constants
    {
        public static final String SERVER_NOT_ACCESSIBLE = "Server is not accessible for now.";
        public static final String USER_IS_NOT_AUTHORIZED = "User is not authorized.";
        public static final String USER_IS_BANED = "User is banned.";
        public static final String ACCESS_IS_DENIED = "Access is denied.";
    }


    public class ServerNotAccessibleException extends Exception
    {
        public ServerNotAccessibleException()
        {
            super(Constants.SERVER_NOT_ACCESSIBLE);
        }

        public ServerNotAccessibleException(Throwable cause)
        {
            super(Constants.SERVER_NOT_ACCESSIBLE, cause);
        }
    }

    public class UnauthorizedUserException extends Exception
    {
        public UnauthorizedUserException()
        {
            super(Constants.USER_IS_NOT_AUTHORIZED);
        }

        public UnauthorizedUserException(Throwable cause)
        {
            super(Constants.USER_IS_NOT_AUTHORIZED, cause);
        }
    }

    public class BannedUserException extends Exception
    {
        public BannedUserException()
        {
            super(Constants.USER_IS_BANED);
        }

        public BannedUserException(Throwable cause)
        {
            super(Constants.USER_IS_BANED, cause);
        }
    }

    public class RestrictionException extends Exception
    {
        public RestrictionException()
        {
            super(Constants.ACCESS_IS_DENIED);
        }

        public RestrictionException(Throwable cause)
        {
            super(Constants.ACCESS_IS_DENIED, cause);
        }
    }

}
