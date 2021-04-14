package Lesson7_HomeWork.server;

import Lesson7_HomeWork.DB.Users_Repository;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

public class AuthenticationService {
        private static Set<Entry> entries;


    /**static {
        entries = new HashSet<>();
        entries.add(new Entry("user1", "l1", "p1"));
        entries.add(new Entry("user2", "l2", "p2"));
        entries.add(new Entry("user3", "l3", "p3"));
    }
     */



    public Optional<Entry> getEntryByCredentials(String login, String password){
       Users_Repository users_repository = new Users_Repository();
       entries = users_repository.findAll();
       return entries.stream()
               .filter(entry -> entry.getLogin().equals(login)&&entry.getPassword().equals(password))
               .findFirst();


        /**Iterator<Entry> iterator = entries.iterator();
        while (iterator.hasNext()){
            Entry next = iterator.next();
            if (next.getLogin().equals(login) && next.getPassword().equals(password)){
                return Optional.of(next);
            }
        }
        return Optional.empty();
        */
    }

    public Entry getEntryByChangeName(String name) {
        Users_Repository users_repository = new Users_Repository();
        Optional<AuthenticationService.Entry> entryForChangeName = users_repository.findEntryForChangeName(name);
        return entryForChangeName.get();
    }


    public static class Entry {
        private String name;
        private String login;
        private String password;
        private int id;

        public Entry(String name, String login, String password) {
            this.name = name;
            this.login = login;
            this.password = password;
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
