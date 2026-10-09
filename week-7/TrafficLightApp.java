using System;

class SignalLight
{
    private string color;
    private readonly string lightId;

    public SignalLight(string lightId)
    {
        this.lightId = lightId;
        color = "RED";
    }

    public void Next()
    {
        if (color == "RED")
        {
            color = "GREEN";
        }
        else if (color == "GREEN")
        {
            color = "YELLOW";
        }
        else if (color == "YELLOW")
        {
            color = "RED";
        }
    }

    public string GetColor()
    {
        return color;
    }

    public string GetId()
    {
        return lightId;
    }
}

class TrafficLightApp
{
    static void Main(string[] args)
    {
        SignalLight t = new SignalLight("TL-9");

        Console.WriteLine(t.GetColor());

        t.Next();
        Console.WriteLine(t.GetColor());

        t.Next();
        Console.WriteLine(t.GetColor());

        t.Next();
        Console.WriteLine(t.GetColor());
    }
}
