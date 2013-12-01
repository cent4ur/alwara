/**
 * 
 */
package Dijkstra;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Nagy Krisztián
 *
 */
public class Vertex implements Comparable<Vertex>
{
    public final String name;
    public List<Edge> adjacencies;
    public double minDistance = Double.POSITIVE_INFINITY;
    public Vertex previous;
    public Vertex(String argName) { name = argName; adjacencies = new ArrayList<Edge>();}
    public String toString() { return name; }
    public int compareTo(Vertex other)
    {
        return Double.compare(minDistance, other.minDistance);
    }
    
    public String getName()
    {
        return name;
    }
}