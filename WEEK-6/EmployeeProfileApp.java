class EmployeeProfile
{
    string empId;
    string empName;
    double salary;
    bool isIntern;

    public EmployeeProfile(string empId, string empName, double salary)
    {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        isIntern = false;
    }

    public EmployeeProfile(string empId, string empName)
        : this(empId, empName, 0)
    {
        isIntern = true;
    }

    public void PrintProfile()
    {
        Console.WriteLine(
            empId + " | " +
            empName + " | Rs " +
            salary + " | Intern: " +
            isIntern
        );
    }
}

class EmployeeProfileApp
{
    static void Main(string[] args)
    {
        EmployeeProfile permanent =
            new EmployeeProfile("E-101", "Divya", 65000);

        EmployeeProfile intern =
            new EmployeeProfile("E-102", "Arjun");

        permanent.PrintProfile();
        intern.PrintProfile();
    }
}
