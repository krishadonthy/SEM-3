class HallTicket
{
    public string studentName;
    public int seatNumber;

    public HallTicket(string studentName, int seatNumber)
    {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

class HallTicketApp1
{
    static void Main(string[] args)
    {
        HallTicket priya =
            new HallTicket("Priya", 0);

        HallTicket copy = priya;

        copy.seatNumber = 45;

        Console.WriteLine(
            "Priya's seatNumber (via first variable): "
            + priya.seatNumber
        );

        Console.WriteLine("copy == priya: " + (copy == priya));

        HallTicket separate =
            new HallTicket("Priya", 45);

        Console.WriteLine(
            "separate == priya: " + (separate == priya)
        );
    }
}