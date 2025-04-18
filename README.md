# neighborhood-library
Screenshoots
Home:![Screenshot 2025-04-18 145408](https://github.com/user-attachments/assets/2993b322-465e-44a5-8672-09e9d2120b36)
Products Display:![Screenshot 2025-04-18 145635](https://github.com/user-attachments/assets/d2b6c723-02aa-4de7-a783-e2a60ec2e6ef)
Eror:![Screenshot 2025-04-18 145805](https://github.com/user-attachments/assets/694c6b13-c3b6-4bfe-8186-f50ba632bea4)
## Interesting Code Snippet

```java
public static Book findBookById(int id) {
    for (Book book : books) {
        if (book.getId() == id) return book;
    }
    return null;
}
Why this code is interesting:
I chose this code snippet because it shows how to efficiently search through a collection of objects. The method findBookById loops through the list of books and returns the one with a matching ID. It’s simple, clear, and shows how we can interact with custom objects using loops and conditional logic. This was one of the first times I worked with object lists like this, so it helped me better understand how to manage and search through data in Java.
