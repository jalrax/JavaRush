package com.javarush.test.level21.lesson05.task01;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/* Equals and HashCode
В классе Solution исправить пару методов equals/hashCode в соответствии с правилами реализации этих методов.
Метод main не участвует в тестировании.
*/
public class Solution
{
    private final String first, last;

    public Solution(String first, String last)
    {
        this.first = first;
        this.last = last;
    }

    public static void main(String[] args)
    {
        Set<Solution> s = new HashSet<>();
        s.add(new Solution("Donald", "Duck"));
        System.out.println(s.contains(new Solution("Donald", "Duck")));
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((first == null) ? 0 : first.hashCode());
        result = prime * result + ((last == null) ? 0 : last.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj)
    {
        if (obj == null)
            return false;

        if (obj.getClass() != this.getClass())
            return false;
        Solution object = (Solution) obj;
        if (Objects.equals(first, object.first) && Objects.equals(last, object.last))
        {
            return true;
        } else return false;
    }
}
