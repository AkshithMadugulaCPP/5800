package Final.Factory;

import Final.User;

abstract class UserFactory {
    public abstract User createUser(String name, String address, String county);
}
