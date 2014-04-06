/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package cmis242project4;

/**
 *
 * @author Valimere
 */
class Color implements Comparable<Color>
{
    private String color;
	private String hex;
	
	public Color(String color, String hex)
	{
		this.color = color;
		this.hex = hex;
	}

	public int compareTo(Color other)
	{
		return color.compareTo(other.color);
	}
	public String toString()
	{
		return "Color: " + color + " Hex; " + hex;
	}
	public String getHex()
	{
		return hex;
	}
}
