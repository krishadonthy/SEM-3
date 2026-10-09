using System;

class SecurePasswordChecker
{
    private readonly string password;

    public SecurePasswordChecker(string password)
    {
        this.password = password;
    }

    public string GetStrength()
    {
        if (password.Length < 6)
        {
            return "Weak";
        }
        else if (password.Length <= 9)
        {
            return "Medium";
        }
        else
        {
            return "Strong";
        }
    }
}

class PasswordCheckerApp
{
    static void Main(string[] args)
    {
        SecurePasswordChecker pc =
            new SecurePasswordChecker("abcd");

        Console.WriteLine("Password strength: " + pc.GetStrength());

        SecurePasswordChecker pc2 =
            new SecurePasswordChecker("abcdefghij");

        Console.WriteLine("Password strength: " + pc2.GetStrength());
    }
}