/**
 * This class represents a specific location in a 2D map.  Coordinates are
 * integer values.
 **/
public class Location
{
    /** X coordinate of this location. **/
    public int xCoord;

    /** Y coordinate of this location. **/
    public int yCoord;


    /** Creates a new location with the specified integer coordinates. **/
    public Location(int x, int y)
    {
        xCoord = x;
        yCoord = y;
    }

    /** Creates a new location with coordinates (0, 0). **/
    public Location()
    {
        this(0, 0);
    }

    @Override
    /** Compares this location with another **/
    public boolean equals(Object o) 
    {
        if (this == o) 
            return true;
        if (getClass() != o.getClass())
            return false;
        else
        {
            Location loc = (Location) o;
            return (this.xCoord == loc.xCoord && this.yCoord == loc.yCoord);
        }
    }

    /** Returns a hash code of this Location **/
    public int hashСode()
    {
        return this.xCoord*31+this.yCoord;
    }
}
