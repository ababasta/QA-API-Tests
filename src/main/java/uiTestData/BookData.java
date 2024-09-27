package uiTestData;

public class BookData {
    private String imageUrl;
    private String title;
    private String author;
    private String publisher;

    public BookData() {
    }

    public BookData(String imageUrl, String title, String author, String publisher) {
        this.imageUrl = imageUrl;
        this.title = title;
        this.author = author;
        this.publisher = publisher;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getAuthor() {
        return author;
    }

    public String getPublisher() {
        return publisher;
    }

    @Override
    public String toString() {
        return "Book{" +
                "Image = '" + imageUrl + '\'' +
                ", Title ='" + title + '\'' +
                ", Author ='" + author + '\'' +
                ", Publisher ='" + publisher + '\'' +
                '}';
    }
}
