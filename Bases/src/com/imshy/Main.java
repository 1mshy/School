package com.imshy;

import java.time.zone.ZoneRulesProvider;
import java.util.Arrays;

public class Main {
    public static void main(String[] args)
    {
        for(int i = 0; i < 501; i++)
        {
            System.out.printf("%d: %s\n", i, toBinary(i));
        }
    }

    // num > 0
    public static String toBinary(int num)
    {
        assert num > 0;
        int nearestTwoBase = 2 << (int) (Math.log(num)/Math.log(2));
        StringBuilder sb = new StringBuilder();
        while(num >= 0)
        {
            // base is 2
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
