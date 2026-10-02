class BookInventory
{
    string title;
    string author;
    int copiesAvailable;

    BookInventory(string title, string author, int copiesAvailable)
    {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    public void PrintEntry()
    {
        Console.WriteLine(title + " by " + author + " - "
            + copiesAvailable + " copies available");
    }
}

class BookInventoryApp
{
    static void Main(string[] args)
    {
        BookInventory[] books =
        {
            new BookInventory("Clean Code", "Robert C. Martin", 3),
            new BookInventory("Effective Java", "Joshua Bloch", 5),
            new BookInventory("Refactoring", "Martin Fowler", 0),
            new BookInventory("Design Patterns", "GoF", 2)
        };

        foreach (BookInventory book in books)
        {
            book.PrintEntry();
        }
    }
}