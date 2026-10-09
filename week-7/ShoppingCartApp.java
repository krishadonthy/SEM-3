using System;

class ShoppingCart
{
    private double[] prices;
    private int itemCount;
    private readonly string cartId;

    public ShoppingCart(string cartId, int maxItems)
    {
        this.cartId = cartId;
        prices = new double[maxItems];
        itemCount = 0;
    }

    public void AddItem(double price)
    {
        if (itemCount < prices.Length)
        {
            prices[itemCount] = price;
            itemCount++;
        }
        else
        {
            Console.WriteLine("Cart is full.");
        }
    }

    public double GetTotal()
    {
        double total = 0;

        for (int i = 0; i < itemCount; i++)
        {
            total += prices[i];
        }

        return total;
    }

    public int GetItemCount()
    {
        return itemCount;
    }

    public string GetCartId()
    {
        return cartId;
    }
}

class ShoppingCartApp
{
    static void Main(string[] args)
    {
        ShoppingCart cart =
            new ShoppingCart("CART-5", 20);

        cart.AddItem(250);
        cart.AddItem(99);
        cart.AddItem(151);

        Console.WriteLine("Cart ID: " + cart.GetCartId());
        Console.WriteLine("Total: " + cart.GetTotal());
        Console.WriteLine("Item count: " + cart.GetItemCount());
    }
}