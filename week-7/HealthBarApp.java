using System;

class GameCharacter
{
    private int health;
    private readonly int maxHealth;

    public GameCharacter(int maxHealth)
    {
        this.maxHealth = maxHealth;
        this.health = maxHealth;
    }

    public void TakeDamage(int amount)
    {
        health = health - amount;

        if (health < 0)
        {
            health = 0;
        }
    }

    public void Heal(int amount)
    {
        health = health + amount;

        if (health > maxHealth)
        {
            health = maxHealth;
        }
    }

    public int GetHealth()
    {
        return health;
    }
}

class HealthBarApp
{
    static void Main(string[] args)
    {
        GameCharacter c = new GameCharacter(100);

        c.TakeDamage(30);
        Console.WriteLine("Health after damage: " + c.GetHealth());

        c.Heal(50);
        Console.WriteLine("Health after healing: " + c.GetHealth());

        c.TakeDamage(150);
        Console.WriteLine("Health after extra damage: " + c.GetHealth());
    }
}