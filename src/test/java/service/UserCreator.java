package service;

import model.User;

public class UserCreator {
    public static final String USER_NAME="test.data.user.username";
    public static final String USER_PASSWORD="test.data.user.userpassword";

    public static User withAllProperty(){
        return new User(TestDataReader.getTestData(USER_NAME),
                TestDataReader.getTestData(USER_PASSWORD));
    }

}
