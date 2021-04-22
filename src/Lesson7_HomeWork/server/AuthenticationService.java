package Lesson7_HomeWork.server;

import Lesson7_HomeWork.DB.Users_Repository;

import java.util.Optional;

public class AuthenticationService {
       // private static Set<Entry> entries;


    public Optional<Entry> getEntryByCredentials(String login, String password){
      Users_Repository users_repository = new Users_Repository();
      return users_repository.findEntryForAuthentication(login, password);
    }

    public static class Entry {
        private String name;
        private String login;
        private String password;
        private int id;

        public Entry(int id, String name, String login, String password) {
            this.name = name;
            this.login = login;
            this.password = password;
            this.id = id;
        }

        public int getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public String getLogin() {
            return login;
        }

        public String getPassword() {
            return password;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Entry{" +
                    "name='" + name + '\'' +
                    ", login='" + login + '\'' +
                    ", password='" + password + '\'' +
                    '}';
        }
    }
}
