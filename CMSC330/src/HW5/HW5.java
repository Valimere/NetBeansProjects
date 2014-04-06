package HW5;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.awt.*;
class MutableString
{
    private char[] chars = new char[200];
    private int size = 0;
    public boolean set(char aChar, int index)
    {
        if (index < 0 || index >= chars.length)
            return false;
        chars[index] = aChar;
        return true;
    }
    public String toString()
    {
        String result = "";
        for (int i = 0; i < size; i++)
            result += chars[i];
        return result;
    }
}

