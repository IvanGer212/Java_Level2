package Lesson7_HomeWork.server;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Optional;
import java.util.Set;

public class AuthenticationService {
        private static final Set<Entry> entries;

    static {
        entries = new HashSet<>();
        entries.add(new Entry("user1", "l1", "p1"));
        entries.add(new Entry("user2", "l2", "p2"));
        entries.add(new Entry("user3", "l3", "p3"));
    }

    public Optional<Entry> getEntryByCredentials(String login, String password){
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


    public static class Entry {
        private String name;
        private String login;
        private String password;

        public Entry(String name, String login, String password) {
            this.name = name;
            this.login = login;
            this.password = password;
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
    }
}
