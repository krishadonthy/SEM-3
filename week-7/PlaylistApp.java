using System;

class MusicPlaylist
{
    private string[] songs;
    private int songCount;

    public MusicPlaylist(int maxSize)
    {
        songs = new string[maxSize];
        songCount = 0;
    }

    public void AddSong(string song)
    {
        if (songCount < songs.Length)
        {
            songs[songCount] = song;
            songCount++;
        }
        else
        {
            Console.WriteLine("Playlist is full.");
        }
    }

    public string[] GetSongs()
    {
        string[] copy = new string[songCount];

        for (int i = 0; i < songCount; i++)
        {
            copy[i] = songs[i];
        }

        return copy;
    }

    public int GetSongCount()
    {
        return songCount;
    }
}

class PlaylistApp
{
    static void Main(string[] args)
    {
        MusicPlaylist p = new MusicPlaylist(10);

        p.AddSong("Song A");
        p.AddSong("Song B");

        string[] copy = p.GetSongs();

        Console.WriteLine("Original playlist:");

        foreach (string song in p.GetSongs())
        {
            Console.WriteLine(song);
        }

        copy[0] = "Hacked";

        Console.WriteLine("\nAfter modifying the copy:");

        foreach (string song in p.GetSongs())
        {
            Console.WriteLine(song);
        }

        Console.WriteLine("\nSong count: " + p.GetSongCount());
    }
}