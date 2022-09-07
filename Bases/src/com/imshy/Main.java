package com.imshy;

import java.time.zone.ZoneRulesProvider;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        System.out.println(toDecimal(toBinary(544443444)));

    }
    public static int toDecimal(String num)
    {
        StringBuilder sb = new StringBuilder();
        sb.append(num).reverse();
        char[] chars = sb.toString().toCharArray();
        int decimal = chars[0]==1 ? 1 : 0;
        for(int i = 1; i < chars.length; i++)
        {
            if(chars[i]=='1')
            {
                decimal += 2 << i-1;
            }
        }
        return decimal;
    }
    // num > 0
    public static String toBinary(int num)
    {
        assert num > 0;
        // closest power of 2 under the number
        int nearestTwoBase = 2 << (int) (Math.log(num)/Math.log(2));
        StringBuilder sb = new StringBuilder();
        while(num >= 0)
        {
            if(num==nearestTwoBase)
            {
                sb.append("1");
                sb.append("0".repeat((int) Math.max(0, Math.log(num)/Math.log(2))));
                return sb.toString();
            }
            if(nearestTwoBase > num)
            {
                nearestTwoBase = nearestTwoBase>>1;
                sb.append("0");
                continue;
            }
            num = num - nearestTwoBase;
            nearestTwoBase = nearestTwoBase >>1;
            sb.append("1");
        }
        return sb.toString();
    }
}
