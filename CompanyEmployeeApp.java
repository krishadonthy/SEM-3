class CompanyEmployee
{
    string empName;
    double salary;

    static string companyName =
        "Bright Horizon Technologies";

    static int employeeCount = 0;

    public CompanyEmployee(string empName, double salary)
    {
        this.empName = empName;
        this.salary = salary;

        employeeCount++;
    }

    public static void PrintCompanyInfo()
    {
        Console.WriteLine(companyName);
        Console.WriteLine(
            "Employees on record: " + employeeCount
        );
    }
}

class CompanyEmployeeApp
{
    static void Main(string[] args)
    {
        CompanyEmployee e1 =
            new CompanyEmployee("Divya", 65000);

        CompanyEmployee e2 =
            new CompanyEmployee("Arjun", 55000);

        CompanyEmployee e3 =
            new CompanyEmployee("Priya", 60000);

        CompanyEmployee.PrintCompanyInfo();
    }
}