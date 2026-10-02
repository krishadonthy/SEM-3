class PayrollAccount
{
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double basicSalary)
    {
        if (basicSalary < 0)
        {
            Console.WriteLine("Invalid basic salary. Starting at Rs 0.");
            this.basicSalary = 0;
        }
        else
        {
            this.basicSalary = basicSalary;
        }

        bonus = 0;
    }

    public void CreditBonus(double amount)
    {
        if (amount <= 0)
        {
            Console.WriteLine("Invalid bonus amount.");
        }
        else
        {
            bonus += amount;
            Console.WriteLine("Bonus credited: Rs " + amount);
        }
    }

    public void DeductTax(double percent)
    {
        if (percent < 0 || percent > 100)
        {
            Console.WriteLine("Invalid tax percentage.");
        }
        else
        {
            basicSalary -= basicSalary * percent / 100;
            Console.WriteLine("Tax deducted: " + percent + "%");
        }
    }

    public double GetNetSalary()
    {
        return basicSalary + bonus;
    }
}

class PayrollApp
{
    static void Main(string[] args)
    {
        PayrollAccount account = new PayrollAccount(50000);

        account.CreditBonus(5000);
        account.DeductTax(10);

        Console.WriteLine("Net salary: Rs " + account.GetNetSalary());
    }
}