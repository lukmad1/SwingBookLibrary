package pl.sda.library.authorfactory;


public class AuthorFactory {
    public static Author createAuthor(String firstName, String lastName) {
        Author author = new Author();
        author.setFirstName(firstName);
        author.setLastName(lastName);
        return author;
    }
}
